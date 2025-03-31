package tinycc.implementation.type;
import java.util.List;

public class FunctionType extends Type {
    private Type returnType;
    private List<Type> parameterTypes;

    public FunctionType(Type returnType, List<Type> parameterTypes) {
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<Type> getParameterTypes() {
        return parameterTypes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FunctionType[").append(returnType);
        for (Type paramType : parameterTypes) {
            sb.append(",").append(paramType);
        }
        sb.append("]");
        return sb.toString();
    }
}
