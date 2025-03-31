package tinycc.implementation.statement;
import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;

public class IfStatement extends Statement {
    private Locatable loc;
    private Expression condition;
    private Statement consequence;
    private Statement alternative;
    public IfStatement(Locatable loc, Expression condition, Statement consequence, Statement alternative) {
        this.loc = loc;
        this.condition = condition;
        this.consequence = consequence;
        this.alternative = alternative;
    }
    public Locatable getLoc() {
        return loc;
    }
    public Expression getCondition() {
        return condition;
    }
    public Statement getConsequence() {
        return consequence;
    }
    public Statement getAlternative() {
        return alternative;
    }
    @Override
    public String toString() {
        if (alternative == null) {
            return "If[%s, %s]".formatted(condition, consequence);
        } else {
            return "If[%s, %s, %s]".formatted(condition, consequence, alternative);
        }
    }
}
