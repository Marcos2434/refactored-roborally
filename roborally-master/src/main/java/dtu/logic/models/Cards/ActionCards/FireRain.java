package dtu.logic.models.Cards.ActionCards;


import java.util.ArrayList;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;

public class FireRain implements ActionCard {

    private String image = "";
    private String name = "FireRain";
    private String Description = "You have stepped upon the storm gods sacred tile, they are punnishing everyone with a storm of fire!! All robots take 1 damage.";
    @Override
    public String getImage(){
        return this.image;
    }
    
    public void action(Robot robot, BoardController boardController){
        for (Player player : boardController.getPlayers()) {
           player.getRobot().takeDmg(boardController);
        }   
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return Description;
    }
    
}
