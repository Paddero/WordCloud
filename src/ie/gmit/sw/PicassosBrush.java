package ie.gmit.sw;

import java.awt.*;
import java.util.Random;

public class PicassosBrush {
	
	private Font font;
	private int fontSize;
	private Color fontColor;
	
	public void setFont() 
	{
		setFont(setRandomFont(), Font.PLAIN, getFontSize());		
	}
	public void setFont(String name, int style, int size)
	{
		font = new Font(name, style, size);
	}
	
	public void setColor()
	{
		fontColor = setRandomColor();
	}
	
	public Color getColor()
	{
		return fontColor;
	}
	
	public int getFontSize()
	{
		return fontSize;
	}
	
	public Font getFont()
	{
		return font;
	}
	
	public void setFontSize(int size)
	{
		if(size > 72)
		{
			size = 72;
		}
		if(size > 120)
		{
			size = 100;
		}
		if(size > 500)
		{
			size =200;
		}
		if(size > 1000)
		{
			size =300;
		}
		fontSize = (int)(size);	
	}
	
	private String setRandomFont()
	{
		Random random = new Random();
		//returns random font styles
		switch(random.nextInt(3))
		{
		case 0:
			return Font.MONOSPACED;
			
		case 1:
			return Font.SANS_SERIF;
			
		case 2:
			return Font.SERIF;
			
		default:
			return Font.SANS_SERIF;
		}		
	}
	
	private Color setRandomColor()
	{		
		return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
	}
	

}
