public class Challenge3 {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        int sum = a + b;
        int subtract = a - b;
        int product = a * b;
        int quotient = a / b;

        boolean greaterThan = true;
        boolean greatherThanAndNotZero = true;

        if (a > b) {
            greaterThan = true;
        } else {
            greaterThan = false;
        }

        if (a > b && b > 0) {
            greatherThanAndNotZero = true;
        } else {
            greatherThanAndNotZero = false;
        }

        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + subtract);
        System.out.println("Multiplication: " + product);
        System.out.println("Division: " + quotient);
        System.out.println("Is a greater than b? " + greaterThan);
        System.out.println("Is a > b and b > 0? " + greatherThanAndNotZero);
    }
}
