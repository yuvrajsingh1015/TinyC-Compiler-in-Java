package tinycc.implementation;
import tinycc.parser.Token;
import tinycc.parser.TokenKind;
import tinycc.implementation.type.Type;

public class ExternalDeclaration {
   private Type type;
   private Token name;
   public ExternalDeclaration(Type type, Token name){
   this.type=type;
   this.name = name;
   }
   public Token getName(){
      return name;
   }
   public Type getType(){
      return type;
   }
}
