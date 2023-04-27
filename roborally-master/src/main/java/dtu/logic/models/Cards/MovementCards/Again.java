package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;



public class Again implements ProgramCard{
    private String image = "Cards/again.png";
    
    @Override
    public String getImage(){
        return this.image;
    }
    
    @Override
    public void effect(Robot robot, BoardController boardController) {
        System.out.println(robot.getLastMove());
        if (robot.getLastMove() != null){
            robot.getLastMove().effect(robot, boardController);
        }
        
    }

    
    
}
