import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class Translator {


    public static void translate() throws Exception {

        boolean check = true;
        while (check=true) {
            System.out.println("Please press 1 for translation to French, 2 for translation toy Italian, 3 for translation to Spanish");
            Scanner a = new Scanner(System.in);
            int one = a.nextInt();

            if (one == 1) {
                //Translate to French
                Translator.translateToFrench();
            } else if (one == 2) {
                //Translate to Italian
                Translator.translateToItalian();
            } else if (one == 3) {
                //Translate to Spanish
                Translator.translateToSpanish();
            } else {
                System.out.println("See you next time");
                check = false;
            }
        }
    }

    public static void translateToFrench() throws Exception {

		final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
		final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
  		final String CLIENT_SECRET = "PUBLIC_SECRET";
        boolean check = true;
        while (check == true) {

            System.out.println("Please insert a word");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            //boolean valid = true;
            //Validation a = new Validation();
            //Validation.wordValidation(text,valid);
            String fromLang = "en";
            String toLang = "fr";
            String jsonPayload = new StringBuilder()
            .append("{")
            .append("\"fromLang\":\"")
            .append(fromLang)
            .append("\",")
            .append("\"toLang\":\"")
            .append(toLang)
            .append("\",")
            .append("\"text\":\"")
            .append(text)
            .append("\"")
            .append("}")
            .toString();

            URL url = new URL(ENDPOINT);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
            conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(jsonPayload.getBytes());
            os.flush();
            os.close();

            int statusCode = conn.getResponseCode();
            System.out.println("Status Code: " + statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()));
            String output;
            while ((output = br.readLine()) != null) {
            System.out.println(output);
            }
            conn.disconnect();
            System.out.println("Would you like to keep translating to French?Press 1 for yes and 0 for no.");

            while (check == true) {
                Scanner answerFrench = new Scanner(System.in);
                int frenchAnswer = answerFrench.nextInt();
                if (frenchAnswer == 1) {
                    Translator.translateToFrench();
                } else if (frenchAnswer == 0) {
                    check = false;
                } else {
					System.out.println("Please insert a valid value");
                }
            }
        }
    }//end translation to french

    public static void translateToItalian() throws Exception {
        final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
		final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
  		final String CLIENT_SECRET = "PUBLIC_SECRET";
        boolean check = true;
        while (check == true) {

            System.out.println("Please insert a word");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            String fromLang = "en";
            String toLang = "it";
            String jsonPayload = new StringBuilder()
            .append("{")
            .append("\"fromLang\":\"")
            .append(fromLang)
            .append("\",")
            .append("\"toLang\":\"")
            .append(toLang)
            .append("\",")
            .append("\"text\":\"")
            .append(text)
            .append("\"")
            .append("}")
            .toString();

            URL url = new URL(ENDPOINT);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
            conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(jsonPayload.getBytes());
            os.flush();
            os.close();

            int statusCode = conn.getResponseCode();
            System.out.println("Status Code: " + statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()));
            String output;
            while ((output = br.readLine()) != null) {
            System.out.println(output);
            }
            conn.disconnect();
            System.out.println("Would you like to keep translating to Italian?Press 1 for yes and 0 for no.");

            while (check == true) {
                Scanner answerItalian = new Scanner(System.in);
                int italianAnswer = answerItalian.nextInt();
                if (italianAnswer == 1) {
                    Translator.translateToItalian();
                } else if (italianAnswer == 0) {
                    check = false;
                } else {
					System.out.println("Please insert a valid value");
                }
            }
        }

    }//end translation to italian

    public static void translateToSpanish() throws Exception {

        final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
		final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
  		final String CLIENT_SECRET = "PUBLIC_SECRET";
        boolean check = true;
        while (check == true) {

            System.out.println("Please insert a word");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            String fromLang = "en";
            String toLang = "es";
            String jsonPayload = new StringBuilder()
            .append("{")
            .append("\"fromLang\":\"")
            .append(fromLang)
            .append("\",")
            .append("\"toLang\":\"")
            .append(toLang)
            .append("\",")
            .append("\"text\":\"")
            .append(text)
            .append("\"")
            .append("}")
            .toString();

            URL url = new URL(ENDPOINT);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
            conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(jsonPayload.getBytes());
            os.flush();
            os.close();

            int statusCode = conn.getResponseCode();
            System.out.println("Status Code: " + statusCode);
            BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()));
            String output;
            while ((output = br.readLine()) != null) {
            System.out.println(output);
            }
            conn.disconnect();
            System.out.println("Would you like to keep translating to Spanish?Press 1 for yes and 0 for no.");

            while (check == true) {
                Scanner answerSpanish = new Scanner(System.in);
                int spanishAnswer = answerSpanish.nextInt();
                if (spanishAnswer == 1) {
                    Translator.translateToSpanish();
                } else if (spanishAnswer == 0) {
                    check = false;
                } else {
					System.out.println("Please insert a valid value");
                }
            }
        }

    }//end translation to spanish
}