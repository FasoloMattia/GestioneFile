## 👤 Autori: [Fasolo Mattia](https://github.com/FasoloMattia) | [Pesaresi Francesco](https://github.com/PesinoFrancesco)

# 📂 GestoreFile

Questo programma Java permette di gestire file **di testo (TXT)** e **binari (BIN)** tramite un'interfaccia testuale interattiva. È possibile leggere, scrivere, copiare e cambiare file in modo semplice e guidato.

---

## ▶️ Avvio del Programma

Compila ed esegui il file `Main.java`:

```bash
javac Main.java
java Main
```

---

## 🛠️ Requisiti base

* Java 8 o superiore
* Console abilitata per l’input

---

## 📋 Menu Principale

Dopo l'avvio, il programma ti chiederà:

1. **Tipo di file da gestire**:

   * `1` → File di testo `.txt`
   * `2` → File binario serializzato `.bin`

2. **Percorso del file**:
   Inserisci il percorso completo e valido del file.

⚠️ Assicurati di inserire il percorso **assoluto** del tuo file.

---

## 🔧 Operazioni Disponibili

Una volta selezionato il file, verrà mostrato il seguente menu:

```
1. Salva contenuto nel file
2. Leggi il file
3. Copia il file
4. Cambia il file
5. Esci
```

### 1. ✍️ Salva contenuto nel file

* Inserisci il testo da scrivere nel file.
* Indica se vuoi **sovrascrivere (false)** o **aggiungere (true)** il contenuto del file selezionato.

### 2. 📖 Leggi il file

* Mostra il contenuto attuale del file selezionato.

### 3. 📁 Copia il file

* Inserisci il percorso di destinazione (nome del nuovo file da creare compreso).
* Il file viene copiato nel nuovo percorso (inclusi i contenuti serializzati nel caso di file binari).

### 4. 🔄 Cambia il file

* Ti permette di selezionare un **nuovo tipo di file** e un **nuovo percorso**.

### 5. ❌ Esci

* Termina il programma.

---

## 📂 Tipi di File Supportati

| Tipo    | Estensione | Classe Usata | DAO          |
| ------- | ---------- | ------------ | ------------ |
| Testo   | `.txt`     | `TxtFile.java`    | `TxtFileDAO.java` |
| Binario | `.bin`     | `BinFile.java`    | `BinFileDAO.java` |

---

## 🧱 Architettura

Il progetto è strutturato secondo il **DAO Pattern**:

* **DAO (Data Access Object)**:

  * `FileDAO`: interfaccia base del programma, presenta i **metodi vuoti**
  * `TxtFileDAO`, `BinFileDAO`: implementazioni per l’accesso ai file
* **Modello di astrazione**:

  * `AbstractFile.java`: classe base **astratta**
  * `TxtFile.java`, `BinFile.java`: estensioni concrete per **popolare i metodi** specifici 
* **Main**:

  * Interfaccia testuale per l’interazione utente

---

## 📊 [Diagramma UML](GestioneFile_UML.png)

## 🧪 Esempio di Utilizzo

```
Scegli il tipo di file:
1. File di testo (TXT)
2. File binario (BIN)
> 1
Inserisci il percorso del file:
> C:\documenti\esempio.txt
```

```
Menu operazioni:
1. Salva contenuto nel file
2. Leggi il file
3. Copia il file
4. Cambia il file
5. Esci
> 2
```

---
