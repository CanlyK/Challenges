import java.util.Scanner;

public class ChallengeTestScores {
    public static void main(String[] args) {

        // Create Scanner object to read input
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your 5 test scores separated by commas: ");
        String inputScores = input.nextLine();

        input.close();

        // Split the string into an array of scores
        String[] scoreArray = inputScores.split(",");
        int[] scores = new int[scoreArray.length];
        for (int i = 0; i < scoreArray.length; i++) {
            scores[i] = Integer.parseInt(scoreArray[i].trim());
        }
        
        // Find total
        int total = 0;
        for (int score: scores) {
            total += score;
        }
        
        // Find average
        int average = total / scores.length;

        // Find Highest
        int highest = scores[0];
        
        for (int score: scores) {
            if (score > highest) {
                highest = score;
            }
        }

        // Find Lowest
        int lowest = scores[0];

        for (int score: scores) {
            if (score < lowest) {
                lowest = score;
            }
        }

        // Print
        System.out.println();
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        System.out.println();

        // Letter Grade
        System.out.println("Your values were:");

        for (int score: scores) {
            if (score >= 90) {
                System.out.println(score + " - " + "A");
            } else if (score >= 80) {
                System.out.println(score + " - " + "B");
            } else if (score >= 70) {
                System.out.println(score + " - " + "C");
            } else if (score >= 60) {
                System.out.println(score + " - " + "D");
            } else {
                System.out.println(score + " - " + "F");
            }
        }
    }
}
