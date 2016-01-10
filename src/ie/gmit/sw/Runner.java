package ie.gmit.sw;

public class Runner {
	
	private static String fileParse;
	private static String freqWords;
	
	public static void main(String[] args) throws Exception {
		fileParse = args[0];
		freqWords = args[1];
		
		Picasso artist;
		FrequentWords realFreqWords = new FrequentWords(freqWords);
		TheWordMap map = new TheWordMap(fileParse, realFreqWords);
		
		artist = new Picasso(map.getMap(), 200);
		System.out.println("Drawing image...?");
		artist.draw();
		System.out.println("Done... maybe?.. Hopefully.");

	}

}
