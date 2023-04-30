
import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import dtu.logic.models.RobotColor;
import dtu.logic.models.*;
import dtu.logic.models.Board.*;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.*;
public class BoardControllerTest {
    
    String[][] board1 = {   
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
    };;
    Board board = new Board(board1);
    BoardController con = new BoardController(board);
    Player response;
    Player player1;
    Player player2;
    
    @Given("a playerlist")
    public void a_playerlist() {
        player1 = new Player(new Robot(RobotColor.BLUE,new Position(0, 3)),"Casper");
        player2 = new Player(new Robot(RobotColor.RED,new Position(0, 5)),"Marcos");
        con.addPlayer(player1);
        con.addPlayer(player2);
    }
    @When("Searching for a player by its name")
    public void searching_for_a_player_by_its_name() {
        response = con.getPlayerByName("Casper");
    }
    @When("Searching for a player by its Color")
    public void searching_for_a_player_by_its_color() {
        response = con.getPlayerByColor(RobotColor.BLUE);
}
    @Then("the player is returned")
    public void the_player_is_returned() {
        assertEquals(response,player1);
}
}
