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
import dtu.logic.models.Robot.Robot;
import dtu.roborally.view.widgets.ControlPanel;
import dtu.view.drawers.BoardDrawer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;





public class BoardScene extends Scene implements RobotObserver, BoardObserver {
    
    BorderPane boardPane;
    Controller c;
    ControlPanel cp;
    HBox rightSide = new HBox();
    ArrayList<Playermat> pMats = new ArrayList<>();
    VBox playersUIright = new VBox();
    VBox playersUIleft = new VBox();
    VBox testpopUP = new VBox();
    BoardDrawer bd;

    public void setPlayermats(ArrayList<Player> players){
        if (players.size() <= 4){
            for (int i = 0; i < players.size(); i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIright.getChildren().add(p1);
                pMats.add(p1);
            }
        }
        else {
            for (int i = 0; i < 4; i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIright.getChildren().add(p1);
                pMats.add(p1);
            }

            for (int i = 4; i < players.size(); i++){
                Playermat p1 = new Playermat(players.get(i));
                playersUIleft.getChildren().add(p1);
                pMats.add(p1);
            }
            boardPane.setLeft(playersUIleft);
        }
        // boardPane.setRight(playersUIright);
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
        rightSide.getChildren().addAll(playersUIright,cp);
        boardPane.setRight(rightSide);
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
        });     
    }

    public void updateNewAction(ActionCard actionCard) {
        // Run popup here !
        System.out.println("New Action!");
    }

    public ControlPanel getControlPanel() {
        return this.cp;
    }
    public void Popup(){
        ImageView imageView = new ImageView("Popupcard.png");
        Label label = new Label("This is a Popup");
      
        // create a popup
        Popup popup = new Popup();
    
        Button button = new Button("Test button for popup");
        // add the label
        
        popup.getContent().add(label);
        //label.setStyle("-fx-background-image: ;");
        // set size of label
        label.setMinWidth(80);
        label.setMinHeight(50);
        // set auto hide
        popup.setAutoHide(true);
        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) //
            {
                if (!popup.isShowing())
                    popup.show(boardPane.getScene().getWindow());
                else
                    popup.hide();
            }
        };
    
        // when button is pressed
        button.setOnAction(event);
        // add button
        rightSide.getChildren().add(button);

    }
}
