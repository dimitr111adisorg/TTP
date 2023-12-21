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


    public static void translate() throws Exception {

        boolean check = true;
        while (check=true) {
            System.out.println("Please press 1 for translation to French, 2 for translation toy Italian, 3 for translation to Spanish. Press 0 to exit");
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
            } else if (one == 0){
                System.out.println("See you next time");
                check = false;
            } else {
                System.out.println("Please enter a valid value");
                Translator.translate();
            }
        }
    }

    public static void translateToFrench() throws Exception {

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
                int validWordFrench = unvalidForFrench.nextInt();
                if (validWordFrench == 0) {
                    Translator.translate();
                } else if (validWordFrench == 1) {
                    Translator.translateToFrench();
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
                //System.out.println("Status Code: " + statusCode);
                System.out.print("The word in french is:");
                /*BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()));
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }*/
                BufferedReader br = new BufferedReader(new InputStreamReader((statusCode == 200) ? conn.getInputStream() : conn.getErrorStream(), StandardCharsets.UTF_8));
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);//new String(output.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
                }
                conn.disconnect();
                System.out.println("Would you like to keep translating to French?Press 1 for yes and 0 for no. Press 2 if yoy want to save the word!");

                while (check == true) {
                    Scanner answerFrench = new Scanner(System.in);
                    int frenchAnswer = answerFrench.nextInt();
                    if (frenchAnswer == 1) {
                        Translator.translateToFrench();
                    } else if (frenchAnswer == 0) {
                        check = false;
                        Translator.translate();
                    } else if (frenchAnswer == 2) {
                        TranslationHistory.addTranslation("French",text,output); // frenchTranslation);
                        check = false;
                    } else {
				        System.out.println("Please insert a valid value");
                    }
                }
            }
        }
    }//end translation to french

    public static void translateToItalian() throws Exception {
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
                    Translator.translate();
                } else if (validWordItalian == 1) {
                    Translator.translateToItalian();
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
                while ((output = br.readLine()) != null) {
                    System.out.println(new String(output.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
                }
                conn.disconnect();
                System.out.println("Would you like to keep translating to Italian?Press 1 for yes and 0 for no.Press 2 if you want to save the word!");

                while (check == true) {
                    Scanner answerItalian = new Scanner(System.in);
                    int italianAnswer = answerItalian.nextInt();
                    if (italianAnswer == 1) {
                        Translator.translateToItalian();
                    } else if (italianAnswer == 0) {
                        check = false;
                        Translator.translate();
                    } else if (italianAnswer == 2) {
                        TranslationHistory.addTranslation("Italian",text, output); //italianTranslation);
                        check = false;
                    } else {
					    System.out.println("Please insert a valid value");
                    }
                }
            }
        }

    }//end translation to italian

    public static void translateToSpanish() throws Exception {

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
                int validWordSpanish = unvalidForSpanish.nextInt();
                if (validWordSpanish == 0) {
                    Translator.translate();
                } else if (validWordSpanish == 1) {
                    Translator.translateToFrench();
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
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
                conn.disconnect();
                System.out.println("Would you like to keep translating to Spanish?Press 1 for yes and 0 for no. Press 2 to save the word!");

                while (check == true) {
                    Scanner answerSpanish = new Scanner(System.in);
                    int spanishAnswer = answerSpanish.nextInt();
                    if (spanishAnswer == 1) {
                        Translator.translateToSpanish();
                    } else if (spanishAnswer == 0) {
                        check = false;
                        Translator.translate();
                    }else if(spanishAnswer == 2) {
                        TranslationHistory.addTranslation("Spanish",text, output); //spanishTranslation);
                        check = false;
                    } else {
	    				System.out.println("Please insert a valid value");
                    }
                }
            }
        }

    }//end translation to spanish
}