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


public class CardDeckGenerationTest {
    Player testPlayer;
    Deck deck;
    @Given("A player is created")
    public void a_player_is_created() {
        Color userTestInputColor = Color.RED;
        testPlayer = new Player(userTestInputColor);
    }

    @Then("A deck of cards is generated")
    public void a_deck_of_cards_is_generated() {
        testPlayer.GenerateDeck();
    }   
}
