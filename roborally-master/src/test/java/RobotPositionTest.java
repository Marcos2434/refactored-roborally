import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import javafx.geometry.Pos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import dtu.logic.models.*;
import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;

public class RobotPositionTest {
    Player testPlayer;
    
    
    @Given("A player is created with a chosen color")
    public void a_player_is_createdCopy() {
        // Write code here that turns the phrase above into concrete actions
        Robot robot = new Robot(Color.RED,new Position(2,2));
        testPlayer = new Player(robot,"Casper");
    }
    @And("A robot is assigned to player")
    public void a_robot_is_assigned_to_the_playerCopy() {
        assertNotNull(testPlayer.getRobot());
        assertNotNull(this.testPlayer);
    }

    @Then("Robot is moved on the board")
    public void robot_is_moved_on_board(){
        testPlayer.moveRobot(6,9);
    }

    @Then("Player receives position of robot")
    public void player_receives_pos_of_robot(){
        Position pos = testPlayer.getRobot().getPos();
        //System.out.println("Position is " + pos.getX() +" , "+ pos.getY() );
    }
}
