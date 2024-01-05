import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SavedWords {
    
    public static void saveFrenchToBD(String currentUserString, String text, String output) throws SQLException {
        String sql = "INSERT INTO TranslationHistory (username, UserText, translation, language) VALUES (?, ?, ?, ?)";
            try (Connection conn = Connect.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)) {
                pstmt.setString(1, currentUserString);
                pstmt.setString(2, text);
                pstmt.setString(3, output);
                pstmt.setString(4, "french");
                pstmt.executeUpdate();
                System.out.println("Word saved!\n");
                pstmt.close();
                conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void saveItalianToBD(String username, String text, String output) throws SQLException {
        String sql = "INSERT INTO TranslationHistory (username, UserText, translation, language) VALUES (?, ?, ?,?)";
        try (Connection conn = Connect.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, text);
                pstmt.setString(3, output);
                pstmt.setString(4, "italian");
                pstmt.executeUpdate();
                System.out.println("Word saved!\n");
                pstmt.close();
                conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
        public static void saveSpanishToBD(String username, String text, String output) throws SQLException {
        String sql = "INSERT INTO TranslationHistory (username, UserText, translation, language) VALUES (?, ?, ?, ?)";
            try (Connection conn = Connect.connect(); PreparedStatement pstmt  = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, text);
                pstmt.setString(3, output);
                pstmt.setString(4, "spanish");
                pstmt.executeUpdate();
                System.out.println("Word saved!\n");
                pstmt.close();
                conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void showSavedWords(String username) {
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
        List<Words> selectedWords = getWords(username, language);
        if (selectedWords.isEmpty()) {
            System.out.println("No words saved for the selected language.");
        } else {
            System.out.println("Saved Questions:");
            for (Words q : selectedWords) {
                System.out.print("The word you entered:");
                System.out.println(q.getText());
                System.out.print("The translation:");
                System.out.println(q.getTranslation()+"\n");
            }
        }
    }
    
    public static List<Words> getWords(String username, String language) {
        List<Words> selectedWords = new ArrayList<Words>();
        String sql = "SELECT * FROM TranslationHistory where username = ? and language = ?";
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
                    selectedWords.add(new Words(rs.getString("UserText"),rs.getString("translation")));
                }
                pstmt.close();
                conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return selectedWords;
    }
}
