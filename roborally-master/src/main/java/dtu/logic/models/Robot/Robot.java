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
import java.util.LinkedHashSet;

public class Robot {
    private RobotColor Robotcolor;
    private Image image;
    private int damageTaken = 0;
    private int lives = 3;
    private int checkpointCount = 0;
    private Position pos = new Position(0, 0);
    private ArrayList<Position> checkpoints = new ArrayList<Position>();
    private int DirID;
    private ProgramCard LastMove = null;
    private Position prevPos;
    private List<ProgramCard> register = new ArrayList<ProgramCard>(5);
    private LinkedHashSet<RobotObserver> observers = new LinkedHashSet<RobotObserver>();

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

    public void CheckpointReached(){
        this.checkpointCount +=1;
    }

    public void heal(){
        if (this.getDamageTaken() > 0){
            this.damageTaken -=1;
            
        }
        robotNotify();
    }

    public void setLastMove(ProgramCard card){
        this.LastMove = card;
    }
    
    
    public void robotNotify() {
        for (RobotObserver observer : observers) {
            observer.updateRobotInfo(this);
        }
    }

    public void robotDamageNotify() {
        for (RobotObserver observer : observers) {
            observer.updateRobotDamageSound(this);
        }
    }

    public void registerNotify(){
        for (RobotObserver observer : observers){
            observer.updateRegister(this);
        }
    }

    public void registerObserver(RobotObserver observer) {
        observers.add(observer);
    }

    public void setPos(Position pos) {
        this.pos = pos;
        // We notify the observers of the updated position
        robotNotify();
    }
    
    public void setPos(int x, int y) {
        pos.set(x, y);
        // We notify the observers of the updated position
        robotNotify();
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
                    Robot r = boardController.getRobotAt(getPosInDir(MoveDir));
                    Push(r,MoveDir,boardController);
                    
                }
            }
            if (this.DirID == 1){this.addRow(-d);}
            else if (this.DirID == 2){this.addCol(d);}
            else if (this.DirID == 3){this.addRow(d);}
            else if (this.DirID == 4){this.addCol(-d);} 
        }
        robotNotify();
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
        LoseLive();
    
        this.damageTaken = 0;
        boardController.getBoard().getTileAt(pos).Occupy();
        robotNotify();
        try{
            Thread.sleep(200);
        }catch(Exception e){System.out.println(e);}

        if (this.getLives() <=0){
            this.setPrevPos(getPos());
            boardController.getBoard().getTileAt(pos).unOccupy();
            this.getRegister().clear();
            robotNotify();
            try{
                Thread.sleep(200);
            }catch(Exception e){System.out.println(e);}
        }
        
    }

    public void takeDmg(BoardController boardController){
        this.damageTaken += 1;
        robotDamageNotify();
        if (this.damageTaken >= 10){
          this.Death(boardController);
        }
        
        robotNotify();
    }

    // interaction with other robots
    public void Push(Robot robot,Direction dir, BoardController boardController){
        robot.setPrevPos(robot.getPos());

        
        if (robot.getPosInDir(Direction.getDirById(dir.getId())).isOutOfBounds()){robot.Death(boardController);}

        else{
            if (boardController.getBoard().getTileAt(robot.getPosInDir(Direction.getDirById(dir.getId()))).isOcupied()){
                Push(boardController.getRobotAt(robot.getPosInDir(Direction.getDirById(dir.getId()))),dir,boardController);}
            
            if (dir.getId() == 1){robot.getPos().addY(-1);}
            else if (dir.getId() == 2){robot.getPos().addX(1);}
            else if (dir.getId() == 3){robot.getPos().addY(1);}
            else if (dir.getId() == 4){robot.getPos().addX(-1);}
        }
        robot.robotNotify();
        try{
            Thread.sleep(20);
        }catch(Exception e){System.err.println(e);}
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
        registerNotify();
    }

    //Register handeling
    public void setRegister(List<ProgramCard> cards) {
        this.register = new ArrayList<ProgramCard>();
        if ((cards.size() <= 5)){
            for (int i=0; i<cards.size(); i++){
                this.register.add(cards.get(i));
            }
            if (cards.size() != 0){
                registerNotify();
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Robot) {
            Robot r = (Robot) obj;
            if (r.getRobotColor() == this.getRobotColor()) return true;
        }
        return false;
    }

    public void moveByCard(BoardController boardController, ProgramCard card){
        card.effect(this,boardController);
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

    public void setDamageTaken(int damage){
        this.damageTaken = damage;
    }
    @Override
    public String toString() {
        return this.Robotcolor.toString();
    }

    public int getCheckpointCount(){
        return this.checkpointCount;
    }

    public Position getPrevPos() {
        return prevPos;
    }

    public ProgramCard getLastMove() {
            return this.LastMove;
    }

    public Image getImage(){
            return image;
        }

    public Position getPos() {
            return pos;
    }

    public RobotColor getRobotColor() {
        return Robotcolor;
    }

    public int getDirID(){return this.DirID;}

    public List<ProgramCard> getRegister() {
        return this.register;
    }
    
    public int getRegisterSize(){
        return this.register.size();
    }
}   

