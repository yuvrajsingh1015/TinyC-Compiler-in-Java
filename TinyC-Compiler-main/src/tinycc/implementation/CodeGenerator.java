package tinycc.implementation;

import tinycc.mipsasmgen.*;
import tinycc.parser.Token;
import tinycc.parser.TokenKind;
import tinycc.implementation.statement.*;
import tinycc.implementation.type.*;
import tinycc.implementation.expression.*;

import java.util.List;

public class CodeGenerator {

    private MipsAsmGen gen;

    public CodeGenerator(MipsAsmGen gen) {
        this.gen = gen;
    }

    public void generateGlobalVariables(List<ExternalDeclaration> externals) {
        for (ExternalDeclaration external : externals) {
            DataLabel dataLabel = gen.makeDataLabel(external.getName().getText());
            gen.emitWord(dataLabel, 0);  
        }
    }

    public void generateFunctions(List<FunctionDefinition> functions) {
        for (FunctionDefinition function : functions) {
            generateFunctionCode(function);
        }
    }

    private void generateFunctionCode(FunctionDefinition function) {
        TextLabel functionLabel = gen.makeTextLabel(function.getName().getText());
        gen.emitLabel(functionLabel);
        generateStatementCode(function.getBody());
        gen.emitInstruction(JumpRegisterInstruction.JR, GPRegister.RA);
    }

    private void generateStatementCode(Statement statement) {
        if (statement instanceof BlockStatement) {
            BlockStatement block = (BlockStatement) statement;
            for (Statement stmt : block.getStatements()) {
                generateStatementCode(stmt);
            }
        } else if (statement instanceof DeclarationStatement) {
            DeclarationStatement declStmt = (DeclarationStatement) statement;
            Token name = declStmt.getName();
            Type type = declStmt.getType();
            Expression init = declStmt.getInit();
            if (init != null) {
                generateExpressionCode(init, GPRegister.T0);  
            }
        } else if (statement instanceof ExpressionStatement) {
            generateExpressionCode(((ExpressionStatement) statement).getExpression(), GPRegister.T0);
        } else if (statement instanceof IfStatement) {
            IfStatement ifStmt = (IfStatement) statement;
            generateExpressionCode(ifStmt.getCondition(), GPRegister.T0);
            generateStatementCode(ifStmt.getConsequence());
            if (ifStmt.getAlternative() != null) {
                generateStatementCode(ifStmt.getAlternative());
            }
        } else if (statement instanceof ReturnStatement) {
            ReturnStatement retStmt = (ReturnStatement) statement;
            if (retStmt.getExpression() != null) {
                generateExpressionCode(retStmt.getExpression(), GPRegister.V0); 
            }
            gen.emitInstruction(JumpRegisterInstruction.JR, GPRegister.RA);
        } else if (statement instanceof WhileStatement) {
            WhileStatement whileStmt = (WhileStatement) statement;
        }
    }

    private void generateExpressionCode(Expression expression, GPRegister target) {
        if (expression instanceof BinaryExpression) {
            BinaryExpression binExpr = (BinaryExpression) expression;
            generateExpressionCode(binExpr.getLeft(), GPRegister.T1);
            generateExpressionCode(binExpr.getRight(), GPRegister.T2);
        } else if (expression instanceof CallExpression) {
            CallExpression callExpr = (CallExpression) expression;
        } else if (expression instanceof UnaryExpression) {
            UnaryExpression unaryExpr = (UnaryExpression) expression;
            generateExpressionCode(unaryExpr.getOperand(), target);
        } else if (expression instanceof PrimaryExpression) {
            PrimaryExpression primExpr = (PrimaryExpression) expression;
            Token token = primExpr.getToken();
            if (token.getKind() == TokenKind.IDENTIFIER) {
            } else if (token.getKind() == TokenKind.NUMBER) {
                gen.emitInstruction(ImmediateInstruction.ADDIU, target, GPRegister.ZERO, Integer.parseInt(token.getText()));
            }
        }
    }
    
}
