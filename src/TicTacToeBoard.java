import java.util.ArrayList;

public class TicTacToeBoard
{
	private char[][] board;
	char winner;

	public TicTacToeBoard()
	{
	//	turn = 0;
		board = new char[][]
		{
				{ ' ', ' ', ' ' },
				{ ' ', ' ', ' ' },
				{ ' ', ' ', ' ' }, 
		};
	}

	public TicTacToeBoard(int turn, char[][] board)
	{
		this.board = board;
	}
	public TicTacToeBoard(char[][] board)
	{
		this.board = board;
	}
	public TicTacToeBoard(char[][] board, char player, int x, int y)
	{
		this.board = board;
		this.board[x][y] = player;
	}
	/**
	 * Performs deep copy of the object
	 */
	public TicTacToeBoard copy()
	{
		char boardArray[][] = new char[3][3];
		for (int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				boardArray[i][j] = this.getArrayBoard()[i][j];
			}
		}
		return new TicTacToeBoard(boardArray);
	}
	
	public int getTurn()
	{
		int count = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (this.board[i][j] != ' ')
				{
					count++;
				}
			}
		}
		return count;
	}
	public char[][] getArrayBoard()
	{
		return this.board;
	}

	public char[][] getBoard()
	{
		return board;
	}

	public void setBoard(char[][] board)
	{
		this.board = board;
	}

	public void makeMove(char player, int x, int y)
	{
		this.board[x][y] = player;
	}
	/**
	 * prints Board on the console for testing
	 */
	public void printBoard()
	{
		
		System.out.println(" " + this.board[0][0] + "  | " + this.board[0][1] + "  | " + this.board[0][2] + "  ");
		System.out.println("==============");
		System.out.println(" " + this.board[1][0] + "  | " + this.board[1][1] + "  | " + this.board[1][2] + "  ");
		System.out.println("==============");
		System.out.println(" " + this.board[2][0] + "  | " + this.board[2][1] + "  | " + this.board[2][2] + "  ");
		System.out.println();
		System.out.println();
		System.out.println();
		
	}

	public boolean isValidPlay(int row, int col)
	{
		if (row > 2 || col > 2 || this.board[row][col] != ' ')
		{
			return false;
		} else
		{
			return true;
		}
	}

	public boolean isGameOver()
	{

		for (int i = 0; i < 3; i++)
		{
			// check horizontal lines
			if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][1] != ' ')
			{
				winner = board[i][1];
				return true;
			}
			// check vertical lines
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
			{
				winner = board[0][i];
				return true;
			}
		}
		// check diagonals
		if (((board[0][0] == board[1][1] && board[1][1] == board[2][2])
				|| (board[0][2] == board[1][1] && board[1][1] == board[2][0])) && board[1][1] != ' ')
		{
			winner = board[1][1];
			return true;
		}
		if (this.getTurn() >= 9)
		{
			winner = ' '; // means the game is draw
			return true;
		} else
		{
			return false;
		}

	}

	public char whoWon()
	{
		if (this.isGameOver())
		{
			return winner;
		} else
		{
			return '-';
		}
	}


	public Action[] possiblePlays()
	{
		ArrayList<Action> possiblePlays = new ArrayList<Action>();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (this.board[i][j] == ' ')
				{
					Action a = new Action(i, j);
					possiblePlays.add(a);
				}
			}
		}
		possiblePlays.trimToSize();
		return possiblePlays.toArray(new Action[possiblePlays.size()]);
	}
	
	public char getPlayer()
	{

		int turn = getTurn();
		if (turn % 2 == 0)
		{
			return 'X';
		} else
		{
			return 'O';
		}

	}
}
