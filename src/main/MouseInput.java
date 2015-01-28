package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import main.KeyInputHandler.Key;


public class MouseInput implements MouseListener {

	public class Mouse
	{
		public boolean down;
		private int x,y;
		public void toggle(boolean isPressed)
		{
			if(isPressed!=down)
			{
				down=isPressed;
			}
		}
		public void setX(int x)
		{
		this.x=x;	
		}
		public void setY(int y)
		{
			this.y=y;
		}
		public int getX()
		{
			return x;
		}
		public int getY()
		{
			return y;
		}
	}
	
	public List<Key>keys=new ArrayList<Key>();
	public Mouse button1 = new Mouse();
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getButton());
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		toggleKey(e,true);
	}

	public void mouseReleased(MouseEvent e) {
		toggleKey(e,false);
	}
	public void toggleKey(MouseEvent e, boolean isPressed)
	{
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			button1.setX(e.getX());
			button1.setY(e.getY());
			button1.toggle(isPressed);
		}
	}

}
