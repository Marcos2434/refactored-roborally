package dtu.view;

import dtu.controller.Controller;
import dtu.logic.models.RobotColor;
import dtu.logic.models.Player.Player;
import dtu.logic.models.Robot.Robot;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;


public class MenuScene extends Scene {

    Controller c;

    public MenuScene(Controller c) {
        super(new BorderPane());
        this.c = c;
        this.initialize();
    }

    private void initialize() {
        // BorderPane menu = new BorderPane();

		// Image background = new Image (("playermat/menubackground.png"));
        // BackgroundImage background2 = new BackgroundImage(background, null, null, null, null);
        // Background background3 = new Background(background2);
        

        

        //Set backround to the whole scene 
        
        BorderPane menu = (BorderPane) this.getRoot();
		// menu.setBackground(background3);
		menu.setPrefSize(500, 500);

		// RED
		Text r = new Text("RED");
		TextField red= new TextField();
		red.setPromptText("Player Name");
		CheckBox CheckRed = new CheckBox("Is red playing?");
		CheckBox AIRed = new CheckBox("Is AI?");
		VBox vboxRED = new VBox(r,red,CheckRed,AIRed);
		vboxRED.setPrefSize(125, 200);
		
		//BLUE
		Text b = new Text("BLUE");
		TextField blue= new TextField();
		blue.setPromptText("Player Name");
		CheckBox CheckBlue = new CheckBox("Is blue playing?");
		CheckBox AIBlue = new CheckBox("Is AI?");
		VBox vboxBLUE = new VBox(b,blue,CheckBlue,AIBlue);
		vboxBLUE.setPrefSize(125, 200);
	
		//GREEN
		Text g = new Text("GREEN");
		TextField green= new TextField();
		green.setPromptText("Player Name");
		CheckBox CheckGreen = new CheckBox("Is green playing?");
		CheckBox AIGreen = new CheckBox("Is AI?");
		VBox vboxGREEN = new VBox(g,green,CheckGreen,AIGreen);
		vboxGREEN.setPrefSize(125, 200);

		//YELLOW
		Text y = new Text("YELLOW");
		TextField yellow= new TextField();
		yellow.setPromptText("Player Name");
		CheckBox CheckYellow = new CheckBox("Is yellow playing?");
		CheckBox AIYellow = new CheckBox("Is AI?");
		VBox vboxYELLOW = new VBox(y,yellow,CheckYellow,AIYellow);
		vboxYELLOW.setPrefSize(125, 200);
		
		
		HBox RGB1 = new HBox(vboxRED,vboxBLUE, vboxGREEN, vboxYELLOW);

		//ORANGE
		Text o = new Text("ORANGE");
		TextField orange= new TextField();
		orange.setPromptText("Player Name");
		CheckBox CheckOrange = new CheckBox("Is orange playing?");
		CheckBox AIOrange = new CheckBox("Is AI?");
		VBox vboxORANGE = new VBox(o,orange,CheckOrange,AIOrange);
		vboxORANGE.setPrefSize(125, 200);

		//PURPLE
		Text p = new Text("PURPLE");
		TextField purple= new TextField();
		purple.setPromptText("Player Name");
		CheckBox CheckPurple = new CheckBox("Is purple playing?");
		CheckBox AIPurple = new CheckBox("Is AI?");
		VBox vboxPURPLE = new VBox(p,purple,CheckPurple, AIPurple);
		vboxPURPLE.setPrefSize(125, 200);

		//WHITE
		Text w = new Text("WHITE");
		TextField white= new TextField();
		white.setPromptText("Player Name");
		CheckBox CheckWhite = new CheckBox("Is white playing?");
		CheckBox AIWhite = new CheckBox("Is AI?");
		VBox vboxWHITE = new VBox(w,white,CheckWhite,AIWhite);
		vboxWHITE.setPrefSize(125, 200);

		//BLACK
		Text bl = new Text("BLACK");
		TextField black= new TextField();
		black.setPromptText("Player Name");
		CheckBox CheckBlack = new CheckBox("Is black playing?");
		CheckBox AIBlack = new CheckBox("Is AI?");
		VBox vboxBLACK = new VBox(bl,black,CheckBlack,AIBlack);
		vboxBLACK.setPrefSize(125, 200);

		HBox RGB2 = new HBox(vboxORANGE,vboxPURPLE, vboxWHITE, vboxBLACK);


		VBox RGB = new VBox(RGB1,RGB2);
		
		// Tuple<Text,Boolean>[] checkarray = {(r,CheckRed.isSelected())};
		CheckBox[] checkarray = {CheckRed,CheckBlue,CheckGreen,CheckYellow,CheckOrange,CheckPurple,CheckWhite,CheckBlack};
        Button createPlayerButton = new Button();
        createPlayerButton.setText("Start Game");
        createPlayerButton.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
				// For loop going through all checkboxes
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
        });
			

		menu.setLeft(RGB);
        menu.setBottom(createPlayerButton);
        
    }
}
