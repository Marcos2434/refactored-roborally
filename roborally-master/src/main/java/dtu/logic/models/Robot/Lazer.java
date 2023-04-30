package dtu.logic.models.Robot;

import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Board.BoardController;

public class Lazer {
    private Position pos;
    private Direction Dir;
    private int DirID;
    private String imageString;

    public Lazer(Position pos, Direction dir){
        this.pos = pos;
        this.Dir = dir;
        this.DirID = dir.getId();
        if (dir.getId() == 1 || dir.getId() == 3){
            this.imageString = "tiles/laserVerti.png";
        }
        else{
            this.imageString = "tiles/laserHori.png";
        }
    }

    public String getImageString(){
        return imageString;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }
    public Position getPos(){
        return pos;
    }

    public void setDir(Direction dir) {
        this.Dir = dir;
    }

    public Direction getdir(){
        return this.Dir;
    }
    
    public void Uturn(){
        for (int i=0; i<2;i++){
            this.DirID +=1;
            setDir(Direction.getDirById(DirID));
            if (DirID > 4){
                this.DirID =1;
                setDir(Direction.UP); 
            }
        }
    }
    public Position getPosInDir(Direction dir){
        if (dir.getId() == 1){return new Position(this.pos.getColumn(), this.pos.getRow()-1);}
        else if (dir.getId() == 2){return new Position(this.pos.getColumn()+1, this.pos.getRow());}
        else if (dir.getId() == 3){return new Position(this.pos.getColumn(), this.pos.getRow()+1);}
        else if (dir.getId() == 4){return new Position(this.pos.getColumn()-1, this.pos.getRow());}
        else {return null;}
    }
    public boolean moveTillHit(BoardController boardController){
      
        for (int i = 0; i <=13;i++){
            try {
                Thread.sleep(100);
              } catch (Exception e) { System.err.println(e); }
            if (boardController.allowmove(this)){
                // move
                
                if (this.Dir.getId() == 1){pos.addY(-1);}
                else if (this.Dir.getId()  == 2){pos.addX(1);}
                else if (this.Dir.getId()  == 3){pos.addY(1);}
                else if (this.Dir.getId()  == 4){pos.addX(-1);}

                
                //Move other robot out of the way first, if there is one
                
                if (boardController.getBoard().getTileAt(getPos())!=null){
                   
                    boardController.notifyLaserObservers(this);
                   
                    if (boardController.getBoard().getTileAt(getPos()).isOcupied()){
                        
                        return true;
                    }
                }
                else{return false;} 
            }
            else{return false;}
        }
        
        return false;    
    }
}
