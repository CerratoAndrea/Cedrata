document.addEventListener('DOMContentLoaded', () => {
  const paesi = window.paesi || [];
  let paeseTarget = null;
  const domandaBox = document.getElementById("domanda");
  const esitoBox = document.getElementById("esito");

  fetch('/svg/world.svg')
    .then(res => res.text())
    .then(svgText => {
      document.getElementById('svg-container').innerHTML = svgText;
      setupGioco();
    })
    .catch(err => {
      console.error("Errore nel caricamento della mappa SVG:", err);
    });

  function setupGioco() {
    // prendo tutti gli elementi dell'svg che hanno un id (i paesi)
    const elementi = document.querySelectorAll("svg [id]");
    elementi.forEach(el => {
      el.classList.add("land");
      el.style.cursor = "pointer";
      // quando clicco su un paese
      el.addEventListener("click", () => {
        const codice = el.id.toUpperCase();
        if (!paeseTarget) return;

        if (codice === paeseTarget.alpha2Code.toUpperCase()) {
          // se ho cliccato il paese giusto, mostro messaggio positivo
          esitoBox.innerHTML = `Corretto! Hai trovato <strong>${paeseTarget.name}</strong>.`;
          // dopo un po', riparto con una nuova domanda
          setTimeout(() => {
            nuovaDomanda();
            esitoBox.innerHTML = "";
          }, 1500);
        } else {
           // se sbaglio, mi ride addosso
          esitoBox.innerHTML = `Sbagliato HHAHAHAH! Hai cliccato <strong>${codice}</strong>, ma cercavamo <strong>${paeseTarget.name}</strong>.`;
        }
      });
    });

    nuovaDomanda();
  }
  // genera una nuova domanda casuale
  function nuovaDomanda() {
    paeseTarget = paesi[Math.floor(Math.random() * paesi.length)];
    domandaBox.textContent = `Dove si trova ${paeseTarget.name}?`;
  }
});