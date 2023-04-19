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
    VBox vbox1 = new VBox()

}

}
