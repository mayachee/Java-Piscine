
// Define the Animal class
public class Animal {
    // Attributes
    private String name;
    private String type;
    private int age;

    // Constructor that allows null for name and age
    public Animal(String name, String type, Integer age) {
        this.name = name != null ? name : "Unknown";  // Default to "Unknown" if name is null
        this.type = type != null ? type : "Unknown";  // Default to "Unknown" if type is null
        this.age = (age != null) ? age : 0;  // Default to 0 if age is null
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to display information about the animal
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Age: " + age);
    }
}
