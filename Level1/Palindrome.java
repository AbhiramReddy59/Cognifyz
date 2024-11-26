import java.util.*;

public class Palindrome {

    public static void main(String[] args) {
        // Create scanner object for input
        Scanner sc = new Scanner(System.in);

        // Ask for user input
        System.out.print("Enter a word or phrase: ");
        String inp = sc.nextLine(); // Get the input from the user

        // Clean the input: remove spaces and make it lowercase
        String str = "";
        for (int i = 0; i < inp.length(); i++) {
            char chra = inp.charAt(i);
            // If it's a letter or number, add it to str
            if ((chra >= 'a' && chra <= 'z') || (chra >= 'A' && chra <= 'Z') || (chra >= '0' && chra <= '9')) {
                str += Character.toLowerCase(chra);
            }
        }

        // Check if the cleaned input is a palindrome
        boolean isPal = true; // Assume it's a palindrome

        // Compare characters from both ends
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPal = false; // If they don't match, it's not a palindrome
                break; // No need to check further
            }
            left++;  // Move the left pointer to the right
            right--; // Move the right pointer to the left
        }

        // Print the result
        if (isPal) {
            System.out.println("Yes, it's a palindrome!");
        } else {
            System.out.println("No, it's not a palindrome.");
        }

        // Close the scanner
        sc.close();
    }
}
