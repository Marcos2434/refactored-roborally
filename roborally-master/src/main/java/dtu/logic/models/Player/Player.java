package dtu.logic.models.Player;

import java.util.ArrayList;
import java.util.List;

import dtu.logic.models.Color;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Player {
    private Robot robot;
    private ArrayList<ProgramCard> hand = new ArrayList<ProgramCard>();
    
    public Player(Color color) {
        this.robot = new Robot(color);
    }

    public Robot getRobot() {
        return robot;
    }

    public void drawProgrammingCards() {
        for (int i = 0; i < 9 - this.robot.getDamageTaken(); i++) {
            // TODO Random integer
            hand.add(new ProgramCard(5));
        }
    }

    public void chooseProgrammingCards() {
        // Choose from the hand

        // ArrayList<Card> firstFive = Arrays.copyOfRange(this.hand, 0, 5); 
        List<ProgramCard> firstFive = this.hand.subList(0, 5); // for now, choose first 5

        // add to robot register
        robot.addCardsToRegister(firstFive);
    }

    @Override
    public String toString() {
        return "Player with robot of color" + robot;
    }
}

