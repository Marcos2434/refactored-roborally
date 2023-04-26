package dtu.view;

import dtu.controller.Controller;
import dtu.logic.models.RobotColor;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class MenuScene extends Scene {

    Controller c;

    public MenuScene(Controller c) {
        super(new BorderPane());
        this.c = c;
        this.initialize();
    }

    private void initialize() {
        // BorderPane menu = new BorderPane();
        BorderPane menu = (BorderPane) this.getRoot();
		
		menu.setPrefSize(500, 500);
        RobotViewer rv = new RobotViewer();

		// RED
		Text r = new Text("RED");
		TextField red= new TextField();
		red.setPromptText("Player Name");
		CheckBox CheckRed = new CheckBox("Is red playing");
		VBox vboxRED = new VBox(r,red,CheckRed);
		vboxRED.setPrefSize(125, 200);
		
		//BLUE
		Text b = new Text("BLUE");
		TextField blue= new TextField();
		blue.setPromptText("Player Name");
		CheckBox CheckBlue = new CheckBox("Is blue playing");
		VBox vboxBLUE = new VBox(b,blue,CheckBlue);
		vboxBLUE.setPrefSize(125, 200);
	
		//GREEN
		Text g = new Text("GREEN");
		TextField green= new TextField();
		green.setPromptText("Player Name");
		CheckBox CheckGreen = new CheckBox("Is green playing");
		VBox vboxGREEN = new VBox(g,green,CheckGreen);
		vboxGREEN.setPrefSize(125, 200);

		//YELLOW
		Text y = new Text("YELLOW");
		TextField yellow= new TextField();
		yellow.setPromptText("Player Name");
		CheckBox CheckYellow = new CheckBox("Is yellow playing");
		VBox vboxYELLOW = new VBox(y,yellow,CheckYellow);
		vboxYELLOW.setPrefSize(125, 200);
		
		
		HBox RGB1 = new HBox(vboxRED,vboxBLUE, vboxGREEN, vboxYELLOW);

		//ORANGE
		Text o = new Text("ORANGE");
		TextField orange= new TextField();
		orange.setPromptText("Player Name");
		CheckBox CheckOrange = new CheckBox("Is orange playing");
		VBox vboxORANGE = new VBox(o,orange,CheckOrange);
		vboxORANGE.setPrefSize(125, 200);

		//PURPLE
		Text p = new Text("PURPLE");
		TextField purple= new TextField();
		purple.setPromptText("Player Name");
		CheckBox CheckPurple = new CheckBox("Is purple playing");
		VBox vboxPURPLE = new VBox(p,purple,CheckPurple);
		vboxPURPLE.setPrefSize(125, 200);

		//WHITE
		Text w = new Text("WHITE");
		TextField white= new TextField();
		white.setPromptText("Player Name");
		CheckBox CheckWhite = new CheckBox("Is white playing");
		VBox vboxWHITE = new VBox(w,white,CheckWhite);
		vboxWHITE.setPrefSize(125, 200);

		//BLACK
		Text bl = new Text("BLACK");
		TextField black= new TextField();
		black.setPromptText("Player Name");
		CheckBox CheckBlack = new CheckBox("Is black playing");
		VBox vboxBLACK = new VBox(bl,black,CheckBlack);
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
										if (red.getText().isEmpty()){
											red.setText("RED");
										}
										c.createPlayer((RobotColor.RED), red.getText());
									}
									if (checkarray[i].getText().contains("blue")){
										if (blue.getText().isEmpty()){
											blue.setText("BLUE");
										}
										c.createPlayer((RobotColor.BLUE), blue.getText());
									}
									if (checkarray[i].getText().contains("green")){
										if (green.getText().isEmpty()){
											green.setText("GREEN");
										}
										c.createPlayer((RobotColor.GREEN), green.getText());
									}
									if (checkarray[i].getText().contains("yellow")){
										if (yellow.getText().isEmpty()){
											yellow.setText("YELLOW");
										}
										c.createPlayer((RobotColor.YELLOW), yellow.getText());
									}
									if (checkarray[i].getText().contains("orange")){
										if (orange.getText().isEmpty()){
											orange.setText("ORANGE");
										}
										c.createPlayer((RobotColor.ORANGE), orange.getText());
									}
									if (checkarray[i].getText().contains("purple")){
										if (purple.getText().isEmpty()){
											purple.setText("PURPLE");
										}
										c.createPlayer((RobotColor.PURPLE), purple.getText());
									}
									if (checkarray[i].getText().contains("white")){
										if (white.getText().isEmpty()){
											white.setText("WHITE");
										}
										c.createPlayer((RobotColor.WHITE), white.getText());
									}
									if (checkarray[i].getText().contains("black")){
										if (black.getText().isEmpty()){
											black.setText("BLACK");
										}
										c.createPlayer((RobotColor.BLACK), black.getText());
										
									}

								}
						
								// this.c.createPlayer(RobotcolorChoice.getValue().toString());
                // this.c.getP().getRobot().registerObserver(rv);
                // System.out.println("Player created:" + RobotcolorChoice.getValue().toString());
            }
			c.changeToBoardScene();	
          }
        }
		);
			

		menu.setLeft(RGB);
        menu.setBottom(createPlayerButton);
        
    }
}
