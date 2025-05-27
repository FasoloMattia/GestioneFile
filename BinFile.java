import java.io.*;

/**
 * Classe che rappresenta un file binario serializzato, estende AbstractFile.
 * Gestisce le operazioni di salvataggio, lettura e copia di file binari.
 */
public class BinFile extends AbstractFile {

    /**
     * Costruttore che inizializza il percorso del file.
     * @param percorsoFile Il percorso del file binario da gestire.
     */
    public BinFile(String percorsoFile) {
        super(percorsoFile);
    }

    /**
     * Salva il contenuto fornito come stringa serializzata nel file binario.
     * @param contenuto La stringa da salvare nel file.
     */
    @Override
    public void salva(String contenuto, boolean append) {
        try (ObjectOutputStream binFileSalva = new ObjectOutputStream(new FileOutputStream(getPercorsoFile(), append))) {
            binFileSalva.writeObject(contenuto); // Serializza e scrive la stringa nel file
        } catch (Exception e) {
            e.printStackTrace(); // Stampa la traccia dell'errore in caso di problemi
        }
    }

    /**
     * Legge il contenuto del file binario e lo restituisce come stringa.
     * @return Il contenuto del file come stringa, o una stringa vuota in caso di errore.
     */
    @Override
    public String leggi() {
        StringBuilder binContenutoFile = new StringBuilder(); // Accumula il contenuto del file
        try (FileInputStream binFileletto = new FileInputStream(getPercorsoFile())) {
            int byteLetto;
            while ((byteLetto = binFileletto.read()) != -1) {
                binContenutoFile.append((char) byteLetto);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Stampa la traccia dell'errore in caso di problemi
            return "";
        }
        return binContenutoFile.toString(); // Restituisce il contenuto come stringa
    }

    /**
     * Copia il contenuto del file binario corrente in un altro file binario.
     * @param destinazione Il percorso del file di destinazione.
     */
    @Override
    public void copia(String destinazione) {
        try (ObjectInputStream binPrimoFile = new ObjectInputStream(new FileInputStream(getPercorsoFile()));
             ObjectOutputStream binSecondoFile = new ObjectOutputStream(new FileOutputStream(destinazione))) {
            while (true) {
                try {
                    // Legge ogni oggetto serializzato dal file sorgente e lo scrive in quello di destinazione
                    Object contenuto = binPrimoFile.readObject();
                    binSecondoFile.writeObject(contenuto);
                } catch (EOFException e) {
                    // Fine del file raggiunta
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Stampa la traccia dell'errore in caso di problemi
        }
    }
}