package dtu.logic.models.Cards.ActionCards;

import java.util.ArrayList;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;

public class SpinLaser implements ActionCard{
    private String image = "";
    
    @Override
    public String getImage(){
        return this.image;
    }
    
    public void action(Robot robot, BoardController boardController){
        for (int i = 0; i < 5; i++) {
            robot.turn(1, boardController);
            robot.FIRE(boardController);
        }
        }
    }