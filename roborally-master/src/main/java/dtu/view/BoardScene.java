package dtu.view;

import java.io.IOException;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;

import javafx.scene.layout.HBox;
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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;





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
    

    private void initialize() throws IOException {
        boardPane = (BorderPane) this.getRoot();

        // Creating the board
        Board board = new Board(Map.getMapByName(c.getBoardSelecter()));
        c.setBoard(board);
        
        redraw();
        //Popup();
        // Register control panel
        cp = new ControlPanel(c);
        boardPane.setRight(playersUIright);
        boardPane.setBottom(cp);

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
        // Create popup
        Label label = new Label("You have been acted upon!");
        Popup popup = new Popup();
        popup.getContent().add(label);
        popup.setAutoHide(true);
    
        // Position popup relative to the board
        double popupX = bd.getLayoutX() + bd.getBoundsInLocal().getWidth() / 2 - label.getWidth() / 2;
        double popupY = bd.getLayoutY() + bd.getBoundsInLocal().getHeight() / 2 - label.getHeight() / 2;
        popup.setX(popupX);
        popup.setY(popupY);
    
        // Show popup
        popup.show(boardPane.getScene().getWindow());
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
}
