package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.layout.GridPane;

public class MainGameLayout extends GridPane
{
	private BoardTile[][] tiles = new BoardTile[3][3];
	private MainGameLayoutListener listener;

	public MainGameLayout()
	{
		setHgap(5);
		setVgap(5);

		ButtonHandler handler = new ButtonHandler();
		Glow glow = new Glow(0.9);
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				tiles[i][j] = new BoardTile(i, j);
				tiles[i][j].setMinSize(100, 100);
				tiles[i][j].setOnAction(handler);
				tiles[i][j].getStyleClass().add("button-tiles");
				tiles[i][j].setEffect(glow);
				add(tiles[i][j], j, i);
			}
		}
	}
	public void setListener(MainGameLayoutListener listener)
	{
		this.listener = listener;
	}
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent e)
		{
			BoardTile source = (BoardTile) e.getSource();
			/*
			int row = source.getRow();
			int col = source.getCol();
			MoveEvent moveEvent = new MoveEvent(this, row, col, source);
			*/
			if(listener != null)
			{
				listener.moveChoosen(source);
			}
			
			/*Should handle this in App
			if(board.isValidPlay(row, col))
			{
				board.makeMove(player, row, col);
				source.setText("" + player);
				changePlayer();
			}
			else
			{
				//make a modal window here
				System.out.println("Illegal play");
			}
			// This is just for testing
			board.printBoard();
			
			if(board.isGameOver())
			{
				System.out.println("Game Over won by " + board.getWinner());
			}
			*/
		}
		
	}
	public void showMoveOnScreen(int row, int col, char player)
	{
		tiles[row][col].setText("" + player);
		tiles[row][col].setStyle("-fx-text-fill: lime;");
	}
	/**
	 * This does not create a new layout, 
	 * instead it just sets all the buttons in the current one to empty strings
	 */
	public void cleanBoard()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				tiles[i][j].setText("");
			}
		}
	}

}
