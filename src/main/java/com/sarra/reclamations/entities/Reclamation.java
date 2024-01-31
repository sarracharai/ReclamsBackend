package com.sarra.reclamations.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reclamation {
	
	@Id
	private Long reference;
	private String societe;
	private Date dateReclamation;
	private String annee;
	private Long nbSemaine;
	private String objetRecalamation;
	
	@ManyToOne
	private Agent agent;
	
	public Reclamation() {}
	
	
	public Reclamation(Long reference, String societe, Date dateReclamation, String annee, Long nbSemaine,
			String objetRecalamation) {
		super();
		this.reference = reference;
		this.societe = societe;
		this.dateReclamation = dateReclamation;
		this.annee = annee;
		this.nbSemaine = nbSemaine;
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
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public Long getNbSemaine() {
		return nbSemaine;
	}
	public void setNbSemaine(Long nbSemaine) {
		this.nbSemaine = nbSemaine;
	}
	public String getObjetRecalamation() {
		return objetRecalamation;
	}
	public void setObjetRecalamation(String objetRecalamation) {
		this.objetRecalamation = objetRecalamation;
		
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
				+ ", annee=" + annee + ", nbSemaine=" + nbSemaine + ", objetRecalamation=" + objetRecalamation + "]";
	}
	
	
	
	
	
	 
	
	 
	 
	 
	 
	

}
