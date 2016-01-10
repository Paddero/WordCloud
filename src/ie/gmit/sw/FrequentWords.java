package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class FrequentWords extends FrequentWordsParser
{
	private HashSet<String> freqWordsMap;
	
	public FrequentWords(String filename) throws Exception
	{
		freqWordsMap = new HashSet<String>();
		try
		{
			parse(filename);
		}
		catch(Exception e)
		{
			System.out.println("File error." + e.toString());
		}
	}
	
	public void parse(String filename) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();		
		int i;
		
		while((i = br.read()) != -1)
		{
			char next = (char)i;
			
			if (next != '\n') sb.append(next);
			
			else 
			{
				String sWord = sb.toString().toUpperCase();
				sb = new StringBuffer();	
				freqWordsMap.add(sWord);
			}
		}
		br.close();
	}
	public boolean isThereWord(String word)
	{
		boolean isThereWord;
		if(freqWordsMap.contains(word))
		{
			isThereWord = true;
		}
		else
		{
			isThereWord = false;
		}
		return isThereWord;
	}
}
