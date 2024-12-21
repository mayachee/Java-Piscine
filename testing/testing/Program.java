// package pkg;
// package testing;

public class Program {
    public static void main(String[] args) {
        // Create an instance of Owner
        Owner owner = new Owner(args[0], "Doe");

        // Create an instance of Cat
        Cat cat = new Cat("Whiskers", 3, null);

        // The owner adopts a cat
        owner.adoptCat(cat);

        // Display owner's information and cat's behavior
        owner.showInfo();
    }
}

// make ARGS="Yassine"
// https://docs.oracle.com/en/java/javase/17/docs/api/index.html