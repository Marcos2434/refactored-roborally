package dtu.logic.models.Cards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Robot.Robot;

public interface ProgramCard {
  
    void effect(Robot robot,Board board);
    
    String getImage();


}
