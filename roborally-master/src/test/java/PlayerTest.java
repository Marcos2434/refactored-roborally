import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;

public class PlayerTest {
    Player testPlayer;
    String[][] board1 = {   
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","WT 1","WT 4","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","AT","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
        {"T","T","T","T","T","T","T","T","T","T"},
    };
    Board board = new Board(board1);
    BoardController bC = new BoardController(board);
    
    @Given("A player is created with a chosen color for the robot")
    public void a_player_is_created() {
        Robot robot = new Robot(RobotColor.RED,new Position(2,2));
        testPlayer = new Player(robot,"Casper");
    }
    @Then("A robot is assigned to the player")
    public void a_robot_is_assigned_to_the_player() {
        assertNotNull(testPlayer.getRobot());
        assertNotNull(this.testPlayer);
    }
    @Then("The robot is facing a direction")
    public void the_robot_is_facing_a_direction() {
        assertNotNull(testPlayer.getRobot().getdir());
    }
    Robot robot1;
    Robot robot2;
    AI ai1; 
    AI ai2;
    @Given("Two AI'")
    public void two_ai() {
        robot1 = new Robot(RobotColor.BLUE);
        robot2 = new Robot(RobotColor.BLUE);
        robot1.getPos().toString();
        ai1  = new AI(robot1);
        ai2  = new AI(robot2,"Hey");
        

    }
    @When("they draw cards")
    public void they_draw_cards() {
        robot1.setDamageTaken(6);
        ai1.drawProgrammingCards();
        ai2.drawProgrammingCards();
    }
    @Then("their hands are not empty")
    public void their_hands_are_not_empty() {
        assertTrue(ai1.getHand().size() > 0);
        assertTrue(ai1.getHand().size() > 0);
        assertTrue(ai1.isAI());
}

    @When("One robot loses three lives and the other dont.")
    public void one_robot_loses_three_lives_and_the_other_dont() {
       robot1.Death(bC);
       robot1.Death(bC);
       robot1.Death(bC);
    }
    @Then("the first robot is no longer on the board")
    public void the_first_robot_is_no_longer_on_the_board() {
        assertNull(robot1.getPos());
        assertNotNull(robot2.getPos());


}
}