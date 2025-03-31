package tinycc.implementation.statement;
import tinycc.implementation.expression.Expression;

public class AssertStatement extends Statement {
    private final Expression condition;

    public AssertStatement(Expression condition) {
        this.condition = condition;
    }

    public Expression getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "Assert[" + condition.toString() + "]";
    }
}

