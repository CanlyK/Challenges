import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        System.out.println("Please create a password:");
        System.out.println();

        String requirements = """
                The password must:
                Be at least 8 characters
                Contain at least one uppercase letter
                Contain at least one lowercase letter
                Contain at least one number
                """;
        
        System.out.println(requirements);

        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Convert string to array for characters
        char[] inputArr = input.toCharArray();

        boolean len = false;
        boolean upper = false;
        boolean lower = false;
        boolean num = false;

        if (input.length() >= 8) {
            len = true;
        }

        // Iterate through each character to check validity
        for (char character: inputArr) {
            if (upper == false && Character.isUpperCase(character)) {
                upper = true;
            }
            if (lower == false && Character.isLowerCase(character)) {
                lower = true;
            }
            if (num == false && Character.isDigit(character)) {
                num = true;
            }
        }

        if (len && upper && lower && num) {
            System.out.println("Password Accepted!");
        } else {
            System.out.println("Password Rejected:");
            if (!len) {
                System.out.println("- Must be at least 8 characters");
            }
            if (!upper) {
                System.out.println("- Must contain an uppercase letter");
            }
            if (!lower) {
                System.out.println("- Must contain an uppercase letter");
            }
            if (!num) {
                System.out.println("- Must contain a number");
            }
        }
        scanner.close();
        
    }
}