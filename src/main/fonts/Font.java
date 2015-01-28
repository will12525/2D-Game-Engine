package main.fonts;

import java.awt.Color;

public class Font {

	//awt font for actual font (style, color, size)
	protected java.awt.Font font;
	
	//What to draw
	protected String text;
	
	//Positions on the screen
	protected int x, y;
	
	//Color of font
	protected Color color;

	//opacity
	
	public Font(java.awt.Font font, String text, Color color, int x, int y)
	{
		this.font = font;
		this.text = text;
		this.color = color;
		this.x = x;
		this.y = y;
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
