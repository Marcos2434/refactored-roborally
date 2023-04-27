package dtu.logic.models;
import dtu.logic.models.Player.Player;

import java.util.ArrayList;
import java.util.List;

import dtu.logic.models.RobotColor;
import dtu.logic.models.Cards.Deck;

import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;
import java.util.Scanner;
 
/**
 * AI
 */
public class AI extends Player {
    static int AICount = 1;
   
    
    public AI(Robot robot) {
        super(robot, "Bob"+AICount);
        //TODO Auto-generated constructor stub
        AICount = AICount+1;
    }

    @Override 
    public void drawProgrammingCards() {
        deck.shuffleDeck();
        ArrayList<ProgramCard> arr = new ArrayList<ProgramCard>();;
        if (this.robot.getDamageTaken()<4) 
        {
            for (int i = 0; i < 5; i++) {
            //String name = ((deck.cards).get(i)).name;
            arr.add(deck.cards.get(i));
        }
        }
        else{
        for (int i = 0; i < 9 - this.robot.getDamageTaken(); i++) {
            //String name = ((deck.cards).get(i)).name;
            arr.add(deck.cards.get(i));
            
            //hand.add(new ProgramCard(name, 3));
            }
        }

        hand = arr;
    }
    @Override
    public boolean isAI(){
        return true;
    }
    
}