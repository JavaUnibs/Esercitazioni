package it.unibs.ing.clinica;

import static org.junit.Assert.*;


import org.junit.Test;

public class ArchivioTest {
	
	Medico medico_g=new Medico("Mario", "Rossi", "22/2/1976", "Torino", "maschio", "3396875054", "MRARSS76F22G725X", "010", "Generico");
	Medico medico_s=new Medico("Mario", "Verdi", "12/9/1954", "Milano", "maschio", "3345754975", "MRAVRD54S12F254B", "025", "Specifico","Cardiologo");
	Utente utente=new Utente("Francesco", "Neri", "5/7/2000", "Varese", "maschio", "3385425842", "FRNNRE00L05G426Z");

	@Test
	public void testricercaUtentigenerico(){
		Archivio archivio = new Archivio();
		String specifico = utente.toStringNomeCognome();
		assertNull(archivio.ricercaUtenti(specifico));
	}
	
	@Test
	public void testricercaMedicigenerico(){
		Archivio archivio = new Archivio();
		String specifico = medico_g.toStringNomeCognomeAlbo();
		assertNull(archivio.ricercaMedici(specifico));
	}
	
	@Test
	public void testInserimentoUtentenomecognomedataNascitaluogoNascitasessonumTelefonocodiceFiscale(){
		Archivio archivio = new Archivio();
		archivio.inserimentoUtente("Francesco", "Neri", "5/7/2000", "Varese", "maschio", "3385425842", "FRNNRE00L05G426Z");
		assertTrue(archivio.getElencoUtenti().size() == 1);
	}


	@Test
	public void testInserimentoMediconomecognomedataNascitaluogoNascitasessonumTelefonocodiceFiscalecodiceAlbocodiceTipo(){
		Archivio archivio = new Archivio();
		archivio.inserimentoMedico("Mario", "Rossi", "22/2/1976", "Torino", "maschio", "3396875054", "MRARSS76F22G725X", "010", "Generico");
		assertTrue(archivio.getElencoMedici().size() == 1);
	}
	
	@Test
	public void testInserimentoMediconomecognomedataNascitaluogoNascitasessonumTelefonocodiceFiscalecodiceAlbocodiceTipoareaDiCompetenza(){
		Archivio archivio = new Archivio();
		archivio.inserimentoMedico("Mario", "Verdi", "12/9/1954", "Milano", "maschio", "3345754975", "MRAVRD54S12F254B", "025", "Specifico","Cardiologia");
		assertTrue(archivio.getElencoMedici().size() == 1);
	}
	
	@Test
	public void testAreeCompetenzaTotElencoMedici(){
		Archivio archivio = new Archivio();
	    archivio.inserimentoMedico("Mario", "Verdi", "12/9/1954", "Milano", "maschio", "3345754975", "MRAVRD54S12F254B", "025", "Specifico","Cardiologia");
	    assertSame(1, archivio.areeCompetenzaTot().size());
	}

}
