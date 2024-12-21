

public class Owner {
    String firstName;
    String lastName;
    Cat cat; // Owner has a Cat

    // Constructor for Owner
    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to adopt a cat
    public void adoptCat(Cat cat) {
        this.cat = cat;
    }

    // Method to display owner's info and call cat's speak method
    public void showInfo() {
        System.out.println("Owner: " + firstName + " " + lastName);
        if (cat != null) {
            System.out.println("The owner " + firstName + " has a cat named " + cat.name);
            cat.speak();
        } else {
            System.out.println("The owner does not have a cat.");
        }
    }
}
