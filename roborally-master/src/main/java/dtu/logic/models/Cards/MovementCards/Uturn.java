package dtu.logic.models.Cards.MovementCards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Uturn implements ProgramCard{
    public void effect(Robot robot, BoardController boardController){
        robot.setLastMove(new Uturn());
        robot.turn(2, boardController);
    }

    private String image = "Cards/uturn.png";
    
    @Override
    public String getImage(){
        return this.image;
    }
}

