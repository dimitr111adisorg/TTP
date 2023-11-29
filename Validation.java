import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Validation {

    public static boolean validWord(String text) {
        String apiKey = "8f1b4d01-17e0-438b-9e34-c910d040e010"; // Replace with your API key
        String wordToValidate = text; // Word to validate
        boolean realWord = true;

        try {
            String encodedWord = URLEncoder.encode(wordToValidate, "UTF-8");
            String apiUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/" + encodedWord;

            // Create URL
            URL url = new URL(apiUrl);

            // Create connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Get response
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the response - check if the word exists
                if (!response.toString().contains("404")) {
                    //System.out.println("The word '" + wordToValidate + "' exists.");
                    realWord = true;
                } else {
                    //System.out.println("The word '" + wordToValidate + "' does not exist.");
                    realWord = false;
                }
            } else {
                System.out.println("Failed to fetch data. Response code: " + responseCode);
                realWord = false; 
            }

            // Disconnect the connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return realWord;
    } 
} 