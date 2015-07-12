package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
		LocalDate[] array= {LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 10)};
		agenda.inserimentoDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), array);
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
		LocalDate[] array={LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 10)};
		agenda.inserimentoDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), array );;
		agenda.cancellaDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), array);
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
		LocalDate[] array={LocalDate.of(2015, 7, 8)};
		agenda.inserimentoDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), array);
		assertNull(agenda.specificaVisita(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 30)));
	}

	@Test
	public void testMassimaData() {
		Agenda agenda=new Agenda();
		LocalDate[] array= {LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 10)};
		agenda.inserimentoDisp(medico, LocalTime.of(14, 0), LocalTime.of(14, 30), array);
		assertEquals(LocalDate.of(2015, 7, 10), agenda.massimaData());
	}


	@Test
	public void testVisiteUtente() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.settimana[12][2].getGiorni().get(0).setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		agenda.settimana[12][2].getGiorni().get(0).setUtente(utente);
		agenda.settimana[12][2].getGiorni().get(0).cambiaStato("Prenotata");
		assertSame(1, agenda.visiteUtente(utente).size());
	}

	@Test
	public void testVisiteMedico() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.settimana[12][2].getGiorni().get(0).setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		agenda.settimana[12][2].getGiorni().get(0).setUtente(utente);
		agenda.settimana[12][2].getGiorni().get(0).cambiaStato("Prenotata");
		assertSame(1, agenda.visiteMedico(medico).size());
	}

	@Test
	public void testVisiteTipo() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.settimana[12][2].getGiorni().get(0).setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		agenda.settimana[12][2].getGiorni().get(0).setUtente(utente);
		agenda.settimana[12][2].getGiorni().get(0).cambiaStato("Prenotata");
		assertSame(1, agenda.visiteTipo("Specialistica").size()); //Inserire Cardiologia
	}

	@Test
	public void testStatisticheVisite() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.settimana[12][2].getGiorni().get(0).setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		agenda.settimana[12][2].getGiorni().get(0).setUtente(utente);
		agenda.settimana[12][2].getGiorni().get(0).cambiaStato("Prenotata");
		String test="Visite totali: 1\nVisite prenotate: 1\nVisite concluse: 0\n";
		assertEquals(test, agenda.statisticheVisite());
	}

	@Test
	public void testStatisticheVisiteTipo() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.settimana[12][2].getGiorni().get(0).setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		agenda.settimana[12][2].getGiorni().get(0).setUtente(utente);
		agenda.settimana[12][2].getGiorni().get(0).cambiaStato("Prenotata");
		String test="Visite totali generiche: 0\nVisite totali specialistiche: 1\nVisite prenotate generiche: 0\nVisite prenotate specialistiche: 1\n"
				+ "Visite concluse generiche: 0\nVisite concluse specialistiche: 0\n";
		assertEquals(test, agenda.statisticheVisiteTipo());
		
	}

	@Test
	public void testStatisticheVisiteArea() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.settimana[12][2].getGiorni().get(0).setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		agenda.settimana[12][2].getGiorni().get(0).setUtente(utente);
		agenda.settimana[12][2].getGiorni().get(0).cambiaStato("Prenotata");
		ArrayList<String> temp=new ArrayList<String>();
		temp.add("Cardiologia");
		String test="Visite prenotate di Cardiologia: 1\nVisite concluse di Cardiologia: 0\n";
		assertEquals(test, agenda.statisticheVisiteArea(temp));
	}

	@Test
	public void testStatisticheVisiteAreaMinMax() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.settimana[12][2].getGiorni().get(0).setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		agenda.settimana[12][2].getGiorni().get(0).setUtente(utente);
		agenda.settimana[12][2].getGiorni().get(0).cambiaStato("Prenotata");
		ArrayList<String> temp=new ArrayList<String>();
		temp.add("Cardiologia");
		String test="Area di competenza con più visite: Cardiologia\nArea di competenza con meno visite: Cardiologia\n";
		assertEquals(test, agenda.statisticheVisiteAreaMinMax(temp));
	}

	@Test
	public void testStatisticheVisiteMedici() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		agenda.settimana[12][2].getGiorni().get(0).setVisita(new Visita("prova", "Specialistica", "Cardiologia"));
		agenda.settimana[12][2].getGiorni().get(0).setUtente(utente);
		agenda.settimana[12][2].getGiorni().get(0).cambiaStato("Prenotata");
		ArrayList<Medico> temp=new ArrayList<Medico>();
		temp.add(medico);
		String test="-----------\nNome: Gino\nCognome: Pasquale\nCodice albo: 007\nVisite assegnate: 1\n";
		assertEquals(test, agenda.statisticheVisiteMedici(temp));
		
	}
	
	@Test
	public void testTrovaDispGiorno() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		assertTrue(agenda.trovaDispGiorno(utente, LocalDate.of(2015, 7, 8), LocalTime.of(13, 0), "generica", ""));
	}

	@Test
	public void testTrovaDispSett() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 8), LocalTime.of(14, 0), LocalTime.of(14, 30));
		assertTrue(agenda.trovaDispSett(utente, LocalDate.of(2015, 7, 6), "generica", ""));
	}

	@Test
	public void testTrovaDispOvunque() {
		Agenda agenda=new Agenda();
		agenda.inserimentoDisp(medico, LocalDate.of(2015, 7, 16), LocalTime.of(14, 0), LocalTime.of(14, 30));
		assertTrue(agenda.trovaDispOvunque(utente, LocalDate.of(2015, 7, 8), "generica", ""));
	}
	
	@Test
	public void testControlloIntervallo(){
		Agenda agenda=new Agenda();
		assertFalse(agenda.controlloIntervallo(LocalDate.of(2015, 7, 12), LocalDate.of(2015, 7, 25)));
	}
	
	@Test
	public void testControlloElencoGiorni(){
		Agenda agenda=new Agenda();
		LocalDate[] array={LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 12)};
		assertFalse(agenda.controlloElencoGiorni(array));
	}

}
