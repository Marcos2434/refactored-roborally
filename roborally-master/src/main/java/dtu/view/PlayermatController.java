package dtu.view;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PlayermatController implements Initializable {

    @FXML
    private ImageView Card;

    @FXML
    private static Label ChPointLab;

    @FXML
    private static Label damageLab;

    @FXML
    private static Label livesLab;

    @FXML
    private static Label pName;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void paneSetName(Pane p, String Name){
        pName.setText(Name);
    }
}