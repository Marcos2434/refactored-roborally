import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Board.*;
public class BoardTest {
    Position pos1;
    Position pos2;
    Position pos3;
    Board board;
    //test creation of Board
    @Given("A layout, a board is created. And a position is created")
    public void a_board_can_be_created() {
        this.pos1 = new Position(1,4);
        this.pos2 = new Position(5,2);
        this.pos3 = new Position(-1,4);
        String[][] board1 = {   
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "}
        };
        this.board = new Board(board1);
        assertNotNull(board);
    }
    // test extraction of tile
    @Then("Show me what Tile it is")
    public void show_me_what_tile_it_is() {
        assertEquals("T",board.getTileAt(pos1).getname());
    }
}
