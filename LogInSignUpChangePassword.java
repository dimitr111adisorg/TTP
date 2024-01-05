import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogInSignInChangePassword {
    
    public static void chooseWhatToDo() throws Exception {
        Scanner a = new Scanner(System.in);
        String username = null;
        boolean flag = true;
        System.out.println("Press: \n1 to log in, \n2 to sign up, \n3 to change password");
        String answer = a.nextLine();
        do {
            if (answer.equals("1")) {
                flag = false;
                username = logIn();
            } else if (answer.equals("2")) {
                flag = false;
                username = signUp();
            } else if (answer.equals("3")) {
                changePassword();
            } else {
                System.out.println("Please enter a valid answer (1,2 or 3)");
                answer = a.nextLine();
            }
        } while (flag);  
        Menu.menu(username);
    }

    private static String logIn() {
        Scanner b = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Please type your username");
            String username = b.nextLine();
            System.out.println("Please type your password");
            String password = b.nextLine();
            String sql = "Select * from Users Where username = ? and password = ?";
            try (Connection conn = Connect.connect();
                    PreparedStatement pstmt  = conn.prepareStatement(sql)){
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        flag = false;
                        User currentUser = new User(username, password);
                        System.out.println("Welcome back, "+currentUser.getUsername()+"!");
                        return currentUser.getUsername();
                    } else {
                        System.out.println("Wrong username or password. Try again");
                    }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } while (flag); 
        return null;  
    }

    private static String signUp() {
        Scanner c = new Scanner(System.in);
        System.out.println("Please enter a username:");
        String username = c.nextLine();
        boolean flag = true;
        do {
           String sql = "Select * From Users Where username = ?";
            try (Connection conn = Connect.connect();
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
                pstmt.setString(1, username);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("This username already exists! Please choose something else!");
                    username = c.nextLine();
                } else {
                    flag = false;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        } while (flag);
        System.out.println("Please enter your password");
        String password = c.nextLine();
        String sql2 = "Insert into Users (username, password) Values (?,?)";
        try (Connection conn = Connect.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql2)){
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            User currentUser = new User(username, password);
            System.out.println("Welcome, "+currentUser.getUsername());
            return currentUser.getUsername();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return null;
    }

    private static void changePassword() {
        Scanner d = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = d.nextLine();
        System.out.println("Please enter your current password:");
        String password = d.nextLine();
        boolean flag = true;
        do {
           String sql = "Select * From Users Where username = ? and password = ?";
            try (Connection conn = Connect.connect();
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    flag = false;
                } else {
                    System.out.println("Wrong username or password. Try again!");
                    System.out.println("Please enter your username:");
                    username = d.nextLine();
                    System.out.println("Please enter your current password:");
                    password = d.nextLine();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        } while (flag);
        System.out.println("Type your new password");
        String newPassword = d.nextLine();
        String sql2 = "UPDATE users SET password=? Where username=?";
        try (Connection conn = Connect.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql2)) {
            pstmt.setString(1, username);
            pstmt.setString(2, newPassword);
            pstmt.executeUpdate();
            User currentUser = new User(username, newPassword);
            System.out.println(currentUser.getUsername()+",your password has been changed successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
