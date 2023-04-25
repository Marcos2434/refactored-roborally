package dtu.logic.models.Cards;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;
import dtu.logic.models.Cards.MovementCards.ProCardFactory;
import dtu.logic.models.Cards.MovementCards.ProCardTypes;

public class Deck {
    public ArrayList<ProgramCard> cards = new ArrayList<ProgramCard>();
  
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
    }

    public ArrayList<ProgramCard> getDeck(){
        return this.cards;
    }

    /*public Boolean CheckDeckMovement(){
        
        int cardsTypes = 0;

        for(int i=0; i<(cards.size()-1); i++){
            for(int j=i+1; j<(cards.size()-1);j++){
                if (cards.get(i).name != null && cards.get(j).name != null && cards.get(i).name.equals(cards.get(j).name)) {
                    cardsTypes++;
                }
            }   
        }
        
        if (cardsTypes == 7){
            return true;
        }
        else return false;
    }*/

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }
}