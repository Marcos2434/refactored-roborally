import static org.junit.Assert.assertNotNull;

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
    
        // Write code here that turns the phrase above into concrete actions
        @Given("A deck is created")
        public void a_deck_is_created() {
            Color userTestInputColor = Color.RED;
            testPlayer = new Player(userTestInputColor);
            testPlayer.GenerateDeck();
            
        }
        @When("The player receives {int} cards from the deck")
        public void the_player_receives_cards_from_the_deck(Integer int1) {
           
            

            throw new io.cucumber.java.PendingException();
        }
        @Then("The player has {int} cards in his hand")
        public void the_player_has_cards_in_his_hand(Integer int1) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

    
}
