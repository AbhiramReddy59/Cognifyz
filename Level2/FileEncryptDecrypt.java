import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for encryption or decryption ch
        System.out.print("Do you want to encrypt or decrypt a file? (Enter 'encrypt' or 'decrypt'): ");
        String ch = sc.nextLine().toLowerCase();

        // Prompt user for the file path
        System.out.print("Enter the file path (e.g., 'input.txt'): ");
        String FP = sc.nextLine();

        // Ask the user for the shift value
        System.out.print("Enter the shift value (e.g., 3 for Caesar Cipher): ");
        int shift = sc.nextInt();

        // Depending on user ch, either encrypt or decrypt the file
        if (ch.equals("encrypt")) {
            encryptFile(FP, shift);
        } else if (ch.equals("decrypt")) {
            decryptFile(FP, shift);
        } else {
            System.out.println("Invalid ch! Please enter 'encrypt' or 'decrypt'.");
        }

        sc.close();
    }

    // Method to encrypt a file
    public static void encryptFile(String FP, int shift) {
        try {
            // Read the contents of the file
            File inputFile = new File(FP);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Create a new output file to store encrypted text
            File outputFile = new File("encrypted_" + inputFile.getName());
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                // Encrypt each line using Caesar Cipher
                String encryptedLine = caesarCipher(line, shift);
                writer.write(encryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("File encrypted successfully! Encrypted file saved as: " + outputFile.getName());

        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }

    // Method to decrypt a file
    public static void decryptFile(String FP, int shift) {
        try {
            // Read the contents of the file
            File inputFile = new File(FP);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Create a new output file to store decrypted text
            File outputFile = new File("decrypted_" + inputFile.getName());
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                // Decrypt each line using Caesar Cipher
                String decryptedLine = caesarCipher(line, -shift);  // Negative shift to decrypt
                writer.write(decryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("File decrypted successfully! Decrypted file saved as: " + outputFile.getName());

        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }

    // Caesar Cipher method to shift characters
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // Loop through each character in the string
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // Encrypt or decrypt only alphabetic characters
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                // Shift the character and wrap around the alphabet if necessary
                c = (char) ((c - base + shift + 26) % 26 + base);
            }

            result.append(c);
        }

        return result.toString();
    }
}
