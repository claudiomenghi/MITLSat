package tack.checker;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.BiMap;
import com.google.common.io.ByteStreams;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.unary.CLTLocEventually;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocEQRelation;
import formulae.cltloc.relations.CLTLocGEQRelation;
import formulae.cltloc.relations.CLTLocGERelation;
import formulae.cltloc.relations.CLTLocLEQRelation;
import formulae.cltloc.relations.CLTLocLERelation;
import formulae.cltloc.relations.Relation;
import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.visitors.GetRelationalAtomsVisitor;
import solvers.CLTLocsolver;
import tack.AP;
import tack.Value;
import tack.Variable;
import tack.VariableAssignementAP;
import zotrunner.ZotException;

public class SystemChecker {

	public static final Function<Integer, CLTLocFormula> rest = (s) -> new CLTLocAP("H_" + s);

	public static final Function<Integer, CLTLocFormula> first = (s) -> new CLTLocAP("P_" + s);

	public static final BinaryOperator<CLTLocFormula> conjunctionOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		return CLTLocFormula.getAnd(left, right);
	};

	public static final BinaryOperator<CLTLocFormula> iffOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if (left.equals(CLTLocFormula.TRUE)) {
			return right;
		}
		if (right.equals(CLTLocFormula.TRUE)) {
			return left;
		}
		return new CLTLocIff(left, right);
	};

	public static final BinaryOperator<CLTLocFormula> disjunctionOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		return CLTLocFormula.getOr(left, right);
	};

	public static final UnaryOperator<CLTLocFormula> eventuallyOperator = (formula) -> {

		return new CLTLocEventually(formula);
	};

	public static final BinaryOperator<CLTLocFormula> implicationOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");
		return CLTLocImplies.create(left, right);
	};

	public static final UnaryOperator<CLTLocFormula> negationOperator = CLTLocNegation::new;
	public static final UnaryOperator<CLTLocFormula> globallyOperator = (formula) -> {
		if (formula.equals(CLTLocFormula.TRUE)) {
			return formula;
		}
		return CLTLocGlobally.create(formula);
	};

	public static final UnaryOperator<CLTLocFormula> nextOperator = (formula) -> {
		Preconditions.checkNotNull(formula, "The formula cannot be null");

		if (formula.equals(CLTLocFormula.TRUE)) {
			return formula;
		}
		return new CLTLocNext(formula);
	};

	public static final UnaryOperator<CLTLocFormula> Y = CLTLocYesterday::new;

	public static final Function<AP, CLTLocFormula> ap2CLTLocFIRSTAp = ap -> new CLTLocAP("P_" + ap.getName());

	public static final BinaryOperator<CLTLocFormula> xorOperator = (left, right) -> {
		Preconditions.checkNotNull(left, "The left formula cannot be null");
		Preconditions.checkNotNull(right, "The right formula cannot be null");

		if (left.equals(CLTLocFormula.FALSE)) {
			return right;
		}

		if (right.equals(CLTLocFormula.FALSE)) {
			return left;
		}

		return CLTLocFormula.getOr(CLTLocFormula.getAnd(left, negationOperator.apply(right)),
				CLTLocFormula.getAnd(negationOperator.apply(left), right));
	};

	/**
	 * The MITLI formula to be considered
	 */
	protected final MITLIFormula mitliformula;

	/**
	 * The bound to be considered in the verification
	 */
	protected int bound;

	/**
	 * The stream to be used to write output messages
	 */
	protected final PrintStream out;

	protected CLTLocFormula formula;

	private float checkingtime;

	private double checkingspace;

	private long mitli2cltlocTime = 0;

	private long ta2clclocTime = 0;

	private long cltloc2zotTime = 0;

	private long sattime = 0;

	public long getCltloc2zotTime() {
		return cltloc2zotTime;
	}

	/**
	 * 
	 * @param ta           the timed automaton to be verified
	 * @param mitliformula the MITLI to be considered
	 * @param bound        the bound to be used
	 * @throws NullPointerException     if the timed automaton is null
	 * @throws NullPointerException     if the MITLI formula is null
	 * @throws IllegalArgumentException if the bound is not grater than zero
	 */
	public SystemChecker(MITLIFormula mitliformula, int bound, PrintStream out) {
		Preconditions.checkNotNull(mitliformula, "The formula of interest cannot be null");
		Preconditions.checkArgument(bound > 0, "The bound should be grater than of zero");

		this.mitliformula = mitliformula;
		this.bound = bound;
		this.out = out;

	}

	public long getMitli2cltlocTime() {
		return mitli2cltlocTime;
	}

	public long getTa2clclocTime() {
		return ta2clclocTime;
	}

	/**
	 * checks the timed automaton with respect to the property of interest
	 * 
	 * @return true iff the property of interest is satisfied
	 * 
	 * @throws IOException
	 * @throws ZotException
	 */
	public boolean check(CLTLocFormula additionalConstraints) throws IOException, ZotException {

		if (additionalConstraints == null) {
			additionalConstraints = CLTLocFormula.TRUE;
		}

		Stopwatch timer = Stopwatch.createUnstarted();
		timer.start();
		out.println("************************************************");
		// out.println("MITLI formula: " + mitliformula);
		out.println("Converting the MITLI formula in CLTLoc");
		MITLI2CLTLoc translator = new MITLI2CLTLoc(mitliformula);
		formula = translator.apply();
		out.println("MITLI formula converted in CLTLoc");
		// out.println("************************************************");
		// out.println("** MITLI FORMULA CLTLoc ENCODING **");
		// translator.printFancy(out);
		// out.println("************************************************");
		timer.stop();
		mitli2cltlocTime = timer.elapsed(TimeUnit.MILLISECONDS);

		BiMap<MITLIFormula, Integer> vocabular = translator.getVocabulary().inverse();
		Set<MITLIRelationalAtom> atoms = mitliformula.accept(new GetRelationalAtomsVisitor());

		Set<VariableAssignementAP> atomicpropositionsVariable = atoms.stream()
				.map(a -> new VariableAssignementAP(vocabular.get(a), new Variable(a.getIdentifier()),
						new Value(Float.toString(a.getValue()))))
				.collect(Collectors.toSet());

		StringBuilder vocabularyBuilder = new StringBuilder();
		vocabular.entrySet().forEach(e -> vocabularyBuilder.append(e.getValue() + "\t" + e.getKey() + "\n"));

		File binding = new File("binding.txt");
		FileUtils.writeStringToFile(binding, vocabularyBuilder.toString());

		this.ta2clclocTime = timer.elapsed(TimeUnit.MILLISECONDS);

		out.println("************************************************");

		// out.println(converter.getMapStateId());
		StringBuilder stateIdMappingBuilder = new StringBuilder();

		File stateIdStringMappingfile = new File("elementsIDmap.txt");

		FileUtils.writeStringToFile(stateIdStringMappingfile, stateIdMappingBuilder.toString());

		StringBuilder transitionsIdMappingBuilder = new StringBuilder();
		FileUtils.writeStringToFile(stateIdStringMappingfile, transitionsIdMappingBuilder.toString(), true);

		out.println("Creating the CLTLoc formulae of the model and the property");
		CLTLocFormula conjunctionFormula = new CLTLocYesterday(CLTLocFormula.getAnd(formula, additionalConstraints,
				variablesAreTrueOnlyIfAssignmentsAreSatisfied(atoms, vocabular),
				variableIntervalsAreRightClosed(atomicpropositionsVariable)));
		out.println("Conjunction of the formulae created");

		out.println("Running ZOT... This might take a while");

		CLTLocsolver cltlocSolver = new CLTLocsolver(conjunctionFormula,
				new PrintStream(ByteStreams.nullOutputStream()), bound);
		boolean sat = cltlocSolver.solve();
		this.sattime = cltlocSolver.getSattime();
		this.checkingspace = cltlocSolver.getCheckingspace();

		this.cltloc2zotTime = cltlocSolver.getCltloc2zottime();
		this.checkingtime = cltlocSolver.getCheckingtime();

		return sat;
	}

	protected CLTLocFormula variablesAreTrueOnlyIfAssignmentsAreSatisfied(
			Set<MITLIRelationalAtom> atomicpropositionsVariable, BiMap<MITLIFormula, Integer> vocabular) {

		return (CLTLocFormula) atomicpropositionsVariable.stream().map(ap ->

		{
			formulae.cltloc.atoms.Variable variable = new formulae.cltloc.atoms.Variable(ap.getIdentifier());

			CLTLocFormula f = null;
			if (Relation.parse(ap.getOperator()).equals(Relation.EQ)) {
				f = new CLTLocEQRelation(variable, new Constant(ap.getValue()));
			} else {
				if (Relation.parse(ap.getOperator()).equals(Relation.LEQ)) {
					f = new CLTLocLEQRelation(variable, new Constant(ap.getValue()));
				} else {

					if (Relation.parse(ap.getOperator()).equals(Relation.LE)) {
						f = new CLTLocLERelation(variable, new Constant(ap.getValue()));
					} else {

						if (Relation.parse(ap.getOperator()).equals(Relation.GEQ)) {
							f = new CLTLocGEQRelation(variable, new Constant(ap.getValue()));
						} else {

							if (Relation.parse(ap.getOperator()).equals(Relation.GE)) {
								f = new CLTLocGERelation(variable, new Constant(ap.getValue()));
							}
							else {
								throw new IllegalArgumentException("Operator: "+ap.getOperator()+" Not valid");
							}
						}
					}
				}
			}

			return (CLTLocFormula) iffOperator.apply(rest.apply(vocabular.get(ap)), f);

		}).reduce(CLTLocFormula.TRUE, conjunctionOperator);

	}

	protected CLTLocFormula variableIntervalsAreRightClosed(Set<VariableAssignementAP> atomicpropositionsVariable) {
		return (CLTLocFormula) atomicpropositionsVariable.stream()
				.map(ap -> iffOperator.apply(rest.apply(ap.getEncodingSymbol()),
						nextOperator.apply(first.apply(ap.getEncodingSymbol()))))
				.reduce(CLTLocFormula.TRUE, conjunctionOperator);
	}

	public CLTLocFormula getFormulaEncoding() {
		return formula;
	}

	public float getCheckingTime() {
		return checkingtime;
	}

	public long getSattime() {
		return sattime;
	}

	public double getCheckingspace() {
		return checkingspace;
	}

	public void printCheckingStatistics() {
		out.println("********* CHECHER STATISTICS ********* ");
		out.println("mitli2cltloc: " + this.mitli2cltlocTime);
		out.println("ta2cltloc: " + this.ta2clclocTime);
		out.println("sat: " + this.checkingtime);

	}
}
