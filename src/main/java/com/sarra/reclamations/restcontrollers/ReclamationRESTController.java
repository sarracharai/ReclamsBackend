package com.sarra.reclamations.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarra.reclamations.entities.Reclamation;
import com.sarra.reclamations.service.ReclamationService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
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
	
	//@RequestMapping(value="/reclamsByAnnee/{annee}",method = RequestMethod.GET)
	//public List<Reclamation> findByAnnee(@PathVariable("annee") String annee) {
	//return reclamationService.findByAnnee(annee);
	//}
	
	@GetMapping("/latest")
    public ResponseEntity<Reclamation> getLatestReclamation() {
        Reclamation latestReclamation = reclamationService.getLatestReclamation();
        if (latestReclamation != null) {
            return new ResponseEntity<>(latestReclamation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@RequestMapping(value="/reclamsByobjet/{objetRecalamation}", method = RequestMethod.GET)
	public List<Reclamation> findByobjetRecalamation(@PathVariable("objetRecalamation") String objetRecalamation) {
	    return reclamationService.findByobjetRecalamation(objetRecalamation);
	}

	 @GetMapping("/archivees")
	  public List<Reclamation> getReclamationsArchivees() {
	    return reclamationService.getReclamationsArchivees();
	  }
	
	 
	 @PutMapping("/archive/{reference}")
	    public ResponseEntity<?> archiveReclamation(@PathVariable Long reference) {
	        try {
	            // Chercher la réclamation par référence
	            Reclamation reclamation = reclamationService.getReclamation(reference);

	           
	            if (reclamation == null) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Réclamation non trouvée");
	            }

	            // Ajouter votre logique d'archivage ici
	            
	            return ResponseEntity.ok().build();
	        } catch (Exception e) {
	            // En cas d'échec, renvoyer une réponse d'erreur
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'archivage de la réclamation");
	        }
	    
	}
	
	
}
