package dtu.logic.models.Cards.MovementCards;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Backwards implements ProgramCard{
    private int intensity;
    public Backwards(int intensity) {
        this.intensity = intensity;
    }
    public void effect(Robot robot,Board board){
        for (int i = 0; i <intensity; i++) {
            robot.moveforward(false, board);
        }
    }
    
}
