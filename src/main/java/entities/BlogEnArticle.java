package entities;

import java.time.LocalDateTime;

public class BlogEnArticle {

	private int lastId = 0;
	private int id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	
	public BlogEnArticle(String title, String content) {
		id = ++id;
		this.title = title;
		this.content = content;
		createdAt = LocalDateTime.now();
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
