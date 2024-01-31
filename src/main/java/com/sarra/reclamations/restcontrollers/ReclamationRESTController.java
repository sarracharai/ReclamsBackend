package com.sarra.reclamations.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarra.reclamations.entities.Reclamation;
import com.sarra.reclamations.service.ReclamationService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ReclamationRESTController {
	@Autowired
	ReclamationService reclamationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Reclamation> getAllReclamations() {
		return reclamationService.getAllReclamations();
	
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Reclamation getReclamationById(@PathVariable("id") Long id) {
		return reclamationService.getReclamation(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Reclamation createReclamation(@RequestBody Reclamation reclamation) {
	return reclamationService.saveReclamation(reclamation);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
	return reclamationService.updateReclamation(reclamation);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteReclamation(@PathVariable("id") Long id)
	{
		reclamationService.deleteById(id);
	}

	@RequestMapping(value="/reclamsag/{matriculeAgent}",method = RequestMethod.GET)
	public List<Reclamation> getReclamationByMatriculeAgent(@PathVariable("matriculeAgent") String MatriculeAgent) {
	return reclamationService.findByAgentMatriculeAgent(MatriculeAgent);
	}
	
	@RequestMapping(value="/reclamsByAnnee/{annee}",method = RequestMethod.GET)
	public List<Reclamation> findByAnnee(@PathVariable("annee") String annee) {
	return reclamationService.findByAnnee(annee);
	}
	
	@RequestMapping(value="/reclamsByobjet/{objetRecalamation}", method = RequestMethod.GET)
	public List<Reclamation> findByobjetRecalamation(@PathVariable("objetRecalamation") String objetRecalamation) {
	    return reclamationService.findByobjetRecalamation(objetRecalamation);
	}

	
	
	
	
}
