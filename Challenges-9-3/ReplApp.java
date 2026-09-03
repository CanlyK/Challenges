import java.util.Scanner;
import java.util.Random;

public class ReplApp {
    public static void main(String[] args) {
        System.out.println("Welcome to my REPL App!");

        String commandList = """
                Available commands:
                    > help
                    > add
                    > subtract
                    > multiply
                    > divide
                    > random
                    > reverse
                    > quit
                """;

        System.out.println(commandList);
        
        // Create scanner
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int inputInt;
        
        // Variables for math
        int num1;
        int num2;
        int result;
        String resultString;
        Random random = new Random();

        while (input != "quit") {
            switch (input) {
            case "help":
                System.out.println();
                System.out.println(commandList);

                input = scanner.nextLine();
                break;

            case "add":
                System.out.println("Enter first number to add:");
                inputInt = scanner.nextInt();
                num1 = inputInt;
                System.out.println("Enter second number to add:");
                num2 = scanner.nextInt();
                result = num1 + num2;
                
                System.out.println("First number: " + num1);
                System.out.println("Second number: " + num2);
                System.out.println("Result: " + result);

                input = scanner.nextLine();
                break;

            case "subtract":
                System.out.println("Enter first number to subtract:");
                inputInt = scanner.nextInt();
                num1 = inputInt;
                System.out.println("Enter second number to subtract:");
                num2 = scanner.nextInt();
                result = num1 - num2;
                
                System.out.println("First number: " + num1);
                System.out.println("Second number: " + num2);
                System.out.println("Result: " + result);

                input = scanner.nextLine();
                break;

            case "multiply":
                System.out.println("Enter first number to multiply:");
                inputInt = scanner.nextInt();
                num1 = inputInt;
                System.out.println("Enter second number to multiply:");
                num2 = scanner.nextInt();
                result = num1 * num2;
                
                System.out.println("First number: " + num1);
                System.out.println("Second number: " + num2);
                System.out.println("Result: " + result);

                input = scanner.nextLine();
                break;

            case "divide":
                System.out.println("Enter first number to divide:");
                inputInt = scanner.nextInt();
                num1 = inputInt;
                System.out.println("Enter second number to divide:");
                num2 = scanner.nextInt();
                result = num1 / num2;
                
                System.out.println("First number: " + num1);
                System.out.println("Second number: " + num2);
                System.out.println("Result: " + result);

                input = scanner.nextLine();
                break;

            case "random":
                System.out.println("Enter the minimum number to randomize between:");
                inputInt = scanner.nextInt();
                num1 = inputInt;
                System.out.println("Enter the maximum number to randomize between:");
                inputInt = scanner.nextInt();
                num2 = inputInt;

                // Formula to randomize between two numbers
                result = random.nextInt(num2 - num1 + 1) + num1;

                System.out.println("Minimum: " + num1);
                System.out.println("Maximum: " + num2);
                System.out.println("Result: " + result);

                input = scanner.nextLine();
                break;

            case "reverse":
                System.out.println("Enter words to reverse:");
                input = scanner.nextLine();

                // StringBuilder to reverse string easily
                StringBuilder sb = new StringBuilder(input);
                resultString = sb.reverse().toString();
                System.out.println(resultString);

                input = scanner.nextLine();
                break;

            case "quit":
                System.out.println("Goodbye!");

                input = scanner.nextLine();
                break;

            default:
                input = scanner.nextLine();
            }
        }

        scanner.close();
    }
}