package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Main {

	public final int WIDTH = 1000;
	public final int HEIGHT = 1000;
	private boolean running=true;
	private Graphics2D g = null;
	private BufferStrategy strat = null;
	
	public KeyInputHandler input;
	public MouseInput mouse;
	
	//for referencing local objects
	public static Main instance = null;
	
	public List<Font> fonts = new ArrayList<Font>();

	@SuppressWarnings("unused")
	public Main()
	{
		makeCanvas();

		  /////////////////
		 //Testing Start//
		/////////////////
		final Font f = new Font(new java.awt.Font("Times New Roman", 16, 24), "Hello, World!", new Color(255, 0, 0, 0), 100, 118);
		
		f.setThread(new Thread()
		{
			@Override
			public void run()
			{
				int changeO = 1;
				int opac = 0;
				
				while(true)
				{
					//System.out.println(f.getColor().getAlpha());
					f.setColor(new Color(255, 0, 0, opac += changeO));
					
					if(opac == 255)
					{
						changeO = -1;
					}
					else if (opac == 0)
					{
						changeO = 1;
					}
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		this.addFont(f);
		f.runThread();
		///////////////
	   //Testing End//
      ///////////////
		
		
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

		//background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);		
		
		for(Font font : this.getFonts())
		{
			//note: draws font from the bottom left point on string
			
			g.setColor(font.getColor());
			g.setFont(font.getFont());
			//g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, font.getOpacity()));
			
			g.drawString(font.getText(), font.getX(), font.getY());
		}
		
		//for key testing purposes
		g.setColor(Color.BLUE);
		if(input.up.down)
		{
			g.drawString("Its working!", 500, 500);
		}
		
		if(input.down.down)
		{
			g.drawString("Hello World!", 10, 10);
		}
		if(mouse.button1.down)
		{
			g.drawString("Mouse works", mouse.button1.getX(),mouse.button1.getY());
		}
		//
		g.dispose();
		strat.show();
		
	}

	public void makeCanvas()
	{
		input = new KeyInputHandler();
		mouse = new MouseInput();
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
		frame.addKeyListener(input);
		c.addMouseListener(mouse);
		
		c.createBufferStrategy(2);
		strat = c.getBufferStrategy();
	}
	
	//thread safe getter for font list
	public synchronized List<Font> getFonts()
	{
		return this.fonts;
	}
	
	//add a font to the list, to be drawn every graphic tick
	public synchronized void addFont(Font f)
	{
		this.getFonts().add(f);
	}
	
	//remove font from list
	public synchronized void removeFont(Font f)
	{
		this.getFonts().remove(f);
	}

	public static void main(String[] args) {
		instance = new Main();
	}
}
