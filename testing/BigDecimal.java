import java.math.BigDecimal;

public class BigDecimalExample {

    public static void main(String[] args) {
        // Create BigDecimal objects from strings for precise representation
        BigDecimal number1 = new BigDecimal("3.14159");
        BigDecimal number2 = new BigDecimal("2.71828");

        // Perform calculations
        BigDecimal sum = number1.add(number2);
        BigDecimal product = number1.multiply(number2);

        // Print results
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);

        BigDecimal hoursWorked = new BigDecimal("7.25"); 
        BigDecimal hourlyRate = new BigDecimal("30.50");

        BigDecimal totalPay = hoursWorked.multiply(hourlyRate); 

        System.out.println("Total Pay: $" + totalPay);
    }
}