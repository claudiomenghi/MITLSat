package tack.checker;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.BiMap;
import com.google.common.io.ByteStreams;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.visitors.GetRelationalAtomsVisitor;
import solvers.CLTLocsolver;
import zotrunner.ZotException;

public class SystemChecker {

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

	protected CLTLocFormula taFormula;

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
	 * @param ta
	 *            the timed automaton to be verified
	 * @param mitliformula
	 *            the MITLI to be considered
	 * @param bound
	 *            the bound to be used
	 * @throws NullPointerException
	 *             if the timed automaton is null
	 * @throws NullPointerException
	 *             if the MITLI formula is null
	 * @throws IllegalArgumentException
	 *             if the bound is not grater than zero
	 */
	public SystemChecker(MITLIFormula mitliformula, int bound,
			PrintStream out) {
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
		MITLIFormula negatedFormula = MITLIFormula.not(mitliformula);
		out.println("Converting the MITLI formula in CLTLoc");
		MITLI2CLTLoc translator = new MITLI2CLTLoc(negatedFormula);
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
		

		StringBuilder vocabularyBuilder = new StringBuilder();
		vocabular.entrySet().forEach(e -> vocabularyBuilder.append(e.getValue() + "\t" + e.getKey() + "\n"));

		File binding = new File("binding.txt");
		FileUtils.writeStringToFile(binding, vocabularyBuilder.toString());

		out.println("************************************************");
		out.println("************************************************");
		out.println("Converting the TA in CLTLoc");

		timer.reset();
		timer.start();

		
		
		out.println("TA converted in CLTLoc");

		timer.stop();
		this.ta2clclocTime = timer.elapsed(TimeUnit.MILLISECONDS);

		out.println("************************************************");

		// out.println(converter.getMapStateId());
		StringBuilder stateIdMappingBuilder = new StringBuilder();
		
		File stateIdStringMappingfile = new File("elementsIDmap.txt");

		FileUtils.writeStringToFile(stateIdStringMappingfile, stateIdMappingBuilder.toString());

		StringBuilder transitionsIdMappingBuilder = new StringBuilder();
		FileUtils.writeStringToFile(stateIdStringMappingfile, transitionsIdMappingBuilder.toString(), true);

		out.println("Creating the CLTLoc formulae of the model and the property");
		CLTLocFormula conjunctionFormula = new CLTLocYesterday(
				CLTLocFormula.getAnd(taFormula, formula, additionalConstraints));
		out.println("Conjunction of the formulae created");

		out.println("Running ZOT... This might take a while");
		
		CLTLocsolver cltlocSolver = new CLTLocsolver(conjunctionFormula,
				new PrintStream(ByteStreams.nullOutputStream()), bound);
		boolean sat = cltlocSolver.solve();
		this.sattime = cltlocSolver.getSattime();
		this.checkingspace = cltlocSolver.getCheckingspace();

		this.cltloc2zotTime = cltlocSolver.getCltloc2zottime();
		this.checkingtime = cltlocSolver.getCheckingtime();

		
		return sat ? false : true;
	}

	

	public CLTLocFormula getTAEncoding() {
		return taFormula;
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
