package main;

import java.awt.Color;

public class Font {

	//awt font for actual font (style, color, size)
	private java.awt.Font font;
	
	//thread for running later (like making the font fade away)
	private Thread thread;
	
	//What to draw
	private String text;
	
	//Positions on the screen
	private int x, y;
	
	//Color of font
	private Color color;

	public Font(java.awt.Font font, String text, Thread thread, Color color, int x, int y)
	{
		this.font = font;
		this.text = text;
		this.thread = thread;
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public Font(java.awt.Font f, String text, Color color, int x, int y)
	{
		this(f, text, null, color, x, y);
	}
	
	public void runThread()
	{
		this.thread.start();
	}
	
	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public java.awt.Font getFont()
	{
		return this.font;
	}
	
	public String getText()
	{
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
