import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

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
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Cards.ActionCards.ActionCardFactory;
import dtu.logic.models.Cards.ActionCards.ActionCardTypes;
import dtu.logic.models.Cards.ActionCards.FireRain;
import dtu.logic.models.Cards.ActionCards.OilStorm;
import dtu.logic.models.Cards.ActionCards.SpinLaser;
import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Position.*;
public class Cards9Test {
        private Player testPlayer;
        Deck deck;
        private ArrayList<dtu.logic.models.Cards.ProgramCard> hand;
        String[][] board1 = {   
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","AT","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
            {"T","T","T","T","T","T","T","T","T","T"},
        };
        Board board = new Board(board1);
        BoardController bC = new BoardController(board);
    
        // Write code here that turns the phrase above into concrete actions
        @Given("A player is created with a chosen color for the robot and a deck is generated")
        public void a_player_is_created_with_a_chosen_color_for_the_robot_and_a_deck_is_generated() {
            Robot robot = new Robot(RobotColor.RED,new dtu.logic.models.Position(0, 0));
            testPlayer = new Player(robot,"Casper");
            testPlayer.GenerateDeck();
        }


        @When("The player receives {int} cards from the deck")
        public void the_player_receives_cards_from_the_deck(Integer int1) {
            testPlayer.drawProgrammingCards();
        }
        @Then("The player has {int} cards in his hand")
        public void the_player_has_cards_in_his_hand(Integer int1) {
            this.hand=testPlayer.getHand();
            hand.size(); 
        }
        
        
        //As a player i want to be able to choose 5 cards out of my hand
        @When("The player receives {int} cards from the deck and chooses {int} of them")
        public void the_player_receives_cards_from_the_deck_and_chooses_of_them(Integer int1, Integer int2) {
            testPlayer.drawProgrammingCards();
            testPlayer.chooseProgrammingCards();        
        }
        @Then("The player has {int} cards in the register")
        public void the_player_has_cards_in_the_register(Integer int1) {
            assertEquals(5, testPlayer.getRobot().register.size());
            //testPlayer.getRobot().register.size();
        }

        @Then("The cards are shuffeled")
        public void the_cards_are_shuffeled() {
            testPlayer.drawProgrammingCards();
            testPlayer.getDeck().shuffleDeck();
            assertNotNull(testPlayer.getDeck());
        }
        Robot robot1;
        Robot robot2;
        Robot robot3;
        ActionCard oil = ActionCardFactory.createActionCard(ActionCardTypes.OilStorm);
        ActionCard storm = ActionCardFactory.createActionCard(ActionCardTypes.FireRain);
        ActionCard Spin = ActionCardFactory.createActionCard(ActionCardTypes.SpinLaser);

        @Given("three robots")
        public void three_robots() {
            robot1 = new Robot(RobotColor.BLUE,new Position(4,4));
            robot2 = new Robot(RobotColor.RED,new Position(2,4));
            robot3 = new Robot(RobotColor.BLACK,new Position(0,4));
            bC.addPlayer(new Player(robot1,"Casper1"));
            bC.addPlayer(new Player(robot2,"Casper2"));
            bC.addPlayer(new Player(robot3,"Casper3"));
            bC.getBoard().getTileAt(robot1.getPos()).Occupy();
            bC.getBoard().getTileAt(robot2.getPos()).Occupy();
            bC.getBoard().getTileAt(robot3.getPos()).Occupy();

        }
        @When("each robot gets a diffenret card")
        public void each_robot_gets_a_diffenret_card() {
          
            
            Spin.action(robot2,bC);
            storm.action(robot3,bC);
            oil.action(robot1,bC);
            
        }
        @Then("they act acordingly")
        public void they_act_acordingly() {
            assertEquals(1,robot1.getDamageTaken());
            assertEquals(0,robot2.getDamageTaken());
            assertEquals(1,robot3.getDamageTaken());
            // only to run through the Tileaction function for coverage, as it is random it cannot be in an actual test.
            bC.RunAllEffects();
}
}
