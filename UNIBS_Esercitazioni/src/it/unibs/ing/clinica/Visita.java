package it.unibs.ing.clinica;

public class Visita {
	 
	public String motivoVisita, refertoMedico, prescrizioneMedica, statoVisita, tipoVisita, areaCompetenza;
	
	Visita(String motivoVisita, String statoVisita, String tipoVisita, String areaCompetenza){
		
	}
	
	public void modificaVisite(String campo, String input){
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
}
