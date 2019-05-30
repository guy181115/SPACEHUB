
package proj;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Title
{
	
	int count;
	Font titleFont;
	Font infoFont;
        Font infoFont2;
         Font infoFont3;
          Font infoFont4;
         Font titleFont2;
	public static Image image;
        public Rectangle playButton = new Rectangle(250, 150, 100, 50);
    public Rectangle helpButton = new Rectangle(250, 250, 100, 50);
    public Rectangle quitButton = new Rectangle(250, 350, 100, 50);
        
	
	Title()
	{
		count = 0;
                titleFont2 = new Font("Monospaced", Font.PLAIN, 60);
		titleFont = new Font("Monospaced", Font.BOLD, 60);
		infoFont = new Font("Monospaced", Font.PLAIN, 30);
                infoFont2 = new Font("Monospaced", Font.BOLD, 30);
                infoFont3 = new Font("Monospaced", Font.PLAIN, 20);
                infoFont4 = new Font("Monospaced", Font.BOLD, 20);
	}
	
	
	public void drawTitle(Graphics g)
	{
                
		g.setColor(Color.black);
		count++;
		g.setFont(titleFont);
		g.drawString("SPACEHUB",150,300);
                g.setColor(Color.black);
                g.setFont(infoFont2);
                 g.drawString("-Press space bar to start-",60,350);
                 g.setColor(Color.white);
		g.setFont(infoFont);
                 g.drawString("-Press space bar to start-",60,350);
		

	}

	
	public void drawGameover(Graphics g)
	{       
                g.setColor(Color.black);
                g.fillRect(0, 240, 600, 50);
		g.setColor(Color.red);
		g.setFont(titleFont);
		g.drawString("YOU DIED",150,280);
                g.setColor(Color.red);
		g.setFont(titleFont2);
		g.drawString("YOU DIED",150,280);
                g.setColor(Color.black);
		g.setFont(infoFont4);
                g.drawString("Press space bar to main menu.",130,540);
                g.setColor(Color.white);
		g.setFont(infoFont3);
                g.drawString("Press space bar to main menu.",130,540);
	}
	
        public void drawPausemenu(Graphics g)
        {       
                g.setColor(Color.black);
		g.setFont(infoFont4);
                g.drawString("Press ESC to Resume.",340,540);
                g.setColor(Color.white);
		g.setFont(infoFont3);
                g.drawString("Press ESC to Resume.",340,540);
                g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString("PAUSED",180,280);
		g.setColor(Color.white);
		g.setFont(titleFont2);
		g.drawString("PAUSED",180,280);
                
	}
        public void drawWin(Graphics g){
            g.setColor(Color.black);
                g.fillRect(0, 240, 600, 50);
		g.setColor(Color.blue);
		g.setFont(titleFont);
		g.drawString("YOU WIN",150,280);
                g.setColor(Color.blue);
		g.setFont(titleFont2);
		g.drawString("YOU WIN",150,280);
                g.setColor(Color.black);
		g.setFont(infoFont4);
                g.drawString("Press space bar to main menu.",130,540);
                g.setColor(Color.white);
		g.setFont(infoFont3);
                g.drawString("Press space bar to main menu.",130,540);
            
        }
        
         public void drawMenu(Graphics g){
             Graphics2D g2d = (Graphics2D) g;
            Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.drawString("Play", playButton.x +20, playButton.y +35);
        g2d.draw(playButton);
        g.drawString("Help", helpButton.x +20, helpButton.y +35);
        g2d.draw(helpButton);
        g.drawString("Quit", quitButton.x +20, quitButton.y +35);
        g2d.draw(quitButton);
            
        }
         public void drawHelp(Graphics g){
             
                g.setFont(infoFont4);
                g.drawString("Press space bar to main menu.",130,540);
                g.setColor(Color.white);
		g.setFont(infoFont3);
                g.drawString("Press space bar to main menu.",130,540);
            
        }
        
    
}

