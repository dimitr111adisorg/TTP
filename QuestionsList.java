import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionsList {
 
    public static void saveQuestion(String username, String question, String answer1, String answer2, String answer3, String correct_answer, String language) throws SQLException {
        String sql = "INSERT INTO SavedQuestions (username, question, answer1, answer2, answer3, correct_answer, language) VALUES (?, ?, ?, ?, ?, ?, ?)";             
        try (Connection conn = Connect.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, question);
                pstmt.setString(3, answer1);
                pstmt.setString(4, answer2);
                pstmt.setString(5, answer3);
                pstmt.setString(6, correct_answer);
                if (language.equals("1")) {
                    pstmt.setString(7, "french");
                } else if (language.equals("2")) {
                    pstmt.setString(7, "spanish");
                } else if (language.equals("3")){
                    pstmt.setString(7, "italian");
                }
                pstmt.executeUpdate();
                System.out.println("Question saved!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
                
    }

    public static void showSavedQuestions(String username) {
        System.out.println("Select language:");
        System.out.println("1. French \n2. Spanish \n3. Italian");
        System.out.println("Type 1,2 or 3");

        boolean flag = true;
        Scanner in = new Scanner(System.in);
        String language = in.nextLine();
        do {
                if (language.equals("1") || language.equals("2") || language.equals("3")) {
                    flag = false;
                } else {
                    System.out.println("Please enter a valid answer (1, 2 or 3)");
                    language = in.nextLine();
                }
         } while (flag);
        List<Questions> selectedQuestions = getQuestionsList(username, language);
        in.close();
        if (selectedQuestions.isEmpty()) {
            System.out.println("No questions saved for the selected language.");
        } else {
            System.out.println("Saved Questions:");
            for (Questions q : selectedQuestions) {
                System.out.println(q.getQuestion());
                System.out.print("a. ");
                System.out.println(q.getAnswer1());
                System.out.print("b. ");
                System.out.println(q.getAnswer2());
                System.out.print("c. ");
                System.out.println(q.getAnswer3());
                System.out.println("Correct answer: "+q.getCorrectAnswer());
                System.out.println();
            }
        }
    }

    private static List<Questions> getQuestionsList(String username, String language) {
        List<Questions> selectedQuestions = new ArrayList<Questions>();
        String sql = "SELECT * FROM SavedQuestions where username = ? AND language = ?";
        ResultSet rs = null;
        try (Connection conn = Connect.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                if (language.equals("1")) {
                    pstmt.setString(2, "french");
                } else if (language.equals("2")) {
                    pstmt.setString(2, "spanish");
                } else if (language.equals("3")){
                    pstmt.setString(2, "italian");
                }
                rs  = pstmt.executeQuery();
                while (rs.next()){
                    selectedQuestions.add(new Questions(rs.getString("question"),rs.getString("answer1"), rs.getString("answer2"), rs.getString("answer3"), rs.getString("correct_answer")));
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return selectedQuestions;
    }
}
