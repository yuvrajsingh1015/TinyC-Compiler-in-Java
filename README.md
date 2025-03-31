TinyC Compiler in Java

Tinhy is a lightweight C compiler developed as part of the Saarland University Programming 2 course for the Summer Term 2024. The project aims to create a minimalistic yet functional C compiler that can parse, analyze, and generate code for a subset of the C programming language. The compiler is designed to be simple and educational, making it an ideal tool for learning the fundamentals of compiler design and implementation.

Project Overview

TinyC is a simplified version of the C programming language, retaining much of C's syntax and semantics while omitting more complex features. This project is divided into three main phases:

Abstract Syntax Tree (AST) Construction: Parsing TinyC code and building an AST.
Semantic Analysis: Checking the AST for semantic correctness, including type checking and scoping rules.
Code Generation/Verification Conditions:
Option 3a: Generating MIPS assembly code from the AST.
Option 3b: Generating logical formulas for verifying the correctness of TinyC programs.
You can choose to implement either the code generation (3a) or verification conditions (3b). Implementing both will grant bonus points.

Project Structure

The repository is structured into several Java packages:

tinycc.driver: Manages the translation process and command-line arguments.
tinycc.parser: Contains the lexer and parser for TinyC.
tinycc.diagnostic: Handles error messages and warnings.
tinycc.mipsasmgen: Responsible for generating MIPS assembly code (Phase 3a).
tinycc.logic: Generates logical formulas for verification (Phase 3b).
tinycc.implementation: This is where your implementation resides. The Compiler class in this package drives the entire compilation process.

Running the Compiler

To compile a TinyC program, use the following command:

java -cp target/tinyc-compiler-java-1.0-SNAPSHOT.jar tinycc.driver.Compiler <source-file>
Where <source-file> is the TinyC file you wish to compile.

Testing

Tests are included to verify the correctness of your implementation. Run the tests using Maven: "mvn test"
