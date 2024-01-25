package Java_Day_01.ex02;

public class User {
    private int identifier;
    private String name;
    private double balance;

    public User(int identifier, String name, double balance) {
        this.identifier = identifier;
        this.name = name;
        this.balance = balance;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }
}