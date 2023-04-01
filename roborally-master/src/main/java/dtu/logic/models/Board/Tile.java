package dtu.logic.models.Board;

import dtu.logic.models.Robot.Robot;

public class Tile {
    private String name = "T";
   
    // effect method for tiles, this normal tile does nothing()
    public void effect(Robot robot){
    System.out.println("Tile effect");
    }

    public String getname(){
        System.out.println("Tile name");
        return this.name;
    }

}
