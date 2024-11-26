import java.io.*;
import java.net.*;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Ask the user for the base currency
        System.out.print("Enter the base currency (e.g., USD, EUR): ");
        String baseCur = sc.nextLine().toUpperCase();

        // Step 2: Ask the user for the target currency
        System.out.print("Enter the target currency (e.g., INR, GBP): ");
        String targetCur = sc.nextLine().toUpperCase();

        // Step 3: Ask the user for the amount to convert
        System.out.print("Enter the amount in " + baseCur + ": ");
        double amount = sc.nextDouble();

        // Step 4: Construct the API URL (replace with your actual API key)
        String apiKey = "9c41d0ab867ae831c188c849";  // Replace this with your actual API key
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCur;

        // Step 5: Get the exchange rate from the API and perform the conversion
        try {
            double exchangeRate = getExchangeRate(url, targetCur);

            if (exchangeRate != -1) {
                // Perform the conversion
                double convertedAmount = amount * exchangeRate;
                System.out.printf("Converted amount: %.2f %s\n", convertedAmount, targetCur);
            } else {
                System.out.println("Error: Could not retrieve exchange rate.");
            }

        } catch (IOException e) {
            System.out.println("Error: Unable to connect to the API.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close(); // Ensure Scanner is closed properly
        }
    }

    // Method to retrieve the exchange rate from the API
    public static double getExchangeRate(String url, String targetCur) throws IOException {
        // Connect to the API URL
        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("GET");

        // Set a timeout to prevent the app from hanging indefinitely
        connection.setConnectTimeout(5000);  // 5 seconds timeout for connection
        connection.setReadTimeout(5000);     // 5 seconds timeout for reading response

        // Check if the connection was successful
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            System.out.println("Error: Failed to get data from API. Response Code: " + responseCode);
            return -1;
        }

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response.toString());

        // Check if the API request was successful
        if (jsonResponse.getString("result").equals("success")) {
            // Get the exchange rate for the target currency
            JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");
            if (conversionRates.has(targetCur)) {
                return conversionRates.getDouble(targetCur);
            } else {
                System.out.println("Error: Target currency not found.");
                return -1;
            }
        } else {
            System.out.println("Error: API request failed.");
            return -1;
        }
    }
}
