package dtu.logic.models.Cards;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;

public class Deck {
    public ArrayList<ProgramCard> cards = new ArrayList<ProgramCard>();
  
    public Deck(){
        for(int i=0; i<5; i++)
        cards.add(MovementCard.createCard("LEFT", -1, "Cards/left_turn.png"));
        for(int i=0; i<5; i++)
        cards.add(MovementCard.createCard("RIGHT", 1, "Cards/right_turn.png"));
        for(int i=0; i<5; i++)
        cards.add(MovementCard.createCard("UTURN", 2, "Cards/uturn.png"));
        for(int i=0; i<5; i++)
        cards.add(MovementCard.createCard("FORWARDS", 1, "Cards/mv_1.png"));
        for(int i=0; i<5; i++)
        cards.add(MovementCard.createCard("FORWARDS", 2, "Cards/mv_2.png"));
        for(int i=0; i<5; i++)
        cards.add(MovementCard.createCard("FORWARDS", 3, "Cards/mv_3.png"));
        for(int i=0; i<5; i++)
        cards.add(MovementCard.createCard("BACKWARDS", -1, "Cards/mv_back.png"));
        for(int i=0; i<3; i++)
        cards.add(ProgramCard.createProgramCard("AGAIN", 0));
        for(int i=0; i<2; i++)
        cards.add(ProgramCard.createProgramCard("POWERUP", 0));

    }

    

    public Boolean CheckDeckMovement(ArrayList<ProgramCard> cards){
        
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
    }

    public ArrayList<ProgramCard> shuffleDeck(ArrayList<ProgramCard> cards){
        Collections.shuffle(cards);
    return cards;

    }
}