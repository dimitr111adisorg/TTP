import java.util.Scanner;
public class Menu {
    
    public static void menu() throws Exception {
        
        boolean check = true; 
        while (check == true) {
            System.out.println("Press 1 to translate, 2 to learn, 3 to see everything you have saved. Press 0 to exit");
            Scanner in = new Scanner(System.in);
            int answer =in.nextInt();
            if (answer == 2) {
                Learning2 a = new Learning2();
                Learning2.MultipleChoice();
                
            } else if ( answer == 3) {
                System.out.println("Press 4 to see the saved words and 5 to see the saved questions");
                Scanner on = new Scanner(System.in);
                int answer2 = on.nextInt();
                if (answer2 == 4) {
                    TranslationHistory translationHistory = new TranslationHistory();
                    translationHistory.displayHistory();
                    
                } else if (answer2 == 5) {
                    QuestionsList.showSavedQuestions("1");
                    QuestionsList.showSavedQuestions("2");
                    QuestionsList.showSavedQuestions("3");
                }
                
            } else if (answer == 1) {
                Translator b = new Translator();
                Translator.translate();
            } else if (answer == 0) {
                System.out.println("See you next time"); 
                check = false;
            } else {
                System.out.println("Enter a valid value");
            }
        }
    }
}
