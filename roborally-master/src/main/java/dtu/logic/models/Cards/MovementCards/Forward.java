package dtu.logic.models.Cards.MovementCards;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Forward implements ProgramCard {
    private int intensity;
    
    private String image;

    public Forward () {
        System.out.println("Forward card created" + image);
    }
    @Override
    public String getImage(){
        return this.image;
    }

    public Forward(int intensity) {
        this.intensity = intensity;
        if (intensity==1){
            this.image = "Cards/mv_1.png";
        }
        if (intensity==2){
            this.image = "Cards/mv_2.png";
        }
        if (intensity==3){
            this.image = "Cards/mv_3.png";
        }
    }
    public void effect(Robot robot, BoardController boardController){
        robot.setLastMove(new Forward(intensity));
        for (int i = 0; i <intensity; i++) {
            robot.moveforward(true, boardController);
            if (robot.getPos().getRow() < 0 || robot.getPos().getRow() > 12 ||
                robot.getPos().getColumn() < 0 || robot.getPos().getColumn()>9){
                    robot.Death(boardController);
                    break;
            }
            
        //update new tile
            boardController.getBoard().getTileAt(robot.getPos()).Occupy(robot.getImage(), robot.getDirID());
            try{Thread.sleep(200);}
            catch(Exception e){System.out.println(e);}

        }
        boardController.getBoard().getTileAt(robot.getPos()).Occupy(robot.getImage(), robot.getDirID());
    }
}
