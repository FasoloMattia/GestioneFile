public class BinFileDAO implements FileDAO {
    private final BinFile file;

    public BinFileDAO(String percorsoFile) {
        this.file = new BinFile(percorsoFile);
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
