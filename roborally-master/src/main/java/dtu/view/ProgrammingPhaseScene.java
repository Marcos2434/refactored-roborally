package dtu.view;

import dtu.controller.Controller;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import dtu.logic.models.Position;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import dtu.logic.models.Robot.RobotObserver;
import dtu.view.drawers.BoardDrawer;
import io.cucumber.plugin.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.application.Platform;
import javafx.event.Event;

import java.io.IOException;
// import javafx.event.EventHandler;
import java.time.Duration;


    
public class ProgrammingPhaseScene extends Scene implements RobotObserver {
    //------------------------------------- GLOBALS_START -------------------------------------//
    Controller c;
    Player player1;
    Robot robot1;
    Deck deck;

    //Columns in grid
    ColumnConstraints column1;
    ColumnConstraints column2;
    ColumnConstraints column3;
    ColumnConstraints column4;
    
    //Vboxes for register
    VBox leftBox1;
    VBox leftBox2;
    VBox leftBox3;
    VBox leftBox4;
    VBox leftBox5;
    VBox buttonBox;

    //Frames
    Rectangle frame;
    Rectangle frame2;
    Rectangle frame3;
    Rectangle frame4;
    Rectangle frame5;
    

    Node store1;
    Node store2;
    Node store3;
    Node store4;
    Node store5;
    //Card Images
    ImageView imageView1;

    GridPane mainGrid;
    
    Button button;

    BoardDrawer bd;
    
    //------------------------------------- GLOBALS_END -------------------------------------//

    //Constructor
    public ProgrammingPhaseScene(Controller c) {

        super(new GridPane());
        this.c = c;
        this.player1 = c.getCurrentPlayer();
        player1.GenerateDeck();
        this.deck = player1.getDeck();
        deck.shuffleDeck();
        player1.drawProgrammingCards();
        this.initialize();
    }

