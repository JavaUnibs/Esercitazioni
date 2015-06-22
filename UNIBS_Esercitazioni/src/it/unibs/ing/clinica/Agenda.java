package it.unibs.ing.clinica;
import java.time.*;

public class Agenda {
	Slot[][] settimana = new Slot[6][20];
	
	Agenda(){
		LocalTime temp= LocalTime.of(8, 00);
		int i,j;
		for(i=0;i<6;i++){
			for (j=0;j<20;j++){
				settimana[i][j]=new Slot(Date.incrementoOra(temp, j));
			}
		}
	}
	
	public void inserimentoMedico (Medico medico, LocalDate giornoIniziale, LocalDate giornoFinale, LocalTime oraIniziale, LocalTime oraFinale){
		int i, j=Date.indiceGiorno(giornoFinale), k, x=Date.indiceOra(oraFinale), cont=0;
		
		for(i=Date.indiceGiorno(giornoIniziale);i<=j;i++){
			for (k=Date.indiceOra(oraIniziale);k<=x;k++){
				settimana[i][k].aggiungiGiorno(new Giorno(medico, Date.incrementoGiorno(giornoIniziale, cont)));
				}
			cont++;
		}
	}
		
		
	
}


