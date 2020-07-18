
public class minMaxTree 
{
	private multiTree aTree;
	private int [] move;
	public minMaxTree(TTTGame game)
	{
		aTree = new multiTree(game, 'O');
		move = createTree(aTree, 'O');
	}
	public int[] getMove()
	{
		return move;
	}
	public int [] createTree(multiTree game, char marker)
	{
		if(!(game.getItem().checkWin('O') || game.getItem().checkWin('X')) && !game.getItem().isFull())
		{
			for(int i = 1; i <= 3; i++)
			{
				for(int j = 1; j <= 3; j ++)
				{
					TTTGame temp = new TTTGame(game.getItem());
					if(temp.input(marker, i, j))
					{
						if(marker == 'O')
						{
							Node tempNode = new Node(temp, 'X');
							tempNode.setMove(i, j);
							createTree( new multiTree(tempNode), 'X');
							game.addChild(tempNode);
						}
						else
						{
							Node tempNode = new Node(temp, 'O');
							tempNode.setMove(i, j);
							createTree( new multiTree(tempNode), 'O');
							game.addChild(tempNode);
						}
					}
				}
			}
			if(marker == 'O')
			{
				if(game.getBestChild().getVal() == 2)
				{
					game.getRoot().setVal(2);
				}
				else if(game.getBestChild().getVal() == 1)
				{
					game.getRoot().setVal(1);
				}
				else
				{
					game.getRoot().setVal(0);
				}
			}
			else
			{
				if(game.getWorstChild().getVal() == 0)
				{
					game.getRoot().setVal(0);
				}
				else if(game.getWorstChild().getVal() == 1)
				{
					game.getRoot().setVal(1);
				}
				else
				{
					game.getRoot().setVal(2);
				}
			}
			return game.getBestChild().move;
		}
		
		else
		{
			if(game.getItem().checkWin('O'))
			{
				game.getRoot().setVal(2);
			}
			else if(game.getItem().checkWin('X'))
			{
				game.getRoot().setVal(0);
			}
			else
			{
				game.getRoot().setVal(1);
			}
			return new int[] {game.getRow(), game.getCol()};
		}
	}
	public int getVal()
	{
		return aTree.getChild(2).getVal();
	}
	public Node getRoot()
	{
		return aTree.getRoot();
	}
	public int getRow()
	{
		return move[0];
	}
	public int getCol()
	{
		return move[1];
	}
}
