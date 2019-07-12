package view;
import javafx.scene.control.Button;

public class BoardTile extends Button
{
	private int row;
	private int col;
	
	public BoardTile(int row, int col)
	{
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow()
	{
		return row;
	}

	
	public int getCol()
	{
		return col;
	}
}
