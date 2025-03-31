package tinycc.implementation;

import java.util.List;

import tinycc.implementation.statement.Statement;
import tinycc.implementation.type.Type;
import tinycc.parser.Token;

public class FunctionDefinition {
    private  Type type;
    private Token name;
    private List<Token> parameterNames;
    private  Statement body;
    public FunctionDefinition (Type type, Token name, List<Token> parameterNames, Statement body){
     this.type=type;
     this.name=name;
     this.parameterNames=parameterNames;
     this.body=body;
    }
    public List<Token> getParameterNames() {
        return parameterNames;
    }
    public Token getName(){
        return name;
    }
    public Statement getBody() {
        return body;
    }

    public Type getType(){
        return type;
    }
}
