package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;



public class KeyInputHandler implements KeyListener {

	public class Key{
		public boolean down;
		public void toggle(boolean isPressed)
		{

			if(isPressed!=down)
			{
				down=isPressed;
			}
		}
	}
	
	public List<Key>keys=new ArrayList<Key>();
	public Key up = new Key();
	public Key down = new Key();
	public Key right = new Key();
	public Key left = new Key();
	
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(),true);
	}

	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(),false);
	}

	public void keyTyped(KeyEvent e) {
		
	}
	public void releaseAll()
	{
		for(int i=0;i<keys.size();i++)
		{
			keys.get(i).down=false;
		}
	}
	public void toggleKey(int keyCode, boolean isPressed)
	{
		if(keyCode==KeyEvent.VK_UP)
		{
			up.toggle(isPressed);
		}
		if(keyCode==KeyEvent.VK_DOWN)
		{
			down.toggle(isPressed);
		}
		if(keyCode==KeyEvent.VK_LEFT)
		{
			left.toggle(isPressed);
		}
		if(keyCode==KeyEvent.VK_RIGHT)
		{
			right.toggle(isPressed);
		}
	}
}
