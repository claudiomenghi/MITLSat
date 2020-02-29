package formulae.cltloc.visitor;

import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.atoms.AssignNextVariable;
import formulae.cltloc.atoms.AssignVariable;
import formulae.cltloc.atoms.CLTLocArithmeticExpression;
import formulae.cltloc.atoms.BoundedVariable;
import formulae.cltloc.atoms.CLTLocAP;
import formulae.cltloc.atoms.CLTLocClock;
import formulae.cltloc.atoms.CLTLocSelector;
import formulae.cltloc.atoms.Constant;
import formulae.cltloc.atoms.KeepBoundedVariableConstant;
import formulae.cltloc.atoms.KeepVariableConstant;
import formulae.cltloc.atoms.Signal;
import formulae.cltloc.atoms.Variable;
import formulae.cltloc.operators.binary.CLTLocConjunction;
import formulae.cltloc.operators.binary.CLTLocDisjunction;
import formulae.cltloc.operators.binary.CLTLocIff;
import formulae.cltloc.operators.binary.CLTLocImplies;
import formulae.cltloc.operators.binary.CLTLocNaryConjunction;
import formulae.cltloc.operators.binary.CLTLocNaryDisjunction;
import formulae.cltloc.operators.binary.CLTLocRelease;
import formulae.cltloc.operators.binary.CLTLocSince;
import formulae.cltloc.operators.binary.CLTLocUntil;
import formulae.cltloc.operators.unary.CLTLocEventually;
import formulae.cltloc.operators.unary.CLTLocGlobally;
import formulae.cltloc.operators.unary.CLTLocNegation;
import formulae.cltloc.operators.unary.CLTLocNext;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.relations.CLTLocRelation;

public class CLTLocGetMaxBound implements CLTLocVisitor<Float>{

	@Override
	public Float visit(CLTLocConjunction formula) {
		
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Float visit(CLTLocNegation formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Float visit(CLTLocUntil formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Float visit(CLTLocImplies formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Float visit(CLTLocIff formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Float visit(CLTLocNext formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Float visit(CLTLocGlobally formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Float visit(CLTLocEventually formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Float visit(CLTLocSince formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Float visit(CLTLocYesterday formula) {
		return formula.getChild().accept(this);
	}

	@Override
	public Float visit(CLTLocRelease formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Float visit(CLTLocRelation formula) {
		if(formula.getLeftChild() instanceof CLTLocClock && formula.getRightChild() instanceof Constant){
			return Float.parseFloat(((Constant) formula.getRightChild()).getValue());
		}
		if(formula.getRightChild() instanceof CLTLocClock && formula.getLeftChild() instanceof Constant){
			return Float.parseFloat(((Constant) formula.getLeftChild()).getValue());
		}
		return 0.0f;
	}

	@Override
	public Float visit(CLTLocDisjunction formula) {
		return Math.max(
				formula.getLeftChild().accept(this),
				formula.getRightChild().accept(this));
	}

	@Override
	public Float visit(CLTLocAP formula) {
		return 0.0f;
	}

	@Override
	public Float visit(CLTLocClock cltlClock) {
		return 0.0f;

	}

	@Override
	public Float visit(Constant cltlConstantAtom) {
		return 0.0f;
	}

	@Override
	public Float visit(Signal formula) {
return 0.0f;
	}

	@Override
	public Float visit(Variable cltLocVariable) {
return 0.0f;
	}

	@Override
	public Float visit(KeepVariableConstant keepVariableConstant) {
		return 0.0f;
	}

	@Override
	public Float visit(CLTLocSelector formula) {
		return 0.0f;
	}

	@Override
	public Float visit(AssignNextVariable formula) {
		return 0.0f;
	}

	@Override
	public Float visit(BoundedVariable variable) {
		return 0.0f;
	}

	@Override
	public Float visit(KeepBoundedVariableConstant variable) {
		return 0.0f;
	}

	@Override
	public Float visit(CLTLocNaryConjunction cltLocNaryConjunction) {
		
		Float max=cltLocNaryConjunction.getChildren().iterator().next().accept(this);
		
		for(CLTLocFormula f:cltLocNaryConjunction.getChildren() ){
			max=Math.max(max, f.accept(this));
		}
		return max;
	}

	@Override
	public Float visit(CLTLocNaryDisjunction cltLocNaryDisjunction) {
		Float max=cltLocNaryDisjunction.getChildren().iterator().next().accept(this);
		
		for(CLTLocFormula f:cltLocNaryDisjunction.getChildren() ){
			max=Math.max(max, f.accept(this));
		}
		return max;
	}
	
	@Override
	public Float visit(CLTLocArithmeticExpression binaryArithmeticExpression) {
		return 0.0f;
	}
	
	@Override
	public Float visit(AssignVariable assignVariable) {
		return 0.0f;
	}
}


