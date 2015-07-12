package it.unibs.ing.clinica;

import static org.junit.Assert.*;

import org.junit.Test;

public class VisitaTest {

	Visita visita = new Visita("Dolori al petto", "Specialista", "Cardiologo");
	
	@Test
	public void testModificaVisitacampoinput() {
		visita.modificaVisita("motivo", "Tachicardia");
		assertEquals("Tachicardia",visita.getMotivo());
	}
	
	@Test
	public void toStringTest() 
	{
		assertEquals("-----------\nMotivo: Dolori al petto\nTipo: Specialista\nArea di competenza: Cardiologo\nReferto Medico: \nPrescrizione medica: \n", visita.toString());
	}
	
}
