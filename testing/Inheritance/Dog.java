// Define the Dog class that inherits from Animal
public class Dog extends Animal {
    private String breed;

    // Constructor
    public Dog(String name, String type, int age, String breed) {
        super(name, type, age); // Call the constructor of the Animal class
        this.breed = breed;
    }

    // Override the displayInfo method to include breed information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }

    // Additional behavior specific to Dog
    public void bark() {
        System.out.println(getName() + " says: Woof! Woof!");
    }
}
