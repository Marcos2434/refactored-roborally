
package dtu.view;

import dtu.controller.Controller;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import dtu.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import javafx.scene.control.ChoiceBox;

public class MenuScene extends Scene {

  	private Controller c;

    public MenuScene(Controller c) {
        super(new BorderPane());
        this.c = c;
        this.initialize();
    }

    private void initialize() {
        // BorderPane menu = new BorderPane();

		Image background = new Image(("playermat/menubackground1.png"));
        BackgroundImage background2 = new BackgroundImage(background, null, null, null, null);
        Background background3 = new Background(background2);
        


        //Set backround to the whole scene 
        
        BorderPane menu = (BorderPane) this.getRoot();
		menu.setBackground(background3);
		menu.setPrefSize(500, 500);

		// RED
		//Text r = new Text("RED");
		TextField red= new TextField();
		red.setPromptText("Player Name");
		red.setStyle("-fx-background-color: #ff3333;");
		ChoiceBox ChoiceRed= new ChoiceBox();
		ChoiceRed.getItems().add("--");
		ChoiceRed.getItems().add("Player");
		ChoiceRed.getItems().add("AI");
		ChoiceRed.setValue("--");
		VBox vboxRED = new VBox(red,ChoiceRed);    
		vboxRED.setPrefSize(125, 70);
		
		//BLUE
		//Text b = new Text("BLUE");
		TextField blue= new TextField();
		blue.setPromptText("Player Name");
		blue.setStyle("-fx-background-color: #80e5ff;");
		ChoiceBox ChoiceBlue= new ChoiceBox();
		ChoiceBlue.getItems().add("--");
		ChoiceBlue.getItems().add("Player");
		ChoiceBlue.getItems().add("AI");
		ChoiceBlue.setValue("--");
		VBox vboxBLUE = new VBox(blue,ChoiceBlue);
		vboxBLUE.setPrefSize(125, 70);
	
		//GREEN
		//Text g = new Text("GREEN");
		TextField green= new TextField();
		green.setPromptText("Player Name");
		green.setStyle("-fx-background-color: #66ff33;");
		ChoiceBox ChoiceGreen= new ChoiceBox();
		ChoiceGreen.getItems().add("--");
		ChoiceGreen.getItems().add("Player");
		ChoiceGreen.getItems().add("AI");
		ChoiceGreen.setValue("--");
		VBox vboxGREEN = new VBox(green, ChoiceGreen);
		vboxGREEN.setPrefSize(125, 70);

		//YELLOW
		//Text y = new Text("YELLOW");
		TextField yellow= new TextField();
		yellow.setPromptText("Player Name");
		yellow.setStyle("-fx-background-color: #ffff33;");
		ChoiceBox ChoiceYellow= new ChoiceBox();
		ChoiceYellow.getItems().add("--");
		ChoiceYellow.getItems().add("Player");
		ChoiceYellow.getItems().add("AI");
		ChoiceYellow.setValue("--");//
		VBox vboxYELLOW = new VBox(yellow,ChoiceYellow);
		vboxYELLOW.setPrefSize(125, 70);
		
		
		HBox RGB1 = new HBox(vboxRED,vboxBLUE, vboxGREEN, vboxYELLOW);

		//ORANGE
		//Text o = new Text("ORANGE");
		TextField orange= new TextField();
		orange.setPromptText("Player Name");
		orange.setStyle("-fx-background-color: #ff8533;");
		ChoiceBox ChoiceOrange= new ChoiceBox();
		ChoiceOrange.getItems().add("--");
		ChoiceOrange.getItems().add("Player");
		ChoiceOrange.getItems().add("AI");
		ChoiceOrange.setValue("--");//
		VBox vboxORANGE = new VBox(orange,ChoiceOrange);
		vboxORANGE.setPrefSize(125, 70);

		//PURPLE
		//Text p = new Text("PURPLE");
		TextField purple= new TextField();
		purple.setPromptText("Player Name");
		purple.setStyle("-fx-background-color: #9933ff;");
		ChoiceBox ChoicePurple= new ChoiceBox();
		ChoicePurple.getItems().add("--");
		ChoicePurple.getItems().add("Player");
		ChoicePurple.getItems().add("AI");
		ChoicePurple.setValue("--");//
		VBox vboxPURPLE = new VBox(purple,ChoicePurple);
		vboxPURPLE.setPrefSize(125, 70);

		//WHITE
		//Text w = new Text("WHITE");
		TextField white= new TextField();
		white.setPromptText("Player Name");
		white.setStyle("-fx-background-color: #ffffff;");
		ChoiceBox ChoiceWhite= new ChoiceBox();
		ChoiceWhite.getItems().add("--");
		ChoiceWhite.getItems().add("Player");
		ChoiceWhite.getItems().add("AI");
		ChoiceWhite.setValue("--");//
		VBox vboxWHITE = new VBox(white,ChoiceWhite);
		vboxWHITE.setPrefSize(125, 70);

		//BLACK
		//Text bl = new Text("BLACK");
		TextField black= new TextField();
		black.setPromptText("Player Name");
		black.setStyle("-fx-background-color: #262626;");
		ChoiceBox ChoiceBlack= new ChoiceBox();
		ChoiceBlack.getItems().add("--");
		ChoiceBlack.getItems().add("Player");
		ChoiceBlack.getItems().add("AI");
		ChoiceBlack.setValue("--");//
		VBox vboxBLACK = new VBox(black,ChoiceBlack);
		vboxBLACK.setPrefSize(125, 70);

		HBox RGB2 = new HBox(vboxORANGE,vboxPURPLE, vboxWHITE, vboxBLACK);
		Text note = new Text(" ");
		final ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.getItems().addAll(Map.getmapNames());
		comboBox.setValue("Select a Board");
	
		comboBox.setOnAction(event -> {
			
			String selectedOption = comboBox.getSelectionModel().getSelectedItem();
			
			int id =  Integer.parseInt(selectedOption.split(" ")[0]);
			c.setBoardSelecter(id);
		
			c.setBoard(new Board(Map.getMapById(id)));


			note.setText(" ");
		});
		Button createPlayerButton = new Button();
		
		createPlayerButton.setPrefWidth(300);
		createPlayerButton.setPrefHeight(50);
        createPlayerButton.setText("Start Game");

		
		VBox RGB = new VBox(RGB1,RGB2,comboBox,createPlayerButton,note);
		RGB.setAlignment(Pos.TOP_CENTER);
		VBox.setMargin(createPlayerButton, new Insets(0, 0, 10, 0));
		VBox.setMargin(comboBox, new Insets(30, 0, 200, 0));
		
        createPlayerButton.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
				// For loop going through all checkboxes
				if (c.getBoardSelecter() != 0){
					try {BoardScene boardScene = new BoardScene(c);
						c.setBoardScene(boardScene);}
					catch(Exception e){System.out.println(e);}
					
					if (ChoiceRed.getValue()=="Player"){
						
						c.createPlayer(RobotColor.RED,red.getText());
					}
					if (ChoiceRed.getValue()=="AI"){
						c.createAI(RobotColor.RED,red.getText());
					}
					if (ChoiceBlue.getValue()=="Player"){
						c.createPlayer(RobotColor.BLUE,blue.getText());
					}
					if (ChoiceBlue.getValue()=="AI"){
						c.createAI(RobotColor.BLUE, blue.getText());
					}
					if (ChoiceGreen.getValue()=="Player"){
						c.createPlayer(RobotColor.GREEN,green.getText());
					}
					if (ChoiceGreen.getValue()=="AI"){
						c.createAI(RobotColor.GREEN, green.getText());
					}
					if (ChoiceYellow.getValue()=="Player"){
						c.createPlayer(RobotColor.YELLOW,yellow.getText());
					}
					if (ChoiceYellow.getValue()=="AI"){
						c.createAI(RobotColor.YELLOW, yellow.getText());
					}
					if (ChoiceOrange.getValue()=="Player"){
						c.createPlayer(RobotColor.ORANGE,orange.getText());
					}
					if (ChoiceOrange.getValue()=="AI"){
						c.createAI(RobotColor.ORANGE, orange.getText());
					}
					if (ChoicePurple.getValue()=="Player"){
						c.createPlayer(RobotColor.PURPLE,purple.getText());
					}
					if (ChoicePurple.getValue()=="AI"){
						c.createAI(RobotColor.PURPLE, purple.getText());
					}
					if (ChoiceWhite.getValue()=="Player"){
						c.createPlayer(RobotColor.WHITE,white.getText());
					}
					if (ChoiceWhite.getValue()=="AI"){
						c.createAI(RobotColor.WHITE, white.getText());
					}
					if (ChoiceBlack.getValue()=="Player"){
						c.createPlayer(RobotColor.BLACK,black.getText());
					}
					if (ChoiceBlack.getValue()=="AI"){
						c.createAI(RobotColor.BLACK,black.getText());
					}
					c.getRealPlayers();
					c.getBoardController().registerBoardObserver(c.getBoardScene());
					c.changeToBoardScene();
					c.spawnRobots();
				}
				else {
					note.setText("Map has not been selected");   
				}
			}
			
			
        });
			

		menu.setLeft(RGB);
    
        
    }
}
