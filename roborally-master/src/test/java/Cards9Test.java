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
            testPlayer.drawProgrammingCards();
        }
        @Then("The player has {int} cards in his hand")
        public void the_player_has_cards_in_his_hand(Integer int1) {
            this.hand=testPlayer.getHand();
            hand.size(); 
        }
        
        @Then("The deck has {int} different kinds of cards in it")
        public void the_deck_has_different_kinds_of_cards_in_it(Integer int1) {
        testPlayer.deck.CheckDeckMovement(testPlayer.deck.cards);       
        }
       
        @Then("The deck has all necessary programming cards in it")
        public void the_deck_has_all_necessary_programming_cards_in_it() { 
        testPlayer.deck.CheckDeckMovement(testPlayer.deck.cards);
        }
        
        //As a player i want to be able to choose 5 cards out of my hand
        @When("The player receives {int} cards from the deck and chooses {int} of them")
        public void the_player_receives_cards_from_the_deck_and_chooses_of_them(Integer int1, Integer int2) {
            testPlayer.drawProgrammingCards();
            testPlayer.chooseProgrammingCards(5);        
        }
        @Then("The player has {int} cards in the register")
        public void the_player_has_cards_in_the_register(Integer int1) {
            testPlayer.robot.register.size();
        }

        @Then("The cards are shuffeled")
        public void the_cards_are_shuffeled() {
            testPlayer.drawProgrammingCards();
            testPlayer.deck.shuffleDeck(testPlayer.deck.cards);
        }
}
