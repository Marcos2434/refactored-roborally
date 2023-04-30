package dtu.logic.models.Cards.MovementCards;
import dtu.logic.models.Cards.ProgramCard;

// Creation of all movement cards on the basis of their types, with added intensity
public class ProCardFactory {
    public static ProgramCard createProgramCard(ProCardTypes type,int intensity){
        if (type == ProCardTypes.TURNLEFT){
            return new TurnLeft(intensity);
        }
        else if (type == ProCardTypes.TURNRIGHT){
            return new TurnRight(intensity);
        }
        else if (type == ProCardTypes.FORWARD){
            return new Forward(intensity);
        }
        else if (type == ProCardTypes.BACKWARDS){
            return new Backwards(intensity);
        }
        else if (type == ProCardTypes.UTURN){
            return new Uturn();
        }
        else if (type == ProCardTypes.AGAIN){
            return new Again();
        }
        else{return null;}

    }
}
