package tinycc.implementation.expression;

import java.util.List;
import java.util.stream.Collectors;

import tinycc.parser.Token;

public class CallExpression extends Expression {
    private Token token;
    private Expression callee;
    private List<Expression> arguments;

    public CallExpression(Token token, Expression callee, List<Expression> arguments) {
        this.token = token;
        this.callee = callee;
        this.arguments = arguments;
    }

    public Token getToken() {
        return token;
    }

    public Expression getCallee() {
        return callee;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        String argsString = arguments.stream()
                .map(Expression::toString)
                .collect(Collectors.joining(", "));
        return "Call[" + callee.toString() + (argsString.isEmpty() ? "" : ", " + argsString) + "]";
    }

}
