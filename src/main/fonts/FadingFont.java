package main.fonts;

import java.awt.Color;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class FadingFont extends Font implements Runnable
{
	//how long before starting fade
	private long delay = 0;

	//how much to change the opacity by each tick
	private int changeAlpha = 1;

	//how long to pause between every change of opacity
	private long pause = 16;

	//limits for opacity
	private int lowerLimit = 0;
	private int upperLimit = 255;

	public FadingFont(java.awt.Font font, String text, Color color, int x, int y) {
		super(font, text, color, x, y);

		ScheduledThreadPoolExecutor timer = new ScheduledThreadPoolExecutor(0);
		timer.scheduleAtFixedRate(this, delay, pause, TimeUnit.MILLISECONDS);
	}

	public FadingFont(java.awt.Font font, String text, Color color, int x, int y, long delay, int changeAlpha, long pause, int lowerLimit, int upperLimit) {
		this(font, text, color, x, y);
		
		this.delay = delay;
		this.changeAlpha = changeAlpha;
		this.pause = pause;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	public void run()
	{
		int newAlpha = color.getAlpha() + changeAlpha;
		
		if(newAlpha > upperLimit)
		{
			newAlpha = upperLimit;
			changeAlpha *= -1;
		}
		else if(newAlpha < lowerLimit)
		{
			newAlpha = lowerLimit;
			changeAlpha *= -1;
		}
		
		color = new Color(color.getRed(), color.getGreen(), color.getBlue(), newAlpha);
	}
}
