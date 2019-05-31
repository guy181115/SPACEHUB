
package proj;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static proj.MyCanvas.thread;
public class MouseInput extends Thread implements MouseListener {
     boolean start = false;
    boolean quit = false;
   boolean help = false;
   boolean esc = false;
    public static int state;
    MouseInput(){
        start = false;
    quit = false;
    help = false;
    }
    @Override
    
    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

//    public Rectangle playButton = new Rectangle(250, 150, 100, 50);
//    public Rectangle helpButton = new Rectangle(250, 250, 100, 50);
//    public Rectangle quitButton = new Rectangle(250, 350, 100, 50);

        //play button
        if(mx >= 250 && mx <= 300)
        {
            if(my >= 150 && my <= 200)
            {
                //press play button
                state = 1;
                start = true;
                checkState();
            } 
        }
        if(mx >= 250 && mx <= 300)
        {
            if(my >= 250 && my <= 300)
            {
                //press play button
               state = 2;
               help = true;
                checkState();
                
            } 
        }
        //Quit Button
        if(mx >= 250 && mx <= 300)
        {
            if(my >= 350 && my <= 400)
            {
                //pressed Quit Button
                state = 3;
                quit = true;
                checkState();
            } 
        }
//         public Rectangle escButton = new Rectangle(450, 10, 100, 50);
//public Rectangle escButton = new Rectangle(530, 10, 40, 40);
//        
        //Esc Button
        if(mx >= 530 && mx <= 550)
        {
            if(my >= 10 && my <= 50)
            {
                
                state = 4;
                esc = true;
                checkState();
            } 
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
            if (start==true)
		{
		start = false;

		}
                else if (help==true)
		{
		help = false;

		}
                else if (quit==true)
		{
		help = false;

		}
               else if (esc==true)
		{
		esc = false;
                 state = 4;
		}
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void checkState()
	{
		
		if (start==true)
		{
		start = false;
                state= 1;
		}
                else if (help==true)
		{
		help = false;
                 state = 2;
		}
                else if (quit==true)
		{
		help = false;
                 state = 3;
		}
                   else if (esc==true)
		{
		esc = false;
                 state = 4;
		}
		
	}

  public void initThread(String name) {
        thread = new Thread(this,name);
        thread.start();

    }

    
}
