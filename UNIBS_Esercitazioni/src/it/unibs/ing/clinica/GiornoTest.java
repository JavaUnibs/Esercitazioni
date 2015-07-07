package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class GiornoTest {
	Medico medico=new Medico("Gino", "Pasquale", "10/8/1966", "Milano", "maschio", "3466783698", "PSQGNI66M10F205V", "007", "Generico");
	Giorno giorno= new Giorno(medico, LocalDate.of(2015, 8, 7));

	@Test
	public void testCambiaStato() {
		giorno.cambiaStato("conclusa");
		assertEquals(StatoVisita.Conclusa, giorno.getStato());
	}

}
