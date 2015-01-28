package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main {

	final int WIDTH = 1000;
	final int HEIGHT = 1000;
	boolean running=true;
	public Graphics2D g = null;
	public BufferStrategy strat = null;

	public Main()
	{
		makeCanvas();

		
		while(running)
		{
			long time = System.currentTimeMillis();
			
			if(System.currentTimeMillis() % 16 == 0)
			{
				render();
		
			}
			
			if(System.currentTimeMillis() % 20 == 0)
			{
				//logic
			}
		}
	}
	
	public void render()
	{
		g = (Graphics2D) strat.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.WHITE);
		g.drawString("Hello world!",470,200);
		
		strat.show();
	}

	public void makeCanvas()
	{
		JFrame frame = new JFrame("ENGINE");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		Canvas c = new Canvas();
		c.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		c.setBounds(new Rectangle(WIDTH, HEIGHT));
		c.setIgnoreRepaint(true);
		
		frame.add(c, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		frame.requestFocus();
		
		c.createBufferStrategy(2);
		strat = c.getBufferStrategy();
	}

	public static void main(String[] args) {
		new Main();
	}
}
