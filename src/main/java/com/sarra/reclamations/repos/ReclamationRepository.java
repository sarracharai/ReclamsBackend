package com.sarra.reclamations.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sarra.reclamations.entities.Agent;
import com.sarra.reclamations.entities.Reclamation;

@RepositoryRestResource(path = "rest")
public interface ReclamationRepository extends JpaRepository <Reclamation , Long>{

	List<Reclamation> findByAnnee(String annee);
	List<Reclamation> findByobjetRecalamation(String objetRecalamation);
	
	@Query("select r from Reclamation r where r.agent = ?1") 
	List<Reclamation> findByAgent (Agent agent);
	List<Reclamation> findByAgentMatriculeAgent(String matriculeAgent);
	List<Reclamation> findByOrderByAnneeAsc();

	

}
