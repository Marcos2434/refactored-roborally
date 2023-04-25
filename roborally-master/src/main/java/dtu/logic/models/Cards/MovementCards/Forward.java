package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Forward implements ProgramCard {
    private int intensity;
    public Forward(int intensity) {
        this.intensity = intensity;
    }
    public void effect(Robot robot,Board board){
        for (int i = 0; i <intensity; i++) {
            robot.moveforward(true, board);
            if (robot.getPos().getRow() < 0 || robot.getPos().getRow() > 12 ||
                robot.getPos().getColumn() < 0 || robot.getPos().getColumn()>9){
                    robot.Death(board);
                    break;
            }
            
        //update new tile
            board.getTileAt(robot.getPos()).Occupy(robot.getImage(), robot.getDirID());
            try{Thread.sleep(200);}
            catch(Exception e){System.out.println(e);}

        }
        board.getTileAt(robot.getPos()).Occupy(robot.getImage(), robot.getDirID());
    }
}
