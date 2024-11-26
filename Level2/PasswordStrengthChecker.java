import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user to input a pass
        System.out.print("Enter a pass to check its strng: ");
        String pass = sc.nextLine();

        // Check the strng of the pass
        String strng = checkPasswordStrength(pass);

        // Display the result
        System.out.println("Password strng: " + strng);

        // Close the sc
        sc.close();
    }

    // Function to check pass strng
    public static String checkPasswordStrength(String pass) {
        int score = 0;

        // Criteria 1: Length of the pass
        if (pass.length() >= 8) {
            score++;  // Good length (>= 8 characters)
        } else {
            System.out.println("Password is too short. It should be at least 8 characters long.");
        }

        // Criteria 2: Contains both uppercase and lowercase letters
        if (containsUppercase(pass) && containsLowercase(pass)) {
            score++;  // Both uppercase and lowercase letters are present
        } else {
            System.out.println("Password should contain both uppercase and lowercase letters.");
        }

        // Criteria 3: Contains numbers
        if (containsNumber(pass)) {
            score++;  // Password contains a number
        } else {
            System.out.println("Password should contain at least one number.");
        }

        // Criteria 4: Contains special characters
        if (containsSpecialCharacter(pass)) {
            score++;  // Password contains a special character
        } else {
            System.out.println("Password should contain at least one special character (e.g., @, #, $, %, etc.).");
        }

        // Evaluate the overall strng
        if (score == 4) {
            return "Strong";
        } else if (score == 3) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }

    // Function to check if the pass contains an uppercase letter
    public static boolean containsUppercase(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // Function to check if the pass contains a lowercase letter
    public static boolean containsLowercase(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLowerCase(pass.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // Function to check if the pass contains a number
    public static boolean containsNumber(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // Function to check if the pass contains a special character
    public static boolean containsSpecialCharacter(String pass) {
        String specialCharacters = "!@#$%^&*()-_=+<>?{}[]|\\:;\"',./";
        for (int i = 0; i < pass.length(); i++) {
            if (specialCharacters.indexOf(pass.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }
}
