package dtu.logic.models.Cards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Robot.Robot;

public interface ActionCard {
  
    /*
    Interface for all action cards
    */

    void action(Robot robot, BoardController boardController);

    String getImage();

    public String getName();

    public String getDescription();

}
