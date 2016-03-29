package main;

public class Program {

	public static void main(String[] args) {
		String location = "C:/";
		String websiteURL = "https://www.google.com";
		
		if(ImageDownloader.downloadImages(websiteURL, location))
			System.out.println("Download complete.");
		else 
			System.out.println("An error has occured.");
	}
	
}
