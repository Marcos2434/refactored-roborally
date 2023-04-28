import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Host {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/roborally";
        String username = "root";
        String password = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet RobotSet = null;
        String PersColor = null;
       
        
        
  
        Scanner scanner = new Scanner(System.in);
        try {
           //establish cennection
           connection = DriverManager.getConnection(url, username, password);
           statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           //read database
            
           String Robotquery = "SELECT * FROM registers";
           RobotSet = statement.executeQuery(Robotquery);
           statement.executeUpdate("DELETE FROM registers");
           System.out.println("Enter a robot color that will play, if done type DONE");
  
           String ans = scanner.nextLine();  
           while (!ans.equals("DONE")){
           System.out.println("Enter a robot color that will play, if done type DONE");
           String query = "INSERT INTO registers (Card1, Card2, Card3, Card4, Card5, Color, AskForRegister) VALUES ('', '', '', '', '','"+ans+"','"+1+"')";
           statement.executeUpdate(query);  
           PersColor = ans;
           ans = scanner.nextLine();  
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
        String Card1;
        String Card2;
        String Card3;
        String Card4;
        String Card5;
        String Color;
        while(true){
           try {
              //establish cennection
              connection = DriverManager.getConnection(url, username, password);
              statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
              //read database
             
              String Robotquery = "SELECT r.*, c.all_values_false " +
              "FROM registers r " +
              "INNER JOIN ( " +
              "  SELECT COUNT(*) = SUM(CASE WHEN AskForRegister = 0 THEN 1 ELSE 0 END) AS all_values_false " +
              "  FROM registers " +
              ") c ON 1=1";
              RobotSet = statement.executeQuery(Robotquery);
  
                 if(RobotSet.next() && RobotSet.getBoolean("all_values_false")){
                    System.out.println("Startimng program with the given registers");
                    RobotSet.beforeFirst();
                    while (RobotSet.next()){
                    Card1 = RobotSet.getString("Card1");
                    Card2 = RobotSet.getString("Card2");
                    Card3 = RobotSet.getString("Card3");
                    Card4 = RobotSet.getString("Card4");
                    Card5 = RobotSet.getString("Card5");
                    Color = RobotSet.getString("Color");
                    //robot.setRegister(Card1, Card2, Card3, Card4, Card5)
                    System.out.println(Color + "\t" + Card1 + "\t" + Card2 + "\t" + Card3 + "\t" + Card4 + "\t" + Card5);
                    } ;
                    // do rounds and logic with the register
                    
                    System.out.println("Rounds have been completed, now ask for new registers.");
                    
                    // Ask for new registers from the players:
                    
                    String AskForRegister = "TRUE";
                    String Subquery = "UPDATE registers SET AskForRegister = " + AskForRegister;
                    statement.executeUpdate(Subquery);
                    
                    
                 }
                 RobotSet.last();
                 
                 if((RobotSet.getBoolean("AskForRegister"))){
                    System.out.println("Everyone now goes to their own computer to choose cards, "+PersColor+" chooses here");
  
                    System.out.println("Enter name of card1");
                    Card1 = scanner.nextLine();
                    System.out.println("Enter name of card2");
                    Card2 = scanner.nextLine();
                    System.out.println("Enter name of card3");
                    Card3 = scanner.nextLine();
                    System.out.println("Enter name of card4");
                    Card4 = scanner.nextLine();
                    System.out.println("Enter name of card5");
                    Card5 = scanner.nextLine();
                    String AskForRegister = "FALSE";
                    String query = "UPDATE registers SET Card1 = '" +Card1+"',Card2 = '"+Card2+"',Card3 = '"+Card3+"',Card4 = '"+Card4+"',Card5 = '"+Card5+"',AskForRegister = "+AskForRegister+" WHERE Color = '"+PersColor+"'";
                    int num = statement.executeUpdate(query);
                    System.out.println(num + " row(s) updated");
                 }
                 
                 try {
                   // Thread.sleep(2000);
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
