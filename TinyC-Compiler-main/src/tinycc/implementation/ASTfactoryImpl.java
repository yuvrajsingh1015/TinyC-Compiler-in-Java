package tinycc.implementation;
import java.util.ArrayList;
import java.util.List;
import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.BinaryExpression;
import tinycc.implementation.expression.CallExpression;
import tinycc.implementation.expression.Expression;
import tinycc.implementation.expression.PrimaryExpression;
import tinycc.implementation.expression.UnaryExpression;
import tinycc.implementation.statement.Statement;
import tinycc.implementation.statement.AnnotatedWhileStatement;
import tinycc.implementation.statement.AssertStatement;
import tinycc.implementation.statement.AssumeStatement;
import tinycc.implementation.statement.BlockStatement;
import tinycc.implementation.statement.DeclarationStatement;
import tinycc.implementation.statement.ExpressionStatement;
import tinycc.implementation.statement.IfStatement;
import tinycc.implementation.statement.ReturnStatement;
import tinycc.implementation.statement.WhileStatement;
import tinycc.implementation.type.Type;
import tinycc.implementation.type.FunctionType;
import tinycc.implementation.type.PointerType;
import tinycc.implementation.type.BaseType;
import tinycc.parser.ASTFactory;
import tinycc.parser.Token;
import tinycc.parser.TokenKind;

public class ASTfactoryImpl implements ASTFactory {
    private List<ExternalDeclaration> externalDeclarations;
    private List<FunctionDefinition> functionDefinition;

    public ASTfactoryImpl (){
        this.externalDeclarations = new ArrayList<>();
        this.functionDefinition = new ArrayList<>();
    } 
    public Statement createBlockStatement(Locatable loc, List<Statement> statements){
        return new BlockStatement(loc, statements);
    }
  
    public Statement createDeclarationStatement(Type type, Token name, Expression init){
        return new DeclarationStatement(type, name, init);
    }

    public Statement createExpressionStatement(Locatable loc, Expression expression){
        return new ExpressionStatement(loc, expression);
    }
    public Statement createIfStatement(Locatable loc, Expression condition, Statement consequence,
			Statement alternative){
                return new IfStatement( loc, condition, consequence, alternative);
    }
    public Statement createReturnStatement(Locatable loc, Expression expression){
        return new ReturnStatement(loc, expression);
    }  
    public Statement createWhileStatement(Locatable loc, Expression condition, Statement body){
        return new WhileStatement(loc, condition, body);
    }
    public Type createFunctionType(Type returnType, List<Type> parameters){
        return new FunctionType(returnType, parameters);
    }
    public Type createPointerType(Type pointsTo){
        return new PointerType(pointsTo);
    }
    public Type createBaseType(TokenKind kind){
        return new BaseType(kind);
    }
    public Expression createBinaryExpression(Token operator, Expression left, Expression right){
        return new BinaryExpression( operator,  left , right);
    }
    public Expression createCallExpression(Token token, Expression callee, List<Expression> arguments){
        return new CallExpression(token, callee, arguments);
    }
    public Expression createUnaryExpression(Token operator, boolean postfix, Expression operand){
        return new UnaryExpression( operator,  postfix, operand);
    }
    public Expression createPrimaryExpression(Token token){
        return new PrimaryExpression( token) ;
    }
    public void createExternalDeclaration(Type type, Token name){
        ExternalDeclaration declare = new ExternalDeclaration(type, name);
        externalDeclarations.add(declare);
        return ;//CHECK ONCE
    }
    public void createFunctionDefinition(Type type, Token name, List<Token> parameterNames, Statement body){
        FunctionDefinition function = new FunctionDefinition(type, name, parameterNames, body);
        functionDefinition.add(function);
        return;//CHECK ONCE
    }
    public List<ExternalDeclaration> getExternalDeclarations() {
        return externalDeclarations ;
    }
    public List<FunctionDefinition> getFunctionDefinitions() {
        return functionDefinition;
    }
    @Override
    public Statement createBreakStatement(Locatable loc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBreakStatement'");
    }
    @Override
    public Statement createContinueStatement(Locatable loc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createContinueStatement'");
    }
    @Override
    public Statement createAnnotatedWhileStatement(Locatable loc , Expression condition , Statement body , Expression invariant ,Expression term , Token loopBound) {
            return new AnnotatedWhileStatement(condition, body, invariant, term);

    }
    @Override
    public Statement createAssumeStatement(Locatable loc, Expression condition) {
            return new AssertStatement(condition);

    }
    @Override
    public Statement createAssertStatement(Locatable loc, Expression condition) {
            return new AssumeStatement(condition);

    }
    @Override
    public Expression createConditionalExpression(Token token, Expression condition, Expression consequence,
            Expression alternative) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createConditionalExpression'");
    }

  

}