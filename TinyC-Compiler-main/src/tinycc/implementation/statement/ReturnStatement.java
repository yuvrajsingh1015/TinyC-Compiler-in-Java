package tinycc.implementation.statement;
import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;

public class ReturnStatement extends Statement {
    private Locatable loc;
    private Expression expression;
    public ReturnStatement(Locatable loc, Expression expression) {
        this.loc = loc;
        this.expression = expression;
    }
    public Locatable getLoc() {
        return loc;
    }
    public Expression getExpression() {
        return expression;
    }
    public String toString() {
        if (expression == null) {
            return "Return[]";
        } else {
            return "Return[%s]".formatted(expression.toString());
        }
    }

}
