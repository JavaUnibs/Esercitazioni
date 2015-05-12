package it.unibs.ing.fp.blog;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostTest {
	
		private static final String TITLE = "Promessi Sposi";
		private static final String AUTHOR = "Manzoni";
		int DATE = 1860;
	
		@Test
	public void testPost() throws Exception {

		Post post = new Post(TITLE, AUTHOR, DATE);
		assertEquals("Promessi Sposi - Manzoni - 1860", post.toString());

	}
}
