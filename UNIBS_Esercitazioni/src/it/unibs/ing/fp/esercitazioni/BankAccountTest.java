package it.unibs.ing.fp.esercitazioni;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest {
	@Test
	public void testName() throws Exception
	{
		BankAccount test = new BankAccount ("Riccardo", 2000);
		assertEquals (1995, test.withdraw(5), 0.01);
	}
}
