package tinycc.implementation.statement;

import java.util.List;
import java.util.stream.Collectors;

import tinycc.diagnostic.Locatable;

public class BlockStatement extends Statement {
  private Locatable loc;
  private List<Statement> statements;
  public BlockStatement(Locatable loc, List<Statement> statements) {
    this.loc = loc;
    this.statements = statements;
   }
   public Locatable getLoc() {
    return loc;
  }

   public List<Statement> getStatements() {
    return statements;
   }
    @Override
    public String toString() {
          return "Block[%s]".formatted(
            statements.stream()
                .map(Statement::toString)
                .collect(Collectors.joining(", "))
        );
    }
    
}
