package progrII;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
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

        String [][] questions = new String[3][5];
        questions = getQuestions(language);
        System.out.println("\nTo answer the questions type a,b or c\n");
        for (int i=0;i<3;i++){
            System.out.println("Question no"+(i+1)+":");
            System.out.println(questions[i][0]);
            for (int j=1;j<4;j++){
                if (j==1) System.out.print("a. ");
                if (j==2) System.out.print("b. ");
                if (j==3) System.out.print("c. ");
                System.out.println(questions[i][j]);
            }
            flag = true;
            String choice = in.nextLine();
            do {
                if (choice.equals("a") || choice.equals("b") || choice.equals("c")) {
                    flag = false;
                } else {
                    System.out.println("Please enter a valid answer (a, b or c)");
                    choice = in.nextLine();
                }
            } while (flag);
            
            if (choice.equals(questions[i][4])) {
                System.out.println("Your answer is correct!\n");
            } else {
                System.out.println("Your answer is wrong!\nThe correct answer is "+questions[i][4]+"\n");
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

    public static String[][] getQuestions(String choice) {
        String [][] UserQuestions = new String[9][5];
        Questions obj = new Questions();
        if (choice.equals("1")) {
            UserQuestions = obj.French();
        } else if (choice.equals("2")) {
            UserQuestions = obj.Spanish();
        } else if (choice.equals("3")){
            UserQuestions = obj.Italian();
        }
        Random random = new Random();
        int upperbound = 10;
        int int_random = random.nextInt(upperbound); 
        int i = 0;
        String [][] Q = new String[3][5];
        for (int j = 0;j<5;j++) {
            Q[i][j] = UserQuestions[int_random][j];
        }
        try {
            // Set the console encoding to UTF-8
           System.setOut(new PrintStream(System.out, true, "ISO-8859-3"));
        } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
        }
        do {
            i = i + 1;
            do {
              int_random = random.nextInt(upperbound);   
            } while (check(Q, int_random, i, UserQuestions));
            for (int j = 0;j<5;j++) {
            Q[i][j] = UserQuestions[int_random][j];
            }
        } while (i<2);
        return Q;

    }


    private static boolean check(String[][] Q, int int_random, int i, String [][] UserQuestions) {
        boolean flag = false;
        for (int l = 0; l < i; l++) {
            if (Q[l][0].equals(UserQuestions[int_random][0])) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }
    
}
    
