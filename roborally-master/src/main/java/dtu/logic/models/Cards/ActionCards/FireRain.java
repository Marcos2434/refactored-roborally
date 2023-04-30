package dtu.logic.models.Cards.ActionCards;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;

//Implementation of ActionCard FireRain 
public class FireRain implements ActionCard {

    private String image = "Cards/fireRain.png";
    private String name = "FireRain";
    private String Description = "You have stepped upon the storm gods sacred tile, they are punnishing everyone with a storm of fire!! All robots take 1 damage.";
    @Override
    public String getImage(){
        return this.image;
    }
    //Each robot takes 1 damage when this card appears
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
