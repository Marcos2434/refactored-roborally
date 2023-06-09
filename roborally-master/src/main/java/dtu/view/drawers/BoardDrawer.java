package dtu.view.drawers;

import dtu.logic.models.Position;

import dtu.logic.models.Board.Board;
import dtu.logic.models.Robot.Lazer;
import dtu.logic.models.Robot.Robot;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class BoardDrawer extends GridPane {

    private Board b;

    public BoardDrawer(Board b) {
        this.b = b;
    }

    public void draw() {
        for (int row = 0; row < 13; row++) {
            for (int col = 0; col < 10; col++) {
                StackPane stackPane = new StackPane();
                stackPane.getChildren().add(b.getGrid()[row][col]);
                add(stackPane, col, row);
                drawTileAt(new Position(col, row), b.getTileAt(new Position(col, row)).getImage());
            }
        }
    }

    public void drawRobot(Robot robot) {
        StackPane stackPane = (StackPane) this.getChildren().get(robot.getPos().getRow() * 10 + robot.getPos().getColumn());

    

        if (robot.getPrevPos() != null && !robot.getPrevPos().isOutOfBounds()) {
            this.unDrawRobot(robot.getPrevPos());
            drawTileAt(robot.getPrevPos(), b.getTileAt(robot.getPrevPos()).getImage());
        }
        if (robot.getLives() > 0){
            if (!robot.getPos().isOutOfBounds()){
            ImageView iv = new ImageView(robot.getImage());
            iv.setRotate(90*(robot.getDirID() - 1));
            stackPane.getChildren().add(iv);
            }
        }
    }
    
    public void unDrawRobot(Position pos) {
        StackPane stackPane = (StackPane) this.getChildren().get(pos.getRow() * 10 + pos.getColumn());
        stackPane.getChildren().removeIf(node -> node instanceof ImageView);
    }

    public void drawTileAt(Position pos, Image image) {
        StackPane stackPane = (StackPane) this.getChildren().get(pos.getRow() * 10 + pos.getColumn());
        stackPane.getChildren().add(new ImageView(image));
    }

    public void drawLaser(Lazer laser) {
        StackPane stackPane = (StackPane) this.getChildren().get(laser.getPos().getRow() * 10 + laser.getPos().getColumn());
        ImageView laserImageView = new ImageView(new Image(laser.getImageString()));
        stackPane.getChildren().add(laserImageView);
    
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            stackPane.getChildren().remove(laserImageView);
        }));
        timeline.play();
    }

}
