package dtu.logic.models.Robot;

import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;

public class MoveableObj {
    private Position pos;
    private Direction Dir;
    
    public MoveableObj(Position pos, Direction dir){
        this.pos=pos;
        this.Dir=dir;
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
    
    public Direction getDir(){
        return this.Dir;
    }

    public Position getPosAhead(){
        if (this.Dir == Direction.UP){return new Position(this.pos.getColumn()-1, this.pos.getRow());}
        else if (this.Dir == Direction.RIGHT){return new Position(this.pos.getColumn(), this.pos.getRow()+1);}
        else if (this.Dir == Direction.DOWN){return new Position(this.pos.getColumn()+1, this.pos.getRow());}
        else if (this.Dir == Direction.LEFT){return new Position(this.pos.getColumn(), this.pos.getRow()-1);}
        else {return null;}
    }

    public void turn(int intens, Board board){
        if (intens>0){
            for (int i = 0; i < intens;i++){
                this.Dir = Direction.getDirById(this.Dir.getId()+1);
                if (this.Dir.getId() > 4){
                    this.Dir = Direction.UP;
                }
            }
        }
        if (intens<0){
            for (int i = 0; i > intens;i--){
                this.Dir = Direction.getDirById(this.Dir.getId()-1);
                if (this.Dir.getId() < 1){
                    this.Dir = Direction.LEFT;
                }
            }
        }
        
    }
}
