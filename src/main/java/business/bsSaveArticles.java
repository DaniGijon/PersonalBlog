package business;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entities.BlogEnArticle;

public class bsSaveArticles {

	static final File folder = new File("/home/konka/eclipse-workspace/PersonalBlog/src/main/webapp/articles");
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
	
	public void export (String filename) {
//		try {
//	        FileWriter writer = new FileWriter(filename + ".csv");
//
//	        writer.append("ID");
//	        writer.append(',');
//	        writer.append("Description");
//	        writer.append(',');
//	        writer.append("Amount");
//	        writer.append(',');
//	        writer.append("Category");
//	        writer.append(',');
//	        writer.append("CreatedAt");
//	        writer.append(',');
//	        writer.append("ModifiedAt");
//	        writer.append('\n');
//
//	        for (Expense expense : listExpenses) {
//	        	writer.append(String.valueOf(expense.getId()));
//		        writer.append(',');
//		        writer.append(expense.getDescription());
//		        writer.append(',');
//		        writer.append(String.valueOf(expense.getAmount()));
//		        writer.append(',');
//		        writer.append(expense.getCategory());
//		        writer.append(',');
//		        writer.append(expense.getCreatedAt().format(formatter));
//		        writer.append(',');
//		        writer.append(expense.getModifiedAt().format(formatter));
//		        writer.append('\n');
//	        }
//	        
//	        writer.flush();
//	        writer.close();
//	    }
//		
//	    catch(IOException e)
//	    {
//	         e.printStackTrace();
//	    } 
	}
}
