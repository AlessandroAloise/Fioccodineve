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

Il progetto è gestito e realizzato dall'alievo Alessandro Aloise (studente di informatica all’Arti e Mestieri di Trevano) sotto la supervisione del professor Luca Muggiasca e  Geo Petrini. Il progetto é realizzare un applicazione java che permette di generale manualmente un fiocco di neve . La realizzazione del progetto inizia il 03 settembre 2019 (03/09/19) e dovrà essere consegnato entro il 20 dicembre 2019 (20/12/19).



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
| REQ_006 | Programma | Tasto per la cancellazione dei punti messi  |2 |1.0 |
| REQ_007 | Programma | Bottone genera il fiocco di neve  |2 |1.0 |
| REQ_008 | Esportazione |L'applicazione deve permettere di esportare il fiocco in formato  PNG |2 |1.0 |
| REQ_009 | Esportazione |Dimensioni che può avere PNG 500 o 1000 o quella attuale |2 |1.0 |
| REQ_010 | Esportazione |L'applicazione deve permettere di esportare il fiocco in formato  SVG |2 |1.0 |
| REQ_011 | Esportazione |Creazione "snapshot" del fiocco per poterlo modificare |2 |1.0 |
| REQ_012 | Programma | Menù del programma con fiocchi default  |1 |1.0 |
| REQ_013 | Sito web + | imagini dei fiocchi di neve recenti  |3 |1.0 |
| REQ_014 | Sito web | Fornire .class in github ma per gli utenti fornire il jar  |2 |1.0 |


I + sono cose previste come extra.



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

Il software sarà sviluppato in maniera che il triangolo da tagliare sarà sempre al centro. oltre ciò saranno disponibili i seguenti bottoni:<br>

| Nome | Componente | utilizzo|
|---|-----|---|
|Render|Bottone| permette di renderezare il fiocco di neve |
|Reset|Bottone| Eliminazione di tutti i punti inseriti e resseta anche la visuale |
|SVG |Bottone|ci permette di cresre un file con estenzione svg del fiocco di neve|
|Salva punti|Bottone | ci permete di salvare i punti del poligno crato dai tagli dell'utente.
|Save PNG|Bottone|Salvataggio del fiocco generato come immagine  PNG (in dimensioni aatuali, 500px x 500px o 100px x 1000px)

### Design dell’architettura del sistema

- diagamramma uml da mettere

### Design dei dati e database

Per poter facilitare il più possibile la realizzazione del programma è stata sviluppata una classe chiamata DrawPanel che permette di gestire in modo autonomo tutte le azzion che vengono svolte sul triangolo.



### Design delle interfacce

[Start page](../Img/startframe.png)<br>
[Cat page](../Img/taglio.PNG)<br>

Le interfaccie WEB sono state praticamente tutte modificate alla fine del progetto, per i seguenti motivi:<br>
- <b>Start page</b>: all'interno della start page possiamno trovare due tasti uno che ci permette di caricare un modello di punti già esistente e un tasto per creare un fiocco di neve nuovo sull'lato destro invece possiamo trovare 3 fiocchi che sono stati messi come modello di default ci bastera cliccare sopra uno di questi per accedere alla sua conformazione e modificarla.

- <b>Cat page</b>: la pagina di creaazione del fiocco di neve e anche dove troviamo la barra per le farie funzioni salvatagglio render esportazione dei punti.lo schermo é diviso a metà sull'lato sinistro abbiamo il triangolo dove possiamo effeturare i tagli e nella parte destra invee troviamo il fiocco di neve renderizazo solo dopo però aver premputo il tasto render


### Design

[Diagramma uml](../Img/diagramma.png)<br>

## Implementazione

 - <b>StartFrame: </b>Questa classe è stata sviluppata per fare in modo che si possono caricare file solo con estenzione (Snowflake) oppure avviare una nuova sessione di creazione di fiocchi di neve o in alternativa si può usufruire dei fiocchi di default che si trovano sulla destra della pagina.

- <b>FioccoDiNeve: </b> Questa classe é un frame che contiene il pannello descritto sotto in più al suo interno ha anche una barra che ci peremtte di fare varie funzioni come salvare in png, salvare in svg, salvare i punti e anche resettare tutto quello che stiamo facendo con la presenza anche di un pop up.

- <b>DrawPanel: </b> Per quanto riguarda questa classe si tratta di un panel dove viene svolto in 90% dell'lavoro a qui al suio interno si trova tutta la logica per la gestione del posizionamento del triango delle sue grandezze del rendere e di come genereare e salvare il fiocco di neve.

## Test

### Protocollo di test

Definire in modo accurato tutti i test che devono essere realizzati per
garantire l’adempimento delle richieste formulate nei requisiti. I test
fungono da garanzia di qualità del prodotto. Ogni test deve essere
ripetibile alle stesse condizioni.

