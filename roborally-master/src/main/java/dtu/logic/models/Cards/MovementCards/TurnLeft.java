package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class TurnLeft implements ProgramCard {
    private int intensity;
    public TurnLeft(int intensity) {
        this.intensity = -intensity;
    }
    public void effect(Robot robot, BoardController boardController){
            robot.turn(intensity, boardController);
        
    }
    
}
