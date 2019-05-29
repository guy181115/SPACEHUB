/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

/**
 *
 * @author Napath
 */

import java.awt.*;
import java.awt.event.*;


import java.util.Random;

import static proj.Title.image;


public class Enemy extends GameObject
{
	
	int counter = 0;
	
	int Str;
	int type;
	
	boolean ishit = false;
	public static boolean boss = false;
	Player player;
	
	boolean startshoot;
	int shootnum;
        public static boolean boss1 = false;
        public static boolean boss2 = false;
        public static boolean boss3 = false;
        public static boolean boss4 = false;
        public static boolean boss5 = false;
        public static boolean boss6 = false;
	Random random;
	Enemy(Player iplayer)
	{
		
		player = iplayer;
		
		active = false;
	}

	
	public void activate(double ix, double iy)
	{
		x = ix;
		y = iy;
		type = (int)(Math.random()+0.5);
		active = true;			
		Str = 1; //Str 1 = 2 Shot 
		counter = 0;
		boolean ishit = false;
		shootnum = Level.getLevel();
		startshoot = false;
	}
        public void activate2(double ix, double iy)
	{
		x = ix;
		y = iy;
		type = 2;
		active = true;			
		Str = 200; //Str 1 = 2 Shot 
		counter = 0;
		boolean ishit = false;
		shootnum = Level.getLevel();
		startshoot = false;
	}
        public void activate3(double ix, double iy)
	{
		x = ix;
		y = iy;
		type = 3;
		active = true;			
		Str = 800; //Str 1 = 2 Shot 
		counter = 0;
		boolean ishit = false;
		shootnum = Level.getLevel();
		startshoot = false;
                
	}
        public void activate4(double ix, double iy)
	{
		x = ix;
		y = iy;
		type = 4;
		active = true;			
		Str = 1000; //Str 1 = 2 Shot 
		counter = 0;
		boolean ishit = false;
		shootnum = Level.getLevel();
		startshoot = false;
                
	}
        public void activate5(double ix, double iy)
	{
		x = ix;
		y = iy;
		type = 5;
		active = true;			
		Str = 1500; //Str 1 = 2 Shot 
		counter = 0;
		boolean ishit = false;
		shootnum = Level.getLevel();
		startshoot = false;
                
	}
        public void activate6(double ix, double iy)
	{
		x = ix;
		y = iy;
		type = 6;
		active = true;			
		Str = 1800; //Str 1 = 2 Shot 
		counter = 0;
		boolean ishit = false;
		shootnum = Level.getLevel();
		startshoot = false;
                
	}

	
	public void hit()
	{
		
		Str--;
		ishit = true;
		if (Str < 0)
		{
			
			switch(type)
			{
				case 0:
					Score.addScore(10);
					break;
				case 1:
					Score.addScore(20);
					break;
                                case 2:
					Score.addScore(100);
                                        Level.addLevel();
                                        ObjectPool.newItems(280, 0,2);
                                        boss = false;
                                        
                                        System.out.println(boss);
                                        
					break;
                                case 3:
					Score.addScore(150);
                                        Level.addLevel();
                                        ObjectPool.newItems(280, 0,3);
                                        boss = false;
                                        System.out.println(boss);
					break;
                                case 4:
					Score.addScore(200);
                                        Level.addLevel();
                                        ObjectPool.newItems(280, 0,4);
                                        boss = false;
                                        System.out.println(boss);
					break;
                                case 5:
					Score.addScore(250);
                                        Level.addLevel();
                                        ObjectPool.newItems(280, 0,5);
                                        boss = false;
                                        System.out.println(boss);
                                        
					break;               
				default:
                                    
                                case 6:
					Score.addScore(300);
                                        if(Level.getLevel() == 25)
                                        Level.addLevel();
                                        boss = false;
                                        Music sound = new Music(); 
                                        sound.setFile("Victory.wav");
                                        sound.play();
                                        System.out.println("YOU WIN");
					break;           
			}
			
			ObjectPool.newParticle(x, y, 45, 2);
			ObjectPool.newParticle(x, y, 135, 2);
			ObjectPool.newParticle(x, y, 225, 2);
			ObjectPool.newParticle(x, y, 315, 2);
			active = false;
		}
	}
	
	
	public void move()
	{
		
		switch(type)
		{
			case 0:
				move_enemy0();
				break;
			case 1:
				move_enemy1();
				break;
                        case 2:
				move_boss1();
				break;
                        case 3:
				move_boss2();
				break;
                        case 4:
				move_boss3();
				break;
                        case 5:
				move_boss4();
				break;   
                        case 6:
				move_boss5();
				break;           
			default:
		}
	}
	
	
	void move_enemy0()
	{
		counter++;
		y++;
		
		x += Math.sin(y / 20);
		
		
		if ( (600 < y) )
		{
			active = false;
		}
		
		
		if ((counter%80)==0)
		{
			Bullet.FireRound(x, y);
		}
	}

	
	void move_enemy1()
	{
		counter++;
		double p = 60;	
		double q = 200;	
		
		y = (-q / Math.pow(p,2) * Math.pow((counter - p), 2) + q);

		
		if ( (-30 > y) )
		{
			active = false;
		}
		
	
		if ((counter%60)==0)
		{
			
			startshoot = true;
		}
		
		
		if (startshoot)
		{
			if (((counter%5)==0)&&(shootnum>0))
			{
				Bullet.FireAim(x, y, player);
				shootnum--;
			}
		}
	}
        void move_boss1()
	{       if(y<=40)
                y++;
		counter++;
		
		
		
	
		if ((counter%60)==0)
		{
			
			startshoot = true;
		}
		
		
		if (startshoot)
		{
                     if (((counter%50)==0))
			{
				Bullet.FireAim(x-25, y+80, player);
				
			}
                    
		}
	}
        
