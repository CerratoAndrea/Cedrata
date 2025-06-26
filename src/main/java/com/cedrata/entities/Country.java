package com.cedrata.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "countries")
public class Country {
	
	@Id
	private String alpha2code;
	private String capital;
	private String name;
	private String region;
	private String subregion;
    private String population;
    
    @Lob
    private String languages;
	
	@Transient //proprietà non del db
	private String flag;
	
	
	public String getAlpha2code() {
		return alpha2code;
	}
	public void setAlpha2code(String alpha2Code) {
		this.alpha2code = alpha2Code;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public String getFlag() {
		
		return "./flags/" + this.alpha2code.toLowerCase() + ".png";
		
	}
	public String getSubregion() {
		return subregion;
	}
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public List<String> getLanguageNames() {
	    try {
	        //creo un oggetto ObjectMapper di Jackson per leggere il JSON
	        ObjectMapper mapper = new ObjectMapper();

	        //converto la stringa JSON in una lista di mappe
	        List<Map<String, Object>> listaLingue = mapper.readValue(
	            this.languages,
	            new TypeReference<List<Map<String, Object>>>() {} // Specifica il tipo atteso
	        );

	        //estraggo solo il valore associato alla chiave "name" da ogni mappa
	        List<String> nomiLingue = new ArrayList<>();
	        for (Map<String, Object> lingua : listaLingue) {
	            if (lingua.containsKey("name")) {
	                nomiLingue.add((String) lingua.get("name"));
	            }
	        }

	        return nomiLingue;

	    } catch (Exception e) {
	        // In caso di errore nel parsing JSON, ritorna un messaggio generico
	        return List.of("Lingue non disponibili");
	    }
	}
	
}
