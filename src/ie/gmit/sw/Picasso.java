package ie.gmit.sw;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.Map;
import java.util.Random;

public class Picasso {
	private Graphics graphics;
	private PicassosBrush brush;
	private Map<String, Integer> wordMap;
	private int wordsMax;
	private int i;
	private int xposition;
	private int yposition;

	public Picasso(Map<String, Integer> map, int max) throws Exception
	{
		this.wordMap = map;
		this.wordsMax = max;
		brush = new PicassosBrush();
		xposition = 20;
		yposition = 80;
		i = 0;
	}
	
	public void draw() throws Exception
	{
		i = 0;
		BufferedImage image = new BufferedImage(1920, 1080, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = image.getGraphics();
		
		for (String word : wordMap.keySet())
		{			
			if(wordMap.get(word) <= 1 == false)
			{
				brush.setFontSize(wordMap.get(word) + 15);
				brush.setFont();
				brush.setColor();
				
				graphics.setFont(brush.getFont());
				graphics.setColor(brush.getColor());
				graphics.drawString(word, xposition, yposition);				
				ChangeLocation();
			}
			if(i == wordsMax)
			{
				break;
			}
			i++;
		}
		
		graphics.dispose();
		ImageIO.write(image, "png", new File("image.png"));
	}
	
	private void ChangeLocation()
	{
		if (xposition <= 1900)
		{
			xposition += 400;
		}
		else{
			xposition = 20;
			yposition += 50;
		}
	}
}
