package it.unibs.ing.fp.blog;

public class Post {

	private String title;
	private String author;
	private int date;

	public Post(String title, String author, int date) {
		this.title = title;
		this.author = author;
		this.date = date;
	}

	public String toString() {
		return String.format(("%s - %s - %d"), this.title, author, date);
	}
		

	}

