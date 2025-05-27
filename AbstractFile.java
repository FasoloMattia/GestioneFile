import java.io.*;

/**
 * Classe astratta che rappresenta un file generico.
 * Fornisce attributi e metodi di base per gestire i permessi e l'esistenza di un file.
 */
public abstract class AbstractFile {
    // Attributi finali che rappresentano le caratteristiche del file
    final String percorsoFile;         // Percorso completo del file

    /**
     * Costruttore che inizializza gli attributi del file.
     * @param percorsoFile Il percorso del file da gestire.
     */
    public AbstractFile(String percorsoFile) {
        this.percorsoFile = percorsoFile;
        // Controlla se il file esiste, è leggibile e modificabile

    }

    /**
     * Controlla se il file esiste.
     * @param percorsoFile Il percorso del file da controllare.
     * @return true se il file esiste, false altrimenti.
     */
    public static boolean controllaEsiste(String percorsoFile) {
        File file = new File(percorsoFile);
        return file.exists();
    }

    /**
     * Controlla se il file è leggibile.
     * @param percorsoFile Il percorso del file da controllare.
     * @return true se il file è leggibile, false altrimenti.
     */
    public static boolean controllaLeggibile(String percorsoFile) {
        File file = new File(percorsoFile);
        return file.canRead();
    }

    /**
     * Controlla se il file è modificabile.
     * @param percorsoFile Il percorso del file da controllare.
     * @return true se il file è modificabile, false altrimenti.
     */
    public static boolean controllaModificabile(String percorsoFile) {
        File file = new File(percorsoFile);
        return file.canWrite();
    }

    /**
     * Restituisce il percorso del file.
     * @return Il percorso del file.
     */
    public String getPercorsoFile() {
        return percorsoFile;
    }

    /**
     * Metodo astratto per salvare il contenuto nel file.
     * @param contenuto Il testo da salvare.
     */
    public abstract void salva(String contenuto, boolean append);

    /**
     * Metodo astratto per leggere il contenuto del file.
     * @return Il contenuto del file come stringa.
     */
    public abstract String leggi();

    /**
     * Metodo astratto per copiare il contenuto del file in un altro file.
     * @param destinazione Il percorso del file di destinazione.
     */
    public abstract void copia(String destinazione);
}
