/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import static proj.Title.image;

/**
 *
 * @author Napath
 */
public class SpecialBullet extends GameObject
{       
        double direction;
	double speed;
	double speedX;
	double speedY;
	
	SpecialBullet()
	{
		active = false;
	}
	
	
	public void move()
	{
        
		y -= 20;
		
		if ( y<0 ) //600
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
        public void activate(double ix, double iy,double idirection, double ispeed)
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
        public static void FireAim(double x, double y)
	{
		
		ObjectPool.newmyBulletsPowerUp(x-30, y);
		ObjectPool.newmyBulletsPowerUp(x, y);
		ObjectPool.newmyBulletsPowerUp(x+30, y);
	}
        public static void FireAim2(double x, double y)
	{
		
		ObjectPool.newmyBulletsPowerUp(x-5, y);
		ObjectPool.newmyBulletsPowerUp(x+5, y);
	}
        
        public static void FireRound(double x, double y, Player player)
	{
		for (int i = 0; i < 360; i += 60 )
		{
			ObjectPool.newmyBulletsPowerUp(x, y, i, 3);
		}
	}
}


    

