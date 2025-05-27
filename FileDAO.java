public interface FileDAO {
    void salva(String contenuto, boolean append);
    String leggi();
    void copia(String destinazione);
}
