
package proj;


import java.awt.*;
import java.awt.event.*;
import static proj.MyCanvas.paused;
import static proj.MyCanvas.thread;


public class KeyInput extends Thread implements KeyListener
{
    
	public static boolean pressed = false;
	boolean keyup;
	boolean keydown;
	boolean keyleft;
	boolean keyright;
        int keyesc ;
	int keyshot; // spacebar
        
	KeyInput() {
		keyup = false;
		keydown = false;
		keyleft = false;
		keyright = false;
                keyesc = 1;
		keyshot = 0;
	}

	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_LEFT )
		{
			keyleft = true;
		}
		if (keycode == KeyEvent.VK_RIGHT)
		{
			keyright = true;
		}
		if (keycode == KeyEvent.VK_UP)
		{
			keyup = true;
		}
		if (keycode == KeyEvent.VK_DOWN)
		{
			keydown = true;
		}
		if (keycode == KeyEvent.VK_SPACE)
		{
			
			if (keyshot == 0)
			{
				
				keyshot = 2;
			}
			else
			{
				
				keyshot = 1;
			}
		}
		
            if (keycode == KeyEvent.VK_ESCAPE) //ตั้งให้กด esc แล้ว pause
		{
                    pressed = true;
                    
                    if (keyesc == 1 )
			{
				
				keyesc = 2;
                                paused = true;
                                
                                  
			}
			else
			{
                               
				paused = false;
				keyesc = 1;
                                thread.resume();
                         }
                    checkESCKey();
                                
			}
		
                   }
        
	
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == KeyEvent.VK_LEFT)
		{
			keyleft = false;
		}
		if (keycode == KeyEvent.VK_RIGHT)
		{
			keyright = false;
		}
		if (keycode == KeyEvent.VK_UP)
		{
			keyup = false;
		}
		if (keycode == KeyEvent.VK_DOWN)
		{
			keydown = false;
		}
		if (keycode == KeyEvent.VK_SPACE)
		{
			keyshot = 0;
		}
               
             
               
	}
	
	
	public int getXDirection()
	{
		int ret = 0;	
		if (keyright)
		{
			ret = 1;
		}
		if (keyleft)
		{
			ret = -1;
		}
		return ret;
	}
	
	
	public int getYDirection()
	{
		int ret = 0;	
		if (keydown)
		{
			ret = 1;
		}
		if (keyup)
		{
			ret = -1;
		}
		return ret;
	}
	
	
	public int checkShotKey()
	{
		int ret = keyshot;
		if (keyshot==2)
		{
			keyshot = 1;
		}
		return ret;
	}
        public int checkESCKey()
	{       pressed = false;
                
		int pau = keyesc;
		return pau;
	}

    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    public void initThread(String name) {
        Thread KeyThread = new Thread(this,name);
        KeyThread.start();

    }
 
}
