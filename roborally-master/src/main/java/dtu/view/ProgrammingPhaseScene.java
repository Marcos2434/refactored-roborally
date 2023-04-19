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

public class ProgrammingPhaseScene extends Scene {
    Controller c;
    
    public ProgrammingPhaseScene (Controller c) {
        super(new BorderPane());
        this.initialize();
        this.c = c;
    }
    private void initialize(){
        BorderPane progBorderPane = (BorderPane) this.getRoot();

        progBorderPane.setPrefSize(500, 500);


        //Create the template for view 
        
    



        Text handTitle = new Text("HAND");
        Text card1 = new Text("First Card");
        CheckBox CheckCard1 = new CheckBox("Is card1 used");
        VBox vbox1 = new VBox(card1, CheckCard1);
        Text card2 = new Text("Second Card");
        CheckBox CheckCard2 = new CheckBox("Is card2 used");
        VBox vbox2 = new VBox(card2, CheckCard2);


        VBox Hand = new VBox(handTitle, vbox1, vbox2);
        Hand.setPrefSize(125, 200);

        

        
        // Text card10 = new VBox("First Card");
        // CheckBox CheckCard1 = new CheckBox("Is card1 used");
        

    //Testing drag and dropping 
    final Text source = new Text(50, 100, "DRAG ME");
    final Text target = new Text(300, 100, "DROP HERE");


    //Gesture 
    source.setOnDragEntered(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
        
        /* Put a string on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        db.setContent(content);
        
        event.consume();
    }
});


        

        
        progBorderPane.setRight(Hand);
    }   
}
