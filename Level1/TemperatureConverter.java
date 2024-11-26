import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the temperature value
        System.out.print("Enter temperature: ");
        double temperature = scanner.nextDouble();

        // Ask the user to specify the unit (Celsius or Fahrenheit)
        System.out.print("Enter unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);

        double convertedTemperature;

        // Perform conversion based on the unit entered
        if (unit == 'C') {
            // Convert Celsius to Fahrenheit
            convertedTemperature = (temperature * 9/5) + 32;
            System.out.println(temperature + " Celsius is equal to " + convertedTemperature + " Fahrenheit.");
        } else if (unit == 'F') {
            // Convert Fahrenheit to Celsius
            convertedTemperature = (temperature - 32) * 5/9;
            System.out.println(temperature + " Fahrenheit is equal to " + convertedTemperature + " Celsius.");
        } else {
            // Invalid unit
            System.out.println("Invalid unit entered. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }

        // Close the scanner object
        scanner.close();
    }
}
