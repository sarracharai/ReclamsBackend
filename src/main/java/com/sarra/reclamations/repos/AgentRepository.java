package com.sarra.reclamations.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarra.reclamations.entities.Agent;

@Repository
public interface AgentRepository extends JpaRepository <Agent , String>{

	 Agent findByMatriculeAgent(String matriculeAgent);


}
