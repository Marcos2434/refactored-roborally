package dtu.logic.models.Cards;

import java.util.ArrayList;

import dtu.logic.models.Direction;

public class MovementCard extends ProgramCard {


    MovementCard(String name, int intensity) {
        super(name, intensity);
        this.name = name;
        this.intensity =intensity;
    }

//Enumeration of all possible movement cards
    enum CardName{
        LEFT,
        RIGHT,
        UTURN,
        BACKWARDS,
        FORWARDS,
    }
//Method to create a movement card- written to correspond with the Deck class and Robot class methods 
    public static MovementCard createCard(String cardName, int intensity){
        switch (cardName){
            case "LEFT":
                return new MovementCard("LEFT",intensity);
            case "RIGHT":
                return new MovementCard("RIGHT",intensity);
            case "UTURN":
                return new MovementCard("UTURN", intensity);
            case "BACKWARDS":
                return new MovementCard("BACKWARDS", intensity);
            case "FORWARDS":
                return new MovementCard("FORWARDS", intensity);
            default:
                return null;
        }
    }
}
