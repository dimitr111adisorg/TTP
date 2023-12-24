import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    /** 
     * Connect to a sample database 
     * @return 
     */  
    public static Connection connect() {  
        Connection conn = null;  
        try {  
            // db parameters  
            String url = "jdbc:sqlite:C:\\SQLite\\DataBase.db";  
            // create a connection to the database
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(url);  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return conn; 
    }
}
