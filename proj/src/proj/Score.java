
package proj;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Score
{
	static int myscore;
	static int hiscore;
	Font scoreFont;
	
	
	Score()
	{
		scoreFont = new Font("Monospaced", Font.BOLD, 20);
		myscore = 0;
	}
	
	public void drawScore(Graphics g)
	{
		g.setColor(Color.black);
		g.setFont(scoreFont);
		g.drawString("score:"+myscore, 30, 30);
	}
	
	
	public void drawHiScore(Graphics g)
	{
		g.setColor(Color.black);
		g.setFont(scoreFont);
		g.drawString("hiscore:"+hiscore, 420, 30);
	}
	
	
	
	public static void addScore(int gain)
	{
		myscore += gain;
	}
	
	
	public static void compareScore()
	{
		
		if (myscore > hiscore)
		{
			hiscore = myscore;
			saveScore();
		}
	}


	
	static void saveScore()
	{
//            DataOutputStream dout = new DataOutputStream(new FileOutputStream("data.dat"));
//            dout.writeInt(hiscore);
//            dout.close();
	}

	
	static void loadScore()
	{
//            DataInputStream din = new DataInputStream(new FileInputStream("data.dat"));
//            hiscore = din.readInt();
//            din.close();
	}




	
	public static void initScore()
	{
		myscore = 0;
	}
}

