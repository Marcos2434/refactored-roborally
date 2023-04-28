
package dtu.view;

import dtu.controller.Controller;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import dtu.controller.Controller;//
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
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

    Controller c;

    public MenuScene(Controller c) {
        super(new BorderPane());
        this.c = c;
        this.initialize();
    }

    private void initialize() {
        // BorderPane menu = new BorderPane();

		Image background = new Image (("playermat/menubackground1.png"));
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
		CheckBox CheckRed = new CheckBox("Is red playing?");
		CheckRed.setStyle("-fx-Text-fill: #ffffff;");
		CheckBox AIRed = new CheckBox("Is AI?");
		AIRed.setStyle("-fx-Text-fill: #ffffff;");
		ChoiceBox ChoiceRed= new ChoiceBox();
		ChoiceRed.getItems().add("--");
		ChoiceRed.getItems().add("Player");
		ChoiceRed.getItems().add("AI");
		ChoiceRed.setValue("--");
		VBox vboxRED = new VBox(red,CheckRed,AIRed,ChoiceRed);    
		vboxRED.setPrefSize(125, 70);
		
		//BLUE
		//Text b = new Text("BLUE");
		TextField blue= new TextField();
		blue.setPromptText("Player Name");
		CheckBox CheckBlue = new CheckBox("Is blue playing?");
		CheckBlue.setStyle("-fx-Text-fill: #ffffff;");
		blue.setStyle("-fx-background-color: #80e5ff;");
		CheckBox AIBlue = new CheckBox("Is AI?");
		AIBlue.setStyle("-fx-Text-fill: #ffffff;");
		VBox vboxBLUE = new VBox(blue,CheckBlue,AIBlue);
		vboxBLUE.setPrefSize(125, 70);
	
		//GREEN
		//Text g = new Text("GREEN");
		TextField green= new TextField();
		green.setPromptText("Player Name");
		green.setStyle("-fx-background-color: #66ff33;");
		CheckBox CheckGreen = new CheckBox("Is green playing?");
		CheckGreen.setStyle("-fx-Text-fill: #ffffff;");
		CheckBox AIGreen = new CheckBox("Is AI?");
		AIGreen.setStyle("-fx-Text-fill: #ffffff;");
		VBox vboxGREEN = new VBox(green,CheckGreen,AIGreen);
		vboxGREEN.setPrefSize(125, 70);

		//YELLOW
		//Text y = new Text("YELLOW");
		TextField yellow= new TextField();
		yellow.setPromptText("Player Name");
		CheckBox CheckYellow = new CheckBox("Is yellow playing?");
		CheckYellow.setStyle("-fx-Text-fill: #ffffff;");
		yellow.setStyle("-fx-background-color: #ffff33;");
		CheckBox AIYellow = new CheckBox("Is AI?");
		AIYellow.setStyle("-fx-Text-fill: #ffffff;");//
		VBox vboxYELLOW = new VBox(yellow,CheckYellow,AIYellow);
		vboxYELLOW.setPrefSize(125, 70);
		
		
		HBox RGB1 = new HBox(vboxRED,vboxBLUE, vboxGREEN, vboxYELLOW);

		//ORANGE
		//Text o = new Text("ORANGE");
		TextField orange= new TextField();
		orange.setPromptText("Player Name");
		CheckBox CheckOrange = new CheckBox("Is orange playing?");
		CheckOrange.setStyle("-fx-Text-fill: #ffffff;");
		orange.setStyle("-fx-background-color: #ff8533;");
		CheckBox AIOrange = new CheckBox("Is AI?");
		AIOrange.setStyle("-fx-Text-fill: #ffffff;");
		VBox vboxORANGE = new VBox(orange,CheckOrange,AIOrange);
		vboxORANGE.setPrefSize(125, 70);

		//PURPLE
		//Text p = new Text("PURPLE");
		TextField purple= new TextField();
		purple.setPromptText("Player Name");
		purple.setStyle("-fx-background-color: #9933ff;");
		CheckBox CheckPurple = new CheckBox("Is purple playing?");
		CheckPurple.setStyle("-fx-Text-fill: #ffffff;");
		CheckBox AIPurple = new CheckBox("Is AI?");
		AIPurple.setStyle("-fx-Text-fill: #ffffff;");
		VBox vboxPURPLE = new VBox(purple,CheckPurple, AIPurple);
		vboxPURPLE.setPrefSize(125, 70);

		//WHITE
		//Text w = new Text("WHITE");
		TextField white= new TextField();
		white.setPromptText("Player Name");
		white.setStyle("-fx-background-color: #ffffff;");
		CheckBox CheckWhite = new CheckBox("Is white playing?");
		CheckWhite.setStyle("-fx-Text-fill: #ffffff;");
		CheckBox AIWhite = new CheckBox("Is AI?");
		AIWhite.setStyle("-fx-Text-fill: #ffffff;");
		VBox vboxWHITE = new VBox(white,CheckWhite,AIWhite);
		vboxWHITE.setPrefSize(125, 70);

		//BLACK
		//Text bl = new Text("BLACK");
		TextField black= new TextField();
		black.setPromptText("Player Name");
		black.setStyle("-fx-background-color: #262626;");
		CheckBox CheckBlack = new CheckBox("Is black playing?");
		CheckBlack.setStyle("-fx-Text-fill: #ffffff;");
		CheckBox AIBlack = new CheckBox("Is AI?");
		AIBlack.setStyle("-fx-Text-fill: #ffffff;");
		VBox vboxBLACK = new VBox(black,CheckBlack,AIBlack);
		vboxBLACK.setPrefSize(125, 70);

		HBox RGB2 = new HBox(vboxORANGE,vboxPURPLE, vboxWHITE, vboxBLACK);
		Text note = new Text(" ");
		final ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.getItems().addAll(Map.getmapNames());
		comboBox.setValue("Select a Board");
	
		comboBox.setOnAction(event -> {
			
			String selectedOption = comboBox.getSelectionModel().getSelectedItem();

			c.setBoardSelecter(selectedOption);
			c.setBoard(new Board(Map.getMapByName(selectedOption)));


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
		
		// Tuple<Text,Boolean>[] checkarray = {(r,CheckRed.isSelected())};
		CheckBox[] checkarray = {CheckRed,CheckBlue,CheckGreen,CheckYellow,CheckOrange,CheckPurple,CheckWhite,CheckBlack};
       
        createPlayerButton.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
				// For loop going through all checkboxes
				if (c.getBoardSelecter() != null){
					try {BoardScene boardScene = new BoardScene(c);
						c.setBoardScene(boardScene);}
					catch(Exception e){System.out.println(e);}
					
					for(int i = 0; i < checkarray.length; i++){
						if (checkarray[i].isSelected()){

							if (checkarray[i].getText().contains("red")){
								if (AIRed.isSelected()) {
									
									c.createAI(RobotColor.RED);
								}
								else{							
									if (red.getText().isEmpty()){
										red.setText("RED");
									}
									c.createPlayer((RobotColor.RED), red.getText());}

							}
							if (checkarray[i].getText().contains("blue")){
								if (AIBlue.isSelected()){
								c.createAI(RobotColor.BLUE);
							}
							else{
								if (blue.getText().isEmpty()){
										blue.setText("BLUE");
									}
									c.createPlayer((RobotColor.BLUE), blue.getText());
								}
	
						}
						if (checkarray[i].getText().contains("green")){
								if (AIGreen.isSelected()){
								c.createAI(RobotColor.GREEN);
							}
							else{
								if (green.getText().isEmpty()){
										green.setText("GREEN");
									}
									c.createPlayer((RobotColor.GREEN), green.getText());
								}
	
						}
						if (checkarray[i].getText().contains("yellow")){
								if (AIYellow.isSelected()){
								c.createAI(RobotColor.YELLOW);
							}
							else{
								if (yellow.getText().isEmpty()){
										yellow.setText("YELLOW");
									}
									c.createPlayer((RobotColor.YELLOW), yellow.getText());
								}
	
						}
						if (checkarray[i].getText().contains("orange")){
								if (AIOrange.isSelected()){
								c.createAI(RobotColor.ORANGE);;
								
							}
							else{
								if (orange.getText().isEmpty()){
										orange.setText("ORANGE");
									}
									c.createPlayer((RobotColor.ORANGE), orange.getText());
								}
	
						}
						if (checkarray[i].getText().contains("purple")){
								if (AIPurple.isSelected()){
								c.createAI(RobotColor.PURPLE);
							}
							else{
								if (purple.getText().isEmpty()){
									purple.setText("PURPLE");
									}
									c.createPlayer((RobotColor.PURPLE), purple.getText());
								}
							}
						if (checkarray[i].getText().contains("white")){
								if (AIWhite.isSelected()){
								c.createAI(RobotColor.WHITE);
							}
							else{
								if (white.getText().isEmpty()){
										white.setText("WHITE");
									}
									c.createPlayer((RobotColor.WHITE), white.getText());
								}
							}
						if (checkarray[i].getText().contains("black")){
								if (AIBlack.isSelected()){
								c.createAI(RobotColor.BLACK);
							}
							else{
								if (black.getText().isEmpty()){
										black.setText("BLACK");
									}
									c.createPlayer((RobotColor.BLACK), black.getText());
								}

							}
						}
					

						
					
					}
				c.getBoardScene().getControlPanel().addPlayerNamesToDropdown();
					c.changeToBoardScene();
					c.spawnRobots();
				}
				else{
					note.setText("Map has not been selected");   
				}
			}
			
			
        });
			

		menu.setLeft(RGB);
        //menu.setBottom(createPlayerButton);
        
    }
}
