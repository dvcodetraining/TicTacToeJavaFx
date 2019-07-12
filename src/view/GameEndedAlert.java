package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameEndedAlert
{
	public static final int NEWGAME = 1;
	public static final int CLOSE = 2;
	private static int option;
	
	public static int display(String title, String message)
	{
		Stage alertWindow = new Stage();
		alertWindow.initModality(Modality.APPLICATION_MODAL);
		alertWindow.setTitle(title);
		alertWindow.setMinWidth(500);
		alertWindow.setMinHeight(250);
		
		Label messageLabel = new Label(message);
		Button newGame = new Button("New Game");
		newGame.setMinWidth(100);
		newGame.setOnAction(e ->
		{
			option = NEWGAME;
			alertWindow.close();
		});
		Button closeButton = new Button("Close");
		closeButton.setMinWidth(100);
		closeButton.setOnAction(e -> 
		{
			option = CLOSE;
			alertWindow.close();
		});
		VBox layout = new VBox(20);
		layout.getChildren().addAll(messageLabel, newGame, closeButton);
		layout.setAlignment(Pos.BASELINE_CENTER);
		
		Scene scene = new Scene(layout);
		alertWindow.setScene(scene);
		alertWindow.showAndWait();
		return option;
	}
}
