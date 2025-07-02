package com.its.quiz.entities;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String domanda;
    private String rispostaUtente;
    private String rispostaCorretta;
    private boolean corretto;
    private String difficolta;
    private LocalDateTime data;
    private Long sessione;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Score() {
        this.data = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public String getRispostaUtente() {
		return rispostaUtente;
	}

	public void setRispostaUtente(String rispostaUtente) {
		this.rispostaUtente = rispostaUtente;
	}

	public String getRispostaCorretta() {
		return rispostaCorretta;
	}

	public void setRispostaCorretta(String rispostaCorretta) {
		this.rispostaCorretta = rispostaCorretta;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

	public String getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(String difficolta) {
		this.difficolta = difficolta;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getSessione() {
		return sessione;
	}

	public void setSessione(Long sessione) {
		this.sessione = sessione;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}

