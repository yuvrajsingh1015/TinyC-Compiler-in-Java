# TinyC Compiler in Java
Tinhy is a lightweight C compiler developed as part of the Saarland University Programming 2 course for the Summer Term 2024. The project aims to create a minimalistic yet functional C compiler that can parse, analyze, and generate code for a subset of the C programming language. The compiler is designed to be simple and educational, making it an ideal tool for learning the fundamentals of compiler design and implementation.


## Project Overview

TinyC is a simplified version of the C programming language, retaining much of C's syntax and semantics while omitting more complex features. This project is divided into three main phases:

1. **Abstract Syntax Tree (AST) Construction**: Parsing TinyC code and building an AST.
2. **Semantic Analysis**: Checking the AST for semantic correctness, including type checking and scoping rules.
3. **Code Generation/Verification Conditions**: 
   - Option 3a: Generating MIPS assembly code from the AST.
   - Option 3b: Generating logical formulas for verifying the correctness of TinyC programs.

You can choose to implement either the code generation (3a) or verification conditions (3b). Implementing both will grant bonus points.

## Project Structure

The repository is structured into several Java packages:

- **tinycc.driver**: Manages the translation process and command-line arguments.
- **tinycc.parser**: Contains the lexer and parser for TinyC.
- **tinycc.diagnostic**: Handles error messages and warnings.
- **tinycc.mipsasmgen**: Responsible for generating MIPS assembly code (Phase 3a).
- **tinycc.logic**: Generates logical formulas for verification (Phase 3b).
- **tinycc.implementation**: This is where your implementation resides. The `Compiler` class in this package drives the entire compilation process.

## Getting Started

### Prerequisites

- **Java 11 or higher**
- **Maven** (for dependency management)
- **Z3 SMT Solver** (optional, required for verification conditions generation)

### Building the Project

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/tinyc-compiler-java.git
   cd tinyc-compiler-java
   ```

2. Build the project using Maven:
   ```
   mvn clean install
   ```

### Running the Compiler

To compile a TinyC program, use the following command:
```
java -cp target/tinyc-compiler-java-1.0-SNAPSHOT.jar tinycc.driver.Compiler <source-file>
```
Where `<source-file>` is the TinyC file you wish to compile.

### Project Phases

1. **Phase 1 - AST Construction**:
   - Implement the `ASTFactory` interface.
   - Override the `toString` method for all AST nodes to provide a string representation of the abstract syntax.

2. **Phase 2 - Semantic Analysis**:
   - Implement semantic checks for types and scoping.
   - Handle errors using the `Diagnostic` class.

3. **Phase 3a - MIPS Code Generation**:
   - Translate the AST into MIPS assembly.

4. **Phase 3b - Verification Condition Generation**:
   - Generate logical formulas to verify the correctness of TinyC programs.

## Testing

Tests are included to verify the correctness of your implementation. Run the tests using Maven:
```
mvn test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

This project was developed as part of the Programming 2 course at Saarland University, Summer Term 2024.

---

Feel free to customize this README as needed for your specific project details and preferences.
