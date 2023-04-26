package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Uturn implements ProgramCard{
    private String image = "Cards/uturn.png";
    
    @Override
    public String getImage(){
        return this.image;
    }
    
    public void effect(Robot robot,Board board){
        robot.turn(2, board);
    
}
}
