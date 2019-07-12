
import javafx.application.Application;
import javafx.stage.Stage;
import view.BoardTile;
import view.GameEndedAlert;
import view.IlegalMoveAlert;
import view.MainWindowListener;
import view.Window;
/**
 * This Class serves as the Controller. Any Logic is done here
 * @author Damian Vaz
 *
 */
// TODO Refactor the shit out of everything
public class App extends Application
{
	private Window mainWindow;
	private static char player;
	private static TicTacToeBoard board = new TicTacToeBoard();
	

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		mainWindow = new Window("TicTacToe Game by Damian Vaz");
		board = new TicTacToeBoard();
		
		//Setting Window Listener
		mainWindow.setMainWindowListener(new MainWindowListener()
		{
			@Override
			public void choosePlayerEventOccurred(char player)
			{
				// Receives the char player all the way from the ChoosePlayerLayout
				//(App listens to Window that listens to ChoosePlayerLayout)	
				App.player = player;
				if(player == 'O')
				{
					makeAIMove();
				}
			}
			
			@Override 			// Receive tile to do move from MainGameLayout to perform move
			public void mainGameEventOccurred(BoardTile tile)
			{
				//Make Move on the board
				int row = tile.getRow();
				int col = tile.getCol();
			
				// Checks if it's a legal move
				if(board.isValidPlay(row, col))
				{
					board.makeMove(player, row, col);
					tile.setText("" + player);
					tile.setStyle("-fx-text-fill: cyan;");
					if(!board.isGameOver())
					{
						makeAIMove();						
					}
					checkGameOver();
				}
				else
				{
					IlegalMoveAlert.display("ILEGAL MOVE", "Please select a empty space\n NO CHEATING ;)");
				}
				// This is just for testing
				board.printBoard();
				
			}
		});
		primaryStage = mainWindow;
	}
	private void changePlayer()
	{
		if (App.player == 'X')
		{
			App.player = 'O';
		}
		else
		{
			App.player = 'X';
		}
		
	}
	private void makeAIMove()
	{
		changePlayer();
		Minimax AI = new Minimax(board, player);
		int row = AI.getBestChoice().getX();
		int col = AI.getBestChoice().getY();
		board.makeMove(player, row, col);
		mainWindow.showMoveOnScreen(row, col, player);
		changePlayer();
		checkGameOver();
	}

	private void checkGameOver()
	{
		if (board.isGameOver())
		{
			String title, message;
			char winner = board.whoWon();
			changePlayer();
			if(winner == player)
			{
				title = "GAME OVER";
				message = "Sorry, I'm invencible ;)";
			}
			else
			{
				title = "DRAW";
				message = "It's a draw, let's try again?";
			}
			int option = GameEndedAlert.display(title, message);
			if(option == GameEndedAlert.NEWGAME)
			{
				board = new TicTacToeBoard();
				mainWindow.goToPlayerSelectonScene();
				mainWindow.cleanBoard();
			}
			else
			{
				mainWindow.close();
				System.exit(0);
			}
		}
	}
}
