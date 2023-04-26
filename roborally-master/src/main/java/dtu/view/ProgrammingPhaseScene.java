package dtu.view;

import dtu.controller.Controller;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.geometry.BoundingBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import dtu.logic.models.Position;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import javafx.scene.paint.Color;

    
public class ProgrammingPhaseScene extends Scene {
    Controller c;
    Player player1;
    Robot robot1;
    Deck deck;


    ColumnConstraints column1;
    ColumnConstraints column2;
    ColumnConstraints column3;
    ColumnConstraints column4;
    

    VBox leftBox1;
    VBox leftBox2;
    VBox leftBox3;
    VBox leftBox4;
    VBox leftBox5;

    
    public ProgrammingPhaseScene(Controller c) {
        super(new GridPane());
        this.robot1 = new Robot(RobotColor.BLUE,new Position(2,2));
        this.player1 = new Player(robot1,"Player1");
        player1.GenerateDeck();
        this.deck = player1.getDeck();
        deck.shuffleDeck();
        player1.drawProgrammingCards();
        this.initialize();
        this.c = c;
    }

    double sceneWidth;
    double sceneHeight;

    GridPane mainGrid;

    public void initialize() {
        this.mainGrid = (GridPane) this.getRoot();
        mainGrid.setGridLinesVisible( true );
        mainGrid.setPrefSize(1500, 1000);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(20);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(60);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(10);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(10);

   
        mainGrid.getColumnConstraints().addAll(column1, column2, column3, column4);
     
           
        

        // Card1
        Image stream = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(0).getImage())); //new FileInputStream("file:src/main/resources/Cards/left_turn.png")); 
        ImageView imageView1 = new ImageView(stream);  
        imageView1.setFitHeight(150);
        imageView1.setFitWidth(100);
        imageView1.setId("Card-0");
    
        //Card2 
        Image stream2 = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(1).getImage())); //new FileInputStream("file:src/main/resources/Cards/left_turn.png"));
        ImageView imageView2 = new ImageView(stream2);
        imageView2.setFitHeight(150);
        imageView2.setFitWidth(100);
    

        mainGrid.add(imageView1, 3, 0, 1, 1);
        mainGrid.add(imageView2, 3,1,1,1);
      
        
    

        mainGrid.getChildren().forEach(this::makeDraggable);

        //Frames for left boxes
        Rectangle frame = new Rectangle(100,150);
        frame.setStroke(Color.BLACK);
        frame.setFill(null);
        // this.leftBox1 = new VBox(frame);
        mainGrid.add(frame, 0, 0, 1, 1);

        // BoundingBox leftBox1 = new BoundingBox(0, 0, 100, 150);
        
        
        Rectangle frame2 = new Rectangle(100,150);
        frame2.setStroke(Color.RED);
        frame2.setFill(null);
        // this.leftBox2 = new VBox(frame2);
        mainGrid.add(frame2, 0, 1, 1, 1); 

        Rectangle frame3 = new Rectangle(100,150);
        frame3.setStroke(Color.BLUE);
        frame3.setFill(null);
        // this.leftBox3 = new VBox(frame3);
        mainGrid.add(frame3, 0, 2, 1, 1);

        Rectangle frame4 = new Rectangle(100,150);
        frame4.setStroke(Color.GREEN);
        frame4.setFill(null);
        // this.leftBox4 = new VBox(frame4);
        mainGrid.add(frame4, 0, 3, 1, 1);

        Rectangle frame5 = new Rectangle(100,150);
        frame5.setStroke(Color.PURPLE);
        frame5.setFill(null);
        // this.leftBox5 = new VBox(frame5);
        mainGrid.add(frame5, 0, 4, 1, 1);



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
            //go through all boxes and check if we released the mouse inside one of them
                // mainGrid.getChildren().get(0);
                
                System.out.println(mainGrid.getChildren().get(1).toString());
                if (mainGrid.getChildren().get(0).contains(e.getSceneX(), e.getSceneY())){
                    System.out.println("mainGrid get(1) box toggle");
                    // System.out.println(node.getId());
                    System.out.println(mainGrid.getChildren().toString());
                }
                if (mainGrid.getChildren().get(1).contains(e.getSceneX(), e.getSceneY())){
                    // System.out.println("mainGrid get(1) box toggle");
                    // System.out.println(node.getId());
                }
                if (mainGrid.getChildren().get(2).contains(e.getSceneX(), e.getSceneY())){
                    // System.out.println("mainGrid get(2) box toggle");
                    // System.out.println(node.getId());
                }
                if (mainGrid.getChildren().get(3).contains(e.getSceneX(), e.getSceneY())){
                    // System.out.println("mainGrid get(3) box toggle");
                    // System.out.println(node.getId());
                }
                if (mainGrid.getChildren().get(4).contains(e.getSceneX(), e.getSceneY())){
                    // System.out.println("mainGrid get(4) box toggle");
                    // System.out.println(node.getId());
                }
                if (mainGrid.getChildren().get(5).contains(e.getSceneX(), e.getSceneY())){
                    // System.out.println("mainGrid get(5) box toggle");
                    // System.out.println(node.getId());
                }
                if (mainGrid.getChildren().get(6).contains(e.getSceneX(), e.getSceneY())){
                    // System.out.println("mainGrid get(6) box toggle");
                    // System.out.println(node.getId());
                }
                if (mainGrid.getChildren().get(7).contains(e.getSceneX(), e.getSceneY())){
                    // System.out.println("mainGrid get(7) box toggle");
                    // System.out.println(node.getId());
                }



                // if (leftBox1.contains(e.getSceneX(), e.getSceneY())){
                //     System.out.println("entered if");
                //     System.out.println(node.getId());
                //     leftBox1.getChildren().add(node);
                //     System.out.println(leftBox1.getChildren());
                //     // leftBox1.removeChild(node);
                //     // leftBox1.getChildren().removeAll(leftBox1.getChildren());
                // }

                // //if we did, then we set the card to the center of the box
                // if (leftBox2.contains(e.getSceneX(), e.getSceneY())){
                //     System.out.println("entered if second one");
                //     System.out.println(node.getId());

                // }
                
                else {
                    // node.setTranslateX(-);
                    node.setLayoutY(startY);
                    System.out.print(startX);
                    //System.out.print(startY);
                }
        
        });
        // node.setOnMouseClicked(e->{
        //     if (leftBox1.contains(e.getSceneX(), e.getSceneY())){
        //         leftBox1.getChildren().clear();
        //   }
        // // node.setOnMouseReleased();   
            
        //  });
    }
}




//HOW TO GET NODE FROM GRIDPANE

// private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
//     for (Node node : gridPane.getChildren()) {
//         if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
//             return node;
//         }
//     }
//     return null;
// }