package dtu.logic.models.Robot;
import java.util.List;

import dtu.logic.models.Color;
import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Tile;
import dtu.logic.models.Cards.ProgramCard;

import java.util.ArrayList;

public class Robot {
    private Color color;

    private int damageTaken = 0;
    private int lives = 3;

    private Position pos = new Position(0,0);
    private Position checkpoint;

    private int DirID;

    public ArrayList<ProgramCard> register = new ArrayList<ProgramCard>(); 

    
    public Robot(Color color) {
        this.color = color;
        this.DirID = 1;
    }
    // Position and movement
    public void setPos(Position pos) {
        this.pos = pos;
    }
    public Position getPos() {
        return pos;
    }

    public void setCheckpoint(Position pos){
        this.checkpoint = pos;
    }
    public Position getCheckpoint(Position pos){
        return this.checkpoint;
    }

    public Direction getDirection(){
        return Direction.getDirById(this.DirID); 
    }

    public void turn(int intens){
        if (intens>0){
            for (int i = 0; i < intens;i++){
                this.DirID += 1;
                if (this.DirID > 4){
                    this.DirID = 1;
                }
            }
        }
        if (intens<0){
            for (int i = 0; i > intens;i--){
                this.DirID -= 1;
                if (this.DirID < 1){
                    this.DirID = 4;
                }
            }
        }
    }

    public void moveforward(Boolean forward){
        int d;
        if (forward){d = 1;}
        else {d = -1;}
        if (this.DirID == 1){pos.addX(-d);}
        if (this.DirID == 2){pos.addY(d);}
        if (this.DirID == 3){pos.addX(d);}
        if (this.DirID == 4){pos.addY(-d);}
        if (this.pos.getX() < 0 || this.pos.getX() > 13 ||
            this.pos.getY() < 0 || this.pos.getY()>10){Death();}
    }

    public void move(int round) {
        this.moveByCard(this.getProgramCardAt(round));
    }

    private void moveByCard(ProgramCard card) {
        
    }
    // Damage and live control
    public void Death(){
        this.pos = this.checkpoint;
        this.lives -=1;
        this.damageTaken = 0;
    }
    public void takeDmg(){
        this.damageTaken += 1;
        if (this.damageTaken >= 10){
          this.Death();
        }
    }
    public int getDamageTaken() {
        return damageTaken;
    }

    public void LoseLive() {
        this.lives -= 1;
    }
   
    public int getLives(){
        return this.lives;
    }
    
    //Register handeling
    public void addCardsToRegister(List<ProgramCard> cards) {
        for (ProgramCard c : cards) {
            this.register.add(c);
        }
    }

    public ProgramCard getProgramCardAt(int i) {
        return this.register.get
        (i);
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