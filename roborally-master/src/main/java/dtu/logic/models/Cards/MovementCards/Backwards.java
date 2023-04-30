package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Backwards implements ProgramCard{
    private int intensity;
    private String image = "Cards/mv_back.png";

    public Backwards(int intensity) {
        this.intensity = intensity;
    }
    
    @Override
    public String getImage(){
        return this.image;
    }
    
    public void effect(Robot robot, BoardController boardController){
        robot.setLastMove(new Backwards(intensity));
        
        for (int i = 0; i <intensity; i++) {
            boardController.getBoard().getTileAt(robot.getPos()).unOccupy();
                robot.moveforward(false, boardController);
            if (robot.getPos().getRow() < 0 || robot.getPos().getRow() > 12 || robot.getPos().getColumn() < 0 || robot.getPos().getColumn()>9){
                robot.Death(boardController);
                break;
            }       
            try {
                // Thread.sleep(200);
            } catch (Exception e) { System.err.println(e); }
            boardController.getBoard().getTileAt(robot.getPos()).Occupy();
        }
        boardController.getBoard().getTileAt(robot.getPos()).Occupy();
    }
}
