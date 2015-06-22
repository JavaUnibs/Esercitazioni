package it.unibs.ing.clinica;
import java.time.*;
import java.util.*;

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
	
	public boolean confrontaDisp(Giorno giorno, Giorno giorno2){
		if(giorno.medico==giorno2.medico&giorno.data.equals(giorno2.data)) return true;
		else return false;
	}
	
	public void inserimentoDisp (Medico medico, LocalDate giornoIniziale, LocalDate giornoFinale, LocalTime oraIniziale, LocalTime oraFinale){
		int i, j=Date.indiceGiorno(giornoFinale), k, x=Date.indiceOra(oraFinale), cont=0;
		boolean valore=false;
		
		for(i=Date.indiceGiorno(giornoIniziale);i<=j;i++){
			for (k=Date.indiceOra(oraIniziale);k<=x;k++){
				Giorno temp=new Giorno(medico, Date.incrementoGiorno(giornoIniziale, cont));
				for(Giorno y: settimana[i][k].giorni){
					if(!confrontaDisp(y, temp)) valore=true;
				}
				if(!valore) settimana[i][k].aggiungiGiorno(temp);
				}
			cont++;
		}
	}
	
	
	public void inserimentoDisp(Medico medico, LocalTime oraIniziale, LocalTime oraFinale, LocalDate... giorniVari){
		int i, k, x=Date.indiceOra(oraFinale), j;
		boolean valore=false;
		
		for(i=0;i<giorniVari.length;i++){
			j=Date.indiceGiorno(giorniVari[i]);
			for (k=Date.indiceOra(oraIniziale);k<=x;k++){
				Giorno temp= new Giorno(medico, giorniVari[i]);
				for(Giorno y: settimana[j][k].giorni){
					if(!confrontaDisp(y, temp)) valore=true;
				}
				if(!valore) settimana[j][k].aggiungiGiorno(temp);
				}
			}
		}
	
	public void inserimentoDisp(Medico medico, LocalDate giorno, LocalTime oraIniziale, LocalTime oraFinale){
		int k, x=Date.indiceOra(oraFinale);
		boolean valore=false;
		
		for (k=Date.indiceOra(oraIniziale);k<=x;k++){
			Giorno temp= new Giorno(medico, giorno);
			for(Giorno y: settimana[Date.indiceGiorno(giorno)][k].giorni){
				if(!confrontaDisp(y, temp)) valore=true;
			}
			if(!valore) settimana[Date.indiceGiorno(giorno)][k].aggiungiGiorno(temp);
			}
			
		}
	

	public void orariVisita(Medico medico){
	ArrayList<LocalDateTime> orari=new ArrayList<LocalDateTime>();
	
		for(int i=0;i<6;i++){
			for(int j=0;j<20;j++){
				for(Giorno y: settimana[i][j].giorni){
					if(y.medico==medico) orari.add(LocalDateTime.of(y.data, settimana[i][j].ora));
				}
			}
		}
	    for(int j=0;j<orari.size();j++){
	    	LocalDate data= orari.get(i).get
	    }
		
	
	
	}
	
	
}


		



