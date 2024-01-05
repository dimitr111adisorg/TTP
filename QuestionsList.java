import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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
                System.out.println("Question saved!\n");
                pstmt.close();
                conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
                
    }

    public static void showSavedQuestions(String username) {
        System.out.println("\nSelect language:");
        System.out.println("1 French \n2 Spanish \n3 Italian");
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
        if (selectedQuestions.isEmpty()) {
            System.out.println("No questions saved for the selected language.");
        } else {
            System.out.println("\nSaved Questions:");
            int i = 0;
            for (Questions q: selectedQuestions){
            i++;
            System.out.println("Question no"+(i)+":");
            try {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
                writer.println(q.getQuestion());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print("a. ");
            try {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
                writer.println(q.getAnswer1());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print("b. ");
             try {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
                writer.println(q.getAnswer2());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print("c. ");
             try {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
                writer.println(q.getAnswer3());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Correct Answer: "+q.getCorrectAnswer()+"\n");
        }
        }
    }

    private static List<Questions> getQuestionsList(String username, String language) {
        List<Questions> selectedQuestions = new ArrayList<Questions>();
        String sql = "SELECT * FROM SavedQuestions where username = ? AND language = ?";
        ResultSet rs = null;
        String lang;
        if (language.equals("1")) {
               lang = "french";
        } else if (language.equals("2")) {
            lang = "spanish";
        } else {
            lang = "italian";
        }
        try (Connection conn = Connect.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, lang);
                rs  = pstmt.executeQuery();
                while (rs.next()){
                    selectedQuestions.add(new Questions(rs.getString("question"),rs.getString("answer1"), rs.getString("answer2"), rs.getString("answer3"), rs.getString("correct_answer")));  
                }
                pstmt.close();
                conn.close();
                return selectedQuestions; 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return selectedQuestions;
    }
}
