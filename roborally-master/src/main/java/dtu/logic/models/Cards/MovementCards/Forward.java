package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Forward implements ProgramCard {
    private int intensity;
    
    private String image = "Cards/mv_"+intensity+".png";
    
    @Override
    public String getImage(){
        return this.image;
    }

    public Forward(int intensity) {
        this.intensity = intensity;
    }
    public void effect(Robot robot,Board board){
        for (int i = 0; i <intensity; i++) {
            robot.moveforward(true, board);
        }
    }
}
