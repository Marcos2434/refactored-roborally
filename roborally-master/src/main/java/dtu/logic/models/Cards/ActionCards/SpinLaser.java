package dtu.logic.models.Cards.ActionCards;

import java.util.ArrayList;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;

//Implementation of ActionCard SpinLaser
public class SpinLaser implements ActionCard{
    private String image = "Cards/spinLaser.png";
    private String Description = "You are infused with the power of the bayblades, your robot spins uncontrollably, shooting its laser in all directions";
    private String Name = "Baybladre Shooter";

    @Override
    public String getImage(){
        return this.image;
    }
    
    public void action(Robot robot, BoardController boardController){
        for (int i = 0; i < 4; i++) {
            try{robot.turn(1, boardController);}
            catch(Exception e){System.out.println(e);}
           
            try{
              //  Thread.sleep(600);
            }
            catch(Exception e){
                System.out.println(e);}
                
            robot.FIRE(boardController);
        }
     }

    public String getName(){
        return Name;
    }

    public String getDescription(){
        return Description;
    }
    
}