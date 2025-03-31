package tinycc.implementation;

import tinycc.diagnostic.Diagnostic;
import tinycc.parser.Token;
import tinycc.parser.TokenKind;
import tinycc.implementation.statement.*;
import tinycc.implementation.type.*;
import tinycc.implementation.expression.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class SemanticAnalyzer {
    private Diagnostic diagnostic;
    private Map<String, Type> globalScope;
    private Stack<Map<String, Type>> localScopes;

    public SemanticAnalyzer(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
        this.globalScope = new HashMap<>();
        this.localScopes = new Stack<>();
    }

    public void analyze(FunctionDefinition function) {
        String functionName = function.getName().getText();
        
        if (!globalScope.containsKey(functionName)) {
            diagnostic.printError(function.getName(), "Function " + functionName + " not declared.");
            return;
        }

        localScopes.push(new HashMap<>());
        for (Token param : function.getParameterNames()) {
            declareVariable(param, function.getType());
        }
        analyzeStatement(function.getBody());
        localScopes.pop();
    }

    public void declareFunction(Token name, Type type) {
        String functionName = name.getText();
        if (globalScope.containsKey(functionName)) {

          //  diagnostic.printError(name, "Function " + functionName + " already declared in global scope.");
        } else {
            globalScope.put(functionName, type);
        }
    }

    private void analyzeStatement(Statement statement) {
        if (statement instanceof BlockStatement) {
            localScopes.push(new HashMap<>());
            for (Statement stmt : ((BlockStatement) statement).getStatements()) {
                analyzeStatement(stmt);
            }
            localScopes.pop();
        } else if (statement instanceof DeclarationStatement) {
            DeclarationStatement declStmt = (DeclarationStatement) statement;
            declareVariable(declStmt.getName(), declStmt.getType());
            if (declStmt.getInit() != null) {
                analyzeExpression(declStmt.getInit());
            }
        } else if (statement instanceof ExpressionStatement) {
            analyzeExpression(((ExpressionStatement) statement).getExpression());
        } else if (statement instanceof IfStatement) {
            IfStatement ifStmt = (IfStatement) statement;
            analyzeExpression(ifStmt.getCondition());
            analyzeStatement(ifStmt.getConsequence());
            if (ifStmt.getAlternative() != null) {
                analyzeStatement(ifStmt.getAlternative());
            }
        } else if (statement instanceof ReturnStatement) {
            ReturnStatement retStmt = (ReturnStatement) statement;
            if (retStmt.getExpression() != null) {
                analyzeExpression(retStmt.getExpression());
            }
        } else if (statement instanceof WhileStatement) {
            WhileStatement whileStmt = (WhileStatement) statement;
            analyzeExpression(whileStmt.getCondition());
            analyzeStatement(whileStmt.getBody());
        }
    }

    private void analyzeExpression(Expression expression) {
        if (expression instanceof BinaryExpression) {
            BinaryExpression binExpr = (BinaryExpression) expression;
            analyzeExpression(binExpr.getLeft());
            analyzeExpression(binExpr.getRight());
        } else if (expression instanceof CallExpression) {
            CallExpression callExpr = (CallExpression) expression;
            analyzeExpression(callExpr.getCallee());
            for (Expression arg : callExpr.getArguments()) {
                analyzeExpression(arg);
            }
        } else if (expression instanceof UnaryExpression) {
            analyzeExpression(((UnaryExpression) expression).getOperand());
        } else if (expression instanceof PrimaryExpression) {
            PrimaryExpression primExpr = (PrimaryExpression) expression;
            if (primExpr.getToken().getKind() == TokenKind.IDENTIFIER) {
                checkVariable(primExpr.getToken());
            }
        }
    }

    public void declareVariable(Token token, Type type) {
        String name = token.getText();
        if (type instanceof BaseType && ((BaseType) type).getKind() == TokenKind.VOID) {
            diagnostic.printError(token, "Variable cannot be of type void.");
        }
        if (localScopes.isEmpty()) {
            if (globalScope.containsKey(name)) {
                diagnostic.printError(token, "Variable " + name + " already declared in global scope.");
            } else {
                globalScope.put(name, type);
            }
        } else {
            Map<String, Type> currentScope = localScopes.peek();
            if (currentScope.containsKey(name)) {
                diagnostic.printError(token, "Variable " + name + " already declared in this scope.");
            } else {
                currentScope.put(name, type);
            }
        }
    }

    private void checkVariable(Token token) {
        String name = token.getText();
        Iterator<Map<String, Type>> iterator = localScopes.iterator();
        while (iterator.hasNext()) {
            Map<String, Type> scope = iterator.next();
            if (scope.containsKey(name)) {
                return; // Found the variable in one of the local scopes
            }
        }
        if (globalScope.containsKey(name)) {
            return; 
        }
        diagnostic.printError(token, "Variable " + name + " not declared.");
    }
}
