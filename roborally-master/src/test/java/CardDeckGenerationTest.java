
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import dtu.logic.models.*;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;


public class CardDeckGenerationTest {
    Player testPlayer;
    Deck deck;
    @Given("A player is created")
    public void a_player_is_created() {
        Robot robot = new Robot(RobotColor.RED,new Position(5,5));
        testPlayer = new Player(robot,"Casper");
    }

    @Then("A deck of cards is generated")
    public void a_deck_of_cards_is_generated() {
        testPlayer.GenerateDeck();
    }   
}
