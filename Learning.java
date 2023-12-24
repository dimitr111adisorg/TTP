import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Learning {
    public static void MultipleChoice () {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Select language:");
        System.out.println("1. French \n2. Spanish \n3. Italian");
        System.out.println("Type 1,2 or 3");

        boolean flag = true;
        String language = in.nextLine();
        do {
                if (language.equals("1") || language.equals("2") || language.equals("3")) {
                    flag = false;
                } else {
                    System.out.println("Please enter a valid answer (1, 2 or 3)");
                    language = in.nextLine();
                }
         } while (flag);

        List<Questions> Q = new ArrayList<Questions>();
        Q = getQuestions(language);
        System.out.println("\nTo answer the questions type a,b or c\n");
        int i = 0;
        for (Questions q: Q){
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

            String choice = in.nextLine();
            flag = true;
            do {
                if (choice.equals("a") || choice.equals("b") || choice.equals("c")) {
                    flag = false;
                } else {
                    System.out.println("Please enter a valid answer (a, b or c)");
                    choice = in.nextLine();
                }
            } while (flag);
            
            if (choice.equals(q.getCorrectAnswer())) {
                System.out.println("Your answer is correct!\n");
            } else {
                System.out.println("Your answer is wrong!\nThe correct answer is "+q.getCorrectAnswer()+"\n");
                System.out.println("Do you wanna save this question for later? Type yes or no");
                String answer = in.nextLine();
                flag = true;
                do {
                    if (answer.equals("yes") || answer.equals("no") || answer.equals("YES") || answer.equals("NO")) {
                        flag = false;
                    } else {
                        System.out.println("Your answer must be 'yes' or 'no'.");
                        answer = in.nextLine();
                    }
                } while (flag);
            }
        }
        in.close();
           
    }

    public static List<Questions> getQuestions(String choice) {
        String sql;
        if (choice.equals("1")) {
            sql = "Select * from FrenchQuestions";
        } else if (choice.equals("2")) {
            sql = "Select * from SpanishQuestions";
        } else {
            sql = "Select * from ItalianQuestions";
        }
        List<Questions> QUESTIONS = new ArrayList<Questions>();
        try (Connection conn = Connect.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                QUESTIONS.add(new Questions(rs.getInt("question_id"), rs.getString("question_text"),rs.getString("answer1"), rs.getString("answer2"), rs.getString("answer3"), rs.getString("correct_answer")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Random random = new Random();
        int upperbound = 10;
        int random1 = random.nextInt(upperbound);
        List<Questions> Q = new ArrayList<Questions>();
        Q.add(QUESTIONS.get(random1));
        try {
            // Set the console encoding to UTF-8
           System.setOut(new PrintStream(System.out, true, "ISO-8859-3"));
        } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
        }
        int random2;
        int random3;
        do {
          random2 = random.nextInt(upperbound);
          random3 = random.nextInt(upperbound);
        } while (check(random1, random2, random3));
        Q.add(QUESTIONS.get(random2));
        Q.add(QUESTIONS.get(random3));
        return Q;

    }


    private static boolean check(int random1, int random2, int random3) {
        boolean flag = true;
        if (random1!=random2 && random1!=random3 && random2!=random3) {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        MultipleChoice();

    }    
}

