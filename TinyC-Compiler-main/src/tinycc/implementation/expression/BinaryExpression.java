package tinycc.implementation.expression;
import tinycc.parser.Token;

public class BinaryExpression extends Expression {
    private Token operator;
    private Expression left;
    private Expression right;
    public BinaryExpression(Token operator, Expression left, Expression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }
    public Token getOperator() {
        return operator;
    }
    public Expression getLeft() {
        return left;
    }
    public Expression getRight() {
        return right;
    }
        @Override
    public String toString() {
       // return "BinaryExpression[" + left.toString() + " " + operator.getText() + " " + right.toString() + "]";
       return "Binary_" + "" + operator.getText() + "" + "[" + left.toString() + "," + right.toString() + "]"  ; 
    }
    
}
