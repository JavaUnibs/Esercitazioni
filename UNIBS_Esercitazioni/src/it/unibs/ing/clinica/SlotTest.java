package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

public class SlotTest {
	
	Medico medico=new Medico("Gino", "Pasquale", "10/8/1966", "Milano", "maschio", "3466783698", "PSQGNI66M10F205V", "007", "Generico");
	Medico medico2=new Medico("Mario", "Carlotti", "5/4/1972", "Napoli", "maschio", "3485860345", "CRLMRA72D05F839D", "008", "Specialista", "Cardiologo");
	Giorno giorno= new Giorno(medico, LocalDate.of(2015, 8, 7));
	Giorno giorno2=new Giorno(medico2, LocalDate.of(2012, 3, 1));
	Slot slot=new Slot(LocalTime.of(13, 30));
	

	@Test
	public void testConfrontaDisp() {
		assertFalse(slot.confrontaDisp(giorno, giorno2));
	}

	@Test
	public void testCiclaElencoIns() {
		slot.aggiungiGiorno(giorno);
		slot.aggiungiGiorno(giorno2);
		slot.ciclaElencoIns(giorno2);
		int cont=0;
		for(Giorno giorno:slot.getGiorni()){
			if(giorno.equals(giorno2))cont++;
		}
		assertSame(1, cont);
	}

	@Test
	public void testCiclaElencoDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerificaDisp() {
		fail("Not yet implemented");
	}

	@Test
	public void testMassimaData() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisiteUtenteSlot() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisiteMedicoSlot() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisiteTipoSlot() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumVisite() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumVisiteTipo() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumVisiteArea() {
		fail("Not yet implemented");
	}

}
