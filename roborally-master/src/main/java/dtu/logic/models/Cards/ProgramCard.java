package dtu.logic.models.Cards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Robot.Robot;

public interface ProgramCard {
    /*
    Interface for all program cards
    */
  
    public void effect(Robot robot, BoardController boardController);
    public String getImage();
}
