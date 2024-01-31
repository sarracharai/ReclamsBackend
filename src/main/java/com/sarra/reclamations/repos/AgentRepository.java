package com.sarra.reclamations.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarra.reclamations.entities.Agent;

public interface AgentRepository extends JpaRepository <Agent , String>{

}
