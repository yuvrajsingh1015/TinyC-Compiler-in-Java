package tinycc.implementation.statement;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;
import tinycc.implementation.type.Type;
import tinycc.parser.Token;

/**
 * This class represents a declaration statement.
 */
public class DeclarationStatement extends Statement {
    private Type type;
    private Token name;
    private Expression init;

    public DeclarationStatement(Type type, Token name, Expression init) {
        this.type = type;
        this.name = name;
        this.init = init;
    }
    public Token getName(){
        return name;
    }
    public Expression getInit(){
        return init;
    }
    public Type getType() {
        return type;
    }
    public Token getToken() {
        return name;
    }
    public Expression getExpression() {
        return init;
    }
    @Override
    public String toString() {
        if (init != null) {
            return "Declaration_%s[%s, %s]".formatted(name.getText(), type.toString(), init.toString());
        } else {
            return "Declaration_%s[%s]".formatted(name.getText(), type.toString());
        }
    }
}

