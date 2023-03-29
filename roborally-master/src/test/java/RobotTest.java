import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Robot.*;
public class RobotTest {
    Robot robot;

    @Given("A robot being created")
    public void a_robot_being_created() {
    Color userTestInputColor = Color.RED;
    robot = new Robot(userTestInputColor);
    // Write code here that turns the phrase above into concrete actions
    
}
    @Then("A robot is created with three lives")
    public void a_robot_is_assigned_lifes() {
        assertEquals(3,robot.getLives());
    // Write code here that turns the phrase above into concrete actions
    
}
}
