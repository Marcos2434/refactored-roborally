package dtu.logic.models.Robot;
import java.util.List;

import dtu.logic.models.Color;
import dtu.logic.models.Position;
import dtu.logic.models.Cards.ProgramCard;

import java.util.ArrayList;

public class Robot {
    private Color color;

    private int damageTaken = 0;
    private int lives = 3;

    public Position pos = new Position(0,0);

    private ArrayList<ProgramCard> register = new ArrayList<ProgramCard>(); 

    public Robot(Color color) {
        this.color = color;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void addCardsToRegister(List<ProgramCard> cards) {
        for (ProgramCard c : cards) {
            this.register.add(c);
        }
    }

    public ProgramCard getProgramCardAt(int i) {
        return this.register.get
        (i);
    }

    public void move(int round) {
        this.moveByCard(this.getProgramCardAt(round));
    }

    private void moveByCard(ProgramCard card) {
        
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x, int y){
        pos.set(x, y);
    }

    public void setX(int x){
        pos.setX(x);
    }

    public void setY(int y){
        pos.setY(y);
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}