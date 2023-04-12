import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Player.*;

public class PlayerTest {
    Player testPlayer;
    
    
    @Given("A player is created with a chosen color for the robot")
    public void a_player_is_created() {
        // Write code here that turns the phrase above into concrete actions
        Color userTestInputColor = Color.RED;
        testPlayer = new Player(userTestInputColor);
    }
    @Then("A robot is assigned to the player")
    public void a_robot_is_assigned_to_the_player() {
        assertNotNull(testPlayer.getRobot());
    }
    @Then("The robot is facing a direction")
    public void the_robot_is_facing_a_direction() {
        assertNotNull(testPlayer.getRobot().getDirection());
    }
}
