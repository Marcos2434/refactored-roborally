import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Player.*;
public class Cards9Test {
        private Player testPlayer;
        Deck deck;
        private ArrayList<dtu.logic.models.Cards.ProgramCard> hand;

    
        // Write code here that turns the phrase above into concrete actions
        @Given("A player is created with a chosen color for the robot and a deck is generated")
        public void a_player_is_created_with_a_chosen_color_for_the_robot_and_a_deck_is_generated() {
            Color userTestInputColor = Color.RED;
            testPlayer = new Player(userTestInputColor);
            testPlayer.GenerateDeck();
        
            
        }
        @When("The player receives {int} cards from the deck")
        public void the_player_receives_cards_from_the_deck(Integer int1) {
                testPlayer.drawProgrammingCards(deck);
        
       
        }
        @Then("The player has {int} cards in his hand")
        public void the_player_has_cards_in_his_hand(Integer int1) {
            this.hand=testPlayer.getHand();
            hand.size();

            
        }

    
}
