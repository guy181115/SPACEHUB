
package proj;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static proj.Enemy.*;
//import static proj.Enemy.type;



public class ObjectPool
{
	
        
	static Bullet[] bullet; //กระสุน
	
	static Enemy[] enemy; //ศัตรู
	
	static MyBullet[] mybullet; //กระสุนเรา
	
	static Particle[] particle; //สิ่งของในฉาก
        
        static Items[] items;
        
        static SpecialBullet[] specialbullet;

	
	Player player;
	
	
	static final int DIST_PLAYER_TO_BULLET = 30  ; //hit box ของผู้เล่นกะกระสุนอีกฝั่ง
	static final int DIST_PLAYER_TO_ENEMY = 25; //hit box ของผู้เล่นกะยานศัตรู
	static final int DIST_ENEMY_TO_MYBULLET = 25; //hit box ของยานศัตรูกะกระสุนเรา
	static final int DIST_BOSS1_TO_MYBULLET = 70;
	static final int DIST_BOSS2_TO_MYBULLET = 100;
        static final int DIST_BOSS3_TO_MYBULLET = 120;
        static final int DIST_PLAYER_TO_ITEMS = 40;
	static final int BULLET_MAX = 100;
	static final int ENEMY_MAX = 100;
	static final int PARTICLE_MAX = 100;
        static final int SPECIALBULLET_MAX = 20;
	static final int MYBULLET_MAX = 5; //จำนวนกระสุนที่ยิงออกไปต่อการยิง 1 ครั้ง
	public static boolean invulnerable = false;
        static final int ITEMS_MAX = 50;
        public static boolean powerup = false;
        public static boolean powerup2 = false;
        public static boolean powerup3 = false;
        public static boolean powerup4 = false;
        int counter = 0;
	
	ObjectPool()
	{
		
		player = new Player(300, 400, 4);
		player.active = true;
		
		
		bullet = new Bullet[BULLET_MAX];
		for(int i = 0; i < bullet.length; i++)
		{
				bullet[i] = new Bullet();
		}

		
		enemy = new Enemy[ENEMY_MAX];
		for(int i = 0; i < enemy.length; i++)
		{
				enemy[i] = new Enemy(player);
		}
		
		
		mybullet = new MyBullet[MYBULLET_MAX];
		for(int i = 0; i < mybullet.length; i++)
		{
				mybullet[i] = new MyBullet();
		}

		
		particle = new Particle[PARTICLE_MAX];
		for(int i = 0; i < particle.length; i++)
		{
				particle[i] = new Particle();
		}
                
                items = new Items[ITEMS_MAX];
		for(int i = 0; i < items.length; i++)
		{
				items[i] = new Items(player);
		}
                specialbullet = new SpecialBullet[SPECIALBULLET_MAX];
		for(int i = 0; i < specialbullet.length; i++)
		{
				specialbullet[i] = new SpecialBullet();
		}
	}

	
	public void drawAll(Graphics g)
	{
        doGameObjects(g, bullet);
        doGameObjects(g, enemy);
        doGameObjects(g, mybullet);
        doGameObjects(g, particle);
        doGameObjects(g, items);
        doGameObjects(g, specialbullet);
	player.draw(g);
	}

	
    public void doGameObjects(Graphics g, GameObject[] objary)
    {
        for (int i = 0; i < objary.length; i++) {
			
            if (objary[i].active == true)
			{
                objary[i].move();
                objary[i].draw(g);				
            }
        }
    }
    
  
	public static int newBullet(double ix, double iy, double idirection, double ispeed)
	{
		for (int i = 0; i < BULLET_MAX; i++)
		{
			if ((bullet[i].active) == false)
			{
				bullet[i].activate(ix, iy, idirection, ispeed);
				return i;
			}
		}
		return -1;		
	}

    
	public static int newEnemy(double ix, double iy)
	{
		for (int i = 0; i < ENEMY_MAX; i++)
		{
			if ((enemy[i].active) == false)
			{
				enemy[i].activate(ix, iy);
				return i;
			}
		}
		return -1;		
	}
        
        
        
        public static int newBoss1(){
            for (int i = 0; i < 1; i++)
		{
			if ((enemy[i].active) == false)
			{
				enemy[i].activate2(300, 0);
				return i;
			}
		}
		return -1;	
        }
        
        public static int newBoss2(){
            for (int i = 0; i < 1; i++)
		{
			if ((enemy[i].active) == false)
			{
				enemy[i].activate3(310, 0);
				return i;
			}
		}
		return -1;	
        }
        
        public static int newBoss3(){
            for (int i = 0; i < 1; i++)
		{
			if ((enemy[i].active) == false)
			{
				enemy[i].activate4(310, 0);
				return i;
			}
		}
		return -1;	
        }
        public static int newBoss4(){
            for (int i = 0; i < 1; i++)
		{
			if ((enemy[i].active) == false)
			{
				enemy[i].activate5(310, 0);
				return i;
			}
		}
		return -1;	
        }
        public static int newBoss5(){
            for (int i = 0; i < 1; i++)
		{
			if ((enemy[i].active) == false)
			{
				enemy[i].activate6(310, 0);
				return i;
			}
		}
		return -1;	
        }
        
