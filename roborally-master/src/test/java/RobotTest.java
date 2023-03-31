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
    
    @Given("A robot being created with a color")
    public void a_robot_being_created_with_a_color() {
        Color userTestInputColor = Color.RED;
        robot = new Robot(userTestInputColor);
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("A robot is created with three lives")
    public void a_robot_is_assigned_lifes() {
        assertEquals(3,robot.getLives());
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("The amount of lives that are left after loosing {int} lives in my robot can be determined")
    public void the_amount_of_lives_that_are_left_after_loosing_lives_in_my_robot_can_be_determined(Integer int1) {
        assertEquals(3,robot.getLives());
            for (int i=0;i < int1;i++) {
                robot.LoseLive();
            }
            assertEquals(3-int1,robot.getLives());    
    }

    @Then("The robot recieved {int} damage and shows it")
    public void the_robot_recieved_damage(Integer int1) {
        assertEquals(0,robot.getDamageTaken());
        for (int i=0;i < int1;i++) {
            robot.takeDmg();
        }
        assertEquals(0+int1, robot.getDamageTaken());

    }

}
