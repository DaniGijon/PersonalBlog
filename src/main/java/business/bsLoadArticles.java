package business;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import entities.BlogEnArticle;

public class bsLoadArticles {
	
	static final File folder = new File("/home/konka/eclipse-workspace/PersonalBlog/src/main/webapp/articles");

	public static List<BlogEnArticle> loadArticles () {
		List <BlogEnArticle> storedArticles = new ArrayList<>();
		for (final File fileEntry : folder.listFiles()) {
			Path file_path = Path.of("/home/konka/eclipse-workspace/PersonalBlog/src/main/webapp/articles/" + fileEntry.getName());
			if (Files.exists(file_path)){
				try {
		            String jsonContent = Files.readString(file_path);
		            String[] articleList = jsonContent.replace("[", "")
		                                            .replace("]", "")
		                                            .split("},");
		            for (String articleJSON : articleList){
		                if (!articleJSON.endsWith("}")){
		                	articleJSON = articleJSON + "}";
		                	storedArticles.add(convertJSONtoBlogEnArticle(articleJSON));
		                } else {
		                	storedArticles.add(convertJSONtoBlogEnArticle(articleJSON));
		                }
		            }
		        } catch (IOException e){
		            e.printStackTrace();
		        }
	        }
	    }
		
		return storedArticles;
	}
	
	public static BlogEnArticle convertJSONtoBlogEnArticle (String articleJSON) {
		articleJSON = articleJSON.replace("{", "").replace("}", "").replace("\"", "");
        String[] json1 = articleJSON.split(",");

        String id = json1[0].split(":")[1].strip();
        String title = json1[1].split(":")[1].strip();
        String content = json1[2].split(":")[1].strip();
        String createdAtStr = json1[3].split(":")[1].strip() + ", " + json1[4].strip();

        BlogEnArticle article = new BlogEnArticle(Integer.valueOf(id), title, content);
  
        article.setCreatedAt(createdAtStr);

        return article;
	    
	}
}
