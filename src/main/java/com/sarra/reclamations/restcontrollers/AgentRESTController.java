package com.sarra.reclamations.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarra.reclamations.entities.Agent;
import com.sarra.reclamations.repos.AgentRepository;

@RestController
@RequestMapping("/api/ag")
@CrossOrigin("*")
public class AgentRESTController {
	
	@Autowired
	AgentRepository agentRepository ;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Agent> getAllAgents()
	{
	return agentRepository.findAll();
	}

}
