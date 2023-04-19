package dtu.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import dtu.controller.*;
import dtu.logic.models.Board.Board;
import dtu.logic.models.Robot.Robot;
import dtu.roborally.view.widgets.ControlPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dtu.logic.models.Color;
import dtu.logic.models.Position;

import java.io.IOException;

//import dtu.logic.Main;
class Tuple<A, B> {
    private A first;
    private B second;

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

public class View extends Application {
	void launchBoard(Stage primaryStage)throws Exception{
		BorderPane menu = new BorderPane();

		String[][] board1 = {
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","WT 1","WT 4","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","C 1","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","C 3","T"},
            {"C 2","T","HT","T","T","T","T","T","T","T"},
            {"T","T","HT","T","T","T","T","T","T","T"},
            //Start Field
            {"T","T","T","T","WT 1","WT 1","T","T","T","T"},
            {"T","S","WT 4","T","S","S","T","WT 2","S","T"},
            {"T","T","T","S","T","T","S","T","T","T"},
        };

        Board board = new Board(board1);
		Robot robot = new Robot(Color.BLUE, new Position(3, 12), board);
		
		ControlPanel cp = new ControlPanel(board, robot);
		menu.setCenter(board);
		menu.setBottom(cp);
		
		
		Scene s = new Scene(menu);
		
		primaryStage.setScene(s);
		primaryStage.setTitle("Tylko jedno w głowie mam");
		primaryStage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Create controller
		Controller c = new Controller();
		// Launch controller
		c.launch(); // create board... etc.
		
		// Ex. Tell controller to move robot

		BorderPane menu = new BorderPane();
		
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
							//For loop going through all checkboxes
							for(int i = 0; i < checkarray.length; i++){
								if (checkarray[i].isSelected()){
									if (checkarray[i].getText().contains("red")){
										if (red.getText().isEmpty()){
											red.setText("RED");
										}
										c.createPlayer((Color.RED), red.getText());
									}
									if (checkarray[i].getText().contains("blue")){
										if (blue.getText().isEmpty()){
											blue.setText("BLUE");
										}
										c.createPlayer((Color.BLUE), blue.getText());
									}
									if (checkarray[i].getText().contains("green")){
										if (green.getText().isEmpty()){
											green.setText("GREEN");
										}
										c.createPlayer((Color.GREEN), green.getText());
									}
									if (checkarray[i].getText().contains("yellow")){
										if (yellow.getText().isEmpty()){
											yellow.setText("YELLOW");
										}
										c.createPlayer((Color.YELLOW), yellow.getText());
									}
									if (checkarray[i].getText().contains("orange")){
										if (orange.getText().isEmpty()){
											orange.setText("ORANGE");
										}
										c.createPlayer((Color.ORANGE), orange.getText());
									}
									if (checkarray[i].getText().contains("purple")){
										if (purple.getText().isEmpty()){
											purple.setText("PURPLE");
										}
										c.createPlayer((Color.PURPLE), purple.getText());
									}
									if (checkarray[i].getText().contains("white")){
										if (white.getText().isEmpty()){
											white.setText("WHITE");
										}
										c.createPlayer((Color.WHITE), white.getText());
									}
									if (checkarray[i].getText().contains("black")){
										if (black.getText().isEmpty()){
											black.setText("BLACK");
										}
										c.createPlayer((Color.BLACK), black.getText());
									}
								}
																
								// c.createPlayer(colorChoice.getValue().toString());
                // c.getP().getRobot().registerObserver(rv);
                // System.out.println("Player created:" + colorChoice.getValue().toString());
            }
          }
        }
		);


		menu.setLeft(RGB);
        menu.setBottom(createPlayerButton);


		Scene s = new Scene(menu);
		BorderPane cards = new BorderPane();
		Scene s1 = new Scene(cards);
		primaryStage.setScene(s);
		primaryStage.setTitle("RoboRally - v. 0.1 - Papers, please");
		primaryStage.show();


		// Show game screen (board)
		

	}
	

	

	public static void main(String[] args) {
		// Launch GUI
		launch(args);
	}
}
