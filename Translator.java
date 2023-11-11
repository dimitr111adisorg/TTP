import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class Translator {

    //private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";

    public static void translate() {

        boolean check = true;
        while (check = true) {
            System.out.println("Please press 1 for translation to French, 2 for translation to Italian, 3 for translation to Spanish, 0 to exit");
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
                System.out.println("See you next time!");
                check = false;
                break;
            }

        }
    }

    public static void translateToFrench() {
		final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
        boolean check = true;
        while (check = true) {

            System.out.println("Please insert a word or text aa to exit");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            String fromLang = "en";
            String toLang = "fr";
            if (text == "aa") { check=false; }
        }

    } //End translate to french

    public static void translateToItalian() {

        boolean check = false;
        while (check == false) {

            System.out.println("Please insert a word or text aa to exit");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            String fromLang = "en";
            String toLang = "it";

            if (text == "aa") { check = true; }
        }

    }//end translatetoitalian

    public static void translateToSpanish() {

        boolean check = true;
        while (check = true) {

            System.out.println("Please insert a word or text aa to exit");
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            String fromLang = "en";
            String toLang = "fr";

            if (text == "aa") { check = false; }


        }
    }//end translation to spanish

}
