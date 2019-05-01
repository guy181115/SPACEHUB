package proj;


import java.awt.event.*;
import javax.swing.JFrame;


public class Game extends JFrame
{
	
	public static void main(String args[])
	{
		
		new Game();
	}
	
	
	Game()
	{
		
		super("Test Demo"); //Title

		
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        }); // ปิด
		
		setSize(600, 600);		//resolution

		
		MyCanvas mc = new MyCanvas();
		add(mc);				//เขียนหน้ากระดาษขึ้นมา
		setVisible(true);		
		
		mc.init();
		
		mc.initThread();
	}
}

