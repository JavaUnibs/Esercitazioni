package it.unibs.ing.clinica;

import java.io.Serializable;
import java.util.*;

public class Visita implements Serializable{
	 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	private String motivoVisita, refertoMedico="", prescrizioneMedica="", tipoVisita, areaCompetenza="";
    private ArrayList<Consulto> elencoConsulti=new ArrayList<Consulto>();
	
	Visita(String _motivoVisita, String _tipoVisita, String _areaCompetenza){
		motivoVisita=_motivoVisita;
		tipoVisita=_tipoVisita;
		areaCompetenza=_areaCompetenza;
	}
/**
 * Crea ed inserisce un consulto specialistico nell'elenco dei consulti di questa visita.	
 * @param _medico         il medico che ha effettuato il consulto
 * @param _approvazione   valore boolean
 * @param _referto        il nuovo referto
 * @param _prescrizione   la nuova prescrizione
 * @author Sartori Fabio
 */
	public void inserisciConsulto(Medico _medico, boolean _approvazione, String _referto, String _prescrizione){
		elencoConsulti.add(new Consulto(_medico, _approvazione, _referto, _prescrizione));
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
* @author Sartori Fabio
*/
	public void modificaVisita(String campo, String input){
		campo=campo.toLowerCase();
		switch (campo){
		case "motivo": motivoVisita=input;
		break;
        case "referto": refertoMedico=input;
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
* @author Sartori Fabio
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
		return motivoVisita;
	}
}
