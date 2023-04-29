package dtu.view;


import dtu.logic.models.RobotColor;
import dtu.logic.models.Player.Player;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Playermat extends StackPane {

    private Player player;

    public static final int width = 330;
    public static final int height = 214;

    private Label pName;
    private Label color;
    private Label lives;
    private Label damage;
    private Label chPoint;
    private HBox cardsHbox = new HBox();
    private HBox hbox1;

    private Image backgroundpic = new Image("playermat/playermat.png");
    private ImageView background = new ImageView(backgroundpic);

    private Image cardbackpic = new Image("playermat/cardback.png");
    private Image lockedpic = new Image("playermat/locked.png");
    private Image dummypic = new Image("playermat/dummy.png");
    private int regSize;

    private Image cardSpacerPic = new Image("playermat/literalyPushingTheCardToThePlace.png");
    private Image ActiveCardPic; // = new Image("Cards/AgainCard.png");
    private ImageView ActiveCard = new ImageView(ActiveCardPic);

    private void setColor(){
        if (player.getRobot().getRobotColor().equals(RobotColor.BLACK)){
            this.color.setText("BLACK");
            this.color.setStyle("-fx-font-weight: bold; -fx-text-fill:BLACK; -fx-font-size: 15; -fx-padding: 0 0 0 10;");
        }
        else if (player.getRobot().getRobotColor().equals(RobotColor.BLUE)){
            this.color.setText("BLUE");
            this.color.setStyle("-fx-font-weight: bold; -fx-text-fill:BLUE; -fx-font-size: 15; -fx-padding: 0 0 0 10;");
        }
        else if (player.getRobot().getRobotColor().equals(RobotColor.GREEN)){
            this.color.setText("GREEN");
            this.color.setStyle("-fx-font-weight: bold; -fx-text-fill:GREEN; -fx-font-size: 15; -fx-padding: 0 0 0 10;");
        }
        else if (player.getRobot().getRobotColor().equals(RobotColor.ORANGE)){
            this.color.setText("ORANGE");
            this.color.setStyle("-fx-font-weight: bold; -fx-text-fill:ORANGE; -fx-font-size: 15; -fx-padding: 0 0 0 10;");
        }
        else if (player.getRobot().getRobotColor().equals(RobotColor.PURPLE)){
            this.color.setText("PURPLE");
            this.color.setStyle("-fx-font-weight: bold; -fx-text-fill:PURPLE; -fx-font-size: 15; -fx-padding: 0 0 0 10;");
        }
        else if (player.getRobot().getRobotColor().equals(RobotColor.RED)){
            this.color.setText("RED");
            this.color.setStyle("-fx-font-weight: bold; -fx-text-fill:RED; -fx-font-size: 15; -fx-padding: 0 0 0 10;");
        }
        else if (player.getRobot().getRobotColor().equals(RobotColor.WHITE)){
            this.color.setText("WHITE");
            this.color.setStyle("-fx-font-weight: bold; -fx-text-fill:WHITE; -fx-font-size: 15; -fx-padding: 0 0 0 10;");
        }
        else if (player.getRobot().getRobotColor().equals(RobotColor.YELLOW)){
            this.color.setText("YELLOW");
            this.color.setStyle("-fx-font-weight: bold; -fx-text-fill:YELLOW; -fx-font-size: 15; -fx-padding: 0 0 0 10;");
        }
    }

    public Player getPlayer(){
        return player;
    }

    public void destroyed(){
        Image shaderpic = new Image("playermat/destroyed.png");
        ImageView shader = new ImageView(shaderpic);
        super.getChildren().add(shader);
    }

    public void setRegister(int amountInHand) {
        cardsHbox.getChildren().clear();
        for (int i = 0; i < amountInHand; i++) {
            ImageView cb = new ImageView(cardbackpic);
            cardsHbox.getChildren().add(cb);
        }
        for (int i = amountInHand; i < 5; i++) {
            ImageView cb = new ImageView(lockedpic);
            cardsHbox.getChildren().add(cb);
        }
        cardsHbox.setStyle("-fx-padding: 0 0 0 2;");
        regSize = 5;
    }

    public void addRegister(){
        if (cardsHbox.getChildren().size() < 5 && regSize < 5){
            ImageView cb = new ImageView(cardbackpic);
            cardsHbox.getChildren().add(cb);
            cardsHbox.setStyle("-fx-padding: 0 0 2 2;");
            this.regSize += 1;
        } 
    }
    
    public void activateCard(String cardImageURL){
        if (regSize == 1){
            cardsHbox.getChildren().clear();
            cardsHbox.setStyle("-fx-padding: 0 0 44 2;");
            regSize = 0;
        } else if (regSize > 0){
            try {
                cardsHbox.getChildren().set(5 - regSize, new ImageView(dummypic));
                this.regSize -= 1;
            }
            catch(Exception i){
            }
        } 
        ActiveCardPic = new Image(cardImageURL, 110, 156, false, false);
        ActiveCard = new ImageView(ActiveCardPic);
        hbox1.getChildren().set(1, ActiveCard);
    }

    public void updateChPInfo(String info) {
        chPoint.setText("Checkpoint: " + info);
    }

    public void updatelives() {
        lives.setText("Lives: " + String.valueOf(player.getRobot().getLives()) + "   ");

    }

    public void updateDamage() {
        damage.setText("Damage: " + String.valueOf(player.getRobot().getDamageTaken()));
    }

    public void updateInfo(){
        if (this.player.getRobot().getcheckpointCount() == 0){
            chPoint.setText("Checkpoint: Start");
        } else {
            chPoint.setText("Checkpoint: " + this.player.getRobot().getcheckpointCount() + "    ");
        }
        lives.setText("Lives: " + String.valueOf(player.getRobot().getLives()) + "    ");
        if (player.getRobot().getLives() == 0){
            destroyed();
        }
        damage.setText("Damage: " + String.valueOf(player.getRobot().getDamageTaken()));
    }

    public void clearActiveCard(){
        ActiveCard = new ImageView();
        hbox1.getChildren().set(1, ActiveCard);
    }

    public String getPName() {
        return player.getName();
    }

    public Playermat(Player player) {

        this.player = player;

        pName = new Label(player.getName());
        pName.prefHeight(54);
        pName.prefWidth(191);
        pName.setStyle("-fx-font-weight: bold; -fx-font-size: 15;");
        color = new Label();
        setColor();
        HBox playerinfo = new HBox(pName, color);
        playerinfo.setStyle("-fx-padding: 5 0 14 0;-fx-border-color: red;");

        cardsHbox.setStyle("-fx-padding: 0 0 44 2;-fx-border-color: red;");
        cardsHbox.setSpacing(4);
        // setRegister(4);

        lives = new Label();
        updatelives();
        chPoint = new Label("Checkpoint: " + "Start");

        HBox playerinfo2 = new HBox(lives, chPoint);
        playerinfo2.setStyle("-fx-padding: 10 0 0 0;-fx-border-color: red;");

        damage = new Label();
        damage.setStyle("-fx-font-weight: bold; -fx-font-size: 15; -fx-padding: 25 0 0 0;");
        updateDamage();
        VBox vbox = new VBox(playerinfo, cardsHbox, playerinfo2, damage);
        vbox.setMaxWidth(210);
        vbox.setMinWidth(210);
        vbox.setStyle("-fx-padding: 0 0 0 20; -fx-border-color: red;");

        ActiveCard = new ImageView(ActiveCardPic);

        hbox1 = new HBox(vbox, ActiveCard);
        hbox1.prefWidth(width);
        hbox1.setStyle("-fx-padding: 14 0 0 0; -fx-border-color: red;");

        super.getChildren().addAll(background, hbox1);
    }
}
