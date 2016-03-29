package main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageDownloader {

	private final static String PNG = "png"; 
	
	/**
	 * Downloads image files from web page to location
	 * @param websiteURL
	 * @param location
	 * @return
	 */
	public static boolean downloadImages(String websiteURL, String location) {
		ArrayList<URL> urls = URLReader.getImageURLs(websiteURL);
		try {
			for (URL url : urls) {
				Image img = ImageIO.read(url);

				BufferedImage bi = (BufferedImage) img;
				String name = getImgName(url);
				
				File outputfile = new File(location + name);
				ImageIO.write(bi, PNG, outputfile);
			}
			return true;			
		} catch (Exception e) {
			System.out.println("failed:\n"+e);
			return false;
		}
	}
	
	/**
	 * Returns the name of file from html <img src="">
	 * @param url
	 * @return
	 */
	private static String getImgName(URL url) {
		String[] elements = url.toString().split("/");
		
		if (elements[elements.length-1].length() > 0)
			return elements[elements.length-1];
		return elements[elements.length-2];
	}
	
}
