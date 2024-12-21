# Variables
JAVAC = javac
JAVA = java
SRC = Program.java Animal.java Dog.java
CLASS = Program

# Default target
all: compile run

# Compile the Java code
compile:
	@$(JAVAC) $(SRC)

# Run the Java program
run:
	@$(JAVA) $(CLASS)

# Clean up generated files
clean:
	rm -f *.class
