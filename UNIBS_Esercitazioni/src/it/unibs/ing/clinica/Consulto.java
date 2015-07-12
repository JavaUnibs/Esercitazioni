package it.unibs.ing.clinica;

public class Consulto {
	
	private Medico medico;
	private boolean approvazione;
	private String referto;
	private String prescrizione;
	
	Consulto(Medico _medico, boolean _approvazione, String _referto, String _prescrizione){
		medico=_medico;
		approvazione=_approvazione;
		referto=_referto;
		prescrizione=_prescrizione;
	}

}
