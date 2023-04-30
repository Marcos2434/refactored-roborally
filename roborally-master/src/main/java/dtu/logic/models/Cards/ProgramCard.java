package dtu.logic.models.Cards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Robot.Robot;

public interface ProgramCard {
   
    /*
    Interface for all program cards
    */
  
    void effect(Robot robot, BoardController boardController);

    String getImage();
}
