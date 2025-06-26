const paesi = window.paesi || [];

window.addEventListener("load", () => {
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
      const el = document.getElementById(paese.alpha2code);
      if (!el) {
        console.warn("Elemento non trovato per:", paese.alpha2code);
        return;
      }

      rendiInterattivo(el, paese, tooltip);
    });
  }

  function rendiInterattivo(el, paese, tooltip) {
    const targets = el.tagName === "g" ? el.querySelectorAll("path") : [el];

    targets.forEach(p => {
      p.classList.add("land");
      p.style.cursor = "pointer";

      p.addEventListener('mouseover', e => {
        tooltip.innerHTML = `
          <img src="${paese.flag}" alt="Bandiera">
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

      p.addEventListener('click', () => {
        window.location.href = '/dettaglio/' + paese.alpha2code;
      });
    });
  }
});