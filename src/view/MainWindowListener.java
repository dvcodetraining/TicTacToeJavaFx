package view;
import java.util.EventListener;


public interface MainWindowListener extends EventListener
{
	/**
	 * This interfaces has 2 methods, one to handle ChoosePlayer Events and one to handle the mainGame events
	 * @param e
	 */
//	public void windowEventOccurred(WindowEvent e);
	
	public void choosePlayerEventOccurred(char player);
//	public void mainGameEventOccurred(MoveEvent event);
	public void mainGameEventOccurred(BoardTile tile);
}
