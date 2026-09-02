import java.util.Scanner;

public class ChallengeREPL {
    public static void main(String[] args) {
        float balance = 0;
        
        // Scanner object to read input
        Scanner input = new Scanner(System.in);
        int mode;

        do {
            System.out.println("Choose an action by entering a number:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            mode = input.nextInt();

            switch (mode) {
                // Check balance
                case 1:
                    System.out.printf("Balance: $%.2f%n", balance);
                    System.out.println();
                    break;
                
                // Deposit
                case 2:
                    System.out.println("How much would you like to deposit?");
                    float depositAmount = input.nextInt();
                    balance += depositAmount;
                    System.out.printf("$%.2f deposited to your account.%n", depositAmount);
                    System.out.println();
                    break;

                // Withdraw
                case 3:
                    System.out.println("How much would you like to withdraw?");
                    float withdrawAmount = input.nextInt();
                    if (balance < withdrawAmount) {
                        System.out.println("Insufficient Balance");
                    } else {
                        balance -= withdrawAmount;
                        System.out.printf("$%.2f withdrew from your account.%n", withdrawAmount);
                    }
                    System.out.println();
                    break;

                // Exit;
                case 4:
                    break;

                default:
                    System.out.println("Please enter a valid number.");
                    System.out.println();
            }
        }
        while (mode != 4);

        input.close();
        
    }
}
