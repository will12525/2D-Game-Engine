package main;

import java.awt.Graphics2D;
import java.awt.Image;


public abstract class Entity {
	double x, y, dx, dy;

	String name;
	String path;

	public Entity(String name, int x, int y, String path)
	{
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
		
		this.name = name;
		this.path = path;
	}

	public abstract void logic();

	public void draw(Graphics2D g)
	{
		g.drawImage(getImage(), (int) getX(), (int) getY(), null);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Image getImage() {

		return ImageLoader.getImage(path);
	}
}
