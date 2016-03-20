package com.gesture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPasswd extends JFrame{
	public DrawPasswd(byte[] p) {
		setTitle("password");
		getContentPane().add(new P(p));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		setAlwaysOnTop(true);
	}
}

class Points {
	public int x;
	public int y;
}

class P extends JPanel{
	private byte[] passwd;
	private Points[][] base = new Points[3][3];
	public P(byte[] p) {
		this.passwd = p;
	}
	
	private Points[] byteToPoint() {
		Points[] psw = new Points[passwd.length];
		
		for(int i = 0; i < passwd.length; i++) {
			psw[i] = new Points();
		}
		
		int count = 0;
		for(byte b : passwd) {
			int t = (int)b;
			switch (t) {
			case 0:
				psw[count] = base[0][0];
				count++;
				break;
			case 1:
				psw[count] = base[0][1];
				count++;
				break;
			case 2:
				psw[count] = base[0][2];
				count++;
				break;
			case 3:
				psw[count] = base[1][0];
				count++;
				break;
			case 4:
				psw[count] = base[1][1];
				count++;
				break;
			case 5:
				psw[count] = base[1][2];
				count++;
				break;
			case 6:
				psw[count] = base[2][0];
				count++;
				break;
			case 7:
				psw[count] = base[2][1];
				count++;
				break;
			case 8:
				psw[count] = base[2][2];
				count++;
				break;

			default:
				break;
			}
		}
		return psw;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.PINK);
		((Graphics2D)g).setStroke(new BasicStroke(5));
		init();
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				g.drawOval(base[i][j].x - 20, base[i][j].y - 20, 40, 40);
			}
		}
		
		Points[] psw = byteToPoint();
		int i;
		g.setColor(Color.BLACK);
		g.drawString(0 + "", psw[0].x - 30, psw[0].y -30);
		for(i = 1; i < psw.length; i++) {
			g.setColor(Color.green);
			g.drawLine(psw[i-1].x, psw[i-1].y, psw[i].x, psw[i].y);
			g.setColor(Color.BLACK);
			g.drawString(i + "", psw[i].x - 30, psw[i].y -30);
		}
		
		
	}

	private void init() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				base[i][j] = new Points();
			}
		}
		
		base[0][0].x = 40;
		base[0][0].y = 40;
		
		base[0][1].x = getWidth()/2;
		base[0][1].y = 40;
		
		base[0][2].x = getWidth() - 40;
		base[0][2].y = 40;
		
		base[1][0].x = 40;
		base[1][0].y = getHeight()/2;
		
		base[1][1].x = getWidth()/2;
		base[1][1].y = getHeight()/2;
		
		base[1][2].x = getWidth() - 40;
		base[1][2].y = getHeight()/2;
		
		base[2][0].x = 40;
		base[2][0].y = getHeight() - 40;
		
		base[2][1].x = getWidth()/2;
		base[2][1].y = getHeight() - 40;
		
		base[2][2].x = getWidth() - 40;
		base[2][2].y = getHeight() - 40;
	}
}