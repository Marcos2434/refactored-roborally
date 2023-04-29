package dtu.logic.models.Cards.ActionCards;
import java.util.concurrent.ThreadLocalRandom;

//Enum of all action cards (so far)
public enum ActionCardTypes {
    FireRain,
    OilStorm,
    SpinLaser;
   

    //Random generator for action cards types 
    
    public static ActionCardTypes getRandomActionType(){
        int rand = ThreadLocalRandom.current().nextInt(0, ActionCardTypes.values().length + 1);
        return ActionCardTypes.values()[rand];
    }
    
}


