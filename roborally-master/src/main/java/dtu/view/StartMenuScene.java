package dtu.view;

import dtu.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.VBox;

public class StartMenuScene extends Scene {
    private Controller c;

    public StartMenuScene(Controller c){
        super(new BorderPane(), 400, 300);
        this.c = c;

        // Create the three buttons
        Button hostButton = new Button("Host");
        hostButton.setPadding(new Insets(10,30,10,30));
        Button joinButton = new Button("Join");
        joinButton.setPadding(new Insets(10,30,10,30));
        Button localButton = new Button("Local");
        localButton .setPadding(new Insets(10,30,10,30));
        
        


        // Set the font and style of the buttons
        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        hostButton.setFont(buttonFont);
        joinButton.setFont(buttonFont);
        localButton.setFont(buttonFont);
        hostButton.setStyle("-fx-background-color: linear-gradient(to bottom, #bdc3c7, #2c3e50); -fx-text-fill: white;");
        joinButton.setStyle("-fx-background-color: linear-gradient(to bottom, #bdc3c7, #2c3e50); -fx-text-fill: white;");
        localButton.setStyle("-fx-background-color: linear-gradient(to bottom, #bdc3c7, #2c3e50); -fx-text-fill: white;");

        // Stack the buttons vertically in a centered StackPane
        
        VBox vbox = new VBox(hostButton,joinButton,localButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        // Set the background color of the scene
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#bdc3c7"), null, null);
        Background background = new Background(backgroundFill);

        // Set the background color of the BorderPane
        BorderPane borderPane = (BorderPane) this.getRoot();

        borderPane.setBackground(background);
        borderPane.setCenter(vbox);
        
    }
}