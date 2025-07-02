package com.its.quiz.dto;

import java.util.List;

public class Quiz {
    private String domanda;
    private List<String> opzioni;
    private String rispostaCorretta;
    private String rispostaUtente;
    private String difficolta;
    private String tipo;
    private Integer numeroDomanda;

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public List<String> getOpzioni() {
        return opzioni;
    }

    public void setOpzioni(List<String> opzioni) {
        this.opzioni = opzioni;
    }

    public String getRispostaCorretta() {
        return rispostaCorretta;
    }

    public void setRispostaCorretta(String rispostaCorretta) {
        this.rispostaCorretta = rispostaCorretta;
    }

    public String getRispostaUtente() {
        return rispostaUtente;
    }

    public void setRispostaUtente(String rispostaUtente) {
        this.rispostaUtente = rispostaUtente;
    }
    
    public String getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(String difficolta) {
        this.difficolta = difficolta;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

	public Integer getNumeroDomanda() {
		return numeroDomanda;
	}

	public void setNumeroDomanda(Integer numeroDomanda) {
		this.numeroDomanda = numeroDomanda;
	}
    
    

}
