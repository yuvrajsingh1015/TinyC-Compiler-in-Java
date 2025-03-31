package tinycc.implementation.statement;
import tinycc.implementation.expression.Expression;

public class AssumeStatement extends Statement {
    private final Expression condition;

    public AssumeStatement(Expression condition) {
        this.condition = condition;
    }

    public Expression getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "Assume[" + condition.toString() + "]";
    }
}
