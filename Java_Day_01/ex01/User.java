package Java_Day_01.ex01;

// User.java
public class User {
    private final int id;
    private String name;

    public User(String name) {
        this.name = name;
        this.id = UserIdsGenerator.getInstance().generateId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    public void printConsole() {
        System.out.format("\nID: %d\nName: %s\n", id, name);
    }
}
