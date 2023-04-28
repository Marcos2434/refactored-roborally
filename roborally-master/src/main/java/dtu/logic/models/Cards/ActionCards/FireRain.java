package dtu.logic.models.Cards.ActionCards;


import java.util.ArrayList;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;

public class FireRain implements ActionCard{

    private String image = "";
    
    @Override
    public String getImage(){
        return this.image;
    }
    
    public void action(Robot robot, BoardController boardController){
        ArrayList<Player> players = boardController.getPlayers();
        for (Player player : players) {
           player.getRobot().takeDmg(boardController);
        }
        
        
    }
    
}
