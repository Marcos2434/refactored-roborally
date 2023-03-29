package dtu.logic.models.Cards;


import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cards = new ArrayList<Card>();
        
    public Deck(){
        for(int i=0; i<20; i++)
        cards.add(new Card());
    }

    public ProgramCard drawCard() {
        return (ProgramCard) cards.remove(0);
    }    

}