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

import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Cards.ProgramCard;
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
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
        {"T","T","HT","T","T","T","T","T","T","T"},
    };
    Board board = new Board(board1, true);
    Deck deck = new Deck();
    // initiats a robot with everything needed, change this when making a
    // new test that requires a new thing so that we know every test works properly with complicated robots as well.
    @Given("A robot being created with a color and a checkpoint")
    public void a_robot_being_created_with_a_color() {
        
        robot = new Robot(Color.BLUE,new Position(5,5));  
       
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
            robot.takeDmg(board);
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
        for (int i=0; i<int1; i++) {robot.takeDmg(board);}
        

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
        robot.turn(0, board); //Test of unambigoius input
        assertEquals(Direction.UP.getId(), robot.getdir().getId());
        robot.turn(1, board); //Test of turning right
        assertEquals(Direction.RIGHT.getId(),robot.getdir().getId());
        robot.turn(-1, board); // Testing leftturn
        assertEquals(Direction.UP.getId(), robot.getdir().getId());
        robot.turn(5, board); //testing full rotation to the right
        assertEquals(Direction.RIGHT.getId(),robot.getdir().getId());
        robot.turn(-5, board); //testing full rotation to the right
        assertEquals(Direction.UP.getId(),robot.getdir().getId());
    }
    // Check of movement
    @Then("It turns to the right and moves forward and backwards {int} times")
    public void it_turns_to_the_right_and_moves_forward_and_backwards_times(Integer int1) {
            //moving right
            robot.turn(1, board);
            robot.moveforward(true,board);
            assertEquals(6,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            robot.moveforward(false,board);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            //moving down
            robot.turn(1, board);
            robot.moveforward(true,board);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(6,robot.getPos().getRow());
            robot.moveforward(false,board);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            //moving left
            robot.turn(1, board);
            robot.moveforward(true,board);
            assertEquals(4,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            robot.moveforward(false,board);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
            //moving left
            robot.turn(1, board);
            robot.moveforward(true,board);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(4,robot.getPos().getRow());
            robot.moveforward(false,board);
            assertEquals(5,robot.getPos().getColumn());
            assertEquals(5,robot.getPos().getRow());
    }
    //Death by moving over edge
    @When("A robot moves over the edge")
    public void a_robot_moves_over_the_edge() { 
    //Moves over the left edge
    robot.setPos(new Position(0,0));
    robot.takeDmg(board);
    robot.turn(-1, board);
    robot.moveforward(true,board);
    
}
    Player player1; 
    Player player2;
    Robot robot1;
    Robot robot2;
    @Given("Two robots being created")
    public void two_robots_being_created() {
        robot1 = new Robot(Color.BLUE,new Position(5,5)); 
        robot2 = new Robot(Color.RED,new Position(5,4));
        player1 = new Player(robot1,"Casper");
        player2 = new Player(robot2,"Marcos");
        board.getTileAt(robot1.getPos()).Occupy(robot1.getImage(), robot1.getDirID());
        board.getTileAt(robot2.getPos()).Occupy(robot2.getImage(), robot2.getDirID());
        
        
    }
    @When("The robots are beside eachother and one robot tries to move through the other")
    public void the_robots_are_beside_eachother_and_one_robot_tries_to_move_through_the_other() {
        board.initPlayers();
        board.addPlayer(player1);
        board.addPlayer(player2);
        robot1.moveforward(true, board);
        
    }
    @Then("the other robot is pushed")
    public void the_other_robot_is_pushed() {
        assertEquals(4,robot1.getPos().getRow());
        assertEquals(3,robot2.getPos().getRow());
}

    @Then("i move. The Tile behind me is not ocupied and the tile i moved to is.")
    public void i_move_the_tile_behind_me_is_not_ocupied_and_the_tile_i_moved_to_is() {
        robot.moveforward(true, board);
        assertTrue(board.getTileAt(new Position(robot.getPos().getColumn(),robot.getPos().getRow())).isOcupied());
        assertFalse(board.getTileAt(new Position(robot.getPos().getColumn()+1,robot.getPos().getRow())).isOcupied());
        robot.moveforward(true, board);
        assertTrue(board.getTileAt(new Position(robot.getPos().getColumn(),robot.getPos().getRow())).isOcupied());
        assertFalse(board.getTileAt(new Position(robot.getPos().getColumn()+1,robot.getPos().getRow())).isOcupied());
}
    @When("The robots are facing eachother and fire their lazer")
    public void the_robots_are_facing_eachother_and_fire_their_lazer() {
        board.initPlayers();
        
        board.addPlayer(player1);
        board.addPlayer(player2);
        
        
        board.getTileAt(robot1.getPos()).unOccupy();
        board.getTileAt(robot2.getPos()).unOccupy();
        
        robot1.setPos(0, 5);
        robot1.setDir(Direction.RIGHT);
        robot2.setPos(8, 5);
        robot2.setDir(Direction.LEFT);

        board.getTileAt(robot1.getPos()).Occupy(robot1.getImage(), robot1.getDirID());
        board.getTileAt(robot2.getPos()).Occupy(robot2.getImage(), robot1.getDirID());

        robot1.FIRE(board);
        
    }
    @Then("both robots take dmg.")
    public void both_robots_take_dmg() {
        assertEquals(0,robot1.getDamageTaken());
        assertEquals(1,robot2.getDamageTaken());
    }


    @Given("A robot is being created with a color and a checkpoint")
    public void a_robot_is_being_created_with_a_color_and_a_checkpoint() {
        robot = new Robot(Color.BLUE,new Position(5,5));
        robot.setDir(Direction.UP);
    }  
    @When("The robot recieves a card")
    public void the_robot_recieves_a_card() {
        Deck deck = new Deck();
        ProgramCard card = deck.cards.get(21); //Checks move forward 
        robot.moveByCard(board, card);
        

        ProgramCard card3 = deck.cards.get(33); //Checks backwards  
        robot.moveByCard(board, card3);
        
        ProgramCard card1 = deck.cards.get(12); //Check U turn 
        robot.moveByCard(board, card1);
        
        ProgramCard card2 = deck.cards.get(7); //Checks Right turn 
        robot.moveByCard(board, card2);

    }
    @Then("The robot moves according to the card desciription")
    public void the_robot_moves_according_to_the_card_desciription() {
        assertEquals(4,robot.getPos().getRow()); //Checks move forward
        // assertEquals(Direction.RIGHT, robot.getDirection());
        assertEquals(Direction.LEFT, robot.getdir()); //final direction

    }
    Player player3; 
    Player player4;
    Robot robot3;
    Robot robot4;
    @Given("Four robots in a row")
    public void four_robots_in_a_row() {
        robot1 = new Robot(Color.BLUE,new Position(0,5)); 
        robot2 = new Robot(Color.RED,new Position(0,4));
        robot3 = new Robot(Color.GREEN,new Position(0,3)); 
        robot4 = new Robot(Color.BLACK,new Position(0,2));
        robot4.turn(2,board);
        player1 = new Player(robot1,"Casper");
        player2 = new Player(robot2,"Marcos");
        player3 = new Player(robot3,"Casper2");
        player4 = new Player(robot4,"Marcos2");
        board.getTileAt(robot1.getPos()).Occupy(robot1.getImage(), robot1.getDirID());
        board.getTileAt(robot2.getPos()).Occupy(robot2.getImage(), robot2.getDirID());
        board.getTileAt(robot3.getPos()).Occupy(robot3.getImage(), robot3.getDirID());
        board.getTileAt(robot4.getPos()).Occupy(robot4.getImage(), robot4.getDirID());
        board.initPlayers();
        board.addPlayer(player1);
        board.addPlayer(player2);
        board.addPlayer(player3);
        board.addPlayer(player4);
    }
    @When("when a robot in the end moves")
    public void when_a_robot_in_the_end_moves() {
        
        robot4.moveforward(true,board);
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
        
        robot1.moveforward(true,board);
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
}

