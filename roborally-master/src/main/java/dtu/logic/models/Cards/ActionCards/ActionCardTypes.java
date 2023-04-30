package dtu.logic.models.Cards.ActionCards;
import java.util.concurrent.ThreadLocalRandom;

public enum ActionCardTypes {
    /*
    Enum of all action cards types
    */

    FireRain,
    OilStorm,
    SpinLaser;
   
    //Random generator for action cards types 
    public static ActionCardTypes getRandomActionType(){
        int rand = ThreadLocalRandom.current().nextInt(0, ActionCardTypes.values().length);
        return ActionCardTypes.values()[rand];
    } 
}


