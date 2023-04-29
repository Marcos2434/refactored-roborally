package dtu.view;
import dtu.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.event.EventHandler;


public class WinScene extends Scene {
  private Controller c;
  private GridPane grid;
  private VBox mainBox = new VBox();


  public WinScene(Controller c) {
    super(new GridPane());
    this.c = c;
  

    this.initialize();
  }

  public void initialize(){
    this.grid = (GridPane) this.getRoot();
    grid.setPrefSize(1200, 800);

    //Setting the backround
    Image background = new Image (("playermat/lava.png"));
    BackgroundImage background2 = new BackgroundImage(background, null, null, null, null);
    Background background3 = new Background(background2);
    grid.setBackground(background3);
    
    
    //Setting the text
    Text winText = new Text("THE WINNNER IS:  " + c.getWinner().getName() + " !");
    winText.setFont(Font.font("Verdana", 72));
    winText.setFill(Color.WHITE);
    DropShadow dropShadow = new DropShadow();
    dropShadow.setColor(Color.DARKGRAY);
    dropShadow.setOffsetX(5);
    dropShadow.setOffsetY(5);
    winText.setEffect(dropShadow);
    
    //Showing the text
    

  
    Button retMenu = new Button();
    VBox vBoxForButton = new VBox(retMenu);
    vBoxForButton.setAlignment(Pos.CENTER);
    retMenu.setText("Back To Menu");
    retMenu.setOnMouseClicked(new  EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            c.getBoardController().wipePlayers();
            c.setTheScene(c.getMenuScene(),"Menu");
        }
    });


    mainBox.getChildren().addAll(winText,vBoxForButton);
    grid.setAlignment(Pos.CENTER);
    mainBox.setSpacing(20);
    grid.add(mainBox, 2, 2, 3, 3);

  }
}