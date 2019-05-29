package proj;


import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Game extends JFrame
{
	
	public static void main(String args[])
	{
		
		new Game();
	}
	
	
	Game()
	{
		
		super("SPACEHUB"); //Title

		
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        }); // ปิด
		
		setSize(600, 600);		//resolution
            
                AudioInputStream inputStream = null;
            try {
                inputStream = AudioSystem.getAudioInputStream(new File("bf.wav"));
            } catch (UnsupportedAudioFileException ex) {
                
            } catch (IOException ex) {
                
            }
                Clip clip = null;
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException ex) {
                
            }
            try {
                clip.open(inputStream);
            } catch (LineUnavailableException ex) {
                
            } catch (IOException ex) {
                
            }
                clip.loop(Clip.LOOP_CONTINUOUSLY);
		
               

		MyCanvas mc = new MyCanvas();
                KeyInput ki = new KeyInput();
		add(mc);				//เขียนหน้ากระดาษขึ้นมา
		setVisible(true);		
		
		mc.init();
		
		mc.initThread("mc");
                
	}
}

