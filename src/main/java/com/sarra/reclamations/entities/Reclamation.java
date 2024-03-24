package com.sarra.reclamations.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reclamation {
	
	@Id
	private Long reference;
	private String societe;
	private Date dateReclamation;
	//private Long nbSemaine;
	private String objetRecalamation;
	private String description;
	private boolean archived;
	
	@ManyToOne
	private Agent agent;
	
	
	
	public Reclamation(Long reference, String societe, Date dateReclamation,String objetRecalamation,
			String description) {
		super();
		this.reference = reference;
		this.societe = societe;
		this.dateReclamation = dateReclamation;
		this.description = description;
		//this.nbSemaine = nbSemaine;
		this.objetRecalamation = objetRecalamation;
	}


	public Long getReference() {
		return reference;
	}


	public void setReference(Long reference) {
		this.reference = reference;
	}


	public String getSociete() {
		return societe;
	}


	public void setSociete(String societe) {
		this.societe = societe;
	}


	public Date getDateReclamation() {
		return dateReclamation;
	}


	public void setDateReclamation(Date dateReclamation) {
		this.dateReclamation = dateReclamation;
	}


	public String getObjetRecalamation() {
		return objetRecalamation;
	}


	public void setObjetRecalamation(String objetRecalamation) {
		this.objetRecalamation = objetRecalamation;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	@Override
	public String toString() {
		return "Reclamation [reference=" + reference + ", societe=" + societe + ", dateReclamation=" + dateReclamation
				+ ", objetRecalamation=" + objetRecalamation + ", description=" + description + ", agent=" + agent
				+ "]";
	}
	
	

	
	 
	
	 
	 
	 
	 
	

}
