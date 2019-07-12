import java.util.ArrayList;

public class Minimax
{
	// Player is AIPlayer and opponent is Human Player
	private char playerAI, opponent;
	public Action bestChoice;

	public int endGameScore(TicTacToeBoard gameBoard)
	{
		int turn = gameBoard.getTurn();
		if (gameBoard.whoWon() == playerAI)
		{
			return 10 - turn; // makes it play the fastest route to win
		} 
		else if (gameBoard.whoWon() == opponent)
		{
			return -10;
		}
		else
		{
			return 0;
		}
	}

	public Action getBestChoice()
	{
		return this.bestChoice;
	}

	public Minimax(TicTacToeBoard board, char playerAI)
	{
		this.playerAI = playerAI;
		opponent = playerAI == 'O' ? 'X' : 'O';
	
		// making new board
		TicTacToeBoard newBoard = board.copy();
		minimax(newBoard);
	}

	public int minimax(TicTacToeBoard board)
	{
		// making new board
		TicTacToeBoard newBoard = board.copy();
		
		if (newBoard.isGameOver())
		{
			return endGameScore(newBoard);
		}

		ArrayList<Integer> scores = new ArrayList<Integer>();

		Action[] possibleMoves = newBoard.possiblePlays();
		char player = newBoard.getPlayer();
		
		// populate array scores
		for (int i = 0; i < possibleMoves.length; i++)
		{
			int x = possibleMoves[i].getX();
			int y = possibleMoves[i].getY();
			TicTacToeBoard possibleBoard = newBoard.copy();
			possibleBoard.makeMove(player, x, y);
			scores.add(minimax(possibleBoard));
		}
		scores.trimToSize();
		
		// Decide between choosing min or max Calculation
		if (player == playerAI)
		{
			// Do max
			int maxScoreIsAt = 0;
			int max = -10;
			Integer[] scoresArray = scores.toArray(new Integer[scores.size()]);
			for (int i = 0; i < scoresArray.length; i++)
			{
				if ((int) scoresArray[i] > max)
				{
					max = (int) scoresArray[i];
					maxScoreIsAt = i;
					bestChoice = possibleMoves[i];
				}
			}
			return (int) scoresArray[maxScoreIsAt];
		} else
		{
			// Do min
			int minScoreIsAt = 0;
			int min = 10;
			Integer[] scoresArray = scores.toArray(new Integer[scores.size()]);
			for (int i = 0; i < scoresArray.length; i++)
			{
				if ((int) scoresArray[i] < min)
				{
					min = (int) scoresArray[i];
					minScoreIsAt = i;
					bestChoice = possibleMoves[i];
				}
			}
			return (int) scoresArray[minScoreIsAt];
		}
	}

}