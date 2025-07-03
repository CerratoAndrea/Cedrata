// prendo i dati dei paesi dal backend
const paesi = window.paesi || [];
// aspetto che tutta la pagina sia caricata
window.addEventListener("load", () => {
   // carico la mappa svg dal server
  fetch('/svg/world.svg')
    .then(res => res.text())
    .then(svgText => {
      document.getElementById('svg-container').innerHTML = svgText;
      setupInterattivita();
    })
    .catch(err => {
      console.error("Errore nel caricamento della mappa SVG:", err);
    });

  function setupInterattivita() {
    const tooltip = document.getElementById('tooltip');

    paesi.forEach(paese => {
      const code = paese.alpha2Code;
      const el = document.getElementById(code);
      if (!el) {
        console.warn("Elemento non trovato per:", code);
        return;
      }

      rendiInterattivo(el, paese, tooltip);
    });
  }
  // funzione che aggiunge gli eventi mouseover, mousemove, click ecc.
  function rendiInterattivo(el, paese, tooltip) {
		const targets = el.tagName === "g" ? el.querySelectorAll("path, circle, rect") : [el];

    targets.forEach(p => {
      p.classList.add("land");
      p.style.cursor = "pointer";

      // quando passo sopra, mostro tooltip con bandiera e info
      p.addEventListener('mouseover', e => {
        tooltip.innerHTML = `
          <img src="/flags/${paese.alpha2Code.toLowerCase()}.png" width="60" alt="Bandiera ${paese.name}"><br>
          <strong>${paese.name}</strong><br>
          Capitale: ${paese.capital}
        `;
        tooltip.style.top = (e.pageY + 15) + "px";
        tooltip.style.left = (e.pageX + 15) + "px";
        tooltip.style.display = "block";
      });

      p.addEventListener('mousemove', e => {
        tooltip.style.top = (e.pageY + 15) + "px";
        tooltip.style.left = (e.pageX + 15) + "px";
      });

      p.addEventListener('mouseout', () => {
        tooltip.style.display = "none";
      });
      // cliccando su un paese vado alla pagina con i dettagli
      p.addEventListener('click', () => {
        window.location.href = '/country?code=' + paese.alpha2Code;
      });
    });
  }
});