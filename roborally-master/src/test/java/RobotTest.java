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
    // initiats a robot with everything needed, change this when making a
    // new test that requires a new thing so that we know every test works properly with complicated robots as well.
    @Given("A robot being created with a color and a checkpoint")
    public void a_robot_being_created_with_a_color() {
        
        robot = new Robot(Color.BLUE);  
        robot.setCheckpoint(new Position(0,0));
    }
    // a robot has 3 lives when created.
    @Then("A robot is created with three lives")
    public void a_robot_is_assigned_lifes() {
        assertEquals(3,robot.getLives());
        
    }
    // Shows that the robot can loose lives
    @Then("The amount of lives that are left after loosing {int} lives in my robot can be determined")
    public void the_amount_of_lives_that_are_left_after_loosing_lives_in_my_robot_can_be_determined(Integer int1) {
        assertEquals(3,robot.getLives());
            for (int i=0;i < int1;i++) {
                robot.LoseLive();
            }
            assertEquals(3-int1,robot.getLives());    
    }
    // Shows that the robot can take dmg
    @Then("The robot recieved {int} damage and shows it")
    public void the_robot_recieved_damage(Integer int1) {
        assertEquals(0,robot.getDamageTaken());
        for (int i=0;i < int1;i++) {
            robot.takeDmg();
        }
        assertEquals(0+int1, robot.getDamageTaken());
    }
    // Reaching 10 dmg, then loose live, reset dmg and go to checkpoint and moves away from checkpoint
    // also checks if the robot actually 
    @When("The robot takes {int} damage.")
    public void the_robot_takes_damage(Integer int1) {
        robot.setPos(new Position(1,2));
        assertEquals(1, robot.getPos().getX());
        assertEquals(2, robot.getPos().getY());
        for (int i=0; i<int1; i++) {robot.takeDmg();}
        

    }
    @Then("The robot looses a lifetoken, resets damage and go back to last checkpoint.")
    public void the_robot_looses_a_lifetoken_resets_damage_and_go_back_to_last_checkpoint() {
        assertEquals(2, robot.getLives());
        assertEquals(0, robot.getDamageTaken());
        assertEquals(0, robot.getPos().getX());
        assertEquals(0, robot.getPos().getY());
    }
    //Being able to turn and show the direction
    @Then("the robot turns and it can display the direction")
    public void the_robot_turns() {
        robot.turn(0); //Test of unambigoius input
        assertEquals(Direction.UP.getId(), robot.getDirection().getId());
        robot.turn(1); //Test of turning right
        assertEquals(Direction.RIGHT.getId(),robot.getDirection().getId());
        robot.turn(-1); // Testing leftturn
        assertEquals(Direction.UP.getId(), robot.getDirection().getId());
        robot.turn(5); //testing full rotation to the right
        assertEquals(Direction.RIGHT.getId(),robot.getDirection().getId());
        robot.turn(-5); //testing full rotation to the right
        assertEquals(Direction.UP.getId(),robot.getDirection().getId());
        
    }
    
}
