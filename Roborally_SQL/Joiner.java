import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Joiner {
    public static void main(String[] args) {
        String url = "jdbc:mysql://10.110.64.31:3306/roborally";
        String username = "RoboPlayer";
        String password = "Player";
        Connection connection = null;
        Statement statement = null;
        ResultSet RobotSet = null;
        String PersColor;
        Scanner Scan = new Scanner(System.in);
        System.out.println("Enter Your Color");
        //Color = Scan.nextLine();
        PersColor = "RED";
        while(true){
           try {
              //establish cennection
              connection = DriverManager.getConnection(url, username, password);
              statement = connection.createStatement();
           
              //read database
              
              String Robotquery = "SELECT * FROM registers WHERE Color = '"+PersColor+"'";
              RobotSet = statement.executeQuery(Robotquery);
              
              
                 if(RobotSet.next()){
                   
                    if (RobotSet.getInt("AskForRegister") == 1) {
                       
  
                       System.out.println("Enter name of card1");
                       String Card1 = Scan.nextLine();
                       System.out.println("Enter name of card2");
                       String Card2 = Scan.nextLine();
                       System.out.println("Enter name of card3");
                       String Card3 = Scan.nextLine();
                       System.out.println("Enter name of card4");
                       String Card4 = Scan.nextLine();
                       System.out.println("Enter name of card5");
                       String Card5 = Scan.nextLine();
                       String AskForRegister = "FALSE";
                       String query = "UPDATE registers SET Card1 = '" +Card1+"',Card2 = '"+Card2+"',Card3 = '"+Card3+"',Card4 = '"+Card4+"',Card5 = '"+Card5+"',AskForRegister = "+AskForRegister+" WHERE Color = '"+PersColor+"'";
                       statement.executeUpdate(query);
                    }
                 }  
                 try {
                    //Thread.sleep(1000);
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                  }
                 
              } 
              catch (SQLException e) {
                 e.printStackTrace();
              } finally {
                 try {
                   
                    RobotSet.close();
                    statement.close();
                    connection.close();
                 } catch (SQLException e) {
                    e.printStackTrace();
                 }
              }
        }
      
     }
}
