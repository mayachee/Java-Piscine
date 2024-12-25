

package time;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Time {

    public static void main(String[] args)
    {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.of(ld,lt);
        LocalDate ld2 = LocalDate.now();
        int year = ld2.getYear();      
        System.out.println("Date is " + ld);
        System.out.println("time is " + lt);
        System.out.println("time is " + ldt);
        System.out.println("years is " + year);
    
        ZoneId defaultzone = ZoneId.systemDefault();
        System.out.println("time in Local is " + defaultzone);

        Instant instant = Instant.now();
        System.out.println(instant);

        // Get the current instant in time
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));

        // Format the time as desired (e.g., HH:mm:ss)
        String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Print the formatted time
        System.out.println("Current time in San Paolo: " + formattedTime);
    }
}