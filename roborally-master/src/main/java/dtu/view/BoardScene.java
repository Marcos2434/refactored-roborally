package dtu.view;

import java.io.File;
import java.io.IOException;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;




public class BoardScene extends Scene implements RobotObserver, BoardObserver {
    

    private BorderPane boardPane;
    private Controller c;
    private ControlPanel cp;
    private ArrayList<Playermat> pMats = new ArrayList<>();
    private VBox playersUIright = new VBox();
    private VBox playersUIleft = new VBox();
    private VBox testpopUP = new VBox();
    private BoardDrawer bd;
    private Popup popup = new Popup();
    private HBox rightSide = new HBox();

    private Pane pane;



    
    private ImageView fireRain;
    private ImageView oilStorm;
    private ImageView spinLaser;

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
    

    public void Popup1(ActionCard actionCard){
        ImageView currentImage;
        System.out.println("we are in popu1");
        if (actionCard.getImage().equals("Cards/fireRain.png")){
            currentImage = fireRain;
            System.out.println("we should be in fireRain");
        }
        else if (actionCard.getImage().equals("Cards/OilStorm.png")){
            currentImage = oilStorm;
            System.out.println("we should be in oilStorm");
        }
        else {
            currentImage = spinLaser;
        }
        
        currentImage.setVisible(true);

        //_______________________
        // Image view = new Image(actionCard.getImage());
        // this.imageView = new ImageView(view);
        // imageView.setFitWidth(200);
        // imageView.setFitHeight(300);

        
        // System.out.println("cp thing before adding"+ pane.getChildren());
        // try {
        //     pane.getChildren().addAll(imageView);
        // }
        // catch (Exception e){
        //     System.out.println("cpFinal is null");
        // }
        // // cpFinal.getChildren().addAll(cp,imageView);
        // System.out.println("cp thing after adding"+ pane.getChildren());
        //_________________
        
        // imageView.setVisible(true);
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), event -> {
            // Show the image after a delay of 3 seconds
            currentImage.setVisible(false);
        }));
        
        timeline.play();
        // imageView.setVisible(false);
        
      
    }

    // private void initialize() throws IOException {
    //     boardPane = (BorderPane) this.getRoot();

    //     Media media = new Media(new File("/Users/Natalia/Downloads/musicPiano.mp3").toURI().toString());
    //     MediaPlayer mediaPlayer = new MediaPlayer(media);  
    //     mediaPlayer.setAutoPlay(true);  

    //     // Creating the board
    //     Board board = new Board(Map.getMapByName(c.getBoardSelecter()));
    //     c.setBoard(board);
        
    //     redraw();
    //     // Register control panel
    //     Image view = new Image("Cards/popup.png");
    //     this.imageView = new ImageView(view);
    //     StackPane.setAlignment(imageView, Pos.CENTER);
    //     // StackPane.setMargin(imageView, new Insets(50));
        
    //     imageView.setVisible(true);
    //     cp = new ControlPanel(c);
    //     cp.getChildren().add(imageView);
    //     boardPane.setRight(playersUIright);
    //     // boardPane.setBottom(testpopUP);
    //     boardPane.setBottom(cp);
    //     // Popup2();
    //     // popup.show(boardPane.getScene().getWindow());
        
    //     // boardPane.getChildren().add(popup);
    // }
    private void initialize() throws IOException {
        boardPane = (BorderPane) this.getRoot();
        //Music player
        Media media = new Media(new File("/Users/Natalia/Downloads/musicPiano.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
        mediaPlayer.setAutoPlay(true);  

        //Background picture
        Image background = new Image (("playermat/dummyplayermat.png"));
        BackgroundImage background2 = new BackgroundImage(background, null, null, null, null);
        Background background3 = new Background(background2);


    
        // Creating the board
        Board board = new Board(Map.getMapByName(c.getBoardSelecter()));
        c.setBoard(board);

        redraw();
        // Popup1();
        // Register control panel
        // Image view = new Image("Cards/popup.png");
        // this.imageView = new ImageView(view);
        // imageView.setVisible(false);
        // imageView.setFitWidth(200);
        // imageView.setFitHeight(300);

        Image view1 = new Image("Cards/fireRain.png");
        this.fireRain = new ImageView(view1);
        fireRain.setVisible(false);
        fireRain.setFitWidth(200);
        fireRain.setFitHeight(300);

        Image view2 = new Image("Cards/OilStorm.png");
        this.oilStorm = new ImageView(view2);
        oilStorm.setVisible(false);
        oilStorm.setFitWidth(200);
        oilStorm.setFitHeight(300);

        Image view3 = new Image("Cards/spinLaser.png");
        this.spinLaser = new ImageView(view3);
        spinLaser.setVisible(false);
        spinLaser.setFitWidth(200);
        spinLaser.setFitHeight(300);

        // this.pane = new Pane();
        cp = new ControlPanel(c);
        VBox cpFinal = new VBox();; 
        cpFinal.getChildren().addAll(cp, fireRain, oilStorm, spinLaser);

        //trying pane
        
        //trying pane

        // cp.getChildren().add(imageView);
        rightSide.getChildren().addAll(playersUIright,cpFinal);
        // boardPane.setBottom(testpopUP);
        boardPane.setBackground(background3);
        boardPane.setRight(rightSide);

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
        ActionCard cardToPass = actionCard;
        Popup1(cardToPass);
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
