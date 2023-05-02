package com.parametric;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {
	final int WINDOW_LENGTH = 1000, WINDOW_HEIGHT = 1000;
	int t = 0;
	int x, y;

	Timer timer;

	MyPanel() {
		this.setPreferredSize(new Dimension(WINDOW_LENGTH, WINDOW_HEIGHT));
		timer = new Timer(1, this);
		timer.start();
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
//		super.paintComponent(g);
		g2d.setPaint(Color.black);
		g2d.setStroke(new BasicStroke(1));

		// x axis
		g2d.drawLine(0, WINDOW_HEIGHT / 2, WINDOW_LENGTH, WINDOW_HEIGHT / 2);
		// y axis
		g2d.drawLine(WINDOW_LENGTH / 2, 0, WINDOW_LENGTH / 2, WINDOW_HEIGHT);
		// x label
		g2d.drawString("X " + x + "T " + t, (WINDOW_LENGTH / 2) + 10, 20);
		// y label
		g2d.drawString("Y" + y, WINDOW_LENGTH - 20, (WINDOW_LENGTH / 2) - 20);

		g2d.setPaint(Color.blue);
		g2d.setStroke(new BasicStroke(5));
		// plot point(x,y)
		Rectangle p = new Rectangle(x, y, 1, 1);
		g2d.draw(p);
		g2d.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// epicycloid scaled 4 times down
		t++;
		// x = 4cos(t) - cos(4t)
		x = (int) ((((Math.cos(t) - (0.25)*Math.cos(4*t)) * WINDOW_LENGTH) / (WINDOW_LENGTH / 2))
				* 100) + (WINDOW_LENGTH / 2);

		// y = 4sin(t) - sin(4t)
		y = (int) ((((Math.sin(t) - (0.25)*Math.sin(4*t)) * WINDOW_HEIGHT) / (WINDOW_HEIGHT / 2))
				* 100) + (WINDOW_HEIGHT / 2);

		repaint();
	}
}
//============================================================
////ASTROID
//t++;
//// x = cos^3(t)
//x=(int)(((Math.pow(Math.cos(t),3)*1000)/500)*100)+500;
//
//// y = sin^3(t)
//y=(int)(((Math.pow(Math.sin(t),3)*1000)/500)*100)+500;
//
//repaint();

//============================================================
////Rose Curve
//t++;
//// x = cos(t) sin(4t)
//x=(int)((((Math.cos(t)*Math.sin(4*t))*WINDOW_LENGTH)/(WINDOW_LENGTH/2))*100)+(WINDOW_LENGTH/2);
//
//// y = sin(t) sin(4t)
//y=(int)((((Math.sin(t)*Math.sin(4*t))*WINDOW_HEIGHT)/(WINDOW_HEIGHT/2))*100)+(WINDOW_HEIGHT/2);
//
//repaint();
//============================================================
////Circle
//t++;
//// x = cos(t)
//x=(int)(((Math.cos(t)*1000)/500)*100)+500;
//
//// y = sin(t)
//y=(int)(((Math.sin(t)*1000)/500)*100)+500;
//
//repaint();
//============================================================
////Hypotrochoid scaled 4 times down
//t++;
//// x = 2cos(t) + 5cos(2t/3)
//x=(int)(((((0.5)*Math.cos(t)+(5/4)*Math.cos(2*t/3))*WINDOW_LENGTH)/(WINDOW_LENGTH/2))*100)+(WINDOW_LENGTH/2);
//
//// y = 2sin(t) - 5sin(2t/3)
//y=(int)(((((0.5)*Math.sin(t)-(5/4)*Math.sin(2*t/3))*WINDOW_HEIGHT)/(WINDOW_HEIGHT/2))*100)+(WINDOW_HEIGHT/2);
//
//repaint();
//============================================================
////epicycloid scaled 4 times down
//t++;
//// x = 4cos(t) - cos(4t)
//x=(int)((((Math.cos(t)-(0.25)*Math.cos(4*t))*WINDOW_LENGTH)/(WINDOW_LENGTH/2))*100)+(WINDOW_LENGTH/2);
//
//// y = 4sin(t) - sin(4t)
//y=(int)((((Math.sin(t)-(0.25)*Math.sin(4*t))*WINDOW_HEIGHT)/(WINDOW_HEIGHT/2))*100)+(WINDOW_HEIGHT/2);
//
//repaint();