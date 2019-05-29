/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.logging.Logger;
import static proj.KeyInput.pressed;
import static proj.Title.image;
import static proj.Enemy.boss;
public class MyCanvas extends Canvas implements Runnable {

    ObjectPool objectpool;
    KeyInput keyinput;
    Image imgBuf;
    Graphics gBuf;
    Random random;
    Title title;
    Score score;
    public static Thread thread; 
    private volatile boolean running = true;
    public static  boolean paused = false;
    public static Object pauseLock = new Object();
    public int scene;
    static final int SCENE_TITLE = 0;

    static final int SCENE_GAMEMAIN = 1;

    public boolean gameover;
    int counter;

    static final int SHOT_PRESSED = 1;

    static final int SHOT_DOWN = 2;

    int shotkey_state;
    int pausekey_state;


    MyCanvas() {

        keyinput = new KeyInput();  //เช็คว่ากดอะไร
        addKeyListener(keyinput);
        setFocusable(true);
        random = new Random();
        title = new Title();
        score = new Score();
    }

    public void init() {
        objectpool = new ObjectPool();
        Score.loadScore();

        scene = SCENE_TITLE;
        gameover = false;

        Level.initLevel();
        ObjectPool.x = 30;
        ObjectPool.y = 0;
        Score.initScore();
    }

    public void initThread(String name) {
        thread = new Thread(this,name);
        thread.start();

    }

    public void paint(Graphics g) {

        g.drawImage(imgBuf, 0, 0, this);
    }

    public void run() {

        

                try {
                    

            imgBuf = createImage(600, 600);  // พื้นหลัง
            gBuf = imgBuf.getGraphics();

            for (counter = 0;; counter++) {
                shotkey_state = keyinput.checkShotKey();
                pausekey_state = keyinput.checkESCKey();

                gBuf.setColor(Color.white);
                gBuf.fillRect(0, 0, 600, 600);
               

                switch (scene) {

                    case 0: //หน้าแรก
                        planet(gBuf);
                        title.drawTitle(gBuf);
                        

                        score.drawHiScore(gBuf);

                        if (shotkey_state == SHOT_DOWN) {
                             
                            scene = SCENE_GAMEMAIN;
                        }
                        break;

                    case 1:
                            
                        gameMain();
                        break;
                }
                
                repaint();
                    Thread.sleep(15);
                }
                } catch (InterruptedException e) {
                }

            
        }
    
    
    
    
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    
    
    void gameMain() {
        
        space(gBuf);
        hearts(gBuf);
        boss = false;
        if(paused == true){
         
         
              title.drawPausemenu(gBuf);
  
                pause();
          
          
      }
        
        
        if (objectpool.isGameover()) { //ตาย
            
            title.drawGameover(gBuf);
            
            if (shotkey_state == SHOT_DOWN) {
                ObjectPool.powerup =false;
                ObjectPool.y=0;
                Items.special=false;
                ObjectPool.x=3;
                Score.compareScore();
                init();
                ObjectPool.powerup2 =false;
                ObjectPool.powerup4 = false;
                ObjectPool.powerup3 = false;
            }
        }
        if(Level.getLevel()==26){
            
            
                title.drawWin(gBuf);
                
            
            if (shotkey_state == SHOT_DOWN) {
                ObjectPool.powerup =false;
                ObjectPool.y=0;
                Items.special=false;
                ObjectPool.x=3;
                Score.compareScore();
                init();
                ObjectPool.powerup2 =false;
                ObjectPool.powerup4 = false;
                ObjectPool.powerup3 = false;
            
        }
        }
        
        if(Level.getLevel()==5){
            boss = true;
            Enemy.boss1 = true;
            ObjectPool.newBoss1();
           /* title.drawWin(gBuf);
            if (shotkey_state == SHOT_DOWN) {
                Score.compareScore();
                init();

            }*/
        }
        
       
         
        
        if(Level.getLevel()==10){
            boss = true;
            Enemy.boss2 = true;
            ObjectPool.newBoss2();
           /* title.drawWin(gBuf);
            if (shotkey_state == SHOT_DOWN) {
                Score.compareScore();
                init();

            }*/
        }
        if(Level.getLevel()==15){
            boss = true;
            Enemy.boss3 = true;
            ObjectPool.newBoss3();
           /* title.drawWin(gBuf);
            if (shotkey_state == SHOT_DOWN) {
                Score.compareScore();
                init();

            }*/
        }
        
        
        if(Level.getLevel()==20){
            boss = true;
            Enemy.boss4 = true;
            ObjectPool.newBoss4();
           /* title.drawWin(gBuf);
            if (shotkey_state == SHOT_DOWN) {
                Score.compareScore();
                init();

            }*/
        }
        if(Level.getLevel()==25){
            boss = true;
            Enemy.boss5 = true;
            ObjectPool.newBoss5();
           /* title.drawWin(gBuf);
            if (shotkey_state == SHOT_DOWN) {
                Score.compareScore();
                init();

            }*/
        }
         

        objectpool.getColision();
        objectpool.movePlayer(keyinput);

        if (counter % (280 - Level.getLevel() * 10) == 0 && boss == false&&Level.getLevel()<25) {
            ObjectPool.newEnemy(100 + random.nextInt(300), 0);
        }
        
        if (counter % (800 - Level.getLevel() * 10) == 0 &&Level.getLevel()!=5&&
                Level.getLevel()!=6&&Level.getLevel()!=7&&Level.getLevel()!=10&&
                Level.getLevel()!=11&&Level.getLevel()!=12&&Level.getLevel()!=15&&
                Level.getLevel()!=16&&Level.getLevel()!=17&&Level.getLevel()!=20&&
                Level.getLevel()!=21&&Level.getLevel()!=22&&Level.getLevel()!=25) {
            ObjectPool.newItems(100 + random.nextInt(300), 0);
        }

        if ((counter % 500) == 0/*&&Level.getLevel()<3*/&& boss == false&&Level.getLevel()<26) {
            Level.addLevel();
        }

        if ((shotkey_state == SHOT_PRESSED) && (counter % 3 == 0)) {
            objectpool.shotPlayer();
            Music sound = new Music(); 
                            sound.setFile("laser1.wav");
                            sound.play();

        }

        objectpool.drawAll(gBuf);

        score.drawScore(gBuf);
        score.drawHiScore(gBuf);
        
    }


    public void pause(){
          
            thread.suspend();
        } 
             public void planet(Graphics g){
              Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage("planet.gif");
         g.drawImage(image, 0, 0, this);
        }
             public void space(Graphics g){
              Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage("space.gif");
         g.drawImage(image, 0, 0, this);
        }
         public void hearts(Graphics g){
             Toolkit toolkit = Toolkit.getDefaultToolkit();
           image = toolkit.getImage("heart.gif");
         g.drawImage(image, 10, 490,(int)40,(int)40, this);
         g.drawString("X"+ObjectPool.x, 50, 516);
         }
    }
   
    

