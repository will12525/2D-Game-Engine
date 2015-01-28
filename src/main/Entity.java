package main;

import java.awt.Graphics2D;
import java.awt.Image;


public abstract class Entity {
	int x,y;


	String name;

	public Entity(String name, int x, int y)
	{
		
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public void logic()
	{

	}

	public void draw(Graphics2D g)
	{

		g.drawImage(getImage(), getX(), getY(), null);

	}
	
	public abstract Image getImage();
	public abstract int getX();
	public abstract int getY();

}
