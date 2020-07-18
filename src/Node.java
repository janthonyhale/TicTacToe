import java.util.*;
public class Node 
{
	char player;
	int val;
	int [] move;
	private TTTGame item;
	private Node right;
	private Node child;
	public Node(TTTGame game, char thePlayer)
	{
		move = new int [2];
		item = game;
		right = null;
		player = thePlayer;
	}
	public TTTGame getItem()
	{
		return item;
	}
	public Node getRight()
	{
		return right;
	}
	public Node getChild()
	{
		return child;
	}
	public void setRight(Node theRight)
	{
		right = theRight;
	}
	public void setChild(Node theChild)
	{
		child = theChild;
	}
	public void setVal(int value)
	{
		val = value;
	}
	public int getVal()
	{
		return val;
	}
	public void setMove(int row, int col)
	{
		move[0] = row;
		move[1] = col;
	}
	public int getRow()
	{
		return move[0];
	}
	public int getCol()
	{
		return move[1];
	}
	public char getPlayer()
	{
		return player;
	}
	public void addChild(Node game)
	{
		if(getChild() == null)
		{
			setChild(game);
		}
		else
		{
			Node temp = getChild();
			while(temp.getRight() != null)
			{
				temp = temp.getRight();
			}
			temp.setRight(game);
		}
	}
	public Node getBestChild()
	{
		if(this.getChild() != null)
		{
			Node temp = this.getChild();
			Node best = temp;
			while(temp.getRight() != null)
			{
				temp = temp.getRight();
				if(temp.getVal() >= best.getVal())
				{
					best = temp;
				}
			}
			return best;
		}
		else
		{
			return null;
		}	
	}
	public Node getWorstChild()
	{
		if(this.getChild() != null)
		{
			Node temp = this.getChild();
			Node worst = temp;
			while(temp.getRight() != null)
			{
				temp = temp.getRight();
				if(temp.getVal() <= worst.getVal())
				{
					worst = temp;
				}
			}
			return worst;
		}
		else
		{
			return null;
		}	
	}
	public Node getChild(int num)
	{
		Node temp = this.getChild();
		for(int i = 0; i < num - 1; i ++)
		{
			temp = temp.getRight();
		}
		return temp;
	}
}
