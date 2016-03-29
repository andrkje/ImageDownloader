package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

// Jsoup
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLReader {

	public static String read(URL url) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));
		String output = "";
		String HTMLLine;
		while ((HTMLLine = in.readLine()) != null)
			output += HTMLLine;
		in.close();

		return output;
	}
	
	public static ArrayList<URL> getImageURLs(String url) {
		ArrayList<URL> result = new ArrayList<URL>();
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements image = doc.select("img");
			for (Element element : image) {
				result.add(new URL(element.absUrl("src")));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
