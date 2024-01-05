import java.util.Scanner;

public class Menu {

    public static void menu(String username) throws Exception {

        boolean check = true;
        while (check == true) {
            System.out.println("\nPress: \n1 To Translate, \n2 To Learn, \n3 To see your saved words/questions \nPress 0 to exit");
            Scanner in = new Scanner(System.in);
            String answer =in.nextLine();
            if (answer.equals("1")) {
                Translator.translate(username);
            } else if (answer.equals("2")) {
                Learning.MultipleChoice(username);
            } else if (answer.equals("3")) {
                System.out.println("\nPress 4 to see the saved words and 5 to see the saved questions\nPress 0 to go back to menu");
                Scanner on = new Scanner(System.in);
                String answer2 = on.nextLine();
                if (answer2.equals("4")) {
                    SavedWords.showSavedWords(username);
                 } else if (answer2.equals("5")) {
                    QuestionsList.showSavedQuestions(username);
                 } else if (answer2.equals("0")) {
                    menu(username);
                 } else {
                    System.out.println("Please enter a valid answer (4 or 5)");
                    answer2 = in.nextLine();
                 }
            } else if (answer.equals("0")) {
                System.out.println("See you next time!");
                check = false;
                System.exit(0);
            } else {
                System.out.println("Please enter a valid answer (0, 1, 2, or 3)");
                answer = in.nextLine();
            }
        }
    } 
}
