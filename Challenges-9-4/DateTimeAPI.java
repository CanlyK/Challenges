import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeAPI {
    public static void main(String[] args) {
        // Print current date
        LocalDate date = LocalDate.now();
        System.out.println("Date: " + date);

        // Print current year
        int year = date.getYear();
        System.out.println("Year: " + year);

        // Print month
        Month month = date.getMonth();
        System.out.println("Month: " + month);

        // Print day
        int day = date.getDayOfMonth();
        System.out.println("Day: " + day);

        // Enter your birthdate
        String input = "";
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your birth date (Year-Month-Day): ");
            input = scanner.nextLine();
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

        // Calculate age
        LocalDate birthdate = LocalDate.parse(input);
        Period gap = Period.between(birthdate, date);
        System.out.println("You are " + gap.getYears() + " years old.");

        // Calculate days left to birthday using the year after
        long days = ChronoUnit.DAYS.between(date, birthdate.withYear(year + 1));
        System.out.println("Days until your next birthday: " + days);
    }
}
