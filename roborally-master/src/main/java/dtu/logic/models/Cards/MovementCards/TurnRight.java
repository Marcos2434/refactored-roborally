package dtu.logic.models.Cards.MovementCards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

//Implementation of a card that makes the robot turn right
public class TurnRight implements ProgramCard{
    private int intensity;
    private String image = "Cards/right_turn.png";

    public TurnRight(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public String getImage(){
        return this.image;
    }

    public void effect(Robot robot, BoardController boardController){
            robot.setLastMove(new TurnRight(intensity));
            robot.turn(intensity, boardController);
    }
}
