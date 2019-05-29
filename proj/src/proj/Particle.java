
package proj;

import java.awt.*;
import java.awt.event.*;
import static proj.Title.image;


public class Particle extends GameObject
{
	double direction;
	double speed;
	double speedX;
	double speedY;
	int size;
	
	Particle()
	{
		active = false;
	}
	
	
	public void move()
	{
		x += speedX;
		y += speedY;
		size--;
		
		if ( (x < 0)||(500 < x)||(y < 0)||(500 < y) )
		{
			active = false;
		}
		if (size < 0)
		{
			active = false;
		}
	}
	
	
	public void draw(Graphics g)
	{
            
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                image = toolkit.getImage("fireball2.gif");
		g.setColor(Color.gray);
		g.drawImage(image,(int)(x-size/2), (int)(y-size/2), size, size,null);
	}
	
	
	public void activate(double ix, double iy, double idirection, double ispeed)
	{
		x = ix;
		y = iy;
		direction = idirection;
		speed = ispeed;
		active = true;			
		size = 30;
		
		
		double radian;
		radian = Math.toRadians(direction);	
		speedX = speed * Math.cos(radian);
		speedY = speed * Math.sin(radian);
	}
}

