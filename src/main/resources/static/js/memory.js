document.addEventListener('DOMContentLoaded', () => {
  const bandiere = window.bandiere.slice(0, 8); // 8 coppie
  const carte = [];

  // Duplica e assegna alpha2Code esplicitamente
  bandiere.forEach(p => {
    carte.push({ id: p.alpha2Code, alpha2Code: p.alpha2Code });
    carte.push({ id: p.alpha2Code, alpha2Code: p.alpha2Code });
  });

  // Mescola le carte
  carte.sort(() => Math.random() - 0.5);

  const grid = document.getElementById('memory-grid');
  let flipped = [];
  let lock = false;

  carte.forEach((carta, idx) => {
    const col = document.createElement('div');
    col.className = 'col';

    const card = document.createElement('div');
    card.className = 'card shadow-sm';
    card.dataset.id = carta.id;
    card.style.cursor = 'pointer';

    const front = document.createElement('div');
    front.className = 'card-body d-flex align-items-center justify-content-center bg-light text-muted';
    front.style.height = '120px';
    front.textContent = '?';

    const back = document.createElement('img');
    const flagUrl = `/flags/${carta.alpha2Code.toLowerCase()}.png`;
    back.src = flagUrl;
    back.className = 'img-fluid d-none';
    back.style.maxHeight = '120px';

    console.log(`Carta #${idx + 1}:`, carta);
    console.log(`→ Bandiera caricata: ${flagUrl}`);

    card.appendChild(front);
    card.appendChild(back);
    col.appendChild(card);
    grid.appendChild(col);

    card.addEventListener('click', () => {
      if (lock || card.classList.contains('matched') || card.classList.contains('flipped')) return;

      card.classList.add('flipped');
      front.classList.add('d-none');
      back.classList.remove('d-none');

      flipped.push(card);

      if (flipped.length === 2) {
        lock = true;
        const [a, b] = flipped;

        if (a.dataset.id === b.dataset.id) {
          a.classList.add('matched');
          b.classList.add('matched');
          flipped = [];
          lock = false;

          if (document.querySelectorAll('.card.matched').length === carte.length) {
            document.getElementById('vittoria').classList.remove('d-none');
          }

        } else {
          setTimeout(() => {
            flipped.forEach(card => {
              card.classList.remove('flipped');
              card.querySelector('div').classList.remove('d-none');
              card.querySelector('img').classList.add('d-none');
            });
            flipped = [];
            lock = false;
          }, 1000);
        }
      }
    });
  });
});