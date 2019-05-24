package proj;


import java.awt.*;
import java.awt.event.*;
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
		if (active)
		{
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    image = toolkit.getImage("playerShip2.gif");
			g.setColor(Color.red);
                        
                        g.drawImage(image, (int)(x-40), (int)(y-40), (int)80, (int)80,null );
                        
                        
			//g.drawLine((int)(x), (int)(y-14), (int)(x-10), (int)(y+7));
			//g.drawLine((int)(x), (int)(y-14), (int)(x+10), (int)(y+7));
			//g.drawLine((int)(x-10), (int)(y+7), (int)(x+10), (int)(y+7));
		}
	}
	
	
}
