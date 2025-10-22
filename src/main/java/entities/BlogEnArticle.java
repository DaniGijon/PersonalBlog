package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BlogEnArticle {

	private int id;
	private String title;
	private String content;
	private String createdAt;
	
	public BlogEnArticle(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, YYYY");
		createdAt = LocalDateTime.now().format(formatter);
		createdAt = createdAt.substring(0, 1).toUpperCase() + createdAt.substring(1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
