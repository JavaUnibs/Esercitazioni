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
		visita.modificaVisita("referto medico", "Angina Pectoris");
		visita.modificaVisita("prescrizione", "Assunzione betabloccanti");
		assertEquals("-----------\nMotivo: Dolori al petto\nTipo: Specialista\nArea di competenza: Cardiologo\nReferto Medico: Angina Pectoris\nPrescrizione medica: Assunzione betabloccanti\n", visita.toString());
	}
	
}
