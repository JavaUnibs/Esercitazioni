package it.unibs.ing.tamag;

import static org.junit.Assert.*;

import org.junit.Test;

public class TamagotchiTest {

	private final String nome = "Mario";
	double felicita = 50;
	double sazieta = 50;
	
	private String messaggio1 = "I valori di Mario sono: \nFelicita: 50,0\nSazieta: 50,0";
	private String messaggio2 = "I valori di Mario sono: \nFelicita: 49,4\nSazieta: 51,0";
	private String messaggio3 = "I valori di Mario sono: \nFelicita: 50,8\nSazieta: 48,4";
	private String messaggio4 = "I valori di Mario sono: \nFelicita: 51,2\nSazieta: 46,8";
	private String messaggio5 = "I valori di Mario sono: \nFelicita: 48,8\nSazieta: 53,0";
	
	/**
	 * Test del metodo stringaOutput della classe TamagotchiConstructor
	 * 
	 * @throws Exception
	 */

	@Test
	public void testOutput() throws Exception {

		TamagotchiCostructor tamag = new TamagotchiCostructor(nome, felicita,
				sazieta);
		assertEquals(messaggio1, tamag.stringaOutput());

	}

	/**
	 * Test del metodo daiBiscotti della classe TamagotchiConstructor
	 * 
	 * @throws Exception
	 */

	@Test
	public void testBiscotti() throws Exception {

		TamagotchiCostructor tamag = new TamagotchiCostructor(nome, felicita,
				sazieta);
		tamag.daiBiscotti(2, 1);
		assertEquals(messaggio2, tamag.stringaOutput());
		tamag.daiBiscotti(2, 2);
		assertEquals(messaggio5, tamag.stringaOutput());

	}

	/**
	 * Test della classe daiCarezze della classe TamagotchiConstructor
	 * 
	 * @throws Exception
	 */

	@Test
	public void testCarezze() throws Exception {

		TamagotchiCostructor tamag = new TamagotchiCostructor(nome, felicita,
				sazieta);
		tamag.daiCarezze(4, 1);
		assertEquals(messaggio3, tamag.stringaOutput());
		tamag.daiCarezze(4, 2);
		assertEquals (messaggio4, tamag.stringaOutput());

	}

}
