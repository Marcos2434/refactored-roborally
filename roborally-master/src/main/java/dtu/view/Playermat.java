package dtu.view;

import java.io.IOException;
import java.util.logging.Logger;

import dtu.logic.models.Player.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Playermat extends StackPane{
    
    public static final int width = 330;
    public static final int height = 214;

    private Label pName;
    private Label color;
    private Label lives;
    private Label damage;
    private Label chPoint;

    private Image backgroundpic = new Image("playermat/playermat.png");
    private ImageView background = new ImageView(backgroundpic);

    private Image cardbackpic = new Image("playermat/cardback.png");
    private ImageView cardback = new ImageView(cardbackpic);

    private Image ActiveCardPic = new Image("Cards/AgainCard.png");
    private ImageView ActiveCard;



    public Playermat(Player player){

        pName = new Label(player.getName());
        pName.prefHeight(54);
        pName.prefWidth(191);
        pName.setStyle("prefHeight= 54.0; prefWidth= 188.0");
        color = new Label("BLUE");
        HBox playerinfo = new HBox(pName, color);

        HBox cardsHbox = new HBox();
        for (int i = 0; i < 5; i++) {
            ImageView cb = new ImageView(cardbackpic);
            cardsHbox.getChildren().add(cb);
        }

        lives = new Label("Lives: " + String.valueOf(player.getRobot().getLives()) + "   ");
        chPoint = new Label("Checkpoint: Start");

        HBox playerinfo2 = new HBox(lives, chPoint);

        damage = new Label("Damage: " + String.valueOf(player.getRobot().getDamageTaken()));
        VBox vbox = new VBox(playerinfo, cardsHbox, playerinfo2, damage);
        vbox.prefHeight(height);
        vbox.prefWidth(210);
        vbox.setStyle("-fx-padding: 0 0 0 20;");;

        ActiveCard = new ImageView(ActiveCardPic);
        
        HBox hbox1 = new HBox(vbox, ActiveCard);
        hbox1.prefHeight(height);
        hbox1.prefWidth(width);

        super.getChildren().addAll(background, hbox1);
    }

    
    // @Override
    // public void start(Stage primaryStage) throws Exception {
    //     try{
    //     Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("playermat/playermat.fxml"));
    //     //BorderPane root = new BorderPane();
    //     Scene scene = new Scene(root);

    //     primaryStage.setTitle("A rohadás öljön meg");
    //     primaryStage.setScene(scene);
    //     primaryStage.show();
    //     }
    //     catch(Exception ex) {
    //         ex.printStackTrace();
    //     }
    // }

    // public static void main(String[] args) {
    //     // Launch GUI
    //     launch(args);
    // }
}
