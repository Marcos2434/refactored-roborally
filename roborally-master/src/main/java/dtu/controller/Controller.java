package dtu.controller;

import dtu.logic.models.Board.*;
import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Color;
import dtu.logic.models.Position;

public class Controller {

    Player p;

    public void launch() {
        // Initialisation 

        // Create board
        // Board b = new Board(null);
        
    }

    public void createPlayer(String color) {
        this.p = new Player(new Robot(Color.BLUE,new Position(2,2)),"Casper");
    }

    public Player getP() {
        return p;
    }

}
