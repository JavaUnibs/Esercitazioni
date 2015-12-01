package it.unibs.ing.asteroids;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;

public enum SpaceSound {
	FIRE("fire.wav"),
	BEAT1("bit1.wav"),
	BEAT2("bit2.wav"),
	ENGINE_ON("thrust.wav");
	
	
	String fileName;
	//Ogni oggetto dell'enum conosce il nome del file
	SpaceSound(String fName){
		this.fileName = fName;
	}
	
	public Clip play(){
		Clip clip = null;
		try{
			//Richiedo al mixer della scheda audio una linea
			AudioInputStream sound = 
					AudioSystem.getAudioInputStream(
							new File(System.getProperty("user.dir") +
									"/resources/" + fileName));
			//Inizializzata la risorsa musicale alla linea riservata dal mixer
			clip = AudioSystem.getClip();
			clip.open(sound);
			
			//Chiude la linea aperta dal mixer
			clip.addLineListener((e) -> {
				if(LineEvent.Type.STOP.equals(e.getType()))
					e.getLine().close();
			}); 
			
			//Play una sola volta(0)
			clip.loop(0);
			
		} catch(Exception e) {
			System.err.println("Errore: Audio Failed " + e);
		}
		return clip;
	}
	
}