       public static int newItems(double ix, double iy){
           for (int i = 0; i < ITEMS_MAX; i++)
		{
			if ((items[i].active) == false)
			{
				items[i].activate(ix-5, iy);
				return i;
			}
		}
		return -1;
       }
       public static int newItems(double ix, double iy,int type){
           for (int i = 0; i < 5; i++)
		{
			if ((items[i].active) == false)
			{
				items[i].activate(ix-5, iy, type);
				return i;
			}
		}
		return -1;
       }
       
    
	public static int newMyBullets(double ix, double iy)
	{
		for (int i = 0; i < MYBULLET_MAX; i++)
		{
			if ((mybullet[i].active) == false)
			{
				mybullet[i].activate(ix, iy);
				return i;
			}
		}
		return -1;		
	}
        public static int newmyBulletsPowerUp(double ix, double iy,double idirection, double ispeed)
	{
		for (int i = 0; i < SPECIALBULLET_MAX; i++)
		{
			if ((specialbullet[i].active) == false)
			{
				specialbullet[i].activate(ix, iy,idirection,ispeed);
				return i;
                                
			}
                        
		}
		return -1;		
	}
        
          public static int newmyBulletsPowerUp(double ix, double iy)
	{
		for (int i = 0; i < SPECIALBULLET_MAX; i++)
		{
			if ((specialbullet[i].active) == false)
			{
				specialbullet[i].activate(ix, iy);
				return i;
                                
			}
                        
		}
		return -1;		
	}

    
	public static int newParticle(double ix, double iy, double idirection, double ispeed)
	{
		for (int i = 0; i < PARTICLE_MAX; i++)
		{
			if ((particle[i].active) == false)
			{
				particle[i].activate(ix, iy, idirection, ispeed);
				return i;
			}
		}
		return -1;		
	}

	
	public void shotPlayer()
	{
		
		if (player.active)
		{
                        if(powerup==false)
			newMyBullets(player.x, player.y);
                        else if(powerup==true&&powerup2==false&&powerup3==false&&
                                powerup4==false){
                        SpecialBullet.FireAim2(player.x,player.y);
                        }
                        else if(powerup==true&&powerup2==true&&powerup3==false&&
                                powerup4==false){
                                
                        SpecialBullet.FireAim(player.x,player.y);
                        
                        }
                        else if(powerup==true&&powerup2==true&&powerup3==true&&
                                powerup4==false){
                                
                        SpecialBullet.FireAim(player.x,player.y);
                        SpecialBullet.FireAim1(player.x+80,player.y);
                        
                        }
                        else if(powerup==true&&powerup2==true&&powerup3==true&&
                                powerup4==true){
                                
                        SpecialBullet.FireAim(player.x,player.y);
                        SpecialBullet.FireAim1(player.x+80,player.y);
                        SpecialBullet.FireAim0(player.x-80,player.y);
                        
                        }
                            
		}
	}

	
	public void movePlayer(KeyInput keyinput)
	{
		player.move(keyinput.getXDirection(), keyinput.getYDirection());
	}
	
	
	public double getDistance(GameObject ga, GameObject gb)
	{
		
		double Xdiff = Math.abs(ga.x - gb.x);
		double Ydiff = Math.abs(ga.y - gb.y);
		return Math.sqrt(Math.pow(Xdiff,2) + Math.pow(Ydiff,2));
	}

