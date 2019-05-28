
package proj;

import java.awt.*;
import java.awt.event.*;
import static proj.Title.image;


public class MyBullet extends GameObject
{
	
	MyBullet()
	{
		active = false;
	}
	
	
	public void move()
	{
        y -= 15; //ความเร็วกระสุน
		
		if ( (y < 0) )
		{
			active = false;
		}
	}
	
	
	public void draw(Graphics g)
	{
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                image = toolkit.getImage("myBullet.png");
		g.setColor(Color.gray);
		
                g.drawImage(image, (int)x-16, (int)y-40, (int)35, (int)45, null);
	}
	
	
	public void activate(double ix, double iy)
	{
		x = ix;
		y = iy;
		active = true;			
	}
       
}

