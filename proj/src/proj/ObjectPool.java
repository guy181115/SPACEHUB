
package proj;

import java.awt.*;
import java.awt.event.*;
import static proj.Enemy.boss;
//import static proj.Enemy.type;



public class ObjectPool
{
	
        
	static Bullet[] bullet; //กระสุน
	
	static Enemy[] enemy; //ศัตรู
	
	static MyBullet[] mybullet; //กระสุนเรา
	
	static Particle[] particle; //สิ่งของในฉาก
        
        static Items[] items;

	
	Player player;
	
	
	static final int DIST_PLAYER_TO_BULLET = 30  ; //hit box ของผู้เล่นกะกระสุนอีกฝั่ง
	static final int DIST_PLAYER_TO_ENEMY = 25; //hit box ของผู้เล่นกะยานศัตรู
	static final int DIST_ENEMY_TO_MYBULLET = 25; //hit box ของยานศัตรูกะกระสุนเรา
	static final int DIST_BOSS_TO_MYBULLET = 70;
	
	static final int BULLET_MAX = 100;
	static final int ENEMY_MAX = 100;
	static final int PARTICLE_MAX = 100;
	static final int MYBULLET_MAX = 5; //จำนวนกระสุนที่ยิงออกไปต่อการยิง 1 ครั้ง
	
        static final int ITEMS_MAX = 50;
	
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
	}

	
	public void drawAll(Graphics g)
	{
        doGameObjects(g, bullet);
        doGameObjects(g, enemy);
        doGameObjects(g, mybullet);
        doGameObjects(g, particle);
        doGameObjects(g, items);
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
				enemy[i].activate3(280, 0);
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
				items[i].activate(ix, iy);
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
			newMyBullets(player.x, player.y);
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
	public void getColision()
	{
            
		
        for (int i = 0; i < bullet.length; i++) {
			if ((bullet[i].active)&&(player.active))
			{
				
				if (getDistance(player, bullet[i]) < DIST_PLAYER_TO_BULLET)
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
                                                    if (getDistance(enemy[i], mybullet[j]) < DIST_BOSS_TO_MYBULLET)
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
			}
        }

		
        for (int i = 0; i < enemy.length; i++) {
			if ((enemy[i].active)&&(player.active))
			{
				
				if (getDistance(player, enemy[i]) < DIST_PLAYER_TO_ENEMY)
				{
					
					player.active = false;

					
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
				
				if (getDistance(player, items[i]) < DIST_PLAYER_TO_ENEMY)
				{
					
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
