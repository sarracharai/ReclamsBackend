package com.sarra.reclamations.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarra.reclamations.entities.Agent;
import com.sarra.reclamations.repos.AgentRepository;

@RestController
@RequestMapping("/agent")
@CrossOrigin("*")
public class AgentRESTController {
	
	@Autowired
	AgentRepository agentRepository ;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Agent> getAllAgents()
	{
	return agentRepository.findAll();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginAgent(@RequestBody Agent agentData) {
	    Agent agent = agentRepository.findByMatriculeAgent(agentData.getMatriculeAgent());
	    if (agent != null && agent.getPassword().equals(agentData.getPassword())) {
	        return ResponseEntity.ok(agent);
	    }
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Agent> registerAgent(@RequestBody Agent agent) {
		System.out.println("Controller Colled");
		return ResponseEntity.ok(agentRepository.save(agent));
		
	}
}
