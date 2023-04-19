package dtu.view;

import dtu.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import dtu.controller.Controller;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import dtu.logic.models.Color;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgrammingPhaseScene extends Scene {
    Controller c;
    
    public ProgrammingPhaseScene (Controller c) {
        super(new GridPane());
        this.initialize();
        this.c = c;
    }
    // private void initialize(){
    //     BorderPane progBorderPane = (BorderPane) this.getRoot();

    //     progBorderPane.setPrefSize(500, 500);


        //Create the template for view 
        
    




    // //////OLI/GLEBBBBB CODE  
        //REGISTER
        // Text registerTitle= new Text("Register");
        

        // //HAND
        // Text handTitle = new Text("HAND");

        // Text card1Title = new Text("Card1");
        // CheckBox CheckCard1 = new CheckBox("Is card1 used");
        // VBox vbox1 = new VBox(card1Title, CheckCard1);
        // Text card2 = new Text("Second Card");
        // CheckBox CheckCard2 = new CheckBox("Is card2 used");
        // VBox vbox2 = new VBox(card2, CheckCard2);


        // VBox Hand = new VBox(handTitle, vbox1, vbox2);
        // Hand.setPrefSize(125, 200);

        // progBorderPane.setRight(Hand);

        

        
        // Text card10 = new VBox("First Card");
        // CheckBox CheckCard1 = new CheckBox("Is card1 used");
        

        


    
    //Testing drag and dropping 
    TextField sourceFld = new TextField("This is the Source Text");
    TextField targetFld = new TextField("Drag and drop the source text here");
    //private Stage stage; 
 
    // Create the LoggingArea
    TextArea loggingArea = new TextArea("");
    public void initialize() {

        VBox root = new VBox();
       
        GridPane progBorderPane = (GridPane) this.getRoot();


        // Set the Size of the TextFields
        sourceFld.setPrefSize(200, 20);
        targetFld.setPrefSize(200, 20);
 
        // Create the Labels
        Label sourceLbl = new Label("Source Node:");
        Label targetLbl = new Label("Target Node:");
 
        // Create the GridPane
        // GridPane pane = new GridPane();
        // pane.setHgap(5);
        // pane.setVgap(20);

 
        // Add the Labels and Fields to the Pane
        progBorderPane.addRow(0, sourceLbl, sourceFld);
        progBorderPane.addRow(1, targetLbl, targetFld);
 
        // Add mouse event handlers for the source
        sourceFld.setOnMousePressed(new EventHandler <MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                sourceFld.setMouseTransparent(true);
                writelog("Event on Source: mouse pressed");
                event.setDragDetect(true);
            }
        });
 
        sourceFld.setOnMouseReleased(new EventHandler <MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                sourceFld.setMouseTransparent(false);
                writelog("Event on Source: mouse released");
            }
        });
 
        sourceFld.setOnMouseDragged(new EventHandler <MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                writelog("Event on Source: mouse dragged");
                event.setDragDetect(false);
            }
        });
 
        sourceFld.setOnDragDetected(new EventHandler <MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                sourceFld.startFullDrag();
                writelog("Event on Source: drag detected");
            }
        });
 
        // Add mouse event handlers for the target
        targetFld.setOnMouseDragEntered(new EventHandler <MouseDragEvent>()
        {
            public void handle(MouseDragEvent event)
            {
                writelog("Event on Target: mouse dragged");
            }
        });
 
        targetFld.setOnMouseDragOver(new EventHandler <MouseDragEvent>()
        {
            public void handle(MouseDragEvent event)
            {
                writelog("Event on Target: mouse drag over");
            }
        });
 
        targetFld.setOnMouseDragReleased(new EventHandler <MouseDragEvent>()
        {
            public void handle(MouseDragEvent event)
            {
                targetFld.setText(sourceFld.getSelectedText());
                writelog("Event on Target: mouse drag released");
            }
        });
 
        targetFld.setOnMouseDragExited(new EventHandler <MouseDragEvent>()
        {
            public void handle(MouseDragEvent event)
            {
                writelog("Event on Target: mouse drag exited");
            }
        });
 
        // Create the VBox
        // VBox root = new VBox();
        // Add the Pane and The LoggingArea to the VBox
        root.getChildren().addAll(progBorderPane,loggingArea);
        // Set the Style of the VBox
        root.setStyle("-fx-padding: 10;" +
            "-fx-border-style: solid inside;" +
            "-fx-border-width: 2;" +
            "-fx-border-insets: 5;" +
            "-fx-border-radius: 5;" +
            "-fx-border-color: blue;");
 
        // Create the Scene
        // Scene scene = new Scene(root,300,200);
        
        // Add the Scene to the Stage
        // stage.setScene(scene);
        // stage.setTitle("A Press Drag Release Example");
        // // Display the Stage
        // stage.show();
    }
 
    // Helper Method for Logging
    private void writelog(String text){
        this.loggingArea.appendText(text + "\n");
    }
}



 

    //Gesture 
    


        

        
        
     

