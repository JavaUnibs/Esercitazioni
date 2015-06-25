package it.unibs.ing.clinica;

public class Visita {
	 
	public String motivoVisita, refertoMedico, prescrizioneMedica, statoVisita, tipoVisita, areaCompetenza;
	
	Visita(String motivoVisita, String statoVisita, String tipoVisita, String areaCompetenza){
		
	}

/**
* Permette di assegnare un nuovo valore ad una variabile con nome uguale alla stringa in ingresso.
* @param campo La variabile che si vuole modificare
* @param input Il nuovo valore da assegnare
* @author Andrea Ferrari
*/
	public void modificaVisita(String campo, String input){
		campo.toLowerCase();
		switch (campo){
		case "motivo": motivoVisita=input;
		break;
        case "referto medico": refertoMedico=input;
		break;
		case "prescrizione": prescrizioneMedica=input;
		break;
		case "stato": statoVisita=input;
		break;
		case "tipo": tipoVisita=input;
		break;
		case "competenza": areaCompetenza=input;
		break;
		}
		
	}

/**
* Sovrascrive il metodo toString.
* @author Andrea Ferrari
*/
	public String toString(){
    	String descrizione="-----------\n"
    			+ "Motivo: "+motivoVisita+"\n"
    			+ "Tipo: "+tipoVisita+"\n"
    			+ "Area di competenza: "+areaCompetenza+"\n"
    			+ "Referto Medico: "+refertoMedico+"\n"
    			+ "Prescrizione medica: "+prescrizioneMedica+"\n"
    			+ "Stato: "+statoVisita+"\n"
    			+"-----------\n";
    	return descrizione;
    	
    }
}
