import java.util.*;

public class GradeCalculator {

    public static void main(String[] args) {
        // Create a sc object for user input
        Scanner sc = new Scanner(System.in);

        // Ask the user how many grades they want to enter
        System.out.print("Enter the number of grades: ");
        int grade = sc.nextInt();

        // Declare an array to store the grades
        double[] grades = new double[grade];

        // Variable to keep track of the sum of the grades
        double sum = 0;

        // Prompt the user to enter each grade and store it in the array
        for (int i = 0; i < grade; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = sc.nextDouble();
            sum += grades[i]; // Add the grade to the sum
        }

        // Calculate the avg
        double avg = sum / grade;

        // Display the avg grade to the user
        System.out.println("The avg grade is: " + avg);

        // Close the sc object
        sc.close();
    }
}
