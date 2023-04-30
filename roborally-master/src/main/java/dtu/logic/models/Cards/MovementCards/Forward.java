package dtu.logic.models.Cards.MovementCards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Board.TileHole;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Robot.Robot;

public class Forward implements ProgramCard {
    private int intensity;
    private String image;

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

    @Override
    public String getImage(){
        return this.image;
    }

    public void effect(Robot robot, BoardController boardController){
        robot.setLastMove(new Forward(intensity));
        for (int i = 0; i <intensity; i++) {
            boardController.getBoard().getTileAt(robot.getPos()).unOccupy();
            robot.setPrevPos(robot.getPos());
            robot.moveforward(true, boardController);
            try{
               // Thread.sleep(200);
            }
            catch(Exception e){System.out.println(e);}

            if (robot.getPos().getRow() < 0 || robot.getPos().getRow() > 12 ||
                robot.getPos().getColumn() < 0 || robot.getPos().getColumn()>9){
                    robot.Death(boardController);
                    break;
            }
            try{
               // Thread.sleep(200);
            }
            catch(Exception e){System.out.println(e);}
            robot.robotNotify();
            
            //update new tile
            boardController.getBoard().getTileAt(robot.getPos()).unOccupy();
            boardController.runAllHoles();
            boardController.getBoard().getTileAt(robot.getPos()).Occupy();
            
            if (boardController.getBoard().getTileAt(robot.getPos()) instanceof TileHole){
                TileHole TH = (TileHole) boardController.getBoard().getTileAt(robot.getPos());
                TH.effect(robot,boardController);
                break;
            }
            boardController.getBoard().getTileAt(robot.getPos()).Occupy();
        }
    }
}
