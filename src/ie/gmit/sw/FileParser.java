package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class FileParser implements Parsable
{
	private Map<String, Integer> wordsMap;
	private FrequentWords freqWords;
	
	public FileParser(FrequentWords freqWords)
	{
		wordsMap = new HashMap<String, Integer>();
		this.freqWords = freqWords;
	}
	public void parse(String filename) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();
		
		int j;
		
		// Read until end of file
		while((j = br.read()) != -1){
			char next = (char)j;
			
			if (next >= 'A' && next <= 'z' || next == '\'')
			{
				sb.append(next);
			}	
			else 
			{
				String word = sb.toString().toUpperCase();
				sb = new StringBuffer();
				
				// Add if not frequent work
				if (!freqWords.isThereWord(word)&& word.length() > 1) 
				{
					int frequency = 0;
					if(wordsMap.containsKey(word))
					{
						frequency = wordsMap.get(word);
					}
					frequency++;
					wordsMap.put(word, frequency);					
				}
			}
		}
		br.close();		
	}
	public Map<String,Integer> getMap()
	{
		return wordsMap;
	}
}
