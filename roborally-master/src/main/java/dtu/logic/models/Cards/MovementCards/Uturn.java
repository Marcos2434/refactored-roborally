package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Uturn implements ProgramCard{
    public void effect(Robot robot,Board board){
        robot.turn(2, board);
    
}
}