        void move_boss2()
	{       if(y<=40)
                y++;
		counter++;
		
		
		
	
		if ((counter%60)==0)
		{
			
			startshoot = true;
		}
		
		
		if (startshoot)
		{
                    if (((counter%150)==0))
			{
				Bullet.FireRound(x-10, y+80);
				
			}
                    if (((counter%40)==0))
			{
				Bullet.FireAim3(x-25, y+80, player);
				
			}
                   
		}
	}
        
        void move_boss3()
	{       if(y<=40)
                y++;
		counter++;
		
		
		
	
		if ((counter%60)==0)
		{
			
			startshoot = true;
		}
		
		
		if (startshoot)
		{
                    if (((counter%150)==0))
			{
				Bullet.FireRound2(x-10, y+80);
				
			}
                    if (((counter%40)==0))
			{
				Bullet.FireAim2(x-25, y+80, player);
				
			}
                   
		}
	}
        void move_boss4()
	{       if(y<=40)
                y++;
		counter++;
		
		
		
	
		if ((counter%60)==0)
		{
			
			startshoot = true;
		}
		
		
		if (startshoot)
		{
                    if (((counter%200)==0))
			{
				Bullet.FireAim3(x-25, y+80, player);
				
			}
                    if (((counter%100)==0))
			{
				Bullet.FireAim2(x-25, y+80, player);
				
			}
                    if (((counter%50)==0))
			{
				Bullet.FireAim(x-25, y+80, player);
				
			}
                   
		}
	}
        void move_boss5()
	{       if(y<=40)
                y++;
		counter++;
		
		
		
	
		if ((counter%60)==0)
		{
			
			startshoot = true;
		}
		
		
		if (startshoot)
		{
                    if (((counter%150)==0))
			{
				Bullet.FireRound2(x-10, y+80);
				
			}
                    if (((counter%80)==0))
			{
				Bullet.FireRound3(x-10, y+80);
				
			}
                    if (((counter%40)==0))
			{
				Bullet.FireAim2(x-25, y+80, player);
				
			}
                   
		}
	}
	
	
	public void draw(Graphics g)
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		if (ishit)
		{
			g.setColor(Color.orange);
		}else{
			switch(type)
			{
				case 0:
					
                                        image = toolkit.getImage("ship2.gif");
                                        g.setColor(Color.WHITE);
                                        g.drawImage(image,(int)x+2, (int)y-16, (int)32, (int)32,null);
					break;
				case 1:
                                        
                                        image = toolkit.getImage("ship2.gif");
                                        g.setColor(Color.WHITE);
                                        g.drawImage(image,(int)x+2, (int)y-16, (int)32, (int)32,null);
					g.setColor(Color.blue);
					break;
                                case 2:
			
                                        image = toolkit.getImage("boss1.gif");
                                        g.setColor(Color.WHITE);
                                        g.drawImage(image,(int)x-70, (int)y, (int)128, (int)128,null);
					break;
                                       
                                case 3:
			
                                        image = toolkit.getImage("boss2new.gif");
                                        g.setColor(Color.WHITE);
                                        g.drawImage(image,(int)x-130, (int)y+10, (int)256, (int)256,null);
					break;
                                case 4:
			
                                        image = toolkit.getImage("boss3new.gif");
                                        g.setColor(Color.WHITE);
                                        g.drawImage(image,(int)x-160, (int)y+10, (int)301, (int)123,null);
					break;
                                case 5:
			
                                        image = toolkit.getImage("boss4.gif");
                                        g.setColor(Color.WHITE);
                                        g.drawImage(image,(int)x-160, (int)y+10, (int)280, (int)104,null);
					break;        
                                case 6:
			
                                        image = toolkit.getImage("lastboss.gif");
                                        g.setColor(Color.WHITE);
                                        g.drawImage(image,(int)x-160, (int)y+10, (int)301, (int)123,null);
					break;        
				default:
			}
		}
		ishit = false;
                
	}
	

}

