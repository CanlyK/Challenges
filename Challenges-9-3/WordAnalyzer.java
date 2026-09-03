import java.util.Scanner;

public class WordAnalyzer {
    public static void main(String[] args) {
        System.out.println("Enter a word:");

        // Create scanner for input
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println();

        // Turn string into character array
        char[] inputArr = input.toCharArray();

        int numChars = input.length();
        int numVowels = 0;
        int numConsonants = 0;
        int numDigits = 0;
        int numSpaces = 0;

        char[] vowelArr = {'a', 'e', 'i', 'o', 'u'};
        char[] consonantArr = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

        // Validation for each character
        for (char character : inputArr) {
            for (char vowel : vowelArr) {
                if (Character.toLowerCase(character) == vowel) {
                    numVowels++;
                }
            }
            for (char consonant : consonantArr) {
                if (Character.toLowerCase(character) == consonant) {
                    numConsonants++;
                }
            }
            if (Character.isDigit(character)) {
                numDigits++;
            }
            if (character == ' ') {
                numSpaces++;
            }
        }
        System.out.println("Characters: " + numChars);
        System.out.println("Vowels: " + numVowels);
        System.out.println("Consonants: " + numConsonants);
        System.out.println("Digits: " + numDigits);
        System.out.println("Spaces: " + numSpaces);

        scanner.close();
    }
}