|Test Case      | TC_001                               |
|---------------|--------------------------------------|
|**Nome**       |Creare un sito per scaricare l'applicativo |
|**Riferimento**|REQ-001                                 |
|**Descrizione**|avviare il sito web e provare a scaricare il file|
|**Prerequisiti**|avere il sito|
|**Procedura**     | avviare il sito e cliccare il tasto download |
|**Risultati attesi** |che il sito funzioni e che ci faccia scaricare il zip |
|**Risultati**|Il sito  rispetta le aspettative e quindi la sua grandezzua può andare sotto quella definita|


|Test Case      | TC_002                               |
|---------------|--------------------------------------|
|**Nome**       |Descrizione del progetto sul sito |
|**Riferimento**|REQ-002                                 |
|**Descrizione**|avviare il sito e leggere la descrione|
|**Prerequisiti**|avere il sito|
|**Procedura**     | avviare il sito. |
|**Risultati attesi** |trovare la descrione sul sito web  |
|**Risultati**|Il sito  rispetta le aspettative e quindi la sua grandezzua può andare sotto quella definita|

|Test Case      | TC_003                               |
|---------------|--------------------------------------|
|**Nome**       |Parametri minimi che il pc deve avere |
|**Riferimento**|REQ-003                                 |
|**Descrizione**|avviare il sito e leggere i requisiti|
|**Prerequisiti**|avere il sito|
|**Procedura**     | avviare il sito. |
|**Risultati attesi** |trovare i requisiti sul sito web  |
|**Risultati**|Il sito  rispetta le aspettative e quindi la sua grandezzua può andare sotto quella definita|
|**Come è stato risolto**| Risolvere |

|Test Case      | TC_004                               |
|---------------|--------------------------------------|
|**Nome**       |dimensione triangolo |
|**Riferimento**|REQ-004                                 |
|**Descrizione**|Provare a rimpicciolire la finestra |
|**Prerequisiti**|Impostare dimensione minima |
|**Procedura**     | Fare partire il programma e provare a  rimpicciolire. |
|**Risultati attesi** |Il programma dovrebbe rimanere con una dimensione minima di 1024x768 |
|**Risultati**|Il programma  non rispetta le aspettative e quindi la sua grandezzua può andare sotto quella definita|
|**Come è stato risolto**| Risolvere |


|Test Case      | TC_005                               |
|---------------|--------------------------------------|
|**Nome**       |I punti di taglio sono da inserire con click del mouse |
|**Riferimento**|REQ-005                                 |
|**Descrizione**|Provare a mettere dei punti di taglio |
|**Prerequisiti**|avere il triangolo su qui provare |
|**Procedura**     | Fare partire il programma e provare a  tagliare il trangolo. |
|**Risultati attesi** |dovrebber apparire dei puntini a schermo |
|**Risultati**|Il programma si comporta come ci si aspettava |
|**Come è stato risolto**| - |


|Test Case      | TC_006                             |
|---------------|--------------------------------------|
|**Nome**       |Tasto per la cancellazione dei punti messi |
|**Riferimento**|REQ-006                                 |
|**Descrizione**|Provare a mettere dei punti di taglio  e poi premere il tasto rest |
|**Prerequisiti**|avere il triangolo su qui provare  e riuscire a mettere i punti |
|**Procedura**     | Fare partire il programma e provare a  tagliare il trangolo e poi premere il tasto . |
|**Risultati attesi** |dovremmo vedere sparire i punti dallo schermo |
|**Risultati**|Il programma si comporta come ci si aspettava |
|**Come è stato risolto**| - |

|Test Case      | TC_007                            |
|---------------|--------------------------------------|
|**Nome**       |Bottone genera il fiocco di neve  |
|**Riferimento**|REQ-007                                |
|**Descrizione**|Provare a mettere dei punti di taglio e poi a cliccare il tasto render |
|**Prerequisiti**|avere il triangolo su qui provare  e riuscire a mettere i punti |
|**Procedura**     | Fare partire il programma e provare a  tagliare il trangolo e poi premere il tasto . |
|**Risultati attesi** |dovremmo vedere sull'lato destro il fiocco generato |
|**Risultati**|Il programma si comporta come ci si aspettava |
|**Come è stato risolto**| - |

|Test Case      | TC_008 / TC_009                          |
|---------------|--------------------------------------|
|**Nome**       |PNG  |
|**Riferimento**|REQ-008                               |
|**Descrizione**|il porogramma permette di esportare il fiocco in png in 3 grandezze diverse 500px x500px oppure 100px x 1000px o le dimensioni attuali del fiocco |
|**Prerequisiti**|riuscure a creare il fiocco  |
|**Procedura**     | Fare partire il programma e provare a  tagliare il trangolo e poi premere il tasto di rendere e dopo il tasto per salvare in png . |
|**Risultati attesi** |si crea un cartella fiocco di neve da dove é stato avviato il porogramma e al suo interno si salva l'imagine |
|**Risultati**|Il programma si comporta come ci si aspettava |
|**Come è stato risolto**| - |


