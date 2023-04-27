package dtu.view.drawers;

import dtu.logic.models.Position;
import dtu.logic.models.Rotation;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Robot.Robot;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class BoardDrawer extends GridPane {

    public void draw(Board b) {
        for (int row = 0; row < 13; row++) {
            for (int col = 0; col < 10; col++) {
                StackPane stackPane = new StackPane();
                stackPane.getChildren().add(b.getGrid()[row][col]);
                add(stackPane, col, row);
            }
        }
    }

    public void drawRobot(Robot robot) {
        System.out.println("Drawing Robot at " + robot.getPos().getRow() + ", " + robot.getPos().getColumn());
        
        StackPane stackPane = (StackPane) this.getChildren().get(robot.getPos().getRow() * 10 + robot.getPos().getColumn());
        
        if (robot.getPrevPos() != null) {
            this.unDrawRobot(robot.getPrevPos());
        }

        ImageView iv = new ImageView(robot.getImage());
        iv.setRotate(90*(robot.getDirID() - 1));
        stackPane.getChildren().add(iv);
        System.out.println("Finished drawing robot");
    }
    
    public void unDrawRobot(Position pos) {
        StackPane stackPane = (StackPane) this.getChildren().get(pos.getRow() * 10 + pos.getColumn());
        stackPane.getChildren().removeIf(node -> node instanceof ImageView);
    }

}
