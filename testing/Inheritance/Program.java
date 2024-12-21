

// This is a basic Java program
public class Program {

    // Main method - the entry point of the program
    public static void main(String[] args) {

        // Create a Dog object
        Dog dog = new Dog("Buddy", "Dog", 5, "Golden Retriever");

        // Display dog's information
        dog.displayInfo();

        // Call the bark method
        dog.bark();

        // Create a Dog object
        Dog dd = new Dog(null, null, 0, "Golden Retriever");

        // Display dog's information
        dd.displayInfo();

        // Call the bark method
        dd.bark();
    }
}