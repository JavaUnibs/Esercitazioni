package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

public class SlotTest {
	
	Medico medico=new Medico("Gino", "Pasquale", "10/8/1966", "Milano", "maschio", "3466783698", "PSQGNI66M10F205V", "007", "Generico");
	Medico medico2=new Medico("Mario", "Carlotti", "5/4/1972", "Napoli", "maschio", "3485860345", "CRLMRA72D05F839D", "008", "Specialista", "Cardiologia");
	Utente utente=new Utente("Piero", "Frollino", "7/12/2001", "Lecco", "maschio", "3490526345", "FRLPRI01T07E507C");
	Giorno giorno= new Giorno(medico, LocalDate.of(2015, 8, 7));
	Giorno giorno2=new Giorno(medico2, LocalDate.of(2012, 3, 1));
	
	

	@Test
	public void testConfrontaDisp() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		assertFalse(slot.confrontaDisp(giorno, giorno2));
	}

	@Test
	public void testCiclaElencoIns() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		slot.ciclaElencoIns(giorno2);
		int cont=0;
		for(Giorno giorno: slot.getGiorni()){
			if(giorno.equals(giorno2))cont++;
		}
		assertSame(1, cont);
	}

	@Test
	public void testCiclaElencoDel() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		slot.aggiungiGiorno(giorno);
		slot.ciclaElencoDel(giorno);
		assertFalse(slot.getGiorni().contains(giorno));
	}

	@Test
	public void testVerificaDisp() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		ArrayList<Giorno> temp= slot.verificaDisp(LocalDate.of(2012, 3, 1), "Specialistica", "Cardiologia");
		assertSame(1, temp.size());
		assertTrue(temp.contains(giorno2));
	}

	@Test
	public void testMassimaData() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		assertEquals(LocalDate.of(2015, 8, 7), slot.massimaData());
	}

	@Test
	public void testVisiteUtenteSlot() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		giorno.setUtente(utente);
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		ArrayList<Giorno> temp=slot.visiteUtenteSlot(utente);
		assertSame(1, temp.size());
		assertTrue(temp.contains(giorno));
	}

	@Test
	public void testVisiteMedicoSlot() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		ArrayList<Giorno> temp=slot.visiteMedicoSlot(medico);
		assertSame(1, temp.size());
		assertTrue(temp.contains(giorno));
	}

	@Test
	public void testVisiteTipoSlot() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		giorno.setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		giorno.cambiaStato("Prenotata");
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		ArrayList<Giorno> temp=slot.visiteTipoSlot("Specialistica", "Cardiologia");
		assertSame(1, temp.size());
		assertTrue(temp.contains(giorno));
	}

	@Test
	public void testNumVisite() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		giorno.setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		giorno.cambiaStato("Prenotata");
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		int[] temp=slot.numVisite();
		assertSame(1, temp[0]);
	}

	@Test
	public void testNumVisiteTipo() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		giorno.setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		giorno.cambiaStato("Prenotata");
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		int[] temp=slot.numVisiteTipo();
		assertSame(1, temp[1]);
	}

	@Test
	public void testNumVisiteArea() {
		Slot slot=new Slot(LocalTime.of(13, 30));
		giorno.setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		giorno.cambiaStato("Prenotata");
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		ArrayList<String> temp=new ArrayList<String>();
		temp.add("Cardiologia");
		int[][] temp2=slot.numVisiteArea(temp);
		assertSame(1, temp2[0][0]);
	}

}
