package org.nic.xhtmlparser.model;

public class NewsFeed {
	
	private String title;
	private String url;
	private String date;
	private String description;

	public NewsFeed(String title, String url, String date, String description) {
		this.title = title;
		this.url = url;
		this.date = date;
		this.description = description;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		return title + " " + url + " " + date + " " + description;
		
	}

}
