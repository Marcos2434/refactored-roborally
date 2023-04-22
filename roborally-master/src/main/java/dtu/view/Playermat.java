package dtu.view;

import dtu.logic.models.Player.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

class smolCard extends Canvas{
    private static final int W_SIZE = 30;
    private static final int H_SIZE = 42;

    public smolCard(){

    }
}

class Background extends Canvas{
    static final int W_SIZE = 330;
    static final int H_SIZE = 214;
    private Image image = new Image("playermat/playermat.png");

    public Background(){
        super(W_SIZE, H_SIZE);
        redraw();
    }

    private void redraw(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
    }
}




public class Playermat extends Application {
    private String pName = "Komv";
    private int rLives = 3;
    private int actCheckpoint = 0;
    private int dmgPoints = 0;

    // public void Playermat(Player player){

    // }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Background bck = new Background();

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        Label name = new Label(pName);
        Label lives = new Label("Lives: "+rLives);
        Label chpLabel = new Label("Checkpoint: " + actCheckpoint);
        Label damage = new Label("Damage: "+dmgPoints);
        Label card = new Label("active card");

        grid.add(name, 0, 0, 5, 1);
        grid.add(lives, 0, 2, 2, 1);
        grid.add(chpLabel, 1, 2, 3, 1);
        grid.add(damage, 0, 3, 5, 1);
        grid.add(card, 5, 0, 1, 4);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        // RowConstraints row1 = new RowConstraints();

        grid.getColumnConstraints().add(column1);
        grid.getColumnConstraints().add(column2);
        grid.getColumnConstraints().add(column3);
        // grid.getRowConstraints().add(row1);


        column1.setPrefWidth(105);
        column2.setPrefWidth(105);
        column2.setPrefWidth(120);
        // row1.setPrefHeight(214);


        //root.setCenter(bck);
        root.setCenter(grid);

        Scene scene = new Scene(root);
        		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tylko jedno w głowie mam");
		primaryStage.show();            
        }
    public static void main(String[] args) {
        // Launch GUI
        launch(args);
    }
}
