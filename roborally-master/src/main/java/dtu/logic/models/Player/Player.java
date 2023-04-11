package dtu.logic.models.Player;

import java.util.ArrayList;
import java.util.List;

import dtu.logic.models.Color;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Player {
    public Robot robot;
    public Deck deck;
    private ArrayList<ProgramCard> hand = new ArrayList<ProgramCard>();
    
    public Player(Color color) {
        this.robot = new Robot(color);
    }

    public Robot getRobot() {
        return robot;
    }

    public void GenerateDeck() {
        this.deck = new Deck();
    }
    

    public void drawProgrammingCards() {
        for (int i = 0; i < 9 - this.robot.getDamageTaken(); i++) {
            String name = ((deck.cards).get(i)).name;
     
            hand.add(new ProgramCard(name, 3));
        }
    }

    

    public void chooseProgrammingCards(Integer numberOfCards) {
        // Choose from the hand


        List<ProgramCard> registerCards = hand.subList(0, numberOfCards);

        // add to robot register
        robot.addCardsToRegister(registerCards);
        
    }

    @Override
    public String toString() {
        return "Player with robot of color" + robot;
    }

    public ArrayList<ProgramCard> getHand() {
        return hand;
    }

  


}

