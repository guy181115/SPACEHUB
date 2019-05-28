package proj;


import java.awt.*;
import java.awt.event.*;
import static proj.ObjectPool.invulnerable;
import static proj.ObjectPool.*;
import static proj.Title.image;


public class Player extends GameObject
{
    double speed;
    
	//ix จุดเริ่มต้นแกน x iy จุดเริ่มต้นแกน y
    Player(double ix, double iy, double ispeed)
    {
                x = ix;
		y = iy;
		speed = ispeed;
		active = false;
	}

    
    public void move()
    {
    }
	
	
	public void move(int mx, int my)
	{
		
		double postX = x + mx * speed;
		double postY = y + my * speed;
		
		if ((0 < postX)&&(postX < 580)) //เคลื่อนที่แกนx จาก 0 ไป 580
		{
			x = postX;
		}
		if ((0 < postY)&&(postY < 546)) //เคลื่อนที่แกนy จาก 0 ไป 546
		{
			y = postY;
		}
	}
	
	
	public void draw(Graphics g)
	{
            Toolkit toolkit = Toolkit.getDefaultToolkit();
		if (active)
		{
                    
                    image = toolkit.getImage("playerShip2.gif");
			g.setColor(Color.red);
                        
                        g.drawImage(image, (int)(x-40), (int)(y-40), (int)80, (int)80,null );
                        image = toolkit.getImage("shiphai.gif");
			g.setColor(Color.red);
                        if(powerup3==true)
                        g.drawImage(image, (int)(x+68), (int)(y-30), (int)24, (int)24,null );
                        if(powerup4==true)
                        g.drawImage(image, (int)(x-90), (int)(y-30), (int)24, (int)24,null );
			//g.drawLine((int)(x), (int)(y-14), (int)(x-10), (int)(y+7));
			//g.drawLine((int)(x), (int)(y-14), (int)(x+10), (int)(y+7));
			//g.drawLine((int)(x-10), (int)(y+7), (int)(x+10), (int)(y+7));
		}
                
                if(invulnerable == true)
                {
                    image = toolkit.getImage("shield.png");
			g.setColor(Color.red);
                        
                        g.drawImage(image, (int)(x-40), (int)(y-40), (int)80, (int)80,null );
                }
                
                
	}
	
	
}
