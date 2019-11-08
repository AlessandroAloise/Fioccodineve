1. [Introduzione](#introduzione)

  - [Informazioni sul progetto](#informazioni-sul-progetto)

  - [Abstract](#abstract)

  - [Scopo](#scopo)

1. [Analisi](#analisi)

  - [Analisi del dominio](#analisi-del-dominio)

  - [Analisi dei mezzi](#analisi-dei-mezzi)

  - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)

  - [Use case](#use-case)

  - [Pianificazione](#pianificazione)

1. [Progettazione](#progettazione)

  - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)

  - [Design dei dati e database](#design-dei-dati-e-database)

1. [Implementazione](#implementazione)

1. [Test](#test)

  - [Protocollo di test](#protocollo-di-test)

  - [Risultati test](#risultati-test)

  - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

1. [Consuntivo](#consuntivo)

1. [Conclusioni](#conclusioni)

  - [Sviluppi futuri](#sviluppi-futuri)

  - [Considerazioni personali](#considerazioni-personali)

1. [Sitografia](#sitografia)

1. [Allegati](#allegati)


## Introduzione

### Informazioni sul progetto

  - Titolo Progetto: Fiocco di neve
  -  Docente responsabile: Luca Muggiasca, Geo Petrini
  -  Allievo responsabili: Alessandro Aloise
  -  CPT Trevano sezione Informatica
  -  Classe: I3AA
  -  Materia: Modulo 306
  -  Inizio progetto 3 settembre 2019
  -  Fine progetto  20 dicembre 2019


### Abstract

Il progetto è gestito e realizzato dal'alievo (studente di informatica all’Arti e Mestieri di Trevano) sotto la supervisione del professor Luca Muggiasca e  Geo Petrini. Il progetto é realizzare un applicazione java che permette di generale manualmente un fiocco di neve . La realizzazione del progetto inizia il 03 settembre 2019 (03/09/19) e dovrà essere consegnato entro il 20 dicembre 2019 (20/12/19).



### Scopo
  Lo scopo dell'progetto é di imparare a gestire i progetti, per fare quesoto
  usaiamo la creazione dell'aplicazione fiocco di neve per imparare tutti quello
  che si deve fare in un progetto.   

## Analisi

### Analisi del dominio

Il progetto consiste in un applicazione in java per generare un fiocco di neve fatto
dall'utente.

# Analisi dei requisiti
| ID | Categoria | Requisito |Priorità |Versione |
| ------|------|------|------|------|
| REQ_001 | Sito web | Creare un sito per scaricare l'applicativo | 2 |1.0 |
| REQ_002 | Sito web | Descrizione del progetto sul sito | 4 |1.0 |
| REQ_003 | Sito web | Parametri minimi che il pc deve avere | 4 |1.0 |
| REQ_004 | Programma | Il triangolo occupa sempre il 50% della finestra  | 1 |1.0 |
| REQ_005 | Programma | I punti di taglio sono da inserire con click del mouse | 1 |1.0 |
| REQ_005 | Programma | Tasto per la cancellazione dei punti messi  |2 |1.0 |
| REQ_006 | Programma | Bottone genera che non salva ma mostra solo l'anteprima  |2 |1.0 |
| REQ_007 | Esportazione |L'applicazione deve permettere di esportare il fiocco in raster con dimensioni selezionabili, il formato consigliato è PNG |2 |1.0 |
| REQ_008 | Esportazione |Dimensioni che può avere PNG 500 o 1000 o quella attuale |2 |1.0 |
| REQ_009 | Salvataggio |Scelta del formato da salvare per l'immagine del fiocco |2 |1.0 |
| REQ_010 | Esportazione |Creazione "snapshot" del fiocco per poterlo modificare |2 |1.0 |
| REQ_011 | Salvataggio |Salvataggio dei triangoli modificati in CSV |2 |1.0 |
| REQ_012 | Sito web | Menù con le varie cose a sinistra |2 |1.0 |
| REQ_013 | Sito web | Menù del programma con fiocchi recenti  |1 |1.0 |
| REQ_014 | Sito web + | imagini dei fiocchi di neve recenti  |3 |1.0 |
| REQ_015 | Sito web | Fornire .class in github ma per gli utenti fornire il jar  |2 |1.0 |



### Pianificazione

Questa è la pianificazione e struttura che abbiamo cercato di rispettare per tutto il percorso di questo progetto.
![Gantt Preventivo](gantt.png)
### Analisi dei mezzi

Per la realizzazione di questo progetto ho usato come software:

GitHub: Punto di riferimento sul quale caricare  il lavoro fatto attraverso i commit.

GitHub Desktop 2.1.3: Programma per effettuare il push e pull di commit attraverso un'interfaccia grafica.

Atom 1.40.1: Editore di testo per scrivere principalmente la documentazione.

NetBeans 11.1: IDE per sviluppare tutto il codice scritto in Java.

ProjectLibre 1.9.1 software per la gestione di progetti.

## Progettazione

Questo capitolo descrive esaustivamente come deve essere realizzato il
prodotto fin nei suoi dettagli. Una buona progettazione permette
all’esecutore di evitare fraintendimenti e imprecisioni
nell’implementazione del prodotto.

### Design dell’architettura del sistema

Descrive:

-   La struttura del programma/sistema lo schema di rete...

-   Gli oggetti/moduli/componenti che lo compongono.

-   I flussi di informazione in ingresso ed in uscita e le
    relative elaborazioni. Può utilizzare *diagrammi di flusso dei
    dati* (DFD).

-   Eventuale sitemap

### Design dei dati e database

Descrizione delle strutture di dati utilizzate dal programma in base
agli attributi e le relazioni degli oggetti in uso.

### Schema E-R, schema logico e descrizione.

Se il diagramma E-R viene modificato, sulla doc dovrà apparire l’ultima
versione, mentre le vecchie saranno sui diari.

### Design delle interfacce

Descrizione delle interfacce interne ed esterne del sistema e
dell’interfaccia utente. La progettazione delle interfacce è basata
sulle informazioni ricavate durante la fase di analisi e realizzata
tramite mockups.

### Design procedurale

Descrive i concetti dettagliati dell’architettura/sviluppo utilizzando
ad esempio:

-   Diagrammi di flusso e Nassi.

-   Tabelle.

-   Classi e metodi.

-   Tabelle di routing

-   Diritti di accesso a condivisioni …

Questi documenti permetteranno di rappresentare i dettagli procedurali
per la realizzazione del prodotto.

## Implementazione

In questo capitolo dovrà essere mostrato come è stato realizzato il
lavoro. Questa parte può differenziarsi dalla progettazione in quanto il
risultato ottenuto non per forza può essere come era stato progettato.

Sulla base di queste informazioni il lavoro svolto dovrà essere
riproducibile.

In questa parte è richiesto l’inserimento di codice sorgente/print
screen di maschere solamente per quei passaggi particolarmente
significativi e/o critici.

Inoltre dovranno essere descritte eventuali varianti di soluzione o
scelte di prodotti con motivazione delle scelte.

Non deve apparire nessuna forma di guida d’uso di librerie o di
componenti utilizzati. Eventualmente questa va allegata.

Per eventuali dettagli si possono inserire riferimenti ai diari.

## Test

### Protocollo di test

Definire in modo accurato tutti i test che devono essere realizzati per
garantire l’adempimento delle richieste formulate nei requisiti. I test
fungono da garanzia di qualità del prodotto. Ogni test deve essere
ripetibile alle stesse condizioni.


|Test Case      | TC-001                               |
|---------------|--------------------------------------|
|**Nome**       |Import a card, but not shown with the GUI |
|**Riferimento**|REQ-012                               |
|**Descrizione**|Import a card with KIC, KID and KIK keys with no obfuscation, but not shown with the GUI |
|**Prerequisiti**|Store on local PC: Profile\_1.2.001.xml (appendix n\_n) and Cards\_1.2.001.txt (appendix n\_n) |
|**Procedura**     | - Go to “Cards manager” menu, in main page click “Import Profiles” link, Select the “1.2.001.xml” file, Import the Profile - Go to “Cards manager” menu, in main page click “Import Cards” link, Select the “1.2.001.txt” file, Delete the cards, Select the “1.2.001.txt” file, Import the cards |
|**Risultati attesi** |Keys visible in the DB (OtaCardKey) but not visible in the GUI (Card details) |


### Risultati test

Tabella riassuntiva in cui si inseriscono i test riusciti e non del
prodotto finale. Se un test non riesce e viene corretto l’errore, questo
dovrà risultare nel documento finale come riuscito (la procedura della
correzione apparirà nel diario), altrimenti dovrà essere descritto
l’errore con eventuali ipotesi di correzione.

### Mancanze/limitazioni conosciute

Descrizione con motivazione di eventuali elementi mancanti o non
completamente implementati, al di fuori dei test case. Non devono essere
riportati gli errori e i problemi riscontrati e poi risolti durante il
progetto.

## Consuntivo

Consuntivo del tempo di lavoro effettivo e considerazioni riguardo le
differenze rispetto alla pianificazione (cap 1.7) (ad esempio Gannt
consuntivo).

## Conclusioni

Quali sono le implicazioni della mia soluzione? Che impatto avrà?
Cambierà il mondo? È un successo importante? È solo un’aggiunta
marginale o è semplicemente servita per scoprire che questo percorso è
stato una perdita di tempo? I risultati ottenuti sono generali,
facilmente generalizzabili o sono specifici di un caso particolare? ecc

### Sviluppi futuri
  Migliorie o estensioni che possono essere sviluppate sul prodotto.

### Considerazioni personali
  Questo progetto è stato utile per imparare l'utilizzo dei pannel e a conoscere meglio java dato che abbiamo dovuto utilizzare molte clssi che non conoscevamo e quindi c'é anche stata da parte mia una ricerca per informarsi su che tipo di classi implementare e gestire classi.


### Sitografia

-   https://stackoverflow.com/, *Stackoverflow*, 11-10-2019.

## Allegati

Elenco degli allegati, esempio:

-   Diari di lavoro

-   Mandato e/o Qdc