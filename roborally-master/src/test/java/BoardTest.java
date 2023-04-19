import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Board.*;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.*;
public class BoardTest {
    Position pos1;
    Position pos2;
    Position pos3;
    Board board;
    Robot robot;
    //test creation of Board
    @Given("A layout, a board is created. And a position is created")
    public void a_board_can_be_created() {
        robot = new Robot(Color.BLUE,new Position(5,5));
        this.pos1 = new Position(4,4);
        this.pos2 = new Position(2, 4);
        this.pos3 = new Position(4,-1);
        
//
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
        };
        this.board = new Board(board1, true);
        robot.setPos(pos1);
        
    }
    // test extraction of tile
    @Then("Show me what Tile it is")
    public void show_me_what_tile_it_is() {
        assertEquals("T",board.getTileAt(pos1).getname());
        assertEquals("HT",board.getTileAt(pos2).getname());
        assertNull(board.getTileAt(pos3));
    }

    @When("the robot steps on a holetile")
    public void the_robot_steps_on_a_holetile() {
        robot.setPos(new Position(2, 0));
        board.getTileAt(robot.getPos()).effect(robot);
}
    @Then("The robot Dies")
    public void the_robot_dies() {
        assertEquals(2, robot.getLives());
        assertEquals(0, robot.getDamageTaken());
        assertEquals(5, robot.getPos().getColumn());
        assertEquals(5, robot.getPos().getRow());
}
    @Then("Show me a wall tile")
    public void show_me_a_wall_tile() {
        if (board.getTileAt(new Position(1,4)) instanceof TileWall){
            TileWall WT = (TileWall) board.getTileAt(new Position(1,4));
            assertEquals("WT",WT.getname()); // check that wall tile is created
        }
    }

    // wall interactions

    @Then("the robot tries to move throug a wall and can't move")
    public void the_robot_tries_to_move_throug_a_wall_and_can_t_move() {
    robot.setPos(new Position(4, 1));

    robot.moveforward(true,board);
    assertEquals(1,robot.getPos().getRow());
    robot.turn(1, board);
    robot.moveforward(true,board);
    assertEquals(4,robot.getPos().getColumn());

}
    //player list in Board
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Robot robot1;
    Robot robot2;
    Robot robot3;
    Robot robot4;
    @Given("A Board and four players")
    public void a_board_and_four_players() {
        String[][] board1 = {   
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","BT 3 1","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","LT 4","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},};
        this.board = new Board(board1, true);
        robot1 = new Robot(Color.BLUE,new Position(3,3));
        robot2 = new Robot(Color.GREEN,new Position(3,3));
        robot3 = new Robot(Color.BLUE,new Position(5,3));
        robot4 = new Robot(Color.RED,new Position(5,3));
        player1 = new Player(robot1,"Casper1");
        player2 = new Player(robot2,"Casper2");
        player3 = new Player(robot3,"Casper3");
        player4 = new Player(robot4,"Casper4");
        board.initPlayers();
    }
    @Then("Add the players to the player list")
    public void add_the_players_to_the_player_list() {
        board.addPlayer(player1);
        board.addPlayer(player4);
        assertEquals("Casper1",board.getPlayers()[0].getName());
        assertEquals("Casper4",board.getPlayers()[1].getName());
}

    @Then("Add the player is not added if they have the same position")
    public void add_the_player_is_not_added_if_they_have_the_same_position() {
        board.addPlayer(player1);
        board.addPlayer(player2);
        assertNull(board.getPlayers()[1]);
}
    @Then("Add the player is not added if they have the same Color")
    public void add_the_player_is_not_added_if_they_have_the_same_color() {
        board.addPlayer(player1);
        board.addPlayer(player3);
        assertNull(board.getPlayers()[1]);
}

    @When("the robots move")
    public void the_robots_move() {
        board.addPlayer(player1);
        robot1.moveforward(true, board);
        
    }
    @Then("The robots position is still the same in playerlist")
    public void the_robots_position_is_still_the_same_in_playerlist() {
        assertTrue(board.getPlayers()[0].getRobot().getPos().equals(robot1.getPos()));
}
    @When("A robot is placed to be hit by the lazer tile")
    public void a_robot_is_placed_to_be_hit_by_the_lazer_tile() {
        board.addPlayer(player1);
        board.moveRobot(robot1,new Position(7,7));

        
        board.fireLazers(); 
        
    }
    @Then("The robot takes damge")
    public void the_robot_takes_damge() {
        assertEquals(1, robot1.getDamageTaken());
    }
    @When("A robot tries to move trough the wall")
    public void a_robot_tries_to_move_trough_the_wall() {
        
        board.moveRobot(robot1,new Position(0,7));
        robot1.turn(1,board);
        robot1.moveforward(true,board);
    }
    @Then("It is unable to")
    public void it_is_unable_to() {
        assertEquals(0,robot1.getPos().getColumn());
}
    @When("A robot is placed on the BeltTile")
    public void a_robot_is_placed_on_the_belt_tile() {
        board.moveRobot(robot1,new Position(2,4));
        Tile tile =  board.getTileAt(robot1.getPos());
        if (tile instanceof TileBelt){
            System.out.println("Tilebelt");
            TileBelt BT = (TileBelt) tile;
            BT.effect(robot1,board);
        }
        
    }
    @Then("The robot is pushed in the direction of the belt.")
    public void the_robot_is_pushed_in_the_direction_of_the_belt() {
        assertEquals(5,robot1.getPos().getRow());
}
}
