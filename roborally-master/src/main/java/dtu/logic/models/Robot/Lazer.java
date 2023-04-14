package dtu.logic.models.Robot;

import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;

public class Lazer {
    private Position pos;
    private Direction Dir;

    public Lazer(Position pos, Direction dir){
        this.pos = pos;
        this.Dir = dir;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }
    public Position getPos(){
        return pos;
    }

    public void setDir(Position pos) {
        this.pos = pos;
    }

    public Direction getDir(){
        return this.Dir;
    }
    public Position getPosAhead(){
        if (this.Dir == Direction.UP){return new Position(this.pos.getX()-1, this.pos.getY());}
        else if (this.Dir == Direction.RIGHT){return new Position(this.pos.getX(), this.pos.getY()+1);}
        else if (this.Dir == Direction.DOWN){return new Position(this.pos.getX()+1, this.pos.getY());}
        else if (this.Dir == Direction.LEFT){return new Position(this.pos.getX(), this.pos.getY()-1);}
        else {return null;}
    }
    public boolean moveTillHit(Board board){
        for (int i = 0; i <=13;i++){

            if (board.allowmove(this)){
                // move
                if (this.Dir.getId() == 1){pos.addX(-1);}
                else if (this.Dir.getId()  == 2){pos.addY(1);}
                else if (this.Dir.getId()  == 3){pos.addX(1);}
                else if (this.Dir.getId()  == 4){pos.addY(-1);}
                //Move other robot out of the way first, if there is one
                
                if (board.getTileAt(getPos())!=null){
                    if (board.getTileAt(getPos()).isOcupied()){
                        return true;
                    }
                    else{;}
                }
                else{return false;} 
            }
            else{return false;}
        }
        return false;    
    }
}
