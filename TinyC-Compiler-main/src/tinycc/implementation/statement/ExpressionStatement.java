package tinycc.implementation.statement;
import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;
public class ExpressionStatement extends Statement {
    private Locatable loc;
    private Expression expression;
    public ExpressionStatement(Locatable loc, Expression expression) {
        this.loc = loc;
        this.expression = expression;
    }
    public Locatable getLoc() {
        return loc;
    }
    public Expression getExpression() {
        return expression;
    }
     @Override
    public String toString() {
        return expression.toString();
    }
    
}
