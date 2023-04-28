package dtu.logic.models.Cards.ActionCards;
import java.util.concurrent.ThreadLocalRandom;
public enum ActionCardTypes {
    FireRain, OilStorm, SpinLaser; 

    public static ActionCardTypes getRandomActionType(){
        int rand = ThreadLocalRandom.current().nextInt(0, ActionCardTypes.values().length + 1);
        return ActionCardTypes.values()[rand];
    }
}


