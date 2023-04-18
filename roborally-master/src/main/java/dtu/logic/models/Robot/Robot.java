package dtu.logic.models.Robot;
import java.util.List;

import dtu.logic.models.Color;
import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.Tile;
import dtu.logic.models.Cards.ProgramCard;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class Robot {
    private Color color;
    private Image image;
    private int damageTaken = 0;
    private int lives = 3;

    private Position pos = new Position(0,0);
    private Position checkpoint;

    private int DirID;

    public ArrayList<ProgramCard> register = new ArrayList<ProgramCard>(); 
    private List<RobotObserver> observers = new ArrayList<RobotObserver>();

    public void notify(Position pos) {
        for (RobotObserver observer : observers) {
            observer.updateCoords(pos);
        }
    }

    public void registerObserver(RobotObserver observer) {
        observers.add(observer);
    }
    
    public Robot(Color color,Position position) {
        this.color = color;
        this.DirID = 1;
        this.pos = position;
        this.checkpoint = position;
        this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.color.getPictureFile()));  
    }
    public Robot(Color color,Position position, Board board) {
        this.color = color;
        this.DirID = 1;
        this.pos = position;
        this.checkpoint = position;
        this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.color.getPictureFile()));
        board.getTileAt(pos).Occupy(image, DirID);    
    }
    // Position and movement
    public void setPos(Position pos) {
        this.pos = pos;
        notify(pos);
    }
    public Position getPos() {
        return(pos);
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return pos.getX();
    }

    public int getY() {
        return pos.getY();
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
    public void setDir(Direction dir){
        this.DirID = dir.getId();
    }


    public int getDirID(){return this.DirID;}


    public void turn(int intens, Board board){
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
        //update tile
        board.getTileAt(pos).Occupy(image, DirID);
    }

    public Position getPosAhead(){
        if (this.DirID == 1){return new Position(this.pos.getX(), this.pos.getY()-1);}
        else if (this.DirID == 2){return new Position(this.pos.getX()+1, this.pos.getY());}
        else if (this.DirID == 3){return new Position(this.pos.getX(), this.pos.getY()+1);}
        else if (this.DirID == 4){return new Position(this.pos.getX()-1, this.pos.getY());}
        else {return null;}
    }

    public void moveforward(Boolean forward,Board board){
        int d;
        if (forward){d = 1;}
        else {d = -1;}
        //Update old tile
        board.getTileAt(pos).unOccupy();

        if (board.allowmove(this)){
            //Move other robot out of the way first, if there is one
            if (board.getTileAt(getPosAhead())!=null){
                if (board.getTileAt(getPosAhead()).isOcupied()){
                    Robot r = board.getRobotAt(getPosAhead());
                    Push(r,board);
                }
            }
            // move
            if (this.DirID == 1){pos.addY(-d);}
            else if (this.DirID == 2){pos.addX(d);}
            else if (this.DirID == 3){pos.addY(d);}
            else if (this.DirID == 4){pos.addX(-d);} 
        }
        // check if over the edge
        if (this.pos.getY() < 0 || this.pos.getY() > 13 ||
            this.pos.getX() < 0 || this.pos.getX()>10){Death();}
            
        //update new tile
        board.getTileAt(pos).Occupy(image, DirID);
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
    // interaction with other robots
    public void Push(Robot robot,Board board){
        board.getTileAt(robot.getPos()).unOccupy();

        if (this.DirID == 1){robot.getPos().addY(-1);}
        else if (this.DirID == 2){robot.getPos().addX(1);}
        else if (this.DirID == 3){robot.getPos().addY(1);}
        else if (this.DirID == 4){robot.getPos().addX(-1);}
        
        if (robot.pos.getY() < 0 || robot.pos.getY() > 13 ||
            robot.pos.getX() < 0 || robot.pos.getX()>10){Death();}
        else{robot.takeDmg();}

        board.getTileAt(robot.getPos()).Occupy(image, DirID);  
    } 
    
    public void FIRE(Board board){
        
        Lazer lazer = new Lazer(new Position(pos.getX(), pos.getY()),this.getDirection());
        if (lazer.moveTillHit(board) == true){
            
            Robot hitRob = board.getRobotAt(lazer.getPos());
            
            hitRob.takeDmg();
        }
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