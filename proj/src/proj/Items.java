/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import static proj.Title.image;


public class Items extends GameObject {
    
        int counter = 0;
	
	int Str;
	int type;
	
	boolean ishit = false;
	public static boolean boss = false;
        public static boolean shield = false;
	Player player;
	
	boolean startshoot;
	int shootnum;
        
         Items(Player iplayer)
	{
		
		player = iplayer;
		
		active = false;
	}
         
         public void activate(double ix, double iy)
	{
		x = ix;
		y = iy;
		type = ThreadLocalRandom.current().nextInt(0,2);
		active = true;			
		Str = 1; //Str 1 = 2 Shot 
		counter = 0;
		boolean ishit = false;
		shootnum = Level.getLevel();
		startshoot = false;
	}
        
         public void move()
	{
		
		switch(type)
		{
			case 0:
				move_item0();
                                shield = false;
				break;
                        case 1:
                                move_item0();
                                shield = true;
				break;
			default:
                                
		}
	}
         
         
         void move_item0()
	{
		counter++;
		y++;
		
		x += Math.sin(y / 20);
		
		
		if ( (600 < y) )
		{
                        shield = true;
			active = false;
		}
		
		
		
	}
         
         public void draw(Graphics g)
	{
            
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            switch(type)
            { 
                case 0:
                       image = toolkit.getImage("heart.gif");
                       g.setColor(Color.WHITE);
                       g.drawImage(image,(int)x+2, (int)y-16, (int)32, (int)32,null);
                       break;
                case 1:
                       image = toolkit.getImage("shield.png");
                       g.setColor(Color.WHITE);
                       g.drawImage(image,(int)x+2, (int)y-16, (int)32, (int)32,null);
                       break;
            }			
        }
}
