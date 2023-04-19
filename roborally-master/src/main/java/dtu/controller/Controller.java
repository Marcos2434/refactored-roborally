package dtu.controller;

import dtu.logic.models.Board.*;
import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Color;
import dtu.logic.models.Position;

import dtu.view.MenuScene;

public class Controller {

    Player p;
    MenuScene menuScene;

    public void launch() {
        // Initialisation 

        // Create board
        // Board b = new Board(null);

        
        
    }

    public void createPlayer(Color color,String name) {
        this.p = new Player(new Robot(Color.BLUE,new Position(2,2)),name);
        System.out.println(name+" has chosen color "+color);
    }

    public Player getP() {
        return p;
    }

    public void setMenuScene(MenuScene s) {
        this.menuScene = s;
    }

    public MenuScene getMenuScene() {
        return menuScene;
    }

}
