package dtu.logic.models;
import dtu.logic.models.Player.Player;
import java.util.ArrayList;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

/**
 * AI
 */
public class AI extends Player {
    static int AICount = 1;
    
    public AI(Robot robot) {
        super(robot, "Bob"+AICount);
        AICount = AICount+1;
    }
    public AI(Robot robot,String name) {
        super(robot, name);
        AICount = AICount+1;
    }

    @Override 
    public void drawProgrammingCards() {
        deck.shuffleDeck();
        ArrayList<ProgramCard> array = new ArrayList<ProgramCard>();;
        if (this.robot.getDamageTaken()<4) 
        {
            for (int i = 0; i < 5; i++) {
            //String name = ((deck.cards).get(i)).name;
            array.add(deck.cards.get(i));
            }
        }
        else{
            for (int i = 0; i < 9 - this.robot.getDamageTaken(); i++) {
                array.add(deck.cards.get(i));
                }
        }
        hand = array;
        robot.setRegister(hand);

    }
    @Override
    public boolean isAI(){
        return true;
    }
}