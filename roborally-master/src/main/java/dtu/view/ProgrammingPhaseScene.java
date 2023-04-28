package dtu.view;
import dtu.controller.Controller;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Cards.ProgramCard;
import dtu.logic.models.Observers.RobotObserver;
import dtu.logic.models.Robot.Robot;
import dtu.view.drawers.BoardDrawer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.application.Platform;


    
public class ProgrammingPhaseScene extends Scene implements RobotObserver {
    //------------------------------------- GLOBALS_START -------------------------------------//
    Controller c;
  
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

    private double startX;
    private double startY;
    
    //------------------------------------- GLOBALS_END -------------------------------------//

    //Constructor
    public ProgrammingPhaseScene(Controller c) {
        super(new GridPane());
        this.c = c;
      
        c.getCurrentPlayer().GenerateDeck();
        this.deck = c.getCurrentPlayer().getDeck();
        deck.shuffleDeck();
        c.getCurrentPlayer().drawProgrammingCards();
        this.initialize();
    }

    //Initialize
    public void initialize() {

        Image background = new Image (("playermat/lava.png"));
        BackgroundImage background2 = new BackgroundImage(background, null, null, null, null);
        Background background3 = new Background(background2);
        
        System.out.println("got over background");
        
        this.mainGrid = (GridPane) this.getRoot();
        //Set backround to the whole scene 
        mainGrid.setBackground(background3);
        // mainGrid.backgroundProperty();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setMinWidth(108);
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

        System.out.println("got over column assembly");
        //------------------------------------- CARDS_START -------------------------------------//
        System.out.println("cards start");
        //Card1
        System.out.println(c.getCurrentPlayer().getHand().get(0).getImage());
        Image stream1 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(0).getImage())); //
        System.out.println("asd2");
        this.imageView1 = new ImageView(stream1); //new ImageView(stream);  
        imageView1.setFitHeight(150);
        imageView1.setFitWidth(100);
        String imagePath1 =c.getCurrentPlayer().getHand().get(0).getImage().toString();
        System.out.println(imagePath1);
        imageView1.setId(imagePath1);
        //Card2 
        Image stream2 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(1).getImage())); 
        ImageView imageView2 = new ImageView(stream2);
        imageView2.setFitHeight(150);
        imageView2.setFitWidth(100);
        String imagePath2 =c.getCurrentPlayer().getHand().get(1).getImage().toString();
        imageView2.setId(imagePath2);
        // Card3
        Image stream3 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(2).getImage())); 
        ImageView imageView3 = new ImageView(stream3);
        imageView3.setFitHeight(150);
        imageView3.setFitWidth(100);
        String imagePath3 =c.getCurrentPlayer().getHand().get(2).getImage().toString();
        imageView3.setId(imagePath3);
        //Card4
        Image stream4 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(3).getImage())); //new FileInputStream("file:src/main/resources/Cards/left_turn.png"));
        ImageView imageView4 = new ImageView(stream4);
        imageView4.setFitHeight(150);
        imageView4.setFitWidth(100);
        String imagePath4 =c.getCurrentPlayer().getHand().get(3).getImage().toString();
        imageView4.setId(imagePath4);
        //Card5
        Image stream5 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(4).getImage())); 
        ImageView imageView5 = new ImageView(stream5);
        imageView5.setFitHeight(150);
        imageView5.setFitWidth(100);
        String imagePath5 =c.getCurrentPlayer().getHand().get(4).getImage().toString();
        imageView5.setId(imagePath5);
        //Card6
        Image stream6 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(5).getImage()));
        ImageView imageView6 = new ImageView(stream6);
        imageView6.setFitHeight(150);
        imageView6.setFitWidth(100);
        String imagePath6 =c.getCurrentPlayer().getHand().get(5).getImage().toString();
        imageView6.setId(imagePath6);
        //Card7
        Image stream7 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(6).getImage()));
        ImageView imageView7 = new ImageView(stream7);
        imageView7.setFitHeight(150);
        imageView7.setFitWidth(100);
        String imagePath7 =c.getCurrentPlayer().getHand().get(6).getImage().toString();
        imageView7.setId(imagePath7);
        //Card8
        Image stream8 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(7).getImage()));
        ImageView imageView8 = new ImageView(stream8);
        imageView8.setFitHeight(150);
        imageView8.setFitWidth(100);
        String imagePath8 =c.getCurrentPlayer().getHand().get(7).getImage().toString();
        imageView8.setId(imagePath8);
        //Card9
        Image stream9 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(c.getCurrentPlayer().getHand().get(8).getImage()));
        ImageView imageView9 = new ImageView(stream9);
        imageView9.setFitHeight(150);
        imageView9.setFitWidth(100);
        String imagePath9 =c.getCurrentPlayer().getHand().get(8).getImage().toString();
        imageView9.setId(imagePath9);


        //Displaying Cards
        Text HandName = new Text("HAND");
        mainGrid.add(HandName, 3, 0, 2, 1);

        mainGrid.add(imageView1, 3,0,1,1);
        mainGrid.add(imageView2, 3,1,1,1);
        mainGrid.add(imageView3, 3,2,1,1);
        mainGrid.add(imageView4, 3,3,1,1);
        mainGrid.add(imageView5, 3,4,1,1);
        mainGrid.add(imageView6, 2,0,1,1);
        mainGrid.add(imageView7, 2,1,1,1);
        mainGrid.add(imageView8, 2,2,1,1);
        mainGrid.add(imageView9, 2,3,1,1);

        //Make cards draggable
        mainGrid.getChildren().forEach(this::makeDraggable);
        // mainGrid.add(c.getBoard(),1, 0, 1, 5);
        
        // Draw board
        bd = new BoardDrawer(c.getBoard());
        bd.draw();
        
        mainGrid.add(bd, 1, 0, 1, 5);

        //------------------------------------- CARDS_END -------------------------------------//

        //------------------------------------- REGISTER_BOXES_START -------------------------------------//
        
        //Frame 1
        this.frame = new Rectangle(100,150);
        frame.setStroke(Color.BLACK);
        frame.setStrokeWidth(8);
        frame.setFill(null);
        this.button = new Button("Remove 1");
        button.setOnAction(e->buttonMethod(store1, frame));
        button.setPrefWidth(108);
        button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        this.leftBox1 = new VBox(frame,button);
        mainGrid.add(leftBox1, 0, 0, 1, 1);
        //Frame 2
        this.frame2 = new Rectangle(100,150);
        frame2.setStroke(Color.BLACK);
        frame2.setStrokeWidth(8);
        frame2.setFill(null);
        this.button= new Button("Remove 2");
        button.setOnAction(e->buttonMethod(store2,frame2));
        button.setPrefWidth(108);
        button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        this.leftBox2 = new VBox(frame2,button);
        mainGrid.add(leftBox2, 0, 1, 1, 1); 
        //Frame 3
        this.frame3 = new Rectangle(100,150);
        frame3.setStroke(Color.BLACK);
        frame3.setStrokeWidth(8);
        frame3.setFill(null);
        this.button = new Button("Remove 3");
        button.setOnAction(e->buttonMethod(store3, frame3));
        button.setPrefWidth(108);
        button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        this.leftBox3 = new VBox(frame3,button);
        mainGrid.add(leftBox3, 0, 2, 1, 1);
        //Frame 4
        this.frame4 = new Rectangle(100,150);
        frame4.setStroke(Color.BLACK);
        frame4.setFill(null);
        frame4.setStrokeWidth(8);
        this.button= new Button("Remove 4");
        button.setOnAction(e->buttonMethod(store4,frame4));
        button.setPrefWidth(108);
        button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        this.leftBox4 = new VBox(frame4,button);
        mainGrid.add(leftBox4, 0, 3, 1, 1);
        //Frame 5
        this.frame5 = new Rectangle(100,150);
        frame5.setStroke(Color.BLACK);
        frame5.setFill(null);
        frame5.setStrokeWidth(8);
        this.button= new Button("Remove 5");
        button.setOnAction(e->buttonMethod(store5,frame5));
        button.setPrefWidth(108);
        button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        this.leftBox5 = new VBox(frame5,button);
        mainGrid.add(leftBox5, 0, 4, 1, 1);

        //Finish Button
        this.button = new Button("Ready");
        button.setPrefWidth(670);
        this.buttonBox = new VBox(button);
        button.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        mainGrid.add(buttonBox, 1, 6, 1, 1);
        button.setOnAction(e->DoneButton());

        //------------------------------------- REGISTER_BOXES_END -------------------------------------//
    }

    // Observer method
    public void updateRobotInfo(Robot robot) {
        Platform.runLater(() -> {
            bd.drawRobot(robot);
        });
        
    }

    
    //------------------------------------- EVENTS_START -------------------------------------//
    private void makeDraggable (Node node){
        // (1) Mouse Pressed
        node.setOnMousePressed(e->{
            node.toFront();
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
            if (leftBox1.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame.getFill()==null){
                    node.setVisible(false);
                    frame.setFill(new ImagePattern(new Image (node.getId()) ));
                    frame.setId(node.getId());
                    this.store1 = node;
                    node.toBack();
                } 
                else {
                    node.setVisible(false);
                    store1.setVisible(true);
                    store1.setTranslateX(0);
                    store1.setTranslateY(0);
                    frame.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store1 = node;
                    frame.setId(node.getId());
                }
            }          
            if (leftBox2.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame2.getFill()==null){
                    node.setVisible(false);
                    frame2.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store2 = node;
                    frame2.setId(node.getId());


                } 
                else {
                    node.setVisible(false);
                    store2.setVisible(true);
                    store2.setTranslateX(0);
                    store2.setTranslateY(0);
                    frame2.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store2 = node;
                    frame2.setId(node.getId());
                }
            }
            if (leftBox3.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame3.getFill()==null){
                    node.setVisible(false);
                    frame3.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store3 = node;
                    frame3.setId(node.getId());
                } 
                else {
                    node.setVisible(false);
                    store3.setVisible(true);
                    store3.setTranslateX(0);
                    store3.setTranslateY(0);
                    frame3.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store3 = node;
                    frame3.setId(node.getId());
                }
                
                            // System.out.println("we are now in box 3");
                            // frame3.setFill(new ImagePattern(new Image (node.getId()) ));
            }
            if (leftBox4.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame4.getFill() == null){
                    node.setVisible(false);
                    frame4.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store4 = node;
                    frame4.setId(node.getId());
                    
                } 
                else {
                    node.setVisible(false);
                    store4.setVisible(true);
                    store4.setTranslateX(0);
                    store4.setTranslateY(0);
                    frame4.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store4 = node;
                    frame4.setId(node.getId());
                }
            }
            if (leftBox5.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
                if (frame5.getFill()==null){
                    node.setVisible(false);
                    frame5.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store5 = node;
                    frame5.setId(node.getId());
                } 
                else {
                    node.setVisible(false);
                    store5.setVisible(true);
                    store5.setTranslateX(0);
                    store5.setTranslateY(0);
                    frame5.setFill(new ImagePattern(new Image (node.getId()) ));
                    this.store5 = node;
                    frame5.setId(node.getId());
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
        frame.setFill(null);
        frame.setId(null);
        store.setVisible(true);
        store.setTranslateX(0);
        store.setTranslateY(0);
    };


    private ProgramCard findCard(String cardId){
        // For loop
        for (int j = 0; j < 9; j++) {
            ProgramCard card = c.getCurrentPlayer().getHand().get(j);
            if (card.getImage().equals(cardId)){
                return card;
            }
        }
        return null;
    }

    private void DoneButton (){
        if (frame.getFill()!=null){
            ProgramCard card  = findCard(frame.getId());
            c.getCurrentPlayer().getRobot().AddToRegister(card);   
        }
        if (frame2.getFill()!=null){
            ProgramCard card  = findCard(frame2.getId());
            c.getCurrentPlayer().getRobot().AddToRegister(card);   
        }
        if (frame3.getFill()!=null){
            ProgramCard card  = findCard(frame3.getId());
            c.getCurrentPlayer().getRobot().AddToRegister(card);  
        }
        if (frame4.getFill()!=null){
            ProgramCard card  = findCard(frame4.getId());
            c.getCurrentPlayer().getRobot().AddToRegister(card);  
        }
        if (frame5.getFill()!=null){
            ProgramCard card  = findCard(frame5.getId());
            c.getCurrentPlayer().getRobot().AddToRegister(card);  
        }

        c.getBoardScene().redraw();
        c.getCurrentPlayer().getHand().clear();
        c.setTheScene(c.getBoardScene());
        c.notifyAllRobotObservers();
    }
}

