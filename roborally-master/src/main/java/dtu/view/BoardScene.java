package dtu.view;

import java.io.File;
import java.io.IOException;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import dtu.controller.Controller;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Cards.ActionCard;
import dtu.logic.models.Observers.BoardObserver;
import dtu.logic.models.Observers.RobotObserver;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Lazer;
import dtu.logic.models.Robot.Robot;
import dtu.view.drawers.BoardDrawer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;




public class BoardScene extends Scene implements RobotObserver, BoardObserver {
    

    BorderPane boardPane;
    Controller c;
    ControlPanel cp;
    ArrayList<Playermat> pMats = new ArrayList<>();
    VBox playersUIright = new VBox();
    VBox playersUIleft = new VBox();
    VBox testpopUP = new VBox();
    BoardDrawer bd;
    Popup popup = new Popup();

    ImageView imageView;

    public void setPlayermats(ArrayList<Player> players){
        if (players.size() <= 4){
            for (int i = 0; i < players.size(); i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIright.getChildren().add(p1);
                pMats.add(p1);
            }
            for (int i = players.size(); i < 4; i++){
                playersUIright.getChildren().add(new ImageView(new Image("playermat/dummyplayermat.png")));
            }
        }
        else {
            for (int i = 0; i < 4; i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIright.getChildren().add(p1);
                pMats.add(p1);
            }
            for (int i = players.size(); i < 4; i++){
                playersUIright.getChildren().add(new ImageView(new Image("playermat/dummyplayermat.png")));
            }

            for (int i = 4; i < players.size(); i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIleft.getChildren().add(p1);
                pMats.add(p1);
            }
            for (int i = players.size()-4; i < 4; i++){
                playersUIleft.getChildren().add(new ImageView(new Image("playermat/dummyplayermat.png")));
            }
            boardPane.setLeft(playersUIleft);
        }
        // boardPane.setRight(playersUIright);
    }

    public Playermat getPlayermat(String pName){
        for (int i = 0; i < pMats.size(); i++){
            if (pMats.get(i).getPName().equals(pName)){
                return pMats.get(i);
            }
        }
        return null;
    }

    public BoardScene(Controller c) throws IOException {
        super(new BorderPane());
        this.c = c;
        this.initialize();
    }
    public void Popup2(){
        System.out.println("popup2");
        Image view1 = new Image("Cards/popup.png");
        Label label = new Label("New Action!");

        VBox topBox = new VBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.setPrefHeight(50);
        topBox.setStyle("-fx-background-color:#ff3333");
        boardPane.setTop(topBox);
        
        
        popup.getContent().addAll(label);

        popup.show(boardPane, boardPane.getPrefWidth()/2, boardPane.getPrefHeight()/2);


    }

    public void Popup1(){
        imageView.setVisible(true);
        // Image view = new Image("Cards/popup.png");
        // ImageView imageView = new ImageView(view);
        // StackPane.setAlignment(imageView, Pos.CENTER);
        // StackPane.setMargin(imageView, new Insets(50));

        // boardPane.getChildren().add(imageView);

        // imageView.setFitHeight(100);
        // imageView.setFitWidth(100);
        // test.getChildren().add(imageView);

        // System.out.println("children of boardpane bottom before: " + boardPane.getBottom());
        // boardPane.setBottom(test);
        // System.out.println("children of boardpane bottom after: " + boardPane.getBottom());
    
        // testpopUP.getChildren().add(t);
        // testpopUP.getChildren().add(imageView);
      

        // add the label
        //stackpane.getChildren().add(imageView);
        
        // popup.getContent().add(imageView);
        // // set size of label
        // popup.show(boardPane.getScene().getWindow());
        
    }

    private void initialize() throws IOException {
        boardPane = (BorderPane) this.getRoot();

        Media media = new Media(new File("/Users/Natalia/Downloads/musicPiano.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
        mediaPlayer.setAutoPlay(true);  

        // Creating the board
        Board board = new Board(Map.getMapByName(c.getBoardSelecter()));
        c.setBoard(board);
        
        redraw();
        // Register control panel
        Image view = new Image("Cards/popup.png");
        this.imageView = new ImageView(view);
        imageView.setVisible(false);
        cp = new ControlPanel(c);
        cp.getChildren().add(imageView);
        boardPane.setRight(playersUIright);
        // boardPane.setBottom(testpopUP);
        boardPane.setBottom(cp);
        // Popup2();
        // popup.show(boardPane.getScene().getWindow());
        
        // boardPane.getChildren().add(popup);
    }

    public void redraw() {
        // Draw board
        bd = new BoardDrawer(c.getBoard());
        bd.draw();
        boardPane.setCenter(bd);
    }

    public void updateRobotInfo(Robot robot) {
        Platform.runLater(() -> {
            bd.drawRobot(robot);
            for (int i = 0; i<pMats.size(); i++){
                if(pMats.get(i).getPlayer().getRobot() == robot){
                    pMats.get(i).updateInfo();
                }
            }
        });     
    }

    public void updateNewAction(ActionCard actionCard) {
        System.out.println("New Action Before loop!");    
        Popup1();
        Popup2();

        System.out.println("New Action!");
    }
    
    public void updateCardTaken(Player player, String cardImageString){
        Platform.runLater(() -> {;
            getPlayermat(player.getName()).activateCard(cardImageString);
        });
    }

    public void updateRegister(Robot robot){
        Platform.runLater(() -> {
            for (int i = 0; i<pMats.size(); i++){
                if(pMats.get(i).getPlayer().getRobot() == robot){
                    pMats.get(i).setRegister(robot.getRegister().size());
                }
            }
        });
    };

    public void clearAllActiveCards(){
        for (int i = 0; i < pMats.size(); i++){
            pMats.get(i).clearActiveCard();
        }
    }

    public ControlPanel getControlPanel() {
        return this.cp;
    }

    public void updateLaser(Lazer laser) {
        Platform.runLater(() -> {
            bd.drawLaser(laser);
        });   
    }
    

        // set auto hide
        //popup.setAutoHide(true);
        //popup.show();        
    
}
