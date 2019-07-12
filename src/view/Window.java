package view;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Stage
{
	private Scene choosePlayer, mainGame;
	private MainGameLayout mainGameLayout;
	private MainWindowListener mainWindowListener;
	
	
	public Window(String title)
	{
		setTitle(title);
		// making Scenes
		mainGameLayout = new MainGameLayout();
		ChoosePlayerLayout choosePlayerLayout = new ChoosePlayerLayout(20);
		mainGame = new Scene(mainGameLayout);
		choosePlayer = new Scene(choosePlayerLayout);
		
		choosePlayerLayout.setListener(player -> 
		{
			// Passing the player received from ChoosePlayerLayout to App Class
			if(mainWindowListener != null)
			{
				//notifying the App of the event passing the player
				mainWindowListener.choosePlayerEventOccurred(player);
				//changing scenes to the mainGame
				setScene(mainGame);
			}
		});
		
		// set listener to mainGameLayout
		mainGameLayout.setListener(tile ->
		{
			// passing the tile to the App
			if (mainWindowListener != null)
			{
				mainWindowListener.mainGameEventOccurred(tile);
			}
		});
		
		mainGame.getStylesheets().add("/css/style.css");
		setScene(choosePlayer);
		
		//sizeToScene();
		show();
		
	}

	public void setMainWindowListener(MainWindowListener mainWindowListener)
	{
		this.mainWindowListener = mainWindowListener;
	}
	public void showMoveOnScreen(int row, int col, char player)
	{
		mainGameLayout.showMoveOnScreen(row, col, player);
	}
	public void cleanBoard()
	{
		mainGameLayout.cleanBoard();
	}

	public void goToPlayerSelectonScene()
	{
		setScene(choosePlayer);
	}
}
