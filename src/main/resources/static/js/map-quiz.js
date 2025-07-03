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
    const elementi = document.querySelectorAll("svg [id]");
    elementi.forEach(el => {
      el.classList.add("land");
      el.style.cursor = "pointer";

      el.addEventListener("click", () => {
        const codice = el.id.toUpperCase();
        if (!paeseTarget) return;

        if (codice === paeseTarget.alpha2Code.toUpperCase()) {
          esitoBox.innerHTML = `Corretto! Hai trovato <strong>${paeseTarget.name}</strong>.`;
          setTimeout(() => {
            nuovaDomanda();
            esitoBox.innerHTML = "";
          }, 1500);
        } else {
          esitoBox.innerHTML = `Sbagliato HHAHAHAH! Hai cliccato <strong>${codice}</strong>, ma cercavamo <strong>${paeseTarget.name}</strong>.`;
        }
      });
    });

    nuovaDomanda();
  }

  function nuovaDomanda() {
    paeseTarget = paesi[Math.floor(Math.random() * paesi.length)];
    domandaBox.textContent = `Dove si trova ${paeseTarget.name}?`;
  }
});