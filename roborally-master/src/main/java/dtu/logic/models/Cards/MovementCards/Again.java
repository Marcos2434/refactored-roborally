package dtu.logic.models.Cards.MovementCards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;


//Implementation of a card that makes the robot do its last move again
public class Again implements ProgramCard{
    private String image = "Cards/again.png";
    
    @Override
    public String getImage(){
        return this.image;
    }
    
    @Override
    public void effect(Robot robot, BoardController boardController) {
        if (robot.getLastMove() != null){
            robot.getLastMove().effect(robot, boardController);
        }
    }
}
