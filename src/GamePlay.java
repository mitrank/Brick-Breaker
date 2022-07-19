import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
	
	private boolean play = false;
	private int score = 0, tot_bricks = 21, delay = 8, player1 = 310;
	private int ball_posx = 120, ball_posy = 350, ball_dirx = -1, ball_diry = -2;
	private Timer timer;
	private MapGenerator map;
	Sound s = new Sound();
	
	String GameWin, GameLose, BreakBrick;
	
	public GamePlay() 
	{
		BreakBrick = "C:\\Users\\Mitrank\\eclipse-workspace\\Brick Breaker\\Sounds\\break.wav";

		map = new MapGenerator(3, 7);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		//map
		map.draw((Graphics2D)g);
		
		//scores
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + score, 590, 30);
		
		//borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//paddle
		g.setColor(Color.green);
		g.fillRect(player1, 550, 100, 8);
		
		//ball
		g.setColor(Color.yellow);
		g.fillOval(ball_posx, ball_posy, 20, 20);
		
		if(tot_bricks <= 0) 
		{
			play = false;
			ball_dirx = 0;
			ball_diry = 0;
			g.setColor(Color.green);
			g.setFont(new Font("calibri", Font.BOLD, 30));
			g.drawString("You WON :D", 190, 300);
			
			g.setColor(Color.white);
			g.setFont(new Font("calibri", Font.BOLD, 20));
			g.drawString("Press ENTER to restart!", 190, 350);

		}
		
		if(ball_posy > 570) 
		{
			play = false;
			ball_dirx = 0;
			ball_diry = 0;
			g.setColor(Color.red);
			g.setFont(new Font("calibri", Font.BOLD, 30));
			g.drawString("GAME OVER ;(", 190, 300);
			
				
			g.setColor(Color.white);
			g.setFont(new Font("calibri", Font.BOLD, 20));
			g.drawString("Press ENTER to restart!", 190, 350);
			

		}
		g.dispose();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		timer.start();
		
		if(play) 
		{
			if(new Rectangle(ball_posx, ball_posy, 20, 20).intersects(new Rectangle(player1, 550, 100, 8))) 
			{
				ball_diry = -ball_diry;
			}
						
			A: for(int i = 0; i < map.map.length; i++)
			{
				for(int j = 0; j < map.map[0].length; j++)
				{
					if(map.map[i][j] > 0) 
					{
						int brick_x = j * map.brick_width + 80;
						int brick_y = i * map.brick_height + 50;
						int brick_width = map.brick_width;
						int brick_height = map.brick_height;
						
						Rectangle rect = new Rectangle(brick_x, brick_y, brick_width, brick_height);
						Rectangle ball_rect = new Rectangle(ball_posx, ball_posy, 20, 20);
						Rectangle brick_rect = rect;
						
						if(ball_rect.intersects(brick_rect)) 
						{
							map.setBrickValue(0, i, j);
							tot_bricks--;
							score += 5;
							
							s.setFile(BreakBrick);
							s.play();
							if(ball_posx + 19 <= brick_rect.x || ball_posx + 1 >= brick_rect.x + brick_rect.width) 
							{
								ball_dirx = -ball_dirx;
							}
							else
							{
								ball_diry = -ball_diry;
							}
							break A;
						}
					}
				}
			}
			
			ball_posx += ball_dirx;
			ball_posy += ball_diry;
			
			if(ball_posx < 0) 
			{
				ball_dirx = -ball_dirx;
			}
			if(ball_posy < 0) 
			{
				ball_diry = -ball_diry;
			}
			if(ball_posx > 670) 
			{
				ball_dirx = -ball_dirx;
			}
		}
		
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
		{
			if(player1 >= 600) 
			{
				player1 = 600;
			}
			else 
			{
				moveRight();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) 
		{
			if(player1 < 10) 
			{
				player1 = 10;
			}
			else 
			{
				moveLeft();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) 
		{
			if(!play) 
			{
				play = true;
				ball_posx = 120;
				ball_posy = 350;
				ball_dirx = -1;
				ball_diry = -2;
				player1 = 310;
				score = 0;
				tot_bricks = 21;
				map = new MapGenerator(3, 7);
				
				repaint();
			}
		}
	}
	public void moveRight()
	{
		play = true;
		player1 += 20;
	}
	public void moveLeft()
	{
		play = true;
		player1 -= 20;
	}
	
}