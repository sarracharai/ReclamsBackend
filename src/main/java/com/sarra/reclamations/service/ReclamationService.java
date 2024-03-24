package com.sarra.reclamations.service;

import java.util.List;

import com.sarra.reclamations.entities.Agent;
import com.sarra.reclamations.entities.Reclamation;

public interface ReclamationService {
	
	Reclamation saveReclamation(Reclamation r);
	Reclamation updateReclamation(Reclamation r);
	Reclamation getLatestReclamation();
	
	void deleteReclamation(Reclamation r);
	void deleteById(Long id);
	Reclamation getReclamation(Long id);
	List<Reclamation> getAllReclamations();
	List<Reclamation> findByAgent (Agent agent);
	//List<Reclamation> findByAnnee(String annee);
	List<Reclamation> findByobjetRecalamation(String objetRecalamation);
	List<Reclamation> findByAgentMatriculeAgent(String matriculeAgent);
	//List<Reclamation> findByOrderByAnneeAsc();
	List<Reclamation> getReclamationsArchivees();
	
}
