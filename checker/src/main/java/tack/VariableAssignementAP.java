package tack;


import com.google.common.base.Preconditions;


public class VariableAssignementAP extends AP {
	private final int encodingSymbol;
	private final Variable variable;
	private final Value expression;
	
	

	public VariableAssignementAP(int encodingSymbol, Variable variable, Value expression) {
		super(variable.toString()+expression.toString());
		Preconditions.checkNotNull(variable, "The variable cannot be null");
		Preconditions.checkNotNull(expression, "The expression assigned to the variable  cannot be null");
		this.encodingSymbol=encodingSymbol;
		this.variable = variable;
		this.expression = expression;
	}

	public int getEncodingSymbol() {
		return encodingSymbol;
	}

	public Variable getVariable() {
		return this.variable;
	}

	public Value getValue() {
		return this.expression;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + ((variable == null) ? 0 : variable.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VariableAssignementAP other = (VariableAssignementAP) obj;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		if (variable == null) {
			if (other.variable != null)
				return false;
		} else if (!variable.equals(other.variable))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return variable + "=" + expression;
	}
	
}
