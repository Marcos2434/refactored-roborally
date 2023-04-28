package dtu.logic.models.Player;
import java.util.ArrayList;
import java.util.List;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;


public class Player {
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
        for (int i = 0; i < 9 - this.robot.getDamageTaken(); i++) {
            //String name = ((deck.cards).get(i)).name;
            arr.add(deck.cards.get(i));
            
            //hand.add(new ProgramCard(name, 3));
        }
        hand = arr;
    }

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
        notify();

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

