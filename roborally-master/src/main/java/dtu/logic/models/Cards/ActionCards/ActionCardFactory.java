package dtu.logic.models.Cards.ActionCards;
import java.util.ArrayList;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Cards.ActionDeck;



public class ActionCardFactory {
    public static ActionCard createActionCard(ActionCardTypes type){
        if (type == ActionCardTypes.OilStorm){
            return new OilStorm();
        }
        else if (type == ActionCardTypes.FireRain){
            return new FireRain();
        }
        else if (type == ActionCardTypes.SpinLaser){
            return new SpinLaser();
        }
        else{return null;}
    }

    


}