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
	int x1, y1;
	int x2, y2;
	int x3, y3;
	int x4, y4;
	int x5, y5;

	Timer timer;

	MyPanel() {
		this.setPreferredSize(new Dimension(WINDOW_LENGTH, WINDOW_HEIGHT));
//		this.setBackground(Color.darkGray);//UNCOMMENNT LINE 35 IF YOU WILL UNCOMMENT THIS
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
		g2d.drawString("Y", (WINDOW_LENGTH / 2) + 10, 20);
		// y label
		g2d.drawString("X", WINDOW_LENGTH - 20, (WINDOW_LENGTH / 2) - 20);

		g2d.setStroke(new BasicStroke(1));
		// plot point(x,y)

		g2d.setPaint(Color.blue);
		Rectangle p1 = new Rectangle(x1, y1, 1, 1);
		g2d.draw(p1);

		// plot point(x,y)
		g2d.setPaint(Color.red);
		Rectangle p2 = new Rectangle(x2, y2, 1, 1);
		g2d.draw(p2);

		// plot point(x,y)
		g2d.setPaint(Color.cyan);
		Rectangle p3 = new Rectangle(x3, y3, 1, 1);
		g2d.draw(p3);

		// plot point(x,y)
		g2d.setPaint(Color.green);
		Rectangle p4 = new Rectangle(x4, y4, 1, 1);
		g2d.draw(p4);

		// plot point(x,y)
		g2d.setPaint(Color.magenta);
		Rectangle p5 = new Rectangle(x5, y5, 1, 1);
		g2d.draw(p5);
		g2d.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Rose Curve
		t++;
		// x = cos(t) sin(4t)
		x1 = (int) ((((Math.cos(t) * Math.sin(4 * t)) * WINDOW_LENGTH) / (WINDOW_LENGTH / 2)) * 100)
				+ (WINDOW_LENGTH / 2);

		// y = sin(t) sin(4t)
		y1 = (int) ((((Math.sin(t) * Math.sin(4 * t)) * WINDOW_HEIGHT) / (WINDOW_HEIGHT / 2)) * 100)
				+ (WINDOW_HEIGHT / 2);

		// Circle

		// x = cos(t)
		x2 = (int) (((Math.cos(t) * WINDOW_LENGTH) / (WINDOW_LENGTH / 2)) * 100) + (WINDOW_LENGTH / 2);

		// y = sin(t)
		y2 = (int) (((Math.sin(t) * WINDOW_HEIGHT) / (WINDOW_HEIGHT / 2)) * 100) + (WINDOW_HEIGHT / 2);

		// ASTROID

		// x = cos^3(t)
		x3 = (int) (((Math.pow(Math.cos(t), 3) * WINDOW_LENGTH) / (WINDOW_LENGTH / 2)) * 100) + (WINDOW_LENGTH / 2);

		// y = sin^3(t)
		y3 = (int) (((Math.pow(Math.sin(t), 3) * WINDOW_HEIGHT) / (WINDOW_HEIGHT / 2)) * 100) + (WINDOW_HEIGHT / 2);

		// Hypotrochoid scaled 4 times down

		// x = 2cos(t) + 5cos(2t/3)
		x4 = (int) (((((0.5) * Math.cos(t) + (5 / 4) * Math.cos(2 * t / 3)) * WINDOW_LENGTH) / (WINDOW_LENGTH / 2))
				* 100) + (WINDOW_LENGTH / 2);

		// y = 2sin(t) - 5sin(2t/3)
		y4 = (int) (((((0.5) * Math.sin(t) - (5 / 4) * Math.sin(2 * t / 3)) * WINDOW_HEIGHT) / (WINDOW_HEIGHT / 2))
				* 100) + (WINDOW_HEIGHT / 2);

		// epicycloid scaled 4 times down

		// x = 4cos(t) - cos(4t)
		x5 = (int) ((((Math.cos(t) - (0.25) * Math.cos(4 * t)) * WINDOW_LENGTH) / (WINDOW_LENGTH / 2)) * 100)
				+ (WINDOW_LENGTH / 2);

		// y = 4sin(t) - sin(4t)
		y5 = (int) ((((Math.sin(t) - (0.25) * Math.sin(4 * t)) * WINDOW_HEIGHT) / (WINDOW_HEIGHT / 2)) * 100)
				+ (WINDOW_HEIGHT / 2);

		repaint();
	}
}