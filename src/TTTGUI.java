import java.awt.Button;
import java.awt.Label;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class TTTGUI extends JFrame implements ActionListener
{
	TTTGame theGame;
	Button start;
	Label title;
	Button [] board;
	Label WL;
	Button again;
	public TTTGUI()
	{
		again = new Button("NEW GAME");
		again.setBounds(100, 200, 100, 20);
		again.setVisible(false);
		again.addActionListener(this);
		add(again);
		theGame = new TTTGame();
		WL = new Label("");
		WL.setBounds(75, 100, 200, 100);
		WL.setVisible(false);
		add(WL);
		setTitle("TIC TAC TOE");
		setSize(300,320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		title = new Label("WELCOME TO TIC TAC TOE");
		title.setBounds(70, 100, 200, 20);
		add(title);
		start = new Button("START");
		start.setBounds(100, 200, 100, 20);
		start.addActionListener(this);
		add(start);
		board = new Button [9];
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == start)
		{
			start.setVisible(false);
			title.setVisible(false);
			renderBoard(theGame.getBoard());
		}
		else if(e.getSource() == again)
		{ 
			theGame = new TTTGame();
			renderBoard(theGame.getBoard());
		}
		else
		{
			if(theGame.isFull())
			{
				WL.setText("DRAW");
				WL.setBounds(125, 100, 200, 100);
				WL.setVisible(true);
				again.setVisible(true);
				for(int i = 0; i < 9; i ++)
				{
					board[i].setVisible(false);
				}
			}
			if(!(theGame.checkWin('O')))
			{
				Button temp = (Button) e.getSource();
				int index = 0;
				for(int i = 0; i < 9; i ++)
				{
					if(board[i] == temp)
					{
						index = i;
					}
				}
				if(theGame.userInput(index/3 + 1, index%3 + 1))
				{
					updateBoard(theGame.getBoard());
					if(!theGame.checkWin('X'))
					{
						theGame.aiInput();
						updateBoard(theGame.getBoard());
					}
				
					else
					{
						for(int i = 0; i < 9; i ++)
						{
							board[i].setVisible(false);
						}
					}
				}
				
			}
			else if(theGame.checkWin('O'))
			{
				//OWIN
				for(int i = 0; i < 9; i ++)
				{
					WL.setText("COMPUTER WINS");
					again.setVisible(true);
					WL.setBounds(100, 100, 200, 100);
					WL.setVisible(true);
					board[i].setVisible(false);
				}
			}
		}
			
	}
	public void renderBoard(char [] a) 
	{
		again.setVisible(false);
		WL.setVisible(false);
		for(int i = 0; i < 9; i++)
		{
			board[i] = new Button(""+a[i]);
			board[i].setBackground(Color.BLACK);
			board[i].setVisible(true);
			board[i].setBounds((i%3) *100, (i/3) *100, 100, 100);
			board[i].setFont(getFont().deriveFont(40.0f));
			board[i].addActionListener(this);
			add(board[i]);
		}
		
	}
	public void updateBoard(char [] a) 
	{
		for(int i = 0; i < 9; i++)
		{
			board[i].setLabel(a[i] + "");;
		}
		
	}
	public static void main(String [] args)
	{
		TTTGUI a = new TTTGUI();
	}
}