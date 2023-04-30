package dtu.logic.models.Cards.MovementCards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

//Implementation of a card that makes the robot turn left
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
    public void effect(Robot robot, BoardController boardController){
        robot.setLastMove(new TurnRight(intensity));
            robot.turn(intensity, boardController);
        
    }
    
}
