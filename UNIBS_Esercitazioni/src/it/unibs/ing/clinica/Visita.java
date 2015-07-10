package it.unibs.ing.clinica;

import java.io.Serializable;

public class Visita implements Serializable{
	 
<<<<<<< HEAD
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String motivoVisita, refertoMedico, prescrizioneMedica, tipoVisita, areaCompetenza="";
=======
	private String motivoVisita, refertoMedico="", prescrizioneMedica="", tipoVisita, areaCompetenza="";
>>>>>>> branch 'master' of https://github.com/JavaUnibs/Esercitazioni
	
	Visita(String _motivoVisita, String _tipoVisita, String _areaCompetenza){
		motivoVisita=_motivoVisita;
		tipoVisita=_tipoVisita;
		areaCompetenza=_areaCompetenza;
	}
	
	
	public String getTipo(){
		return tipoVisita;
	}
	
	public String getAreaComp(){
		return areaCompetenza;
	}
	
	public String getReferto(){
		return refertoMedico;
	}
	
	public String getPrescrizione(){
		return prescrizioneMedica;
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
    			+ "Prescrizione medica: "+prescrizioneMedica+"\n";
    	return descrizione;
    	
    }
	
	public String getMotivo(){
		return "Motivo: "+motivoVisita+"\n";
	}
	
	public String getRefertoPrescrizione(){
		return "Referto Medico: "+refertoMedico+"\n"
    			+ "Prescrizione medica: "+prescrizioneMedica+"\n";	
	}
}
