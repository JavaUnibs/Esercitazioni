package it.unibs.ing.fp.blog;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class BlogTest {
	private static final String URL = "http://javapeanuts.blogspot.com";
	private static final String NAME = "Java Peanuts";

	@Test
	public void testName() throws Exception {
		Blog blog = new Blog(NAME, URL);
		assertEquals("Java Peanuts - http://javapeanuts.blogspot.com", blog.toString());
	}

	@Test
	public void testList() throws Exception {
		LinkedList<String> list = new LinkedList<String>();
		list.add("Uno");
		list.add("Due");
		list.add("Tre");

		assertEquals(3, list.size());
		assertEquals("Due", list.get(1));

		String result = "";
		for (String s : list) {
			result += s;
		}

		assertEquals("UnoDueTre", result);
	}
}
