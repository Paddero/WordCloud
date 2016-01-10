package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;

public class TheWordMap {
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	private Parsable toParse;
	//private String fileOrUrl;
	
	public TheWordMap(String filename, FrequentWords fw) throws Exception{
		toParse = new FileParser(fw);
		System.out.println("File parsed...");
		toParse.parse(filename);
		wordMap = toParse.getMap();
	}
	
	public Map<String, Integer> getMap()
	{
		return wordMap;
	}

}
