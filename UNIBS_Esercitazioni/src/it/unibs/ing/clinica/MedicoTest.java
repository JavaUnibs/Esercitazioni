package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedicoTest {
	
	Medico medico_generico = new Medico("Mario","Rossi","01/01/1970", "Brescia", "maschio", "0301234567", "MRARSS70A01B157U", "123456789", "generico");
	Medico medico_specialista = new Medico("Andrea","Bianchi","04/05/1978", "Brescia", "maschio", "030753869", "NDRBCH78C05B157G", "000008", "specialista", "cardiologia");
	
	@Test
	public void toStringTest() 
	{
		assertEquals(medico_generico.toString(), "-----------\nNome: Mario\nCognome: Rossi\nData di nascita: 01/01/1970\nLuogo di nascita: Brescia\nSesso: maschio\nTelefono: 0301234567\nCodice fiscale: MRARSS70A01B157U\n\nCodice albo: 123456789\n" + "Tipo: generico\n" + "Area di competenza: \n");
		assertEquals(medico_specialista.toString(), "-----------\nNome: Andrea\nCognome: Bianchi\nData di nascita: 04/05/1978\nLuogo di nascita: Brescia\nSesso: maschio\nTelefono: 030753869\nCodice fiscale: NDRBCH78C05B157G\n\nCodice albo: 000008\n" + "Tipo: specialista\n" + "Area di competenza: cardiologia\n");
	}
	
	@Test
	public void toStringNomeCognomeAlboTest()
	{
		assertEquals(medico_generico.toStringNomeCognomeAlbo(), "-----------\nNome: Mario\nCognome: Rossi\nCodice albo: 123456789\n");
		assertEquals(medico_specialista.toStringNomeCognomeAlbo(), "-----------\nNome: Andrea\nCognome: Bianchi\nCodice albo: 000008\n");
	}
	
	@Test
	public void modificaMedicoTest()
	{
		medico_specialista.modificaMedico("codice albo", "159263");
		assertEquals(medico_specialista.toStringNomeCognomeAlbo(), "-----------\nNome: Andrea\nCognome: Bianchi\nCodice albo: 159263\n" );
	}
	
	@Test
	public void datoUgualeTest()
	{
		assertEquals(medico_generico.datoUguale("0301234567"), true);
		assertEquals(medico_generico.datoUguale("03012345"), false);
	}
}
