import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	
	public int map[][], brick_width, brick_height;
	public MapGenerator(int row, int col)
	{
		map = new int[row][col];
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				map[i][j] = 1; //each brick will be drawn inside the panel, if don't want to draw the brick change the value to '0'
			}
		}
		
		brick_width = 540 / col;
		brick_height = 150 / row;
	}
	
	public void draw(Graphics2D g)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				if(map[i][j] > 0) 
				{
					g.setColor(Color.white);
					g.fillRect(j * brick_width + 80, i * brick_height + 50, brick_width, brick_height);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brick_width + 80, i * brick_height + 50, brick_width, brick_height);
					
				}
			}
		}
	}
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value; //helps in breaking the brick when ball touches it
	}
	
}
