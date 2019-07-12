package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class IlegalMoveAlert
{
	public static void display(String title, String message)
	{
		Stage alertWindow = new Stage();
		alertWindow.initModality(Modality.APPLICATION_MODAL);
		alertWindow.setTitle(title);
		alertWindow.setMinWidth(500);
		alertWindow.setMinHeight(150);
		
		Label messageLabel = new Label(message);
		
		Button okButton = new Button("OK");
		okButton.setMinWidth(80);
		okButton.setOnAction(e -> alertWindow.close());
		VBox layout = new VBox(20);
		layout.getChildren().addAll(messageLabel, okButton);
		layout.setAlignment(Pos.BASELINE_CENTER);
		
		Scene scene = new Scene(layout);
		alertWindow.setScene(scene);
		alertWindow.showAndWait();
	}
}
