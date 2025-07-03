# Quiz Paesi, by CEDRATA SRL (Andrea Cerrato e Robert Smau)

**Quiz Paesi** è un'applicazione web che include quiz dinamici, una mappa interattiva, modalità allenamento, un gioco memory con bandiere e classifiche personalizzate.

## Tecnologie utilizzate

| Componente       | Tecnologia               |
|------------------|---------------------------|
| **Backend**      | Java + Spring Boot        |
| **Sicurezza**    | Spring Security           |
| **Database**     | H2 Database (in file)     |
| **Template HTML**| Thymeleaf                 |
| **Frontend**     | HTML + CSS + JavaScript   |
| **UI Framework** | Bootstrap 5               |

## Funzionalità principali

### Modalità Quiz
- 10 domande generate casualmente
- 3 livelli di difficoltà: `facile` (15s), `normale` (10s), `difficile` (5s)
- Domande su:
  - Capitali dei paesi
  - Lingue ufficiali
  - Popolazione
- Timer per ogni domanda
- Risultato finale salvato se l’utente è autenticato

| Difficoltà | Tempo per domanda | Tipi di domanda                      | Numero opzioni |
|------------|-------------------|--------------------------------------|----------------|
| **Facile** | ⏱️ 15 secondi      | Solo domande su **capitali**  e **bandiere**        | 3              |
| **Normale**| ⏱️ 10 secondi      | Domande miste: **capitale**, **lingua** e **bandiere** | 4              |
| **Difficile** | ⏱️ 5 secondi     | Tutto incluso la **popolazione** | 5              |



### Modalità Allenamento
- Domande casuali illimitate
- Nessun timer
- Nessun salvataggio punteggio
- Utile per esercitarsi liberamente

### Mappa Interattiva
- Mappa SVG del mondo interattiva
- Hover su un paese mostra bandiera e capitale
- Clic su un paese apre la sua scheda
- Piccolo minigioco dove devi indovinare sul mappamondo dov'è il paese!

### Gioco Memory
- Memory con 8 coppie di bandiere
- Interfaccia dinamica realizzata con JavaScript puro
- Messaggio di vittoria al completamento

### Classifiche
- Classifica globale per ogni difficoltà (`facile`, `normale`, `difficile`)
- Visualizzazione dei propri punteggi
- Percentuale di risposte corrette
- Classifica per singola sessione di gioco

### Gestione Utenti
- Registrazione e login con Spring Security
- Password cifrate con BCrypt
- Visualizzazione username loggato
- Salvataggio punteggi legati all’account

### DB
- H2 preinstallato ma facilmente adattabile con altri DB!