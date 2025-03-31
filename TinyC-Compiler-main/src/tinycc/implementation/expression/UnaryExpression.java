package tinycc.implementation.expression;
import tinycc.parser.Token;

public class UnaryExpression extends Expression {
    private Token operator; 
    private Expression operand; 
    private boolean postfix;
    public UnaryExpression(Token operator,boolean postfix, Expression operand) {
        this.operator = operator;
        this.operand = operand;
        this.postfix = postfix;
    }
    public Token getOperator() {
        return operator;
    }

    public Expression getOperand() {
        return operand;
    }
    public boolean getBool(){
        return postfix;
    }
    @Override
    public String toString() {
        return "Unary_"+operator.getText() + "["+ operand.toString() + "]"; 
    }


    
}
