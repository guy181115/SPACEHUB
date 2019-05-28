
package proj;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import static proj.Title.image;


public class Bullet extends GameObject
{
       
	double direction;
	double speed;
	double speedX;
	double speedY;
	
	
	Bullet()
	{
		
		active = false;
	}
	
	
	public void move()
	{
		x += speedX;
		y += speedY;
		
		if ( (x < 0)||(600 < x)||(y < 0)||(600 < y) ) //600
		{
			active = false;
		}
	}
	
	
	public void draw(Graphics g)
	{
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                image = toolkit.getImage("laserBullet.png");
		g.setColor(Color.RED);
		
                g.drawImage(image, (int)(x-3), (int)(y-3), (int)40, (int)30,null ); //default 6,6
                
                
	}
	
	
	public void activate(double ix, double iy, double idirection, double ispeed)
	{
		x = ix;
		y = iy;
		direction = idirection;
		speed = ispeed;
		active = true;			
		
		
		
		double radian;
		radian = Math.toRadians(direction);	
		speedX = speed * Math.cos(radian);
		speedY = speed * Math.sin(radian);
	}

	
	public static void FireRound(double x, double y)
	{
		for (int i = 0; i < 360; i += 60 )
		{
			ObjectPool.newBullet(x, y, i, 3);
		}
	}
        public static void FireRound2(double x, double y)
	{
		for (int i = 0; i < 360; i += 60 )
		{
			ObjectPool.newBullet(x, y, i, 3);
                        ObjectPool.newBullet(x, y, i, 3);
                        ObjectPool.newBullet(x, y, i, 3);
		}
	}

	
	public static void FireAim(double x, double y, Player player)
	{
		double degree = Math.toDegrees(Math.atan2(player.y - y, player.x - x));
		ObjectPool.newBullet(x, y, degree, 4);
		ObjectPool.newBullet(x, y, degree+20, 4);
		ObjectPool.newBullet(x, y, degree-20, 4);
	}
        public static void FireAim2(double x, double y, Player player)
	{
		double degree = Math.toDegrees(Math.atan2(player.y - y, player.x - x));
		ObjectPool.newBullet(x, y, degree, 6);
		ObjectPool.newBullet(x, y, degree+20, 6);
		ObjectPool.newBullet(x, y, degree-20, 6);
                ObjectPool.newBullet(x, y, degree-40, 6);
                ObjectPool.newBullet(x, y, degree+40, 6);
	}
        public static void FireAim3(double x, double y, Player player)
	{
		double degree = Math.toDegrees(Math.atan2(player.y - y, player.x - x));
		ObjectPool.newBullet(x, y, degree, 4);
		ObjectPool.newBullet(x, y, degree+10, 4);
		ObjectPool.newBullet(x, y, degree-10, 4);
              
	}
        
        
}

