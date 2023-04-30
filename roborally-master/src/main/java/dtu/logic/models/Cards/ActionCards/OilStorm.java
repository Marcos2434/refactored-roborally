package dtu.logic.models.Cards.ActionCards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;


//Implementation of ActionCard OilStorm
public class OilStorm implements ActionCard{

    private String image = "Cards/OilStorm.png";
    private String name = "OilRain";
    private String Description = "A huge oil tanker not to far of the shore of your battle has tipped over, the huge barrels of oil are slung into the shore with such force that oil sprays upon the boardgame, to the pleassure of the robots. All robots heal for one damage";
    @Override
    public String getImage(){
        return this.image;
    }
    //Each robot heals 1 damage when this card appears
    public void action(Robot robot, BoardController boardController){
        
        for (Player player : boardController.getPlayers()) {
           player.getRobot().heal();
        }
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return Description;
    }
    
}
