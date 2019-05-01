
package proj;


import java.awt.*;
import java.awt.event.*;


public class Title
{
	
	int count;
	Font titleFont;
	Font infoFont;
	
	
	Title()
	{
		count = 0;
		titleFont = new Font("Monospaced", Font.BOLD, 60);
		infoFont = new Font("Monospaced", Font.PLAIN, 30);
	}
	
	
	public void drawTitle(Graphics g)
	{
		g.setColor(Color.black);
		count++;
		g.setFont(titleFont);
		g.drawString("Game",220,200);

		g.setFont(infoFont);
                 g.drawString("-Press space bar to start-",60,350);
		

	}

	
	public void drawGameover(Graphics g)
	{
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString("GAMEOVER",150,300);
	}
	
        public void drawPausemenu(Graphics g)
                	{
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString("THE WORLD",150,300);
	}
}

