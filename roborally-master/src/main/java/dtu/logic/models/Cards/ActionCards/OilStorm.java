package dtu.logic.models.Cards.ActionCards;

import java.util.ArrayList;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;

public class OilStorm implements ActionCard{

    private String image = "";
    private String name = "OilRain";
    private String Description = "A huge oil tanker not to far of the shore of your battle has tipped over, the huge barrels of oil are slung into the shore with such force that oil sprays upon the boardgame, to the pleassure of the robots. All robots heal for one damage";
    @Override
    public String getImage(){
        return this.image;
    }
    
    public void action(Robot robot, BoardController boardController){
        ArrayList<Player> players = boardController.getPlayers();
        for (Player player : players) {
           //player.getRobot()
        }
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return Description;
    }
    
}
