# Define variables
JAVAC = javac
JAVAFLAGS = -g
SOURCES = $(wildcard *.java)
CLASSES = $(SOURCES:.java=.class)
MAIN_CLASS = Program

# Default target
all: $(CLASSES)

# Compile Java source files
%.class: %.java
    $(JAVAC) $(JAVAFLAGS) $<

# Run the Java program
run:
    java $(MAIN_CLASS)

# Clean compiled files
clean:
    rm -f $(CLASSES)

.PHONY: all run clean
