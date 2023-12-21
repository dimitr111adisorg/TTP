import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class LogInSignInChangePassword {
    
    public static void chooseWhatToDo() throws Exception {
        
        System.out.println("Press 1 to log in, 2 to sign in, 3 to change password");
        Scanner a = new Scanner(System.in);
        int answer = a.nextInt();
        
        try {
            if (answer == 1) {
            
            LogInSignInChangePassword.logIn();
        } else if (answer == 2) {
            
            LogInSignInChangePassword.signIn();
            
        } else if (answer == 3) {
            LogInSignInChangePassword.changePassword();
        } else {
            System.out.println("Please enter a valid value");
            LogInSignInChangePassword.chooseWhatToDo();
        }
        } catch (Exception e) {
            System.out.println("Please enter valid value");
            LogInSignInChangePassword.chooseWhatToDo();
            // TODO: handle exception
        }
        /*if (answer == 1) {
            
            LogInSignInChangePassword.logIn();
        } else if (answer == 2) {
            
            LogInSignInChangePassword.signIn();
            
        } else if (answer == 3) {
            LogInSignInChangePassword.changePassword();
        } else {
            System.out.println("Please enter a valid value");
            LogInSignInChangePassword.chooseWhatToDo();
        }*/
    }
    
    public static void logIn() throws Exception {
        
        boolean check = true;
        while (check == true) {
            
            
            System.out.println("Please enter username");
            Scanner b = new Scanner(System.in);
            String usernameLogIn = b.nextLine();
            System.out.println("Please enter password. ONLY NUMBERS PLEASE!!"); 
            Scanner c = new Scanner(System.in);
            int passwordLogIn = c.nextInt();
            //String encryptedUsername = encrypt(usernameLogIn);
            if ( usernameLogIn == "hi")/*(usernameLogIn =! με τη βάση || passwordLogIn =! με τη βάση )*/  {
                System.out.println("Wrong or unfind username or password try again");
                LogInSignInChangePassword.logIn();
            } else {
                System.out.println("Welcome!");
                Menu a = new Menu(); 
                Menu.menu();
            }
        }
    }
    
    public static void signIn() throws Exception {
        
        boolean check = true;
        while (check == true) {
            
            System.out.println("Please enter username");
            Scanner b = new Scanner(System.in);
            String usernameSignIn = b.nextLine();
            System.out.println("Please enter password. ONLY NUMBERS PLEASE!!"); 
            Scanner c = new Scanner(System.in);
            int passwordSignIn = c.nextInt();
            //String encryptedUsername = encrypt(usernameLogIn);
            if ( usernameSignIn == "hi")/*(usernameLogIn == με τη βάση)*/  {
                System.out.println("Username already in use");
                LogInSignInChangePassword.signIn();
            } else {
                System.out.println("Thank you for your registration. We are redirecting you to menu");
                Menu a = new Menu(); 
                Menu.menu();
            }
        }
    }
    
    public static void changePassword() throws Exception {
        
        boolean check = true;
        while (check == true) {
            
            System.out.println("Please enter username");
            Scanner b = new Scanner(System.in);
            String usernameChange = b.nextLine();
            System.out.println("Please enter new password. ONLY NUMBERS PLEASE!!"); 
            Scanner c = new Scanner(System.in);
            int passwordChange = c.nextInt();
            System.out.println("Please verify new password. ONLY NUMBERS PLEASE!!"); 
            Scanner d = new Scanner(System.in);
            int passwordChangeVerify = d.nextInt();
            //String encryptedUsername = encrypt(usernameLogIn);
            if ( usernameChange == "hi")/*(usernameLogIn =! δεν υπαρχει στη βαση)*/  {
                System.out.println("Wrong or unfind username try again");
                LogInSignInChangePassword.changePassword();
            } else if (passwordChange != passwordChangeVerify) {
                System.out.println("The password and verify password do not match");
                LogInSignInChangePassword.changePassword();
            } else {
                System.out.println("Your password has change! We are redirecting you to the menu");
                Menu a = new Menu(); 
                Menu.menu();
            }
        }
    }
}
