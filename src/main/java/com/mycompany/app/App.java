package com.mycompany.app;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
	public static void main(String[] args) {
		
		try {
			
			Document doc = Jsoup.connect("https://www2.hm.com/en_us/men/products/hoodies-sweatshirts.html").get();
			
			System.out.println("Title: " + doc.title());
			
			Elements products = doc.getElementsByClass("product-item");
			
			for (Element product: products) {
				String productName = product.getElementsByClass("item-heading").text();
				String productPrice = product.getElementsByClass("item-price").text();
				String image = product.getElementsByClass("item-image").attr("src");
				String altImage = product.getElementsByClass("item-image").attr("data-altimage");

				System.out.println("Product: " + productName);
				System.out.println("Price: " + productPrice);
				System.out.println("Image Link: " + image);
				System.out.println("Alt Image: " + altImage);
				System.out.println("\n");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();;
		}
	}
	
	
	
	
}
