public class Challenge5 {
    public static void main(String[] args) {
        // For loop
        System.out.print("For Loop: ");
        for (int i = 1; i <= 5; i++) {
            if (i == 5) {
                System.out.print(i);
            }
            else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // While loop
        System.out.print("While Loop: ");
        int num = 1;
        while (num <= 5) {
            if (num == 5) {
                System.out.print(num);
            }
            else {
                System.out.print(num + " ");
            }
            num++;
        }
        System.out.println();

        // Do-While Loop
        System.out.print("Do-While Loop: ");
        int count = 1;
        do {
            if (count == 5) {
                System.out.print(count);
            }
            else {
                System.out.print(count + " ");
            }
            count++;
        }
        while (count <= 5);
    }
}