    //Initialize
    public void initialize() {
        this.mainGrid = (GridPane) this.getRoot();
        // mainGrid.setGridLinesVisible( true ); //////
        // mainGrid.setPrefSize(1200, 900);

        // ColumnConstraints column1 = new ColumnConstraints();
        // column1.setPercentWidth(10);
        // ColumnConstraints column2 = new ColumnConstraints();
        // column2.setPercentWidth(70);
        // ColumnConstraints column3 = new ColumnConstraints();
        // column3.setPercentWidth(10);
        // ColumnConstraints column4 = new ColumnConstraints();
        // column4.setPercentWidth(10);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setMinWidth(100);
        column1.setMaxWidth(100);    
                
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(70);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setMinWidth(100);
        column3.setMaxWidth(100); 
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setMinWidth(100);
        column4.setMaxWidth(100);
   
        mainGrid.getColumnConstraints().addAll(column1, column2, column3, column4);


        

        
        
        //------------------------------------- CARDS_START -------------------------------------//

        //Card1
        Image stream1 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(0).getImage())); //
        this.imageView1 = new ImageView(stream1); //new ImageView(stream);  
        imageView1.setFitHeight(150);
        imageView1.setFitWidth(100);
        String imagePath1 =player1.getHand().get(0).getImage().toString();
        imageView1.setId(imagePath1);
        //Card2 
        Image stream2 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(1).getImage())); 
        ImageView imageView2 = new ImageView(stream2);
        imageView2.setFitHeight(150);
        imageView2.setFitWidth(100);
        String imagePath2 =player1.getHand().get(1).getImage().toString();
        imageView2.setId(imagePath2);
        // Card3
        Image stream3 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(2).getImage())); 
        ImageView imageView3 = new ImageView(stream3);
        imageView3.setFitHeight(150);
        imageView3.setFitWidth(100);
        String imagePath3 =player1.getHand().get(2).getImage().toString();
        imageView3.setId(imagePath3);
        //Card4
        Image stream4 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(3).getImage())); //new FileInputStream("file:src/main/resources/Cards/left_turn.png"));
        ImageView imageView4 = new ImageView(stream4);
        imageView4.setFitHeight(150);
        imageView4.setFitWidth(100);
        String imagePath4 =player1.getHand().get(3).getImage().toString();
        imageView4.setId(imagePath4);
        //Card5
        Image stream5 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(4).getImage())); 
        ImageView imageView5 = new ImageView(stream5);
        imageView5.setFitHeight(150);
        imageView5.setFitWidth(100);
        String imagePath5 =player1.getHand().get(4).getImage().toString();
        imageView5.setId(imagePath5);
        //Card6
        Image stream6 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(5).getImage()));
        ImageView imageView6 = new ImageView(stream6);
        imageView6.setFitHeight(150);
        imageView6.setFitWidth(100);
        String imagePath6 =player1.getHand().get(5).getImage().toString();
        imageView6.setId(imagePath6);
        //Card7
        Image stream7 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(6).getImage()));
        ImageView imageView7 = new ImageView(stream7);
        imageView7.setFitHeight(150);
        imageView7.setFitWidth(100);
        String imagePath7 =player1.getHand().get(6).getImage().toString();
        imageView7.setId(imagePath7);
        //Card8
        Image stream8 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(7).getImage()));
        ImageView imageView8 = new ImageView(stream8);
        imageView8.setFitHeight(150);
        imageView8.setFitWidth(100);
        String imagePath8 =player1.getHand().get(7).getImage().toString();
        imageView8.setId(imagePath8);
        //Card9
        Image stream9 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(8).getImage()));
        ImageView imageView9 = new ImageView(stream9);
        imageView9.setFitHeight(150);
        imageView9.setFitWidth(100);
        String imagePath9 =player1.getHand().get(8).getImage().toString();
        imageView9.setId(imagePath9);

        //Displaying Cards
        mainGrid.add(imageView1, 3,0,1,1);
        mainGrid.add(imageView2, 3,1,1,1);
        mainGrid.add(imageView3, 3,2,1,1);
        mainGrid.add(imageView4, 3,3,1,1);
        mainGrid.add(imageView5, 3,4,1,1);
        mainGrid.add(imageView6, 2,0,1,1);
        mainGrid.add(imageView7, 2,1,1,1);
        mainGrid.add(imageView8, 2,2,1,1);
        mainGrid.add(imageView9, 2,3,1,1);


        
        //Make cards graggable
        mainGrid.getChildren().forEach(this::makeDraggable);
        // mainGrid.add(c.getBoard(),1, 0, 1, 5);
        
        // Draw board
        bd = new BoardDrawer();
        bd.draw(c.getBoard());
        
        mainGrid.add(bd, 1, 0, 1, 5);

        //------------------------------------- CARDS_END -------------------------------------//

        //------------------------------------- REGISTER_BOXES_START -------------------------------------//
        
        //Frame 1
        this.frame = new Rectangle(100,150);
        frame.setStroke(Color.LIGHTSKYBLUE);
        frame.setFill(null);
        this.button = new Button("Remove 1");
        button.setOnAction(e->buttonMethod(store1, frame));
        button.setPrefWidth(100);
        this.leftBox1 = new VBox(frame,button);
        mainGrid.add(leftBox1, 0, 0, 1, 1);
        //Frame 2
        this.frame2 = new Rectangle(100,150);
        frame2.setStroke(Color.GREEN);
        frame2.setFill(null);
        this.button= new Button("Remove 2");
        button.setOnAction(e->buttonMethod(store2,frame2));
        button.setPrefWidth(100);
        this.leftBox2 = new VBox(frame2,button);
        mainGrid.add(leftBox2, 0, 1, 1, 1); 
        //Frame 3
        this.frame3 = new Rectangle(100,150);
        frame3.setStroke(Color.BLACK);
        frame3.setFill(null);
        this.button = new Button("Remove 3");
        button.setOnAction(e->buttonMethod(store3, frame3));
        button.setPrefWidth(100);
        this.leftBox3 = new VBox(frame3,button);
        mainGrid.add(leftBox3, 0, 2, 1, 1);
        //Frame 4
        this.frame4 = new Rectangle(100,150);
        frame4.setStroke(Color.TOMATO);
        frame4.setFill(null);
        this.button= new Button("Remove 4");
        button.setOnAction(e->buttonMethod(store4,frame4));
        button.setPrefWidth(100);
        this.leftBox4 = new VBox(frame4,button);
        mainGrid.add(leftBox4, 0, 3, 1, 1);
        //Frame 5
        this.frame5 = new Rectangle(100,150);
        frame5.setStroke(Color.PINK);
        frame5.setFill(null);
        this.button= new Button("Remove 5");
        button.setOnAction(e->buttonMethod(store5,frame5));
        button.setPrefWidth(100);
        this.leftBox5 = new VBox(frame5,button);
        mainGrid.add(leftBox5, 0, 4, 1, 1);

        //Finish Button
        this.button = new Button("Ready");
        button.setPrefWidth(670);
        this.buttonBox = new VBox(button);
        mainGrid.add(buttonBox, 1, 6, 1, 1);
        button.setOnAction(e->DoneButton());
    
        //------------------------------------- REGISTER_BOXES_END -------------------------------------//
    }

    // Observer method
    public void updateRobotInfo(Robot robot) {
        Platform.runLater(() -> {
            System.out.println("Drawing!");
            bd.drawRobot(robot);
        });
        
    }

    

    private double startX;
    private double startY;
    
    //------------------------------------- EVENTS_START -------------------------------------//
    private void makeDraggable (Node node){
        // (1) Mouse Pressed
        node.setOnMousePressed(e->{
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();
        });
        // (2) Mouse Dragged
        node.setOnMouseDragged(e->{
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });
        // (3) Mouse Released
        node.setOnMouseReleased(e->{
            double mouseX = e.getSceneX();
            double mouseY = e.getSceneY();
            if (leftBox1.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame.getFill()==null){
                    node.setVisible(false);
                    System.out.println("WE are now in box 1");
                    frame.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store1 = node;
                } 
                else {
                    node.setVisible(false);
                    store1.setVisible(true);
                    store1.setTranslateX(0);
                    store1.setTranslateY(0);
                    frame.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store1 = node;
                }
            }          
            if (leftBox2.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame2.getFill()==null){
                    node.setVisible(false);
                    System.out.println("we are now in box 2");
                    frame2.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store2 = node;
                } 
                else {
                    node.setVisible(false);
                    store2.setVisible(true);
                    store2.setTranslateX(0);
                    store2.setTranslateY(0);
                    frame2.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store2 = node;
                }
            }
            if (leftBox3.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame3.getFill()==null){
                    node.setVisible(false);
                    System.out.println("we are now in box 3");
                    frame3.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store3 = node;
                } 
                else {
                    node.setVisible(false);
                    store3.setVisible(true);
                    store3.setTranslateX(0);
                    store3.setTranslateY(0);
                    frame3.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store3 = node;
                }
                
                            // System.out.println("we are now in box 3");
                            // frame3.setFill(new ImagePattern(new Image (node.getId()) ));
            }
            if (leftBox4.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame4.getFill() == null){
                    node.setVisible(false);
                    System.out.println("we are now in box 4");
                    frame4.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store4 = node;
                } 
                else {
                    node.setVisible(false);
                    store4.setVisible(true);
                    store4.setTranslateX(0);
                    store4.setTranslateY(0);
                    frame4.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store4 = node;
                }
            }
            if (leftBox5.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame5.getFill()==null){
                    node.setVisible(false);
                    System.out.println("we are now in box 5");
                    frame5.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store5 = node;
                } 
                else {
                    node.setVisible(false);
                    store5.setVisible(true);
                    store5.setTranslateX(0);
                    store5.setTranslateY(0);
                    frame5.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store5 = node;
                }
            }
            if (!leftBox5.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())&&
                !leftBox4.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())&&
                !leftBox3.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())&&
                !leftBox2.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())&&
                !leftBox1.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())) {
                //Return card back
                node.setTranslateX(0);
                node.setTranslateY(0);
            }
        });  
    }

    //------------------------------------- EVENTS_END -------------------------------------//

    private void buttonMethod(Node store, Rectangle frame){
        System.out.println("Button pressed");
        frame.setFill(null);
        store.setVisible(true);
        store.setTranslateX(0);
        store.setTranslateY(0);
        System.out.println("Button Pressed");
    };

    private void DoneButton (){
        //Hardcoded passing card (right now passing first 5 cards from hand)
        if (frame.getFill()!=null){
            leftBox1.getId();
            player1.getRobot().AddToRegister(player1.getHand().get(0));   
        }
        if (frame2.getFill()!=null){
            leftBox2.getId();
            player1.getRobot().AddToRegister(player1.getHand().get(1));   
        }
        if (frame3.getFill()!=null){
            leftBox3.getId();
            player1.getRobot().AddToRegister(player1.getHand().get(2));   
        }
        if (frame4.getFill()!=null){
            leftBox4.getId();
            player1.getRobot().AddToRegister(player1.getHand().get(3));   
        }
        if (frame5.getFill()!=null){
            leftBox5.getId();
            player1.getRobot().AddToRegister(player1.getHand().get(4));   
        }
        
    }
}




        // Button createPlayerButton = new Button();
        // createPlayerButton.setText("Start Game");
        // createPlayerButton.setOnMouseClicked(new EventHandler<Event>() {
        //     @Override
        //     public void handle(Event event) {
    


















//HOW TO GET NODE FROM GRIDPANE

// private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
//     for (Node node : gridPane.getChildren()) {
//         if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
//             return node;
//         }
//     }
//     return null;
// }//