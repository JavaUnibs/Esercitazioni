package it.unibs.ing.archivioCD;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArchivioCdTest {
	@Test
	public void testAggiuntaCd() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De André"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De André"));
		assertEquals(2, archivio.getNumeroCd());
	}
	
	@Test
	public void testRicercaTitoloPresente() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De André"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De André"));
		assertTrue(archivio.contiene("Anime salve"));
	}
	
	@Test
	public void testRicercaTitoloNonPresente() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De André"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De André"));
		assertFalse(archivio.contiene("La buona novella"));
	}
	
	@Test
	public void testEliminazioneCdPerTitolo() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.aggiungiCd(new Cd("Anime salve", "Fabrizio De André"));
		archivio.aggiungiCd(new Cd("Storia di un impiegato", "Fabrizio De André"));
		assertEquals(2, archivio.getNumeroCd());
		archivio.eliminaCd("Anime salve");
		assertEquals(1, archivio.getNumeroCd());
		assertFalse(archivio.contiene("Anime salve"));
	}
}
