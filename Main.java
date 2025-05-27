import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tipoFile;
        FileDAO fileDao = null;
        String percorso = "";

        while (true) {
            System.out.println("Scegli il tipo di file:");
            System.out.println("1. File di testo (TXT)");
            System.out.println("2. File binario (BIN)");
            System.out.print("Inserisci la scelta: ");
            try {
                tipoFile = scanner.nextInt();
                scanner.nextLine();
                if (tipoFile == 1 || tipoFile == 2) break;
                else System.out.println("Scelta non valida. Inserisci 1 o 2.");
            } catch (Exception e) {
                System.out.println("Errore: inserisci un numero valido!");
                scanner.nextLine();
            }
        }

        // Ottieni percorso valido
        while (true) {
            System.out.print("Inserisci il percorso del file: ");
            percorso = scanner.nextLine();
            if (AbstractFile.controllaEsiste(percorso)) break;
            System.out.println("Errore: percorso non valido!");
        }

        // Crea il DAO corretto
        fileDao = (tipoFile == 1) ? new TxtFileDAO(percorso) : new BinFileDAO(percorso);

        while (true) {
            System.out.println("\nMenu operazioni:");
            System.out.println("1. Salva contenuto nel file");
            System.out.println("2. Leggi il file");
            System.out.println("3. Copia il file");
            System.out.println("4. Cambia il file");
            System.out.println("5. Esci");
            System.out.print("Inserisci la scelta: ");
            int scelta;

            try {
                scelta = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Errore: inserisci un numero valido!");
                scanner.nextLine();
                continue;
            }

            switch (scelta) {
                case 1:
                    if (!AbstractFile.controllaModificabile(percorso)) {
                        System.out.println("Il file non è modificabile");
                        break;
                    }
                    System.out.print("Inserisci il contenuto da salvare: ");
                    String testo = scanner.nextLine();
                    System.out.print("Append (true) o sovrascrivi (false)? ");
                    boolean append = scanner.nextBoolean();
                    scanner.nextLine();
                    fileDao.salva(testo, append);
                    System.out.println("Contenuto salvato con successo.");
                    break;

                case 2:
                    if (!AbstractFile.controllaLeggibile(percorso)) {
                        System.out.println("Il file non è leggibile");
                        break;
                    }
                    String contenuto = fileDao.leggi();
                    System.out.println("\nContenuto del file:");
                    System.out.println(contenuto);
                    break;

                case 3:
                    if (!AbstractFile.controllaLeggibile(percorso)) {
                        System.out.println("Il file non è copiabile");
                        break;
                    }
                    System.out.print("Inserisci il percorso del file di destinazione: ");
                    String destinazione = scanner.nextLine();
                    fileDao.copia(destinazione);
                    System.out.println("File copiato con successo.");
                    break;

                case 4:
                    // Ritorna alla selezione tipo file e percorso
                    while (true) {
                        System.out.println("Scegli il tipo di file:");
                        System.out.println("1. File di testo (TXT)");
                        System.out.println("2. File binario (BIN)");
                        System.out.print("Inserisci la scelta: ");
                        try {
                            tipoFile = scanner.nextInt();
                            scanner.nextLine();
                            if (tipoFile == 1 || tipoFile == 2) break;
                            else System.out.println("Scelta non valida.");
                        } catch (Exception e) {
                            System.out.println("Errore: numero non valido!");
                            scanner.nextLine();
                        }
                    }

                    while (true) {
                        System.out.print("Inserisci il percorso del nuovo file: ");
                        percorso = scanner.nextLine();
                        if (AbstractFile.controllaEsiste(percorso)) break;
                        System.out.println("Errore: percorso non valido!");
                    }

                    fileDao = (tipoFile == 1) ? new TxtFileDAO(percorso) : new BinFileDAO(percorso);
                    break;

                case 5:
                    System.out.println("Arrivederci!");
                    return;

                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }
    }
}
