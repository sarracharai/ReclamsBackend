package com.sarra.reclamations.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Agent {
	
	@Id
	private String matriculeAgent ; 
	private Integer numTel;
	private String nomAgent;
	private String cin;
	private String prenomAgent;
	private String adresseAgent;
	private String emailAgent;
	private Date dateNaissance;
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "agent")
	private List<Reclamation> reclamations;
	
	
	
	
	

}
