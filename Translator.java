import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Translator {


    public static void translate(String username) throws Exception {

        boolean check = true;
        while (check=true) {
            System.out.println("Press: \n1 for translation to French, \n2 for translation toy Italian, \n3 for translation to Spanish. \nPress 0 to go back to menu");
            Scanner a = new Scanner(System.in);
            String one = a.nextLine();

            if (one.equals("1")) {
                //Translate to French
                Translator.translateToFrench(username);
            } else if (one.equals("2")) {
                //Translate to Italian
                Translator.translateToItalian(username);
            } else if (one.equals("3")) {
                //Translate to Spanish
                Translator.translateToSpanish(username);
            } else if (one.equals("0")){
                System.out.println("Back to menu");
                check = false;
                Menu.menu(username);
            } else {
                System.out.println("Please enter a valid value");
                Translator.translate(username);
            }
        }
    }

    public static void translateToFrench(String username) throws Exception {

		final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
		final String CLIENT_ID = "t8210213@aueb.gr";
  		final String CLIENT_SECRET = "c1cdce16ea404052a366e390ac25de17";
        boolean check = true;
        while (check == true) {

            System.out.println("Please insert a word");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            Validation a = new Validation();
            boolean isValid = Validation.validWord(text);
            if (isValid == false) {
                System.out.println("Invalid word. Press 1 to enter a valid one or press 0 to exit");
                Scanner unvalidForFrench = new Scanner(System.in);
                String validWordFrench = unvalidForFrench.nextLine();
                if (validWordFrench.equals("0")) {
                    Translator.translate(username);
                } else if (validWordFrench.equals("1")) {
                    Translator.translateToFrench(username);
                } else {
                    System.out.println("Please enter a valid value");
                }
            } else {
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
                System.out.print("The word in french is:");
        
                BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream(), StandardCharsets.UTF_8));
                String output;
                String translation = null;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    translation = output;
                }

                conn.disconnect();
                System.out.println("Do you want to save this word?\nType yes or no");
                boolean flag = true;
                Scanner answerFrench = new Scanner(System.in);
                String answer = answerFrench.nextLine();
                do {
                    if (answer.equals("yes") || answer.equals("YES")) {
                        flag = false;
                        SavedWords.saveFrenchToBD(username, text, translation);
                    } else if (answer.equals("no") || answer.equals("NO")) {
                        flag = false;
                    } else {
                        System.out.println("Your answer must be 'yes' or 'no'.");
                        answer = in.nextLine();
                    }
                } while (flag);
                System.out.println("Would you like to keep translating to French?\nPress 1 for yes and 0 to go back to menu");
                while (check == true) {
                    String frenchAnswer = answerFrench.nextLine();
                    if (frenchAnswer.equals("1")) {
                        Translator.translateToFrench(username);
                    } else if (frenchAnswer.equals("0")) {
                        check = false;
                        Menu.menu(username);
                        Translator.translate(username);
                    } else {
				        System.out.println("Please insert a valid value (0 or 1)");
                    }
                }
            }
        }
    }//end translation to french

    public static void translateToItalian(String username) throws Exception {
        final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
		final String CLIENT_ID = "t8210213@aueb.gr";
  		final String CLIENT_SECRET = "c1cdce16ea404052a366e390ac25de17";
        boolean check = true;
        while (check == true) {

            System.out.println("Please insert a word");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            Validation b = new Validation();
            boolean isValid = Validation.validWord(text);
            if (isValid == false) {
                System.out.println("Unvalid word. Press 1 to enter a valid one or 0 to exit");
                Scanner unvalidForItalian = new Scanner(System.in);
                int validWordItalian = unvalidForItalian.nextInt();
                if (validWordItalian == 0) {
                    Translator.translate(username);
                } else if (validWordItalian == 1) {
                    Translator.translateToItalian(username);
                } else {
                    System.out.println("Please enter a valid value");
                }
            } else {
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
                //System.out.println("Status Code: " + statusCode);
                /*BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()));
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }*/
                System.out.print("The word in italian is:");
                BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream(), StandardCharsets.UTF_8));
                String output;
                String translation = null;
                while ((output = br.readLine()) != null) {
                    System.out.println(new String(output.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
                    translation = output;
                }
                conn.disconnect();

                System.out.println("Do you want to save this word?\nType yes or no");
                boolean flag = true;
                Scanner answerItalian = new Scanner(System.in);
                String answer = answerItalian.nextLine();
                do {
                    if (answer.equals("yes") || answer.equals("YES")) {
                        flag = false;
                         SavedWords.saveItalianToBD(username, text, translation);
                    } else if (answer.equals("no") || answer.equals("NO")) {
                        flag = false;
                    } else {
                        System.out.println("Your answer must be 'yes' or 'no'.");
                        answer = in.nextLine();
                    }
                } while (flag);
                System.out.println("Would you like to keep translating to Italian?\nPress 1 for yes and 0 to go back to menu");
                while (check == true) {
                    String frenchAnswer = answerItalian.nextLine();
                    if (frenchAnswer.equals("1")) {
                        Translator.translateToFrench(username);
                    } else if (frenchAnswer.equals("0")) {
                        check = false;
                        Menu.menu(username);
                        Translator.translate(username);
                    } else {
				        System.out.println("Please insert a valid value (0 or 1)");
                    }
                }
            }
        }

    }//end translation to italian

    public static void translateToSpanish(String username) throws Exception {

        final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
		final String CLIENT_ID = "t8210213@aueb.gr";
  		final String CLIENT_SECRET = "c1cdce16ea404052a366e390ac25de17";
        boolean check = true;
        while (check == true) {

            System.out.println("Please insert a word");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            Validation c = new Validation();
            boolean isValid = Validation.validWord(text);
            if (isValid == false) {
                System.out.println("Invalid word.Press 1 to enter a valid one or 0 to exit");
                Scanner unvalidForSpanish = new Scanner(System.in);
                String validWordSpanish = unvalidForSpanish.nextLine();
                if (validWordSpanish.equals("0")) {
                    Translator.translate(username);
                } else if (validWordSpanish.equals("1")) {
                    Translator.translateToSpanish(username);
                } else {
                    System.out.println("Please enter a valid value");
                }
            } else {
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
                //System.out.println("Status Code: " + statusCode);
                System.out.print("The word in spanish is:");
                BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()));
                String output;
                String translation = null;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    translation = output;
                }
                conn.disconnect();
                System.out.println("Do you want to save this word?\nType yes or no");
                boolean flag = true;
                Scanner answerSpanish = new Scanner(System.in);
                String answer = answerSpanish.nextLine();
                do {
                    if (answer.equals("yes") || answer.equals("YES")) {
                        flag = false;
                         SavedWords.saveSpanishToBD(username, text, translation);
                    } else if (answer.equals("no") || answer.equals("NO")) {
                        flag = false;
                    } else {
                        System.out.println("Your answer must be 'yes' or 'no'.");
                        answer = in.nextLine();
                    }
                } while (flag);
                System.out.println("Would you like to keep translating to Spanish?\nPress 1 for yes and 0 to go back to menu");
                while (check == true) {
                    String frenchAnswer = answerSpanish.nextLine();
                    if (frenchAnswer.equals("1")) {
                        Translator.translateToFrench(username);
                    } else if (frenchAnswer.equals("0")) {
                        check = false;
                        Menu.menu(username);
                        Translator.translate(username);
                    } else {
			System.out.println("Please insert a valid value (0 or 1)");
                    }
                }
            }
        }

    }//end translation to spanish
}
