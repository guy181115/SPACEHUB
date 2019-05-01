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

/**
*�p�[�e�B�N���N���X<p>
*�i”�”ญ�โ�A“G�ษ’e�ช“–�ฝ�ม�ฝ�ฦ�ซ�ฬ�๘�ส�j<p>
*�ฺ“ฎ��—��A•`�ๆ��—��ศ�ว
*/
public class Particle extends GameObject
{
	double direction;
	double speed;
	double speedX;
	double speedY;
	int size;
	
	Particle()
	{
		active = false;
	}
	
	
	public void move()
	{
		x += speedX;
		y += speedY;
		size--;
		
		if ( (x < 0)||(500 < x)||(y < 0)||(500 < y) )
		{
			active = false;
		}
		if (size < 0)
		{
			active = false;
		}
	}
	
	/**
	 * •`�ๆ��—��B
	 * �P���[�v�ล�๊�๑�ฤ�ฮ�๊�้�B
	 * @param g •`�ๆ�ๆ�O���t�B�b�N�n�“�h��
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.gray);
		g.drawOval((int)(x-size/2), (int)(y-size/2), size, size);
	}
	
	//���๚�ป��—��เ�ฑ�ฑ�ล�s�ค�i�I�u�W�F�N�g�๐�g�ข�๑�ต�ฤ�ข�้�ฬ�ล�j
	public void activate(double ix, double iy, double idirection, double ispeed)
	{
		x = ix;
		y = iy;
		direction = idirection;
		speed = ispeed;
		active = true;			//’e�ฬ�C�“�X�^�“�X�๐—L�๘�ษ�ท�้
		size = 30;
		
		//��‘ฌ�ป�ฬ�ฝ�฿�A�ษ�ภ•W�ฉ�็XY‘ฌ“x�ษ•ฯ�ท�ต�ฤ�จ�ญ�B
		double radian;
		radian = Math.toRadians(direction);	//“x�๐���W�A�“�ษ•ฯ�ท
		speedX = speed * Math.cos(radian);
		speedY = speed * Math.sin(radian);
	}
}

