import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class QuestionsList {
    private static final List<String[]> frenchQuestions = new ArrayList<>();
    private static final List<String[]> spanishQuestions = new ArrayList<>();
    private static final List<String[]> italianQuestions = new ArrayList<>();

    public static void saveQuestion(String[] question, String language) {
        switch (language) {
            case "1":
                frenchQuestions.add(question);
                break;
            case "2":
                spanishQuestions.add(question);
                break;
            case "3":
                italianQuestions.add(question);
                break;
            default:
                System.out.println("Invalid language choice.");
                break;
        }
        System.out.println("Question saved");
    }

    public static void showSavedQuestions(String language) {
        List<String[]> selectedQuestions = getQuestionsList(language);

        if (selectedQuestions.isEmpty()) {
            System.out.println("No questions saved for the selected language.");
        } else {
            System.out.println("Saved Questions:");
            for (String[] q : selectedQuestions) {
                System.out.println(Arrays.toString(q));
            }
        }
    }

    private static List<String[]> getQuestionsList(String language) {
        switch (language) {
            case "1":
                return frenchQuestions;
            case "2":
                return spanishQuestions;
            case "3":
                return italianQuestions;
            default:
                System.out.println("Invalid language choice.");
                return new ArrayList<>();
        }
    }
}
