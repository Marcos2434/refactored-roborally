package dtu.logic.models.Observers;
import dtu.logic.models.Robot.Robot;

public interface RobotObserver {
    /*Interface for all observers of the robot*/
    
    public void updateRobotInfo(Robot robot);
    public void updateRegister(Robot robot);
    public void updateRobotDamageSound(Robot robot);
}

