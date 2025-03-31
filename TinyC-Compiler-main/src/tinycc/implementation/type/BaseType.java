package tinycc.implementation.type;
import tinycc.parser.TokenKind;

public class BaseType extends Type {
    private TokenKind kind;

    public BaseType(TokenKind kind) {
        this.kind = kind;
    }

    public TokenKind getKind() {
        return kind;
    }

    @Override
    public String toString() {
        // Implement the mapping from TokenKind to string representation of the base type
        switch (kind) {
            case INT:
                return "Type_int";
            case CHAR:
                return "Type_char";
            case VOID:
                return "Type_void";
            default:
                return "unknown"; // Handle any other types appropriately
        }
    }
}
