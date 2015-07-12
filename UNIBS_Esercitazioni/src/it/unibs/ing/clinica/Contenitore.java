package it.unibs.ing.clinica;

import java.io.Serializable;
/**
 * 
 * @author Sartori Fabio
 *
 */

public class Contenitore implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Archivio archivio;
	private Agenda agenda;
	

	public Contenitore (Archivio _archivio, Agenda _agenda){
		archivio = _archivio;
		agenda = _agenda;
	}
	
	public Archivio getArchivio(){
		return archivio;
	}
	
	public Agenda getAgenda(){
		return agenda;
	}

}
