package dtu.logic.models.Cards;
import java.util.ArrayList;
import java.util.Collections;
import dtu.logic.models.Cards.MovementCards.ProCardFactory;
import dtu.logic.models.Cards.MovementCards.ProCardTypes;

public class Deck {
    public ArrayList<ProgramCard> cards = new ArrayList<ProgramCard>();
  //Creates a deck of cards
    public Deck(){
        for(int i=0; i<5; i++){
        cards.add(ProCardFactory.createProgramCard(ProCardTypes.TURNLEFT, 1));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.TURNRIGHT, 1));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.UTURN, 0));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.FORWARD, 1));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.FORWARD, 2));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.FORWARD, 3));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.BACKWARDS, 1));}
       
        for(int i=0; i<2; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.AGAIN, 0));}

    }

    public ArrayList<ProgramCard> getDeck(){
        return this.cards;
    }
    //Shuffles the deck
    public void shuffleDeck(){
        Collections.shuffle(cards);
    }
}