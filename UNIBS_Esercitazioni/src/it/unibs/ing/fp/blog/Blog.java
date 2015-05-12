package it.unibs.ing.fp.blog;

import java.util.ArrayList;

public class Blog {
	private String name;
	private String url;

	public Blog(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String toString() {
		return String.format(("&s - &s "), this.name, url);
	}

	public ArrayList<Post> postlist;

};
