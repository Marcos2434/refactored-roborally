package dtu.logic.models.Cards;

import java.util.ArrayList;

import dtu.logic.models.Cards.ActionCards.ActionCardFactory;
import dtu.logic.models.Cards.ActionCards.ActionCardTypes;

public class ActionDeck {
    public ArrayList<ActionCard> cards = new ArrayList<ActionCard>();
    
    public ActionDeck(){
        for(int i=0; i<5; i++){
        cards.add(ActionCardFactory.createActionCard(ActionCardTypes.OilStorm));}
        for(int i=0; i<5; i++)
        {cards.add(ActionCardFactory.createActionCard(ActionCardTypes.FireRain));}
        for(int i=0; i<5; i++)
        {cards.add(ActionCardFactory.createActionCard(ActionCardTypes.SpinLaser));}

    }

    public ArrayList<ActionCard> getDeck(){
        return this.cards;
    }
    
}
