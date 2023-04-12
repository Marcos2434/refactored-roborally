package dtu.controller;

import dtu.logic.models.Board.*;
import dtu.logic.models.Player.*;
import dtu.logic.models.Color;

public class Controller {

    Player p;

    public void launch() {
        // Initialisation 

        // Create board
        // Board b = new Board(null);

        // Create players
        // Create cards
        // Create game
    }

    public void createPlayer(String color) {
        this.p = new Player(Color.RED);
    }

    public Player getP() {
        return p;
    }

}
