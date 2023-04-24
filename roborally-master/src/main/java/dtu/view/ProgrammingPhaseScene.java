package dtu.view;

import dtu.controller.Controller;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import dtu.controller.Controller;
import javafx.scene.Scene;

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
import dtu.logic.models.Color;
import dtu.logic.models.Position;
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
        this.robot1 = new Robot(Color.BLUE,new Position(2,2));
        this.player1 = new Player(robot1,"Player1");
        player1.GenerateDeck();
        this.deck = player1.getDeck();
        deck.shuffleDeck(deck.cards);
        player1.drawProgrammingCards();
        this.initialize();
        this.c = c;
    }

    

    public void initialize() {
        BorderPane mainGrid = (BorderPane) this.getRoot();

        Image stream = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(0).imagePath)); //new FileInputStream("file:src/main/resources/Cards/left_turn.png")); 
        ImageView imageView1 = new ImageView(stream);  
        imageView1.setFitHeight(150);
        imageView1.setFitWidth(100);
        imageView1.setTranslateX(300);
        imageView1.setTranslateY(300);





        Rectangle rect = new Rectangle(150,30);
        rect.setTranslateX(150); 
        rect.setTranslateY(50);

        Label label = new Label ("Test"); 
        label.setTranslateX(250);
        label.setTranslateY(150);

        // mainGrid.setLeft(imageView1);


        // VBox Hand = new VBox(handTitle, card1);

        mainGrid.setPrefSize(1000, 1000);

        // mainGrid.setRight(label);
        // mainGrid.setLeft(label);
        mainGrid.setCenter(imageView1);

        mainGrid.getChildren().forEach(this::makeDraggable);
        // mainGrid.setRight(Hand);



    }

    private double startX;
    private double startY;

    private void makeDraggable (Node node){
        node.setOnMousePressed(e->{
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();
        });
            
        node.setOnMouseDragged(e->{
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });
        node.setOnMouseReleased(e->{
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });
        // node.setOnDragOver();
        // node.setOnDragDropped(e->{
            
        // });
        // System.out.print(event.getX());
        

        
        
    }
}