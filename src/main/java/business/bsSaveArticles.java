package business;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entities.BlogEnArticle;

public class bsSaveArticles {

	static final File folder = new File("/home/konka/eclipse-workspace/PersonalBlog/src/main/webapp/articles"); //edit path
	private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	
	public static int getNewId (List <BlogEnArticle> listArticles) {
		int newId = 0;
		for (BlogEnArticle article : listArticles) {
			if (article.getId() > newId) {
				newId = article.getId();
			}
		}
		
		return ++newId;
	}
	
	public static void addArticle (BlogEnArticle newArticle) {
		try {
	        FileWriter writer = new FileWriter(folder + "/" + newArticle.getTitle() + ".JSON");
	        LocalDateTime now = LocalDateTime.now();
	        writer.append("{\"id\":\"" + String.valueOf(newArticle.getId()) 
	        	+ "\", \"title\":\"" + newArticle.getTitle().strip() 
	        	+ "\", \"content\":\"" + newArticle.getContent().strip()  
	        	+ "\", \"createdAt\":\"" + newArticle.getCreatedAt().strip() + "\"}");
	        
	        writer.flush();
	        writer.close();
	    }
		
	    catch(IOException e)
	    {
	         e.printStackTrace();
	    } 
	}
	
	public static void deleteArticle (BlogEnArticle article) {
		File articleToDelete = new File (folder + "/" + article.getTitle() + ".JSON");
		if (articleToDelete.delete()) { 
		      System.out.println("Deleted the file: " + articleToDelete.getName());
		    } else {
		      System.out.println("Failed to delete the file.");
		    } 
	}
}
