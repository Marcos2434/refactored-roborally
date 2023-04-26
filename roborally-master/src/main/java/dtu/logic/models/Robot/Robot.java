package dtu.logic.models.Robot;
import java.util.List;

import dtu.logic.models.RobotColor;
import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Board.Tile;

import dtu.logic.models.Cards.ProgramCard;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class Robot {
    private RobotColor Robotcolor;
    private Image image;
    private int damageTaken = 0;
    private int lives = 3;
    private int checkpointCount = 0;
    
    private Position pos = new Position(0,0);
    private Position checkpoint;

    private int DirID;
    private ProgramCard LastMove = null;

    public List<ProgramCard> register = new ArrayList<ProgramCard>(5);
    
    private List<RobotObserver> observers = new ArrayList<RobotObserver>();

    public int getcheckpointCount(){
        return this.checkpointCount;
    }

    public void CheckpointReached(){
        this.checkpointCount +=1;
    }

    public void setLastMove(ProgramCard card){
        this.LastMove = card;
    }
    public ProgramCard getLastMove() {
        return this.LastMove;
    }
    
    public void robotNotify() {
        for (RobotObserver observer : observers) {
            observer.updateRobotInfo(this);
        }
    }
    public Image getImage(){
        return image;
    }
    
    public void registerObserver(RobotObserver observer) {
        observers.add(observer);
    }


    public Robot(RobotColor Robotcolor) {
        this.Robotcolor = Robotcolor;
        this.DirID = 1;
        this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.Robotcolor.getPictureFile()));  
    }

    public Robot(RobotColor Robotcolor,Position position) {
        this.Robotcolor = Robotcolor;
        this.DirID = 1;
        this.pos = position;
        this.checkpoint = new Position(position.getColumn(), position.getRow());
        this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.Robotcolor.getPictureFile()));  
    }



    // Position and movement
    public void setPos(Position pos) {
        this.pos = pos;
        robotNotify();
    }

    public Position getPos() {
        return pos;
    }

    public RobotColor getRobotColor() {
        return Robotcolor;
    }

    public int getX() {
        return pos.getColumn();
    }

    public int getY() {
        return pos.getRow();
    }

    public void setCheckpoint(Position pos){
        this.checkpoint = new Position(pos.getColumn(),pos.getRow());
    }
    public Position getCheckpoint(){
        return this.checkpoint;
    }


    public Direction getdir(){
        return Direction.getDirById(this.DirID); 
    }
    public void setDir(Direction dir){
        this.DirID = dir.getId();
    }


    public int getDirID(){return this.DirID;}


    public void turn(int intens, BoardController boardController){
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
        boardController.getBoard().getTileAt(pos).Occupy();
    }

    public Position getPosInDir(Direction dir){
        if (dir.getId() == 1){return new Position(this.pos.getColumn(), this.pos.getRow()-1);}
        else if (dir.getId() == 2){return new Position(this.pos.getColumn()+1, this.pos.getRow());}
        else if (dir.getId() == 3){return new Position(this.pos.getColumn(), this.pos.getRow()+1);}
        else if (dir.getId() == 4){return new Position(this.pos.getColumn()-1, this.pos.getRow());}
        else {return null;}
    }

    public void addCol(int intensity) {
        pos.addX(intensity);
        robotNotify();
    }    

    public void addRow(int intensity) {
        pos.addY(intensity);
        robotNotify();
    }    

    public void moveforward(Boolean forward, BoardController boardController){
        
        int d;
        Direction MoveDir;
        if (forward){MoveDir = getdir();
                        d = 1;}
        else {  turn(2,boardController);
                MoveDir = Direction.getDirById(getdir().getId());
                turn(2,boardController); 
                d = -1;}
        //Update old tile
        boardController.getBoard().getTileAt(pos).unOccupy();
       
        if (boardController.allowmove(this,MoveDir)){
            //Move other robot out of the way first, if there is one
            if (boardController.getBoard().getTileAt(getPosInDir(MoveDir))!=null){
                if (boardController.getBoard().getTileAt(getPosInDir(MoveDir)).isOcupied()){
                    Robot r = boardController.getRobotAt(getPosInDir(MoveDir));
                    Push(r,boardController);
                }
            }
           
            // move
            if (this.DirID == 1){this.addRow(-d);}
            else if (this.DirID == 2){this.addCol(d);}
            else if (this.DirID == 3){this.addRow(d);}
            else if (this.DirID == 4){this.addCol(-d);} 
        }
        
        
    }

    // Damage and live control
    public void Death(BoardController boardController){
        
        if (this.pos.getRow() > 0 && this.pos.getRow() < 13 &&
            this.pos.getColumn() > 0 && this.pos.getColumn()<10){
            boardController.getBoard().getTileAt(pos).unOccupy();
        } 
        this.pos = new Position(checkpoint.getColumn(),checkpoint.getRow());
        this.lives -=1;
        this.damageTaken = 0;
        boardController.getBoard().getTileAt(pos).Occupy();
    }
    public void takeDmg(BoardController boardController){
        this.damageTaken += 1;
        if (this.damageTaken >= 10){
          this.Death(boardController);
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
    public void Push(Robot robot, BoardController boardController){

        boardController.getBoard().getTileAt(robot.getPos()).unOccupy();
        
        if (boardController.getBoard().getTileAt(robot.getPosInDir(Direction.getDirById(this.DirID))).isOcupied()){
            Push(boardController.getRobotAt(robot.getPosInDir(Direction.getDirById(this.DirID))),boardController);}

        if (this.DirID == 1){robot.getPos().addY(-1);}
        else if (this.DirID == 2){robot.getPos().addX(1);}
        else if (this.DirID == 3){robot.getPos().addY(1);}
        else if (this.DirID == 4){robot.getPos().addX(-1);}
        
        if (robot.pos.getRow() < 0 || robot.pos.getRow() > 13 ||
            robot.pos.getColumn() < 0 || robot.pos.getColumn()>10){Death(boardController);}
        

        boardController.getBoard().getTileAt(robot.getPos()).Occupy();  
    } 
    
    public void FIRE(BoardController boardController){
        
        Lazer lazer = new Lazer(new Position(pos.getColumn(), pos.getRow()),this.getdir());
        if (lazer.moveTillHit(boardController) == true){
            
            Robot hitRob = boardController.getRobotAt(lazer.getPos());
            
            hitRob.takeDmg(boardController);
        }
    }
    public void AddToRegister(ProgramCard card){
        if (register.size() <5){
            register.add(card);
            System.out.println("Card added to register");
        }
        else{System.out.println("Register is full,insert is not possible");}
    }
    //Register handeling
    public void setRegister(List<ProgramCard> cards) {
        this.register = new ArrayList<ProgramCard>();
        if ((cards.size() <= 5)){
            for (int i=0; i<cards.size(); i++){
                this.register.add(cards.get(i));
            }
        }
        else{System.out.println("Too many cards!!!!!!!!!");}
    }


    public List<ProgramCard> getRegister() {
        return this.register;
    }

    public void setPos(int x, int y){
        pos.set(x, y);
    }

    public void setX(int x){
        pos.setColumn(x);
    }

    public void setY(int y){
        pos.setRow(y);
    }

    @Override
    public String toString() {
        return this.Robotcolor.toString();
    }

    public void moveByCard(BoardController boardController, ProgramCard card){
        
        card.effect(this, boardController);
        this.LastMove = card;

    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Robot) {
            Robot r = (Robot) obj;
            if (r.getRobotColor() == this.getRobotColor()) return true;
        }
        return false;
    }
}   