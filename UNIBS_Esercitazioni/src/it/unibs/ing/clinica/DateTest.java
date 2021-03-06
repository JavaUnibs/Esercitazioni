package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;


public class DateTest {

	@Test
	public void testIndiceGiorno() {
		LocalDate data=LocalDate.of(2015, 7, 8); //marted�
		assertSame(2, Date.indiceGiorno(data));
	}

	@Test
	public void testIndiceOra() {
		LocalTime ora=LocalTime.of(14, 30);
		assertSame(13, Date.indiceOra(ora));
	}

	@Test
	public void testIncrementoGiorno() {
		LocalDate data=LocalDate.of(2015, 8, 7);
		assertEquals(LocalDate.of(2015, 8, 14), Date.incrementoGiorno(data, 7));
	}

	@Test
	public void testIncrementoOra() {
		LocalTime ora=LocalTime.of(17, 30);
		assertEquals(LocalTime.of(19, 0), Date.incrementoOra(ora, 3));
	}
	
	@Test
	public void testControlloIntervallo(){
		assertFalse(Date.controlloIntervallo(LocalDate.of(2015, 7, 12), LocalDate.of(2015, 7, 25)));
	}
	
	@Test
	public void testControlloElencoGiorni(){
		LocalDate[] array={LocalDate.of(2015, 7, 8), LocalDate.of(2015, 7, 12)};
		assertFalse(Date.controlloElencoGiorni(array));
	}
	
	@Test
	public void testControlloOrari(){
		assertFalse(Date.controlloOrari(LocalTime.of(23, 0), LocalTime.of(22, 0)));
	}

}