	public static int x = 3;
        public static int y = 0;
	public void getColision()
	{
            
		
        for (int i = 0; i < bullet.length; i++) {
			if ((bullet[i].active)&&(player.active))
			{
				
				if (getDistance(player, bullet[i]) < DIST_PLAYER_TO_BULLET&&invulnerable == false)
				{
                                    x--;
					if(x==0)
                                        {
					player.active = true;
                                        
                                        }

					
					for (int j = 0; j < 360; j += 20)
					{
						newParticle(player.x, player.y, j, 2);
					}

					
					bullet[i].active = false;
				}
                                else if (getDistance(player, bullet[i]) < DIST_PLAYER_TO_BULLET&&invulnerable == true)
				{
                                    
                                    y--;
					if(y==0)
                                        {
					invulnerable = false;
                                        
                                        }

					
					for (int j = 0; j < 360; j += 20)
					{
						newParticle(player.x, player.y, j, 2);
					}

					
					bullet[i].active = false;
				}
                                
			}
        }

		
        for (int i = 0; i < enemy.length; i++) {
			if (enemy[i].active == true)
			{
				for (int j = 0; j < mybullet.length; j++)
				{
					if (mybullet[j].active == true)
					{
                                                if(boss == true)
                                                {
                                                    if (getDistance(enemy[i], mybullet[j]) < DIST_BOSS1_TO_MYBULLET&& boss1 == true)
                                                    {
							newParticle(mybullet[j].x, mybullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							mybullet[j].active = false;
                                                    }
                                                    if (getDistance(enemy[i], mybullet[j]) < DIST_BOSS2_TO_MYBULLET&& boss2 == true)
                                                    {
							newParticle(mybullet[j].x, mybullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							mybullet[j].active = false;
                                                    }
                                                     if (getDistance(enemy[i], mybullet[j]) < DIST_BOSS3_TO_MYBULLET&& boss3 == true)
                                                    {
							newParticle(mybullet[j].x, mybullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							mybullet[j].active = false;
                                                    }
                                                      if (getDistance(enemy[i], mybullet[j]) < DIST_BOSS3_TO_MYBULLET&& boss4 == true)
                                                    {
							newParticle(mybullet[j].x, mybullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							mybullet[j].active = false;
                                                    }
                                                      if (getDistance(enemy[i], mybullet[j]) < DIST_BOSS3_TO_MYBULLET&& boss5 == true)
                                                    {
							newParticle(mybullet[j].x, mybullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							mybullet[j].active = false;
                                                    }
                                                }
                                                
                                                
                                                 if (getDistance(enemy[i], mybullet[j]) < DIST_ENEMY_TO_MYBULLET)
                                                    {
                                                        
							newParticle(mybullet[j].x, mybullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							mybullet[j].active = false;
                                                       
                                                    }
                                                
					}
				}
                                for (int j = 0; j < specialbullet.length; j++)
				{
					if (specialbullet[j].active == true)
					{
                                                if(boss == true)
                                                {
                                                    if (getDistance(enemy[i], specialbullet[j]) < DIST_BOSS1_TO_MYBULLET&& boss1 == true)
                                                    {
							newParticle(specialbullet[j].x, specialbullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							specialbullet[j].active = false;
                                                    }
                                                    if (getDistance(enemy[i], specialbullet[j]) < DIST_BOSS2_TO_MYBULLET&& boss2 == true)
                                                    {
							newParticle(specialbullet[j].x, specialbullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							specialbullet[j].active = false;
                                                    }
                                                    if (getDistance(enemy[i], specialbullet[j]) < DIST_BOSS3_TO_MYBULLET&& boss3 == true)
                                                    {
							newParticle(specialbullet[j].x, specialbullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							specialbullet[j].active = false;
                                                    }
                                                    if (getDistance(enemy[i], specialbullet[j]) < DIST_BOSS3_TO_MYBULLET&& boss4 == true)
                                                    {
							newParticle(specialbullet[j].x, specialbullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							specialbullet[j].active = false;
                                                    }
                                                    if (getDistance(enemy[i], specialbullet[j]) < DIST_BOSS3_TO_MYBULLET&& boss5 == true)
                                                    {
							newParticle(specialbullet[j].x, specialbullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							specialbullet[j].active = false;
                                                    }
                                                }
                                                
                                                
                                                 if (getDistance(enemy[i], specialbullet[j]) < DIST_ENEMY_TO_MYBULLET)
                                                    {
                                                        
							newParticle(specialbullet[j].x, specialbullet[j].y, 270, 2);
							
							enemy[i].hit();
							
							specialbullet[j].active = false;
                                                       
                                                    }
                                                
					}
				}
			}
        }

		
        for (int i = 0; i < enemy.length; i++) {
			if ((enemy[i].active)&&(player.active))
			{
				
				if (getDistance(player, enemy[i]) < DIST_PLAYER_TO_ENEMY&&invulnerable == false)
				{
					
					player.active = false;

					
					for (int j = 0; j < 360; j += 20)
					{
						newParticle(player.x, player.y, j, 2);
					}
					
				}
                               else if (getDistance(player, enemy[i]) < DIST_PLAYER_TO_ENEMY&&invulnerable == true)
				{
					
					y--;
                                        if(y==0)
                                        {
					invulnerable = false;
                                        
                                        }
					
					for (int j = 0; j < 360; j += 20)
					{
						newParticle(player.x, player.y, j, 2);
					}
					
				}
                                
			}
        }
        
         for (int i = 0; i < items.length; i++) {
			if ((items[i].active)&&(player.active))
			{
				
				if (getDistance(player, items[i]) < DIST_PLAYER_TO_ITEMS)
				{ 
                                    if(Items.shield==true&&invulnerable == false)
                                    {
                                        y += 5;
                                        Items.shield=false;
                                        invulnerable = true;
                                        items[i].active = false;

                                    }
                                    else if(Items.special==true)
                                    {
                                        powerup = true;
                                        Items.special=false;
                                    }
                                    else if(Items.special2==true)
                                    {
                                        powerup = true;
                                        powerup2 = true;
                                        Items.special2=false;
                                    }
                                    else if(Items.special3==true)
                                    {
                                        powerup3 = true;
                                        Items.special=false;
                                    }
                                    else if(Items.special4==true)
                                    {
                                        powerup4 = true;
                                        Items.special=false;
                                    }
					else
					x++;
                                    
                                        items[i].active = false;
					
					
					
				}
			}
        }

	}
	
	
	public boolean isGameover()
	{
		return !player.active;
	}
	
	
	
}