|Test Case      | TC_010                       |
|---------------|--------------------------------------|
|**Nome**       |SVG |
|**Riferimento**|REQ-010                              |
|**Descrizione**|il porogramma permette di esportare il fiocco in SVG |
|**Prerequisiti**|riuscure a creare il fiocco  |
|**Procedura**     | Fare partire il programma e provare a  tagliare il trangolo e poi premere il tasto di rendere e dopo il tasto per salvare in svg . |
|**Risultati attesi** |si crea un cartella fiocco di neve da dove é stato avviato il porogramma e al suo interno si salva l'imagine |
|**Risultati**|Il programma si comporta come ci si aspettava |
|**Come è stato risolto**| - |


|Test Case      | TC_011                      |
|---------------|--------------------------------------|
|**Nome**       |salvataggio punti |
|**Riferimento**|REQ-011                              |
|**Descrizione**|il porogramma permette di esportare il salvataggio dei punti. |
|**Prerequisiti**|riuscure a creare il fiocco  |
|**Procedura**     | Fare partire il programma e provare a  tagliare il trangolo e poi premere il tasto di rendere e dopo il tasto per salvare i putni . |
|**Risultati attesi** |si crea un cartella fiocco di neve da dove é stato avviato il porogramma e al suo interno si salva il file con estenzione Snowflake. |
|**Risultati**|Il programma si comporta come ci si aspettava |
|**Come è stato risolto**| - |


|Test Case      | TC_012                      |
|---------------|--------------------------------------|
|**Nome**       |fiocchi di default |
|**Riferimento**|REQ-012                              |
|**Descrizione**|il programma deve avere dei fiocchi di neve di default. |
|**Prerequisiti**|avere il programma funzionante |
|**Procedura**     | Fare partire il programma e cliccare uno dei fiocchi sulla destra 1 volta e vedere cosa succede . |
|**Risultati attesi** |si apre la schermata dove vediamo il trangolo con i punti di taglio. |
|**Risultati**|Il programma si comporta come ci si aspettava |
|**Come è stato risolto**| - |


|Test Case      | TC_014                      |
|---------------|--------------------------------------|
|**Nome**       |jar e class  |
|**Riferimento**|REQ-014                              |
|**Descrizione**|su github ci deve eseere il programma e sul sito ci deve essere il jar. |
|**Prerequisiti**|avere il programma funzionante  e avere il sito|
|**Procedura**     | andare sul mio github e vedere se c'é tutto, andare sul sito e scaricare il file. |
|**Risultati attesi** |che su GitHub ci sia tutto e che il sito faccio scaricare. |
|**Risultati**|Il programma si comporta come ci si aspettava |
|**Come è stato risolto**| - |


### Risultati test

Tabella riassuntiva in cui si inseriscono i test riusciti e non del
prodotto finale. Se un test non riesce e viene corretto l’errore, questo
dovrà risultare nel documento finale come riuscito (la procedura della
correzione apparirà nel diario), altrimenti dovrà essere descritto
l’errore con eventuali ipotesi di correzione.

### Mancanze/limitazioni conosciute

Le uncihe mancanze del programma sono  l'aggiunta di più poligoni e la motivazione del percé non lo messo é:il programma non lo permette per come è stato pensato dall'inizio.
L'alra limitazione é che quando si salva in png le imagini sono sgrante perché per la generazione delle imagini prima lo disegno e poi lo ingrandisco cosi facendo perdo qualità e causa quelle inprecisione che si trovano nel disegno.

## Consuntivo

La pianificazione era sicuramente fatta in maniera  sbagliata, i tempi erano irrelaistici per le consocenze che avevo dato che quasi tutte le informazioni le abbiamo dovuto cercare. Oltre al tempo a disposizione ho dovuto sfruttare del tempon aggiuntivo, soprattutto a causa che alcune lezioni sono saltate per altri impegni scolastici.

## Conclusioni

Con questo progetto ho imparato pian piano a gestire un progetto al meglio dato che non avevo la minima idea da che parte iniziare.Penso che da questo progetto ne esco più colto e accultruato e sicuramentre sapro gestire meglio il prossimo progetto.

### Sviluppi futuri
In futuro si possono aggiugnere i requisiti non ancoa sviluppati esempio quello dei più poligoni. Magari si potrebbe anche ottimizare del codice anche se ho già cercato di fare del mio meglio

### Considerazioni personali
  Questo progetto è stato utile per imparare l'utilizzo dei pannel e a conoscere meglio java dato che abbiamo dovuto utilizzare molte clssi che non conoscevamo e quindi c'é anche stata da parte mia una ricerca per informarsi su che tipo di classi implementare e gestire classi.


### Sitografia

-   https://stackoverflow.com/, *Stackoverflow*, 11-10-2019.

## Allegati

Elenco degli allegati, esempio:

-   Diari di lavoro

-   Mandato e/o Qdc
