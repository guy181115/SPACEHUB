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
        public static boolean special = false;
        public static boolean special2 = false;
        public static boolean special3 = false;
        public static boolean special4 = false;
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
		
	}
         public void activate(double ix, double iy,int type)
	{
		x = ix;
		y = iy;
		this.type = type;
		active = true;			
		Str = 1; //Str 1 = 2 Shot 
		counter = 0;
		boolean ishit = false;

	}
        
         public void move()
	{
		
		switch(type)
		{
			case 0:
				move_item0();
				break;
                        case 1:
                                move_item0();
                                shield = true;
				break;
                        case 2:
                                move_item0();
                                shield = false;
                                special = true;
				break;       
                        case 3:
                                move_item0();
                                shield = false;
                                special = false;
                                special2 = true;
				break;     
                        case 4:
                                move_item0();
                                shield = false;
                                special = false;
                                special2 = false;
                                special3 = true;
				break; 
                        case 5:
                                move_item0();
                                shield = false;
                                special = false;
                                special2 = false;
                                special3 = false;
                                special4 = true;
				break; 
			default:
                                
		}
	}
         
         
         void move_item0()
	{
		counter++;
		y++;
		
		x += Math.sin(y / 20);
		
		
		if ( 580 <= y )
		{
                        shield = false;
                        special = false;
                        special2 = false;
                        special3 = false;
                        special4 = false;
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
                case 2:
                       image = toolkit.getImage("powerup.png");
                       g.setColor(Color.WHITE);
                       g.drawImage(image,(int)x, (int)y-16, (int)64, (int)64,null);
                       break;       
                case 3:
                       image = toolkit.getImage("powerup1.png");
                       g.setColor(Color.WHITE);
                       g.drawImage(image,(int)x, (int)y-16, (int)64, (int)64,null);
                       break;   
                case 4:
                       image = toolkit.getImage("powerup2.png");
                       g.setColor(Color.WHITE);
                       g.drawImage(image,(int)x, (int)y-16, (int)64, (int)64,null);
                       break;  
                case 5:
                       image = toolkit.getImage("powerup3.png");
                       g.setColor(Color.WHITE);
                       g.drawImage(image,(int)x, (int)y-16, (int)64, (int)64,null);
                       break;         
            }			
        }
}
