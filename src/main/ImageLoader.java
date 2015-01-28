package main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class ImageLoader {
	protected static BufferedImage image =null;

	private static HashMap<String, Image> sprites = new HashMap<String, Image>();
	

	public static Image getImage(String path)
	{
		
		if(sprites.get(path)!=null)
		{
			return sprites.get(path);
		}

		try {
			InputStream path1 = ImageLoader.class.getResourceAsStream(path);

			if(path1==null)
			{
				System.out.println("Missing image");
				System.exit(0);
			}
			else
			{
				image=ImageIO.read(path1);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}


		sprites.put(path, image);
		return image;

	}
}
