import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        // Create scanner object to read user input
        Scanner sc = new Scanner(System.in);
        
        // Create Random object to generate random numbers
        Random rand = new Random();

        // Ask user for pass length
        System.out.print("Enter the length of the pass: ");
        int length = sc.nextInt();

        // Ask user if they want to include each type of character
        System.out.print("Include lowercase letters? (y/n): ");
        String inLow = sc.next();

        System.out.print("Include uppercase letters? (y/n): ");
        String inUp = sc.next();

        System.out.print("Include numbers? (y/n): ");
        String inNum = sc.next();

        System.out.print("Include special characters? (y/n): ");
        String inSpl = sc.next();

        // Create the string of characters to choose from
        String allChars = "";
        
        if (inLow.equalsIgnoreCase("y")) {
            allChars += "abcdefghijklmnopqrstuvwxyz";
        }
        if (inUp.equalsIgnoreCase("y")) {
            allChars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (inNum.equalsIgnoreCase("y")) {
            allChars += "0123456789";
        }
        if (inSpl.equalsIgnoreCase("y")) {
            allChars += "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
        }

        // Check if any characters were chosen
        if (allChars.isEmpty()) {
            System.out.println("You must choose at least one type of character!");
            return;  // End the program early if no characters are chosen
        }

        // Build the pass by randomly picking characters
        String pass = "";
        for (int i = 0; i < length; i++) {
            int randIndex = rand.nextInt(allChars.length());  // Get a random index
            pass += allChars.charAt(randIndex);  // Add the character at that index to the pass
        }

        // Output the generated pass
        System.out.println("Your generated pass is: " + pass);
        
        // Close the scanner object
        sc.close();
    }
}
