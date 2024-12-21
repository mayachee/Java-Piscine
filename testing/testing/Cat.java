public class Cat extends Animal {
    String breed;

    // Constructor for Cat, calling the constructor of Animal
    public Cat(String name, int age, String breed) {
        super(name, age, "Cat");  // Set type to "Cat" for all instances
        this.breed = breed;
    }

    // Overriding the speak method to give a more specific behavior for cats
    @Override
    public void speak() {
        System.out.println(name + " the Cat says: Meow, I am a cat!");
        System.out.println("Breed: " + breed);
    }
}
