package main;

public class PlayerEntity extends Entity {

	private KeyInputHandler input;
	
	public PlayerEntity(String name, int x, int y, KeyInputHandler input, String path) {
		super(name, x, y, path);
		
		this.x=x;
		this.y=y;
		this.input=input;
		
		this.dx = .05d;
		this.dy = .05d;
		
	}

	public void logic()
	{
		if(input.up.down)
		{
			y -= dy;
		}
		if(input.down.down)
		{
			y += dy;
		}
		if(input.left.down)
		{
			x -= dx;
		}
		if(input.right.down)
		{
			x += dx;
		}
	}
}
