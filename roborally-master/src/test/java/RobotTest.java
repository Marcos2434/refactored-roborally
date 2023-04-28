import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Cards.MovementCards.Again;
import dtu.logic.models.Cards.MovementCards.Forward;
import dtu.logic.models.Cards.MovementCards.TurnLeft;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.*;
public class RobotTest {
    Robot robot;
    String[][] board1 = {   
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"WT 3","T","HT","T","WT 1","WT 4","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","C 1"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
    };
    Board board = new Board(board1);
    BoardController bC = new BoardController(board);
    Deck deck = new Deck();
    // initiats a robot with everything needed, change this when making a
    // new test that requires a new thing so that we know every test works properly with complicated robots as well.
    @Given("A robot being created with a color and a checkpoint")
    public void a_robot_being_created_with_a_color() {
        
        robot = new Robot(RobotColor.BLUE,new Position(5,5));  
       
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
    public void the_robot_recieved_damage(int int1) {
        assertEquals(0,robot.getDamageTaken());
        for (int i=0;i < int1;i++) {
            robot.takeDmg(bC);
        }
        assertEquals(0+int1, robot.getDamageTaken());
    }
    // Reaching 10 dmg, then loose live, reset dmg and go to checkpoint and moves away from checkpoint
    // also checks if the robot actually 
    @When("The robot takes {int} damage.")
    public void the_robot_takes_damage(int int1) {
        robot.setPos(new Position(1,2));
        assertEquals(1, robot.getPos().getColumn());
        assertEquals(2, robot.getPos().getRow());
        for (int i=0; i<int1; i++) {robot.takeDmg(bC);}
        

    }
    @Then("The robot looses a lifetoken, resets damage and go back to last checkpoint.")
    public void the_robot_looses_a_lifetoken_resets_damage_and_go_back_to_last_checkpoint() {
        assertEquals(2, robot.getLives());
        assertEquals(0, robot.getDamageTaken());
        assertEquals(5, robot.getPos().getColumn());
        assertEquals(5, robot.getPos().getRow());
    }
    //Being able to turn and show the direction
    @Then("the robot turns and it can display the direction")
    public void the_robot_turns() {
        robot.turn(0, bC); //Test of unambigoius input
        assertEquals(Direction.UP.getId(), robot.getdir().getId());
        robot.turn(1, bC); //Test of turning right
        assertEquals(Direction.RIGHT.getId(),robot.getdir().getId());
        robot.turn(-1, bC); // Testing leftturn
        assertEquals(Direction.UP.getId(), robot.getdir().getId());
        robot.turn(5, bC); //testing full rotation to the right
        assertEquals(Direction.RIGHT.getId(),robot.getdir().getId());
        robot.turn(-5, bC); //testing full rotation to the right
        assertEquals(Direction.UP.getId(),robot.getdir().getId());
    }
    // Check of movement
    @Then("It turns to the right and moves forward and backwards {int} times")
    public void it_turns_to_the_right_and_moves_forward_and_backwards_times(Integer int1) {
            //moving right
            robot.turn(1, bC);
            robot.moveforward(true,bC);
            assertEquals(6,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            robot.moveforward(false,bC);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            //moving down
            robot.turn(1, bC);
            robot.moveforward(true,bC);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(6,robot.getPos().getRow());
            robot.moveforward(false,bC);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            //moving left
            robot.turn(1, bC);
            robot.moveforward(true,bC);
            assertEquals(4,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            robot.moveforward(false,bC);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            //moving left
            robot.turn(1, bC);
            robot.moveforward(true,bC);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(4,robot.getPos().getRow());
            robot.moveforward(false,bC);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
    }
    //Death by moving over edge
    @When("A robot moves over the edge")
    public void a_robot_moves_over_the_edge() { 
    //Moves over the left edge
    robot.setPos(new Position(0,0));
    robot.takeDmg(bC);
    robot.turn(-1, bC);
    robot.moveByCard(bC, new Forward(1));
    
}
    Player player1; 
    Player player2;
    Robot robot1;
    Robot robot2;
    @Given("Two robots being created")
    public void two_robots_being_created() {
        robot1 = new Robot(RobotColor.BLUE,new Position(5,5)); 
        robot2 = new Robot(RobotColor.RED,new Position(5,4));
        player1 = new Player(robot1,"Casper");
        player2 = new Player(robot2,"Marcos");
        bC.getBoard().getTileAt(robot1.getPos()).Occupy();
        bC.getBoard().getTileAt(robot2.getPos()).Occupy();
        bC.addPlayer(player1);
        bC.addPlayer(player2);
        
        
    }
    @When("The robots are beside eachother and one robot tries to move through the other")
    public void the_robots_are_beside_eachother_and_one_robot_tries_to_move_through_the_other() {
        
        bC.addPlayer(player1);
        bC.addPlayer(player2);
        robot1.moveforward(true, bC);
        
    }
    @Then("the other robot is pushed")
    public void the_other_robot_is_pushed() {
        assertEquals(4,robot1.getPos().getRow());
        assertEquals(3,robot2.getPos().getRow());
}

    @Then("i move. The Tile behind me is not ocupied and the tile i moved to is.")
    public void i_move_the_tile_behind_me_is_not_ocupied_and_the_tile_i_moved_to_is() {
        robot.moveByCard(bC,new Forward(1));
        assertTrue(bC.getBoard().getTileAt(new Position(robot.getPos().getColumn(),robot.getPos().getRow())).isOcupied());
        assertFalse(bC.getBoard().getTileAt(new Position(robot.getPos().getColumn()+1,robot.getPos().getRow())).isOcupied());
        robot.moveByCard(bC,new Forward(1));
        assertTrue(bC.getBoard().getTileAt(new Position(robot.getPos().getColumn(),robot.getPos().getRow())).isOcupied());
        assertFalse(bC.getBoard().getTileAt(new Position(robot.getPos().getColumn()+1,robot.getPos().getRow())).isOcupied());
}
    @When("The robots are facing eachother and fire their lazer")
    public void the_robots_are_facing_eachother_and_fire_their_lazer() {
       
        
        bC.addPlayer(player1);
        bC.addPlayer(player2);
        
        
        bC.getBoard().getTileAt(robot1.getPos()).unOccupy();
        bC.getBoard().getTileAt(robot2.getPos()).unOccupy();
        
        robot1.setPos(0, 5);
        robot1.setDir(Direction.RIGHT);
        robot2.setPos(8, 5);
        robot2.setDir(Direction.LEFT);

        bC.getBoard().getTileAt(robot1.getPos()).Occupy();
        bC.getBoard().getTileAt(robot2.getPos()).Occupy();

        robot1.FIRE(bC);
        
    }
    @Then("both robots take dmg.")
    public void both_robots_take_dmg() {
        assertEquals(0,robot1.getDamageTaken());
        assertEquals(1,robot2.getDamageTaken());
    }


    @Given("A robot is being created with a color and a checkpoint")
    public void a_robot_is_being_created_with_a_color_and_a_checkpoint() {
        robot = new Robot(RobotColor.BLUE,new Position(5,5));
        robot.setDir(Direction.UP);
    }  
    @When("The robot recieves a card")
    public void the_robot_recieves_a_card() {
        Deck deck = new Deck();
        ProgramCard card = deck.cards.get(21); //Checks move forward 
        robot.moveByCard(bC, card);
        
        ProgramCard card3 = deck.cards.get(33); //Checks backwards  
        robot.moveByCard(bC, card3);
        
        ProgramCard card1 = deck.cards.get(12); //Check U turn 
        robot.moveByCard(bC, card1);
        
        ProgramCard card2 = deck.cards.get(7); //Checks left turn
        robot.moveByCard(bC, card2);

        robot.moveByCard(bC, deck.cards.get(2));//Checks Right turn




    }
    @Then("The robot moves according to the card desciription")
    public void the_robot_moves_according_to_the_card_desciription() {
        assertEquals(4,robot.getPos().getRow()); //Checks move forward
        // assertEquals(Direction.RIGHT, robot.getDirection());
        assertEquals(Direction.DOWN, robot.getdir()); //final direction

    }
    Player player3; 
    Player player4;
    Robot robot3;
    Robot robot4;
    @Given("Four robots in a row")
    public void four_robots_in_a_row() {
        robot1 = new Robot(RobotColor.BLUE,new Position(0,5)); 
        robot2 = new Robot(RobotColor.RED,new Position(0,4));
        robot3 = new Robot(RobotColor.GREEN,new Position(0,3)); 
        robot4 = new Robot(RobotColor.BLACK,new Position(0,2));
        robot4.turn(2,bC);
        player1 = new Player(robot1,"Casper");
        player2 = new Player(robot2,"Marcos");
        player3 = new Player(robot3,"Casper2");
        player4 = new Player(robot4,"Marcos2");
        bC.getBoard().getTileAt(robot1.getPos()).Occupy();
        bC.getBoard().getTileAt(robot2.getPos()).Occupy();
        bC.getBoard().getTileAt(robot3.getPos()).Occupy();
        bC.getBoard().getTileAt(robot4.getPos()).Occupy();
       
        bC.addPlayer(player1);
        bC.addPlayer(player2);
        bC.addPlayer(player3);
        bC.addPlayer(player4);
    }
    @When("when a robot in the end moves")
    public void when_a_robot_in_the_end_moves() {
        
        robot4.moveforward(true,bC);
    }
    @Then("All the robots are pushed")
    public void all_the_robots_are_pushed() {
        assertEquals(6, robot1.getPos().getRow());
        assertEquals(5, robot2.getPos().getRow());
        assertEquals(4, robot3.getPos().getRow());
        assertEquals(3, robot4.getPos().getRow());
        
        
}
    @Then("All robots take damage")
    public void all_robots_take_damage() {
        assertEquals(1,robot1.getDamageTaken());
        assertEquals(1,robot2.getDamageTaken());
        assertEquals(1,robot3.getDamageTaken());
        assertEquals(0,robot4.getDamageTaken());
}
    @When("when the robot opposite the wall moves into the row of robots")
    public void when_the_robot_opposite_the_wall_moves_into_the_row_of_robots() {
        
        robot1.moveforward(true,bC);
    }
    @Then("Noone moves")
    public void noone_moves() {
        assertEquals(5, robot1.getPos().getRow());
        assertEquals(4, robot2.getPos().getRow());
        assertEquals(3, robot3.getPos().getRow());
        assertEquals(2, robot4.getPos().getRow());
        
}
    @Then("Three robots take damage")
    public void three_robots_take_damage() {
        assertEquals(0,robot1.getDamageTaken());
        assertEquals(1,robot2.getDamageTaken());
        assertEquals(1,robot3.getDamageTaken());
        assertEquals(1,robot4.getDamageTaken());
}
    @When("One robot pushes the other over the edge")
    public void one_robot_pushes_the_other_over_the_edge() {
    
        bC.moveRobot(robot1, new Position(0,5));
        bC.moveRobot(robot2, new Position(1,5));
        robot1.addCheckpoint(new Position(6, 6));
        robot2.moveByCard(bC, new TurnLeft(1));
        robot2.moveByCard(bC,new Forward(1));
    }
    @Then("The other robot dies and respawns")
    public void the_other_robot_dies_and_respawns() {
    assertEquals(new Position(6, 6),robot1.getPos());
}
    @When("one robot has a register consiting of one or more Again cards")
    public void one_robot_has_a_register_consiting_of_one_or_more_again_cards() {
        bC.moveRobot(robot1,new Position(5, 5));
        robot1.AddToRegister(new Forward(1));
        robot1.AddToRegister(new Again());
        robot1.AddToRegister(new Again());
        robot1.AddToRegister(new Again());
        bC.runAllRegisters();
    }
    @Then("they will perform the effect of the last run card.")
    public void they_will_perform_the_effect_of_the_last_run_card() {
        assertEquals(new Position(5, 1),robot1.getPos());
}
    @When("The robot is pushed over the edge while having the checkpoint")
    public void the_robot_is_pushed_over_the_edge_while_having_the_checkpoint() {
        bC.moveRobot(robot1,new Position(9,9));
        bC.moveRobot(robot2,new Position(8, 9));
        bC.getBoard().getTileAt(robot1.getPos()).Occupy();
        bC.getBoard().getTileAt(robot2.getPos()).Occupy();
        robot2.turn(1,bC);
        robot2.AddToRegister(new Forward(1));
        bC.RunAllEffects();
        bC.runAllRegisters();
    }
    @Then("it spawnns at the startpoint.")
    public void it_spawnns_at_the_startpoint() {
        assertEquals(new Position(5,5),robot1.getPos());
        assertEquals(new Position(9,9),robot2.getPos());
    }
}
