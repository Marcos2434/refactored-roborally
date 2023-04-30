package dtu.view;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import dtu.controller.Controller;


public class ControlPanel extends GridPane {

	private Controller c;
	
	private Button ChooseCards = new Button("Choose cards");
	private Button Activate = new Button("Activate register");
	
	public ControlPanel(Controller c) {
		this.c = c;
		configure();
		addListeners();
	}

	public void setChoose(boolean b){
		ChooseCards.setDisable(b);
		Activate.setDisable(!b);
	}


	private void configure() {
		add(ChooseCards,0,0);
		add(Activate, 1, 0);
		
	

		// add(comboBox, 0, 5);
		
		ColumnConstraints firstCol = new ColumnConstraints();
		firstCol.setHgrow(Priority.ALWAYS);
		ColumnConstraints lastCol = new ColumnConstraints();
		lastCol.setHgrow(Priority.ALWAYS);
		getColumnConstraints().addAll(firstCol, new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), lastCol);
		
	}

	private void addListeners() {
		ChooseCards.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				c.getBoardScene().clearAllActiveCards();
				if (c.getRealPlayers().get(0).getRobot().getLives() <= 0){
					c.addCount();
				}
				c.nextScene();
				c.notifyAllRobotObservers();
				
			}
		});

		Activate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent event) {

					Task<Void> task = new Task<Void>() {
						@Override
						protected Void call() throws Exception {
							Activate.setDisable(true);
							c.getBoardController().runAllRegisters();
							Activate.setDisable(true);
							setChoose(false);
							return null;
							
						}
					};
					new Thread(task).start();}
				
		});
	}
}
