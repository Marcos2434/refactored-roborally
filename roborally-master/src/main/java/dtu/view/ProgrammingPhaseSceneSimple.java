package dtu.view;

import dtu.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import dtu.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import dtu.logic.models.Position;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Cards.Deck;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import javafx.collections.FXCollections;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class ProgrammingPhaseSceneSimple extends Scene {
    Controller c;
    
    Player player1;
    Robot robot1;
    Deck deck;

    

    // player1 = new Player

    // Player player1;
    // this.player1 = new Player(new Robot(Color.BLUE,new Position(2,2)),"Player1");
    
    
    public ProgrammingPhaseSceneSimple (Controller c) {
        super(new BorderPane());
        this.robot1 = new Robot(RobotColor.BLUE,new Position(2,2));
        this.player1 = new Player(robot1,"Player1");
        player1.GenerateDeck();
        this.deck = player1.getDeck();
        deck.shuffleDeck(deck.cards);
        player1.drawProgrammingCards();
        this.initialize();
        this.c = c;
        
    }
    private void initialize(){
        BorderPane progBorderPane = (BorderPane) this.getRoot();
        String[] choices = {"1","2","3","4","5","6","7","8","9"};
    
        progBorderPane.setPrefSize(500, 500);


        //Create the template for view 
        
    




    // //////OLI/GLEBBBBB CODE  
        //REGISTER
        Text registerTitle= new Text("Register");
            //Register1
        Text register1Title=new Text("Card1");
        Button register1Card= new Button("Card");
        register1Card.setPrefSize(87, 100);
        ChoiceBox register1CardBox = new ChoiceBox(FXCollections.observableArrayList(choices));
        VBox register1 = new VBox(register1Title,register1Card,register1CardBox);
            //Register2
        Text register2Title=new Text("Card2");
        Button register2Card= new Button("Card");
        register2Card.setPrefSize(87, 100);
        ChoiceBox register2CardBox = new ChoiceBox(FXCollections.observableArrayList(choices));
        VBox register2 = new VBox(register2Title,register2Card,register2CardBox);
            //Register3
        Text register3Title=new Text("Card3");
        Button register3Card= new Button("Card");
        register3Card.setPrefSize(87, 100);
        ChoiceBox register3CardBox = new ChoiceBox(FXCollections.observableArrayList(choices));
        VBox register3 = new VBox(register3Title,register3Card,register3CardBox);
            //Register4
        Text register4Title=new Text("Card4");
        Button register4Card= new Button("Card");
        register4Card.setPrefSize(87, 100);
        ChoiceBox register4CardBox = new ChoiceBox(FXCollections.observableArrayList(choices));
        VBox register4 = new VBox(register4Title,register4Card,register4CardBox);
            //Register5
        Text register5Title=new Text("Card5");
        Button register5Card= new Button("Card");
        register5Card.setPrefSize(87, 100);
        ChoiceBox register5CardBox = new ChoiceBox(FXCollections.observableArrayList(choices));
        VBox register5 = new VBox(register5Title,register5Card,register5CardBox);


        register1CardBox.setPrefWidth(87);
        register2CardBox.setPrefWidth(87);        
        register3CardBox.setPrefWidth(87);
        register4CardBox.setPrefWidth(87);
        register5CardBox.setPrefWidth(87);
        VBox registers = new VBox(registerTitle,register1,register2,register3,register4,register5);
        progBorderPane.setLeft(registers);
        
        
        //HAND
        Text handTitle = new Text("HAAAAND");





        Text card1Title = new Text("1");
        Button card1= new Button("card 1/9");
        card1.setPrefSize(87, 100);
        
        Image stream = new Image (ProgrammingPhaseScene.class.getClassLoader().getResourceAsStream(player1.getHand().get(0).imagePath)); //new FileInputStream("file:src/main/resources/Cards/left_turn.png")); 
        ImageView imageView1 = new ImageView(stream);    
        //player1.getHand().get(0).imagePath
        // //Creating the image view
        // ImageView imageView = new ImageView();
        // //Setting image to the image view
        // imageView.setImage(image);

        //hand1 = player1.getHand(0);
        // Image hand1Image = new Image(new FileInputStream(""));
        CheckBox CheckCard1 = new CheckBox();
        HBox vbox1 = new HBox(card1Title, imageView1, card1, CheckCard1);
        vbox1.setPrefSize(125, 125);
        vbox1.setSpacing(10);
        




        Text card2Title = new Text("2");

        Button card2= new Button("card 2/9");
        card2.setPrefSize(87, 100);
        CheckBox CheckCard2 = new CheckBox();
        HBox vbox2 = new HBox(card2Title, CheckCard2);
        vbox2.setPrefSize(125, 125);
        vbox2.setSpacing(10);

        Text card3Title = new Text("3");
        Button card3= new Button("card 3/9");
        card3.setPrefSize(87, 100);
        CheckBox CheckCard3 = new CheckBox();
        HBox vbox3 = new HBox(card3Title, CheckCard3);
        vbox3.setPrefSize(125, 125);
        vbox3.setSpacing(10);

        Text card4Title = new Text("4");
        Button card4= new Button("card 4/9");
        card4.setPrefSize(87, 100);
        CheckBox CheckCard4 = new CheckBox();
        HBox vbox4 = new HBox(card4Title, CheckCard4);
        vbox4.setPrefSize(125, 125);
        vbox4.setSpacing(10);

        
        


        VBox Hand = new VBox(handTitle, vbox1, vbox2);
        Hand.setStyle("-fx-border-color: black;");
        Hand.setPrefSize(125, 200);
        Hand.setSpacing(10);
        Hand.setPadding(new Insets(15));
        

        progBorderPane.setRight(Hand);
        
        
    }   
}
