import java.util.*;
public class TTTGame 
{
	private char [] gameBoard;
	private boolean running;
	Scanner reader;
	public TTTGame()
	{
		gameBoard = new char [9];
		running = true;
	}
	public TTTGame(TTTGame game)
	{
		gameBoard = new char [9];
		running = game.running;
		for(int i = 0; i < 9; i++)
		{
			gameBoard[i] = game.gameBoard[i];
		}
	}
	public boolean userInput(int theRow, int column)
	{
		
		int row = theRow; 
		int col = column;
		if(!insertBoard('X', row, col) || (col > 3 || row > 3))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean insertBoard(char val, int row, int column)
	{
		int index;
		row --;
		column --;
		index = 3 * row + column;
		if((index > 9 || index < 0) || gameBoard[index] == 'X' || gameBoard[index] == 'O')
		{
			return false;
		}
		else
		{
			gameBoard[index] = val;
		}
		return index < 9;
	}
	public void printBoard()
	{
		for(int i = 1; i <= gameBoard.length; i ++)
		{
			if(gameBoard[i - 1] == 'X' || gameBoard[i - 1] == 'O')
			{
				System.out.printf("|%1c", gameBoard[i - 1]);
			}
			else
			{
				System.out.printf("|%1c", ' ');
			}
			if(i % 3 == 0)
			{
				System.out.println("|");
			}
		}
		System.out.println();
	}
	public boolean checkWin(char A)
	{
		//check diagonal
		if(checkDiagonal(A, 1, 0, 1) || checkDiagonal(A, -1, 2, 1))
		{
			return true;
		}
		if(checkVert(A))
		{
			return true;
		}
		if(checkHor(A))
		{
			return true;
		}
		
		return false;
	}
	public boolean checkDiagonal(char charA, int sign, int start, int step)
	{
		if(step == 3)
		{
			return gameBoard[start] == charA;
		}
		else if(gameBoard[start] == charA)
		{
			return checkDiagonal(charA, sign, start + 3 + sign, step + 1);
		}
		else
		{
			return false;
		}
	}
	public boolean checkVert(char charA)
	{
		for(int i = 0; i < 3; i ++)
		{
			if(checkVert(charA, i, 1))
			{
				return true;
			}
		}
		return false;
	}
	public boolean checkVert(char charA, int start, int step)
	{
		if(step == 3)
		{
			return gameBoard[start] == charA;
		}
		else if(gameBoard[start] == charA)
		{
			return checkVert(charA, start + 3, step + 1);
		}
		else
		{
			return false;
		}
	}
	public boolean checkHor(char charA)
	{
		for(int i = 0; i < 7; i += 3)
		{
			if(checkHor(charA, i, 1))
			{
				return true;
			}
		}
		return false;
	}
	public boolean checkHor(char charA, int start, int step)
	{
		if(step == 3)
		{
			return gameBoard[start] == charA;
		}
		else if(gameBoard[start] == charA)
		{
			return checkHor(charA, start + 1, step + 1);
		}
		else
		{
			return false;
		}
	}
	public void aiInput()
	{
		minMaxTree a = new minMaxTree(this);
		int row = a.getRow();
		int col = a.getCol();
		insertBoard('O', row, col);
	}
	public boolean input(char a, int row, int column)
	{
		return insertBoard(a, row, column);
	}
	public boolean isFull()
	{
		for(char a: gameBoard)
		{
			if(a != 'X' && a != 'O')
			{
				return false;
			}
		}
		return true;
	}
	public char [] getBoard()
	{
		return gameBoard;
	}
}
