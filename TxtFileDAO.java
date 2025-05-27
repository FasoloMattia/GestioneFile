public class TxtFileDAO implements FileDAO {
    private final TxtFile file;

    public TxtFileDAO(String percorsoFile) {
        this.file = new TxtFile(percorsoFile);
    }

    @Override
    public void salva(String contenuto, boolean append) {
        file.salva(contenuto, append);
    }

    @Override
    public String leggi() {
        return file.leggi();
    }

    @Override
    public void copia(String destinazione) {
        file.copia(destinazione);
    }
}
