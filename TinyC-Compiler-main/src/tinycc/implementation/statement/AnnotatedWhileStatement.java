package tinycc.implementation.statement;
import tinycc.implementation.expression.Expression;

public class AnnotatedWhileStatement extends Statement {
    private final Expression condition;
    private final Statement body;
    private final Expression invariant;
    private final Expression termination;

    public AnnotatedWhileStatement(Expression condition, Statement body, Expression invariant, Expression termination) {
        this.condition = condition;
        this.body = body;
        this.invariant = invariant;
        this.termination = termination;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getBody() {
        return body;
    }

    public Expression getInvariant() {
        return invariant;
    }

    public Expression getTermination() {
        return termination;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("While[");
        sb.append(condition.toString());
        sb.append(", ");
        sb.append(body.toString());
        sb.append(", ");
        sb.append(invariant.toString());
        if (termination != null) {
            sb.append(", ");
            sb.append(termination.toString());
        }
        sb.append("]");
        return sb.toString();
    }
}

