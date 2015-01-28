package main;

import java.awt.Image;

public class PlayerEntity extends Entity{

	private int x,y;
	private String name;
	KeyInputHandler input;
	Image image;
	public PlayerEntity(String name, int x, int y,KeyInputHandler input) {
		super(name, x, y);
		this.x=x;
		this.y=y;
		this.name=name;
		this.input=input;
		
	}

	public void logic()
	{
		if(input.up.down)
		{
			y--;
		}
		if(input.down.down)
		{
			y++;
		}
		if(input.left.down)
		{
			x--;
		}
		if(input.right.down)
		{
			x++;
		}
	}
	
	public Image getImage() {
		
		return ImageLoader.getImage("/sprites/alien3.png");
	}

	
	public int getX() {
		
		return x;
	}

	public int getY() {
		return y;
	}

}
