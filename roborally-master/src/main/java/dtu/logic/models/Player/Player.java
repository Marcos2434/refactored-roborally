package dtu.logic.models.Player;
import java.util.ArrayList;
import java.util.List;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;


public class Player {
    /* 
    Class which represents a player in the game
    */

    private String name;
    protected Robot robot;
    protected Deck deck = new Deck();
    protected ArrayList<ProgramCard> hand = new ArrayList<ProgramCard>();
    
    
    public Player(Robot robot,String name) {
        this.robot = robot;
        this.name = name;
    }
    public Deck getDeck(){
        return deck;
    }
    public Robot getRobot() {
        return robot;
    }

    public String getName() {
        return name;
    }

    public void GenerateDeck() {
        this.deck = new Deck();
    }

    public void drawProgrammingCards() { 
        deck.shuffleDeck();
        ArrayList<ProgramCard> arr = new ArrayList<ProgramCard>();;
        // We draw the 9 cards unless there is a damage taken on the robot, then the hand gets smaller
        for (int i = 0; i < 9 - this.robot.getDamageTaken(); i++) {
            arr.add(deck.cards.get(i));
        }
        hand = arr;
    }

    //The method is overriden in the AI class, therefore the  normal player needs to be set as not AI
    public boolean isAI(){
        return false;
    }
    
    public void chooseProgrammingCards() {
        List<ProgramCard> registerCards;
        if (hand.size() >= 5){
            registerCards = hand.subList(0, 5);
        }
        // Choose from the hand
        else{
            registerCards = hand;
        }
        
        // notify observers
        try{
            notify();
        }
        catch(Exception e){System.out.println(e);}
        // add to robot register
        robot.setRegister(registerCards);
        
    }

    public void moveRobot(int x, int y){
        robot.setPos(x, y);
    }

    @Override
    public String toString() {
        return "Player with robot of color" + robot;
    }

    public ArrayList<ProgramCard> getHand() {
        return hand;
    }
}

