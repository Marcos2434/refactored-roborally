package dtu.controller;

import dtu.logic.models.Board.*;
import dtu.logic.models.Player.*;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Color;
import dtu.logic.models.Position;
import javafx.stage.Stage;

import dtu.view.MenuScene;
import javafx.scene.Scene;

public class Controller {

    private Player p;
    

    // --- Scenes ---
    private MenuScene menuScene;
    // --------------
    private Stage primaryStage;


    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void launch() {
        this.setTheScene(this.getMenuScene(), "Roborally - Main Menu");
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

    public void setTheScene(Scene s) {
        this.primaryStage.setScene(s);
        primaryStage.setTitle("Roborally - v. 0.1");
        this.primaryStage.show();
    }

    public void setTheScene(Scene s, String title) {
        this.primaryStage.setScene(s);
        primaryStage.setTitle(title);
        this.primaryStage.show();
    }

}
