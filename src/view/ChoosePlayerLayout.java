package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ChoosePlayerLayout extends VBox implements EventHandler<ActionEvent>
{
	Button playerX, playerO;
	private ChoosePlayerButtonListener buttonListener;
	public ChoosePlayerLayout(int gap)
	{
		super(gap);
		Label title = new Label("Choose player: ");
		playerX = new Button("Player X");
	
		playerX.setOnAction(this);
		playerO = new Button("Player O");
		playerO.setOnAction(this);
		setAlignment(Pos.BASELINE_CENTER);
		setPadding(new Insets(20, 20, 20, 20));
		getChildren().addAll(title, playerX, playerO);
	}
	public void setListener(ChoosePlayerButtonListener listener)
	{
		this.buttonListener = listener;
	}
	@Override
	public void handle(ActionEvent event)
	{
		Button source = (Button) event.getSource();
		char player;
		if(source == playerX)
		{
			player = 'X';
		}
		else
		{
			player = 'O';
		}
		if(buttonListener != null)
		{
			buttonListener.playerChoosen(player);
		}
	}
}
