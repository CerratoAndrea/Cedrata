// prendo il riferimento al timer e al form del quiz
const display = document.getElementById("countdown");
const quizForm = document.querySelector("form[method='post']");

// se entrambi esistono nella pagina
if (display && quizForm) {
    const difficolta = document.querySelector("input[name='difficolta']").value;
    let countdown = 10;

    
    // prendo il valore della difficoltà selezionata
    switch (difficolta) {
        case "facile":
            countdown = 15;
            break;
        case "difficile":
            countdown = 5;
            break;
        default:
            countdown = 10;
    }

    display.textContent = countdown;

    const timer = setInterval(() => {
        countdown--;
        display.textContent = countdown;

        if (countdown <= 0) {
            clearInterval(timer);

            // mostra messaggio "Tempo scaduto"
            const messaggio = document.createElement("p");
            messaggio.id = "timeout";
            messaggio.textContent = "Tempo scaduto! Clicca Verifica per vedere la risposta.";
            messaggio.style.color = "crimson";
            messaggio.style.fontWeight = "bold";
            // lo inserisco sotto il form
            quizForm.parentElement.insertBefore(messaggio, quizForm.nextSibling);
        }
    }, 1000);
}
