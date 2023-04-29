package dtu.logic.models.Cards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Robot.Robot;

public interface ActionCard {
  
    void action(Robot robot, BoardController boardController);

    String getImage();

    public String getName();

    public String getDescription();

}
