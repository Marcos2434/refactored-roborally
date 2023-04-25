import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import dtu.logic.models.RobotColor;
import dtu.logic.models.*;
import dtu.logic.models.Board.*;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Cards.MovementCards.Again;
import dtu.logic.models.Cards.MovementCards.Backwards;
import dtu.logic.models.Cards.MovementCards.Forward;
import dtu.logic.models.Cards.MovementCards.TurnLeft;
import dtu.logic.models.Cards.MovementCards.TurnRight;
import dtu.logic.models.Cards.MovementCards.Uturn;
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
        robot = new Robot(RobotColor.BLUE,new Position(5,5));
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
        board.getTileAt(robot.getPos()).effect(robot,board);
        
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
    
    board.moveRobot(robot,new Position(4, 1));

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
            {"BT 3 2","T","HT","T","T","T","T","T","T","T"},
            {"BT 3 2","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","BT 3 1","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","LT 4","T","T","T","T","BT 1 2","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"BT 2 2","BT 1 2","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"}};
        this.board = new Board(board1, true);
        robot1 = new Robot(RobotColor.BLUE,new Position(3,3));
        robot2 = new Robot(RobotColor.GREEN,new Position(3,3));
        robot3 = new Robot(RobotColor.BLUE,new Position(5,3));
        robot4 = new Robot(RobotColor.RED,new Position(5,3));
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
    @Then("Add the player is not added if they have the same RobotColor")
    public void add_the_player_is_not_added_if_they_have_the_same_Robotcolor() {
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
        board.fireboardLazers(); 
        
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
            TileBelt BT = (TileBelt) tile;
            BT.effect(robot1,board);
        }
        
    }
    @Then("The robot is pushed in the direction of the belt.")
    public void the_robot_is_pushed_in_the_direction_of_the_belt() {
        assertEquals(5,robot1.getPos().getRow());
}
    @When("A robot is placed on the BeltTile with intensity two where the tile after is no a belt tile")
    public void a_robot_is_placed_on_the_belt_tile_with_intensity_two_where_the_tile_after_is_no_a_belt_tile() {
        board.moveRobot(robot1,new Position(6,7));
        if (board.getTileAt(robot1.getPos()) instanceof TileBelt){
            TileBelt tileBelt = (TileBelt)board.getTileAt(robot1.getPos());
            tileBelt.effect(robot1,board);
        }
        
    }
    @Then("The robot is pushed one space")
    public void the_robot_is_pushed_one_space() {
        assertEquals(6,robot1.getPos().getRow());
}
    @When("A robot is placed on the BeltTile with intensity two where the tile after is a belt tile")
    public void a_robot_is_placed_on_the_belt_tile_with_intensity_two_where_the_tile_after_is_a_belt_tile() {
        board.moveRobot(robot1,new Position(0,0));
        if (board.getTileAt(robot1.getPos()) instanceof TileBelt){
            TileBelt tileBelt = (TileBelt)board.getTileAt(robot1.getPos());
            tileBelt.effect(robot1,board);
        }
    }
    @Then("The robot is pushed two space")
    public void the_robot_is_pushed_two_space() {
        assertEquals(2,robot1.getPos().getRow());
}
    @When("A robot is placed on the BeltTile with intensity two where the tile after is a belt tile with different direction")
    public void a_robot_is_placed_on_the_belt_tile_with_intensity_two_where_the_tile_after_is_a_belt_tile_with_different_direction() {
        board.moveRobot(robot1,new Position(0,10));
        if (board.getTileAt(robot1.getPos()) instanceof TileBelt){
            TileBelt tileBelt = (TileBelt)board.getTileAt(robot1.getPos());
            tileBelt.effect(robot1,board);
        }
    }
    @Then("The robot is pushed twice in different directions.")
    public void the_robot_is_pushed_twice_in_different_directions() {
        assertEquals(9,robot1.getPos().getRow());
        assertEquals(1,robot1.getPos().getColumn());
    }
    @Given("A Board and four players with different starting points")
    public void a_board_and_four_players_with_different_starting_points() {
        String[][] board1 = {   
            {"BT 3 2","T","HT","","T","T","T","T","T","T"},
            {"BT 3 2","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","BT 3 1","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","LT 4","T","T","T","T","BT 1 2","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"LT 3","T","T","T","T","T","T","T","T","T"},
            {"BT 2 2","BT 1 2","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"}};
        this.board = new Board(board1, true);
        robot1 = new Robot(RobotColor.BLUE,new Position(0,5));
        robot2 = new Robot(RobotColor.GREEN,new Position(1,5));
        robot3 = new Robot(RobotColor.BLACK,new Position(2,5));
        robot4 = new Robot(RobotColor.RED,new Position(3,5));
        player1 = new Player(robot1,"Casper1");
        player2 = new Player(robot2,"Casper2");
        player3 = new Player(robot3,"Casper3");
        player4 = new Player(robot4,"Casper4");
        board.initPlayers();
}
    @When("robots are placed on tiles and allTileEffect is called")
    public void four_robots_are_placed_on_tiles_and_all_tile_effect_is_called() {
        board.addPlayer(player1);
        board.addPlayer(player2);
        board.addPlayer(player3);
        board.addPlayer(player4);
        board.moveRobot(robot1, new Position(2,2));
        robot1.setCheckpoint(new Position(0, 5));
        board.moveRobot(robot2, new Position(0,10));
        board.moveRobot(robot3, new Position(2,4));
               
        board.RunAllEffects();
    }
    @Then("Each robot is effected accordingly")
    public void each_robot_is_effected_accordingly() {
        
        assertEquals((new Position(0,5)),robot1.getPos());
        assertEquals((new Position(1,9)),robot2.getPos());
        assertEquals((new Position(2,5)),robot3.getPos());
    }
    @Given("A clean board and {int} players")
    public void a_clean_board_and_players(Integer int1) {
        String[][] board1 = {   
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"}};
        this.board = new Board(board1, true);
        robot1 = new Robot(RobotColor.BLUE,new Position(0,5));
        robot2 = new Robot(RobotColor.GREEN,new Position(1,5));
        
        player1 = new Player(robot1,"Casper1");
        player2 = new Player(robot2,"Casper2");
       
        board.initPlayers();
}
    @When("The board activates the registers")
    public void The_board_activates_the_registers() {
        board.moveRobot(player1.getRobot(),new Position(2,8));
        board.moveRobot(player2.getRobot(),new Position(8,8));
        List<ProgramCard> cards1 = new ArrayList<ProgramCard>(Arrays.asList(new Forward(2),
                                                                            new TurnRight(1),
                                                                            new Forward(1),
                                                                            new TurnLeft(1),
                                                                            new Uturn()));
        List<ProgramCard> cards2 = new ArrayList<ProgramCard>(Arrays.asList(new TurnLeft(1),
                                                                            new Forward(2),
                                                                            new Again(),
                                                                            new Backwards(1),
                                                                            new Uturn()));
        player1.getRobot().setRegister(cards1);
        player2.getRobot().setRegister(cards2);
        board.addPlayer(player1);
        board.addPlayer(player2);
        board.runAllRegisters();


    }
    @Then("The Robots follow the register sequence")
    public void the_robots_follow_the_register_sequence() {
    assertEquals(new Position(3,6),player1.getRobot().getPos());
    assertEquals(Direction.DOWN,player1.getRobot().getdir());

    assertEquals(new Position(5,8),player2.getRobot().getPos());
    assertEquals(Direction.RIGHT,player2.getRobot().getdir());
}
    @When("The board activates the registers in a way that makes them push eachother")
    public void the_board_activates_the_registers_in_a_way_that_makes_them_push_eachother() {
        board.moveRobot(player1.getRobot(),new Position(5,8));
        board.moveRobot(player2.getRobot(),new Position(4,8));
        List<ProgramCard> cards1 = new ArrayList<ProgramCard>(Arrays.asList(new TurnLeft(1), //deals 1 damage to platyer 2
                                                                            new Forward(2), //deals 3 damage to player 2 (2 push + lazer)
                                                                            new TurnRight(1), //does not hit
                                                                            new TurnLeft(1), //deals 1 damage to platyer 2
                                                                            new Uturn())); //ends pointing right
        List<ProgramCard> cards2 = new ArrayList<ProgramCard>(Arrays.asList(new TurnRight(1),// deals 1 damage to player 1
                                                                            new Forward(2),//deals 3 damage to player 2 (2 push + lazer)
                                                                            new Again(), //deals 3 damage to player 2 (2 push + lazer)
                                                                            new Backwards(1), //deals 1 damage to platyer 2
                                                                            new Uturn())); // ends pointing Left
        player1.getRobot().setRegister(cards1);
        player2.getRobot().setRegister(cards2);
        board.addPlayer(player1);
        board.addPlayer(player2);
        
        board.runAllRegisters();
    }
    @Then("The robots respond accordingly")
    public void the_robots_respond_accordingly() {
    
    assertEquals(new Position(7,8),player1.getRobot().getPos());
    assertEquals(Direction.RIGHT,player1.getRobot().getdir());
    assertEquals(8,player1.getRobot().getDamageTaken());

    assertEquals(new Position(5,8),player2.getRobot().getPos());
    assertEquals(Direction.LEFT,player2.getRobot().getdir());
    assertEquals(5,player2.getRobot().getDamageTaken());
}
    @When("The board activates the registers in a way that makes them walk on top of tiles with effects")
    public void the_board_activates_the_registers_in_a_way_that_makes_them_walk_on_top_of_tiles_with_effects() {
       
        board.moveRobot(player1.getRobot(),new Position(1,0));
        robot1.setCheckpoint(new Position(0, 5));
        List<ProgramCard> cards1 = new ArrayList<ProgramCard>(Arrays.asList(new TurnLeft(1),
                                                                            new Forward(1),
                                                                            new Uturn(),
                                                                            new Forward(2),
                                                                            new TurnRight(1)));
        player1.getRobot().setRegister(cards1);
        board.addPlayer(player1);
        
        board.runAllRegisters();
    }
    @Then("The robots are affected acordingly.")
    public void the_robots_are_affected_acordingly() {
    assertEquals(new Position(0,5),player1.getRobot().getPos());
    assertEquals(Direction.DOWN,player1.getRobot().getdir());
    assertEquals(2,player1.getRobot().getDamageTaken());
    assertEquals(2,player1.getRobot().getLives());
}
}


