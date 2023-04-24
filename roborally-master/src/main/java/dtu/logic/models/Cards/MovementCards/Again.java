package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Again implements ProgramCard{

    @Override
    public void effect(Robot robot, Board board) {
        robot.getLastMove().effect(robot, board);
    }
    
}
