package dtu.logic.models.Robot;
import java.util.List;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Direction;
import dtu.logic.models.Position;
import dtu.logic.models.Board.BoardController;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Observers.RobotObserver;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Robot {
    private RobotColor Robotcolor;
    private Image image;
    private int damageTaken = 0;
    private int lives = 3;
    private int checkpointCount = 0;
    
    private Position pos = new Position(0,0);
    private ArrayList<Position> checkpoints = new ArrayList<Position>();

    private int DirID;
    private ProgramCard LastMove = null;

    private Position prevPos;

    public List<ProgramCard> register = new ArrayList<ProgramCard>(5);
    
    // TODO: hashset?
    private List<RobotObserver> observers = new ArrayList<RobotObserver>();

    public int getcheckpointCount(){
        return this.checkpointCount;
    }

    public Position getPrevPos() {
        return prevPos;
    }

    public void CheckpointReached(){
        this.checkpointCount +=1;
    }

    public void heal(){
        if (this.getDamageTaken() > 0){
            this.damageTaken -=1;
            
        }
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
        this.checkpoints.add(new Position(position.getColumn(), position.getRow()));
        this.image = new Image(getClass().getClassLoader().getResourceAsStream(this.Robotcolor.getPictureFile()));  
    }

    // Position and movement
    public void setPos(Position pos) {
        this.pos = pos;
        robotNotify();
    }
    
    public void setPos(int x, int y) {
        pos.set(x, y);
        robotNotify();
    }

    public Position getPos() {
        return pos;
    }

    public RobotColor getRobotColor() {
        return Robotcolor;
    }

    public void addCheckpoint(Position pos){
        this.checkpoints.add(new Position(pos.getColumn(),pos.getRow()));
    }
    public ArrayList<Position> getCheckpoints(){
        return this.checkpoints;
    }


    public Direction getdir(){
        return Direction.getDirById(this.DirID); 
    }
    public void setDir(Direction dir){
        this.DirID = dir.getId();
    }


    public int getDirID(){return this.DirID;}


    public void turn(int intens, BoardController boardController){
        this.prevPos = this.pos;

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
        robotNotify();
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
        
        this.prevPos = new Position(pos.getColumn(),pos.getRow());

        int d;
        Direction MoveDir;
        boolean shouldpush = false;
        Robot r = null;
        if (forward) {
            MoveDir = getdir();
            d = 1;
        } else {  
            
            MoveDir = getdir().opposite();
            d = -1;
        }

        //Update old tile
        boardController.getBoard().getTileAt(pos).unOccupy();
       
        if (boardController.allowmove(this,MoveDir)){

            
            //Move other robot out of the way first, if there is one
            if (boardController.getBoard().getTileAt(getPosInDir(MoveDir))!=null){
                if (boardController.getBoard().getTileAt(getPosInDir(MoveDir)).isOcupied()){
                    r = boardController.getRobotAt(getPosInDir(MoveDir));
                    shouldpush = true;
                    
                }
            }
            if (this.DirID == 1){this.addRow(-d);}
            else if (this.DirID == 2){this.addCol(d);}
            else if (this.DirID == 3){this.addRow(d);}
            else if (this.DirID == 4){this.addCol(-d);} 
            
            
            if (shouldpush){
                Push(r,boardController);
            }
            
        }
        
        
    }

    // Damage and live control
    public void Death(BoardController boardController){
        
        if (this.pos.getRow() >= 0 && this.pos.getRow() < 13 &&
            this.pos.getColumn() >= 0 && this.pos.getColumn()<10){
            boardController.getBoard().getTileAt(pos).unOccupy();
            this.prevPos = new Position(pos.getColumn(),pos.getRow());
        } 
        Collections.reverse(this.checkpoints);
        for (int i = 0; i <checkpoints.size(); i++){
            

            if (i == checkpoints.size() - 1){
                if (boardController.getBoard().getTileAt(checkpoints.get(i)).isOcupied()){
                    boardController.getRobotAt(checkpoints.get(i)).Death(boardController);
                }
                this.pos = new Position (checkpoints.get(i).getColumn(),checkpoints.get(i).getRow());
                break;
            }
            
            else if (!boardController.getBoard().getTileAt(checkpoints.get(i)).isOcupied()){
                this.pos = new Position (checkpoints.get(i).getColumn(),checkpoints.get(i).getRow());
                break;
            }
            
            
        }
        Collections.reverse(this.checkpoints);
        this.lives -=1;
        this.damageTaken = 0;
        boardController.getBoard().getTileAt(pos).Occupy();
        robotNotify();
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

    public void setPrevPos(Position pos){
        this.prevPos = new Position(pos.getColumn(),pos.getRow());
    }
    // interaction with other robots
    public void Push(Robot robot, BoardController boardController){
        robot.setPrevPos(robot.getPos());
        

        if (robot.getPosInDir(Direction.getDirById(this.DirID)).isOutOfBounds()){robot.Death(boardController);}

        else{
            if (boardController.getBoard().getTileAt(robot.getPosInDir(Direction.getDirById(this.DirID))).isOcupied()){
                Push(boardController.getRobotAt(robot.getPosInDir(Direction.getDirById(this.DirID))),boardController);}
            
            if (this.DirID == 1){robot.getPos().addY(-1);}
            else if (this.DirID == 2){robot.getPos().addX(1);}
            else if (this.DirID == 3){robot.getPos().addY(1);}
            else if (this.DirID == 4){robot.getPos().addX(-1);}
        }
        robot.robotNotify();
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
        }

    }
    //Register handeling
    public void setRegister(List<ProgramCard> cards) {
        this.register = new ArrayList<ProgramCard>();
        if ((cards.size() <= 5)){
            for (int i=0; i<cards.size(); i++){
                this.register.add(cards.get(i));
            }
        }
        else{;}
    }


    public List<ProgramCard> getRegister() {
        return this.register;
    }

    // public void setPos(int x, int y){
    //     pos.set(x, y);
    // }

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
        
    card.effect(this,boardController);
    

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

