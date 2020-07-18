public class multiTree 
{
	private Node root;
	public multiTree(TTTGame theRoot, char a)
	{
		root = new Node(theRoot, a);
	}
	public multiTree(Node theRoot)
	{
		root = theRoot;
	}
	public void addChild(Node game)
	{
		root.addChild(game);
	}
	public Node getChild(int num)
	{
		Node theNode = this.getRoot();
		Node temp = theNode.getChild();
		for(int i = 0; i < num - 1; i ++)
		{
			temp = temp.getRight();
		}
		return temp;
	}
	public TTTGame getItem()
	{
		return root.getItem();
	}
	public void addTree(multiTree a)
	{
		addChild(a.root);
	}
	public Node getRoot()
	{
		return root;
	}
	public int getRow()
	{
		return root.getRow();
	}
	public int getCol()
	{
		return root.getCol();
	}
	public Node getBestChild()
	{
		return root.getBestChild();
	}
	public Node getWorstChild()
	{
		return root.getWorstChild();
	}
}
