package it.unibs.ing.myutility;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Sartori Fabio
 *
 */
public class SalvataggioFile {
	private final static String FILE_NON_SCRITTO = "Il processo di scrittura del file non è riuscito.";
	private final static String FILE_NON_LETTO = "Il processo di lettura del file non è riuscito.";
	private final static String FILE_NON_TROVATO = "Il file non è stato trovato.";
	private final static String FILE_NON_CHIUSO = "Il processo di chiusura del file non è riuscito.";
	
/**
 * Salva l'oggetto selezionato e quelli ad esso correlato in uno specifico file.
 * @param file
 * @param oggettoDaSalvare
 */
	public static void salvaOggetto(File file, Object oggettoDaSalvare) {
		ObjectOutputStream output = null;

		try {
			output = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(file)));

			output.writeObject(oggettoDaSalvare);

		} catch (IOException excScrittura) {
			System.out.println(FILE_NON_SCRITTO + file.getName());
		}

		finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException excChiusura) {
					System.out.println(FILE_NON_CHIUSO + file.getName());
				}
			}
		}

	}
	
/**
 * Carica l'oggetto(precedentemente salvato) e quelli ad esso correlato dal file specifico
 * @param file
 * @return
 */
	public static Object caricaOggetto(File file) {
		Object nomeFile = null;
		ObjectInputStream input = null;

		try {
			input = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(file)));

			nomeFile = input.readObject();

		} catch (FileNotFoundException excNotFound) {
			System.out.println(FILE_NON_TROVATO + file.getName());
		} catch (IOException excLettura) {
			System.out.println(FILE_NON_LETTO + file.getName());
		} catch (ClassNotFoundException excLettura) {
			System.out.println(FILE_NON_LETTO + file.getName());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException excChiusura) {
					System.out.println(FILE_NON_CHIUSO + file.getName());
				}
			}
		}

		return nomeFile;

	}
}
