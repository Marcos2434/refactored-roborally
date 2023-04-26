package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class TurnLeft implements ProgramCard {
    private int intensity;

    private String image = "Cards/left_turn.png";
    
    @Override
    public String getImage(){
        return this.image;
    }

    public TurnLeft(int intensity) {
        this.intensity = -intensity;
    }
    public void effect(Robot robot,Board board){
            robot.turn(intensity, board);
        
    }
    
}
