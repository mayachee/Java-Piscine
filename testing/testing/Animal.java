

public class Animal {
    String name;
    String type;
    int age;

    // Constructor for Animal
    public Animal(String name, Integer age, String type) {
        this.name = name != null ? name : "Unknown";  // Default to "Unknown" if name is null
        this.type = type != null ? type : "Unknown";  // Default to "Unknown" if type is null
        this.age = (age != null) ? age : 0;  // Default to 0 if age is null
    }

    // Method to make animal speak
    public void speak() {
        System.out.println(name + " the " + type + " says: Meow!");
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
}
