import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Board.*;
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
        robot = new Robot(Color.BLUE);
        robot.setPos(pos1);
        robot.setCheckpoint(new Position(5,5));
        this.pos1 = new Position(4,4);
        this.pos2 = new Position(5,2);
        this.pos3 = new Position(-1,4);
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
            {"T","T","HT","T","T","T","T","T","T","T"}
        };
        this.board = new Board(board1);
        assertNotNull(board);
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
    robot.setPos(new Position(0,2));
    board.getTileAt(robot.getPos()).effect(robot);
}
    @Then("The robot Dies")
    public void the_robot_dies() {
        assertEquals(2, robot.getLives());
        assertEquals(0, robot.getDamageTaken());
        assertEquals(5, robot.getPos().getX());
        assertEquals(5, robot.getPos().getY());
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
    robot.setPos(new Position(1,4));

    robot.moveforward(true,board.allowmove(robot));
    assertEquals(robot.getPos().getX(), 1);
    robot.turn(1);
    robot.moveforward(true,board.allowmove(robot));
    assertEquals(robot.getPos().getY(), 4);

}

}
