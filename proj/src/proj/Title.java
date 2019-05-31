
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
         Font infoFont5;
         Font infoFont6;
           Font fnt1;
	public static Image image;
        public static Image image2;
    public Rectangle playButton = new Rectangle(250, 150, 100, 50);
     public Rectangle playButton1 = new Rectangle(249, 151, 102, 50);
    public Rectangle helpButton = new Rectangle(250, 250, 100, 50);
    public Rectangle helpButton1 = new Rectangle(249, 251, 102, 50);
    public Rectangle quitButton = new Rectangle(250, 350, 100, 50);
    public Rectangle quitButton1 = new Rectangle(249, 351, 102, 50);
    public Rectangle escButton = new Rectangle(530, 10, 40, 40);

        
	
	Title()
	{
		count = 0;
                titleFont2 = new Font("Monospaced", Font.PLAIN, 60);
		titleFont = new Font("Monospaced", Font.BOLD, 60);
		infoFont = new Font("Monospaced", Font.PLAIN, 30);
                infoFont2 = new Font("Monospaced", Font.BOLD, 30);
                infoFont3 = new Font("Monospaced", Font.PLAIN, 20);
                infoFont4 = new Font("Monospaced", Font.BOLD, 20);
                infoFont5 = new Font("Monospaced", Font.PLAIN, 40);
                infoFont6 = new Font("Monospaced", Font.BOLD, 40);
                fnt1 = new Font("arial", Font.BOLD, 30);
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
          
             g.setColor(Color.black);
        g.setFont(infoFont6);
        g.drawString("Play", playButton.x +3, playButton.y +35);
        g.setFont(infoFont5);
        g.drawString("Play", playButton.x +3, playButton.y +35);
        g2d.draw(playButton);
         g2d.draw(playButton1);
        
         g.setFont(infoFont6);
        g.drawString("Help", helpButton.x +3, helpButton.y +35);
        g.setFont(infoFont5);
        g.drawString("Help", helpButton.x +3, helpButton.y +35);
        g2d.draw(helpButton);
         g2d.draw(helpButton1);
       g.setFont(infoFont6);
        g.drawString("Quit", quitButton.x +3, quitButton.y +35);
         g.setFont(infoFont5);
        g.drawString("Quit", quitButton.x +3, quitButton.y +35);
        g2d.draw(quitButton);
         g2d.draw(quitButton1);
            
        }
         public void drawHelp(Graphics g){
             
                g.setFont(infoFont4);
                g.drawString("Press space bar to main menu.",130,540);
                g.setColor(Color.white);
		g.setFont(infoFont3);
                g.drawString("Press space bar to main menu.",130,540);
            
        }
          public void drawHow(Graphics g){
               Graphics2D g2d = (Graphics2D) g;
           
        g.setFont(fnt1);
        g.setColor(Color.red);
        g.drawString("X", escButton.x +11 , escButton.y +30);
        g.setColor(Color.white);
        g2d.draw(escButton);
              
          
          }
        
    
}

