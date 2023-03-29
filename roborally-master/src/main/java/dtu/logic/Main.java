package dtu.logic;
import dtu.logic.models.*;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Player.Player;

import java.util.ArrayList;

// string input
import java.util.*;

//javac Main.java; java Main.java

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n---- Game Start ----\n\n");
        
        // -----------------------------------------------------
        // Setup
        // -----------------------------------------------------

        // ------------------------------
        // Create players
        // ------------------------------
		ArrayList<Player> players = new ArrayList<Player>();;
        // TODO: Get input from user for amount of players
		int playerCount = 2;

		// Change with enum
		ArrayList<Color> availableColours = new ArrayList<>();
        availableColours.add(Color.RED);
        availableColours.add(Color.BLUE);
        availableColours.add(Color.GREEN);
        availableColours.add(Color.YELLOW);
        availableColours.add(Color.ORANGE);
        availableColours.add(Color.PURPLE);
        availableColours.add(Color.WHITE);
        availableColours.add(Color.BLACK);

		for (int i = 1; i <= playerCount; i++) {
			// Get colour input from user
            Color colorInput = null;
            while (colorInput == null) {
                try {
                    System.out.println("\nAvailable colors: ");
                    for (int j = 0; j < availableColours.size(); j++) {
                        System.out.println(availableColours.get(j));
                    }
                    System.out.println();
                    
                    System.out.println("What color do you want your robot to be?");  
                    System.out.print("Please choose one of the available colors\n> ");  
                    String colorInput_read = sc.nextLine();

                    colorInput = Color.valueOf(colorInput_read.toUpperCase());
                    
                    // Check that the color was available
                    boolean found = false;
                    for (int j = 0; j < availableColours.size(); j++) {
                        if (colorInput == availableColours.get(j)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        throw new IllegalArgumentException("Color was not available");
                    }
                } catch (IllegalArgumentException error) {
                    System.out.println("Invalid color!\n");
                    colorInput = null;
                }
            }
			// remove from available colors
			availableColours.remove(colorInput);
			players.add(new Player(colorInput));
		}

        for (Player p : players) {
            System.out.println(p);
        }

        // ------------------------------

        // ------------------------------
        // Create board
        String[][] board1 = {   
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "},
            {"T","T","HT","T","T","T","T","T"," "," "}
        };
        
        Board board = new Board(board1);
        // ------------------------------

        // -----------------------------------------------------
        // Game loop
        // (Two stages)
        // -----------------------------------------------------
        // ------------------------------
        // 1st stage : Programming stage
        // ------------------------------
        
        // Draw programming cards
        for (Player p : players) {
            p.drawProgrammingCards();
        }

        // Each player chooses their programming cards, within that method, 
        // the cards are added to the register
        for (Player p : players) {
            p.chooseProgrammingCards();
        }

        // ------------------------------
        
        // ------------------------------
        // 2nd stage : Execution stage
        // (Divided into 4 parts)
        // ------------------------------

        for (int round = 0; round < 5; round++) {
            // 2.1 : Move
            for (int i = 0; i < players.size(); i++) {
                System.out.println(players.get(i).getRobot().getProgramCardAt(round));
                players.get(i).getRobot().move(round);
            }

            // 2.2 : Table movements; gears, pits... etc.
            // for (Player p : players) {
            //     int xPos = p.getRobot().getPos().getX();
            //     int yPos =  p.getRobot().getPos().getY();
            //     Tile tile = board.getTileAt(xPos, yPos);
            // }

            // 2.3 : Lasers fire
            // 2.4 : Checkpoints   
        }
        // ------------------------------


        System.out.println("\n\n---- Game End ----\n\n");
    }
}

