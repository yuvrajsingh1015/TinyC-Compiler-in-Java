package tinycc.implementation.expression;
import mars.assembler.TokenList;
import tinycc.parser.Token;
import tinycc.parser.TokenKind;

public class PrimaryExpression extends Expression {
    private Token token;
    public PrimaryExpression(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
    
    /*	IDENTIFIER("<identifier>"),
	NUMBER("<number>"),
	CHARACTER("<character constant>"),
	STRING("<string literal>"), */
  
   
    @Override
    public String toString() {
        TokenKind t =  token.getKind();
        switch (t) {
            case NUMBER:
            return "Const_"+ token.getText(); 
            case IDENTIFIER:
            return "Var_"+ token.getText(); 
            case CHARACTER:
            return "Const_"+"'"+token.getText()+"'";
            case STRING:
            return "Const_" + token.toString();
            default:
            return "Compiler Error!";
            

        }

       // return "Var_"+ token.getText(); 
    }
    
}
