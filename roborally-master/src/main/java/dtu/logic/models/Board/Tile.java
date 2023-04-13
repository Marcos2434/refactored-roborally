package dtu.logic.models.Board;

import dtu.logic.models.Robot.Robot;

public class Tile {
    private String name = "T";
    private Boolean Ocupied = false;
    // effect method for tiles, this normal tile does nothing()
    public void effect(Robot robot){
    ;
    }

    public String getname(){
        return this.name;
    }

    public void Occupy(){
        this.Ocupied = true;
    }

    public void unOccupy(){
        this.Ocupied = false;
    }

    public boolean isOcupied(){
        return this.Ocupied;
    }
}
