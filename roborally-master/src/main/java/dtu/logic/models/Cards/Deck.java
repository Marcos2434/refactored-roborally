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
        cards.add(ProCardFactory.createProgramCard(ProCardTypes.TURNLEFT, 1,"Cards/left_turn.png"));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.TURNRIGHT, 1,"Cards/right_turn.png"));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.UTURN, 0,"Cards/uturn.png"));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.FORWARD, 1,"Cards/mv_1.png"));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.FORWARD, 2,"Cards/mv_2.png"));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.FORWARD, 3,"Cards/mv_3.png"));}
        for(int i=0; i<5; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.BACKWARDS, 1,"Cards/mv_back.png"));}
        for(int i=0; i<2; i++)
        {cards.add(ProCardFactory.createProgramCard(ProCardTypes.AGAIN, 0,"Cards/again.png"));}

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