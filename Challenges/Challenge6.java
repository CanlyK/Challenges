public class Challenge6 {
    public static void main(String[] args) {
        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";
        double result = 0;

        while (again == "y") {
            again = "n";
            if (operator == '+') {
                result = num1 + num2;
            }
            else if (operator == '-') {
                result = num1 - num2;
            }
            else if (operator == '*') {
                result = num1 * num2;
            }
            else {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero");
                    break;
                }
                else {
                    result = num1 / num2;
                }
            }
            System.out.println("Result: " + result);
        }
        System.out.print("Thank you for using the calculator.");

    }
}
