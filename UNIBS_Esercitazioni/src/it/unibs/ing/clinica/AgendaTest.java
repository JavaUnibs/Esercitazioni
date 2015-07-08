package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

public class AgendaTest {
	
	Medico medico=new Medico("Gino", "Pasquale", "10/8/1966", "Milano", "maschio", "3466783698", "PSQGNI66M10F205V", "007", "Generico");
	Utente utente=new Utente("Piero", "Frollino", "7/12/2001", "Lecco", "maschio", "3490526345", "FRLPRI01T07E507C");
	
	@Test
	public void testInserimentoDispMedicoLocalDateLocalDateLocalTimeLocalTime() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 9), LocalTime.of(14, 0), LocalTime.of(14, 30));
		assertTrue(agenda.settimana[12][2].getGiorni().get(0).equals(new Giorno(medico, LocalDate.of(2015, 7, 8))));
		assertTrue(agenda.settimana[13][2].getGiorni().get(0).equals(new Giorno(medico, LocalDate.of(2015, 7, 8))));
		assertTrue(agenda.settimana[12][3].getGiorni().get(0).equals(new Giorno(medico, LocalDate.of(2015, 7, 9))));
		assertTrue(agenda.settimana[13][3].getGiorni().get(0).equals(new Giorno(medico, LocalDate.of(2015, 7, 9))));
	}

	@Test
	public void testInserimentoDispMedicoLocalTimeLocalTimeLocalDateArray() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 10));
		assertTrue(agenda.settimana[12][2].getGiorni().get(0).equals(new Giorno(medico, LocalDate.of(2015, 7, 8))));
		assertTrue(agenda.settimana[13][2].getGiorni().get(0).equals(new Giorno(medico, LocalDate.of(2015, 7, 8))));
		assertTrue(agenda.settimana[12][4].getGiorni().get(0).equals(new Giorno(medico, LocalDate.of(2015, 7, 10))));
		assertTrue(agenda.settimana[13][4].getGiorni().get(0).equals(new Giorno(medico, LocalDate.of(2015, 7, 10))));
	}

	@Test
	public void testInserimentoDispMedicoLocalDateLocalTimeLocalTime() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		Giorno giorno=new Giorno(medico, LocalDate.of(2015, 7, 8));
		assertTrue(agenda.settimana[12][2].getGiorni().get(0).equals(giorno));
		assertTrue(agenda.settimana[13][2].getGiorni().get(0).equals(giorno));
		
	}

	@Test
	public void testOrariVisita() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		String test="Orari disponibili: \n2015-07-08T14:00\n2015-07-08T14:30\n";
		assertEquals(test, agenda.orariVisita(medico));
		
	}

	@Test
	public void testMediciDisponibili() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		String test="Medici disponibili: \n-----------\nNome: Gino\nCognome: Pasquale\nCodice albo: 007\n";
		assertEquals(test, agenda.mediciDisponibili(LocalDate.of(2015, 7, 8), LocalTime.of(14, 30)));
	}

	@Test
	public void testCancellaDispMedicoLocalDateLocalDateLocalTimeLocalTime() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 9), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.cancellaDisp(medico, LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 9), LocalTime.of(14, 0), LocalTime.of(14, 30));
		assertSame(0, agenda.settimana[12][2].getGiorni().size());
		assertSame(0,agenda.settimana[13][2].getGiorni().size());
		assertSame(0,agenda.settimana[12][3].getGiorni().size());
		assertSame(0,agenda.settimana[13][3].getGiorni().size());
	}

	@Test
	public void testCancellaDispMedicoLocalTimeLocalTimeLocalDateArray() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 10));
		agenda.cancellaDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 10));
		assertSame(0,agenda.settimana[12][2].getGiorni().size());
		assertSame(0,agenda.settimana[13][2].getGiorni().size());
		assertSame(0,agenda.settimana[12][4].getGiorni().size());
		assertSame(0,agenda.settimana[13][4].getGiorni().size());
	}

	@Test
	public void testCancellaDispMedicoLocalDateLocalTimeLocalTime() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.cancellaDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		assertSame(0,agenda.settimana[12][2].getGiorni().size());
		assertSame(0,agenda.settimana[13][2].getGiorni().size());
	}

	@Test
	public void testSpecificaVisita() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), LocalDate.of(2015, 7, 8));
		assertNull(agenda.specificaVisita(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 30)));
	}

	@Test
	public void testMassimaData() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 10));
		assertEquals(LocalDate.of(2015, 7, 10), agenda.massimaData());
	}

	@Test
	public void testInserimentoVisita() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisiteUtente() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisiteMedico() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisiteTipo() {
		fail("Not yet implemented");
	}

	@Test
	public void testStatisticheVisite() {
		fail("Not yet implemented");
	}

	@Test
	public void testStatisticheVisiteTipo() {
		fail("Not yet implemented");
	}

	@Test
	public void testStatisticheVisiteArea() {
		fail("Not yet implemented");
	}

	@Test
	public void testStatisticheVisiteAreaMinMax() {
		fail("Not yet implemented");
	}

	@Test
	public void testStatisticheVisiteMedici() {
		fail("Not yet implemented");
	}

}
