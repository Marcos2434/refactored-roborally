package dtu.view;

import dtu.controller.Controller;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import dtu.controller.Controller;
import javafx.scene.Scene;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;


import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import dtu.logic.models.Color;
import dtu.logic.models.Position;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

// public class ProgrammingPhaseScene extends Scene {
//     Controller c;
    
//     public ProgrammingPhaseScene (Controller c) {
//         super(new GridPane());
//         this.initialize();
//         this.c = c;
//     }}

    
    
public class ProgrammingPhaseScene extends Scene {
    Controller c;
    Player player1;
    Robot robot1;
    Deck deck;
    
    
    public ProgrammingPhaseScene(Controller c) {
        super(new BorderPane());
        this.robot1 = new Robot(RobotColor.BLUE,new Position(2,2));
        this.player1 = new Player(robot1,"Player1");
        player1.GenerateDeck();
        this.deck = player1.getDeck();
        //deck.shuffleDeck(deck.cards);
        player1.drawProgrammingCards();
        this.initialize();
        this.c = c;
    }

    double sceneWidth;
    double sceneHeight;

    public void initialize() {
        BorderPane mainGrid = (BorderPane) this.getRoot();
        sceneWidth = this.getWidth();
        sceneHeight = this.getHeight();

        //Card1
        // //Image stream = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(0).imagePath)); //new FileInputStream("file:src/main/resources/Cards/left_turn.png")); 
        // ImageView imageView1 = new ImageView(stream);  
        // imageView1.setFitHeight(150);
        // imageView1.setFitWidth(100);
        // imageView1.setLayoutX(-10);
        // imageView1.setLayoutY(10);
        

        // //Card2 
        // //Image stream2 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(1).imagePath)); //new FileInputStream("file:src/main/resources/Cards/left_turn.png"));
        // ImageView imageView2 = new ImageView(stream2);
        // imageView2.setFitHeight(150);
        // imageView2.setFitWidth(100);
        


        // mainGrid.setLeft(imageView1);


        // VBox Hand = new VBox(handTitle, card1);

        mainGrid.setPrefSize(1000, 1000);

        // mainGrid.setRight(label);
        // mainGrid.setLeft(label);
        // mainGrid.(imageView1);
        // mainGrid(imageView2);

        mainGrid.getChildren().forEach(this::makeDraggable);
        // mainGrid.setRight(Hand);
        //Create a rectangle to represent the drop zone
        Rectangle frame = new Rectangle(100,150);
        frame.setStroke(Color.BLACK);
        frame.setFill(null);
        frame.setLayoutX(10);
        frame.setLayoutY(10);
        mainGrid.setLeft(frame);

        Rectangle frame2 = new Rectangle(100,150);
        frame2.setStroke(Color.BLACK);
        frame2.setFill(null);
        frame2.setLayoutX(-10);
        frame2.setLayoutY(10);
        mainGrid.setRight(frame2);


    }

    //Bounding box for the cards
    private BoundingBox registerCard1  =  new BoundingBox(10, 10, 100, 150);
    private BoundingBox registerCard2  =  new BoundingBox(-10, 10, 100, 150);
    
    
    
    public boolean contains (BoundingBox Box, double x, double y){
        return Box.contains(x, y);
    };


    private double startX;
    private double startY;

    private void makeDraggable (Node node){
        double width = getWidth();
        double height = getHeight();

        node.setOnMousePressed(e->{
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();
        });
            
        node.setOnMouseDragged(e->{
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });

        node.setOnMouseReleased(e->{
            //go through all boxes and check if we released the mouse inside one of them
            for (int i = 0; i < 5; i++){
                //if we did, then we set the card to the center of the box
                if (contains(registerCard1, e.getSceneX(), e.getSceneY())){
                    //It set
                    node.setLayoutX(registerCard1.getCenterX());
                    node.setLayoutY(registerCard1.getCenterY());
                }
                if (contains(registerCard2, e.getSceneX(), e.getSceneY())){
                    node.setLayoutX(registerCard2.getCenterX());
                    node.setLayoutY(registerCard2.getCenterY());
                    
                }
                else {
                    node.setTranslateX(startX);
                    node.setTranslateY(startY);
                }
            }
        });
    }
}