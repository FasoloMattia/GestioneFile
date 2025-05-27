import java.io.*;

/**
 * Classe che rappresenta un file di testo, estende AbstractFile.
 * Gestisce le operazioni di salvataggio, lettura e copia di un file di testo.
 */
public class TxtFile extends AbstractFile {

    /**
     * Costruttore che inizializza il percorso del file.
     * @param percorsoFile Il percorso del file da gestire.
     */
    public TxtFile(String percorsoFile) {
        super(percorsoFile);
    }

    /**
     * Salva il contenuto fornito nel file specificato dal percorso.
     * @param contenuto Il testo da salvare nel file.
     * @param append True o False per decidere se sovrasrcivere o aggiungere testo
     */
    @Override
    public void salva(String contenuto, boolean append) {
        try (BufferedWriter txtFileSalva = new BufferedWriter(new FileWriter(getPercorsoFile(), append))) {
            if (append) txtFileSalva.newLine();
            txtFileSalva.write(contenuto);
        } catch (Exception e) {
            e.printStackTrace(); // Stampa la traccia dell'errore in caso di problemi
        }
    }

    /**
     * Legge tutto il contenuto del file specificato dal percorso.
     * @return Il contenuto del file come stringa, o una stringa vuota in caso di errore.
     */
    @Override
    public String leggi() {
        StringBuilder contenuto = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(getPercorsoFile()))) {
            String linea;
            // Legge ogni riga del file fino alla fine
            while ((linea = reader.readLine()) != null) {
                // Aggiunge la riga letta al risultato, seguita da un a capo
                contenuto.append(linea).append(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Stampa la traccia dell'errore in caso di problemi
            return "";
        }
        return contenuto.toString();
    }

    /**
     * Copia il contenuto del file corrente nel file di destinazione specificato.
     * @param destinazione Il percorso del file di destinazione.
     */
    @Override
    public void copia(String destinazione) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getPercorsoFile()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinazione))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Stampa la traccia dell'errore in caso di problemi
        }
    }
}
