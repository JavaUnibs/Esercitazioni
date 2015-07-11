package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtenteTest {

	Utente utente = new Utente ("Marco", "Verdi","01/06/1985","Brescia","maschio","0307654321","MRCVRD85H01B157G");
	String codice_fiscale_errato = "ABCD123";
	
	@Test
	public void toStringTest() 
	{
		assertEquals(utente.toString(), "-----------\nNome: Marco\nCognome: Verdi\nData di nascita: 01/06/1985\nLuogo di nascita: Brescia\nSesso: maschio\nTelefono: 0307654321\nCodice fiscale: MRCVRD85H01B157G\n");
	}

	@Test
	public void toStringNomeCognomeTest()
	{
		assertEquals(utente.toStringNomeCognome(), "-----------\nNome: Marco\nCognome: Verdi\n");
	}
	
	@Test
	public void toStringCodiceFiscaleTest()
	{
		assertEquals(utente.toStringCodiceFiscale(), "Codice fiscale: MRCVRD85H01B157G\n");
	}
	
	@Test
	public void verificaCodice()
	{
		assertEquals(utente.verificaCodice(codice_fiscale_errato), false); //dovrebbe essere permesso
		assertEquals(utente.verificaCodice("MRCVRD85H01B157G"), true);
	}
	
	@Test
	public void modificaUtenteTest()
	{
		utente.modificaUtente("nome", "Giovanni");
		assertEquals(utente.toStringNomeCognome(), "-----------\nNome: Giovanni\nCognome: Verdi\n");
	}
	
	@Test
	public void datoUgualeTest()
	{
		assertEquals(utente.datoUguale("0301234567"), false);
		assertEquals(utente.datoUguale("0307654321"), true);
	}
}
