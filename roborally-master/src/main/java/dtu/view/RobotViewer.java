package dtu.view;

import dtu.logic.models.Position;
import dtu.logic.models.Robot.RobotObserver;

public class RobotViewer implements RobotObserver {
    public void updateCoords(Position pos) {
        // Move picture
        System.out.println("Robot moved to: " + pos);
    }
}
