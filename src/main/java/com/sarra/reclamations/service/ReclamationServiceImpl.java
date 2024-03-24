package com.sarra.reclamations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarra.reclamations.entities.Agent;
import com.sarra.reclamations.entities.Reclamation;
import com.sarra.reclamations.repos.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {
	
	@Autowired
	ReclamationRepository reclamationRepository;

	@Override
	public Reclamation saveReclamation(Reclamation r) {
		return reclamationRepository.save(r);
	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		return reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamation(Reclamation r) {
		reclamationRepository.delete(r);
		
	}

	@Override
	public void deleteById(Long id) {
		reclamationRepository.deleteById(id);
		
	}

	@Override
	public Reclamation getReclamation(Long id) {
		return reclamationRepository.findById(id).get();
	}

	@Override
	public List<Reclamation> getAllReclamations() {
		return reclamationRepository.findAll();
	}

	@Override
	public List<Reclamation> findByAgent(Agent agent) {
		return reclamationRepository.findByAgent(agent);
	}

	//@Override
	//public List<Reclamation> findByAnnee(String annee) {
		//return reclamationRepository.findByAnnee(annee);
	//}

	@Override
	public List<Reclamation> findByAgentMatriculeAgent(String matriculeAgent) {
		return reclamationRepository.findByAgentMatriculeAgent(matriculeAgent);
	}

	//@Override
	//public List<Reclamation> findByOrderByAnneeAsc() {
		//return reclamationRepository.findByOrderByAnneeAsc();
	//}

	@Override
	public List<Reclamation> findByobjetRecalamation(String objetRecalamation) {
	    return reclamationRepository.findByobjetRecalamation(objetRecalamation);
	}

	
	@Override
	public Reclamation getLatestReclamation() {
	    List<Reclamation> reclamations = reclamationRepository.findAll();
	    if (!reclamations.isEmpty()) {
	        return reclamations.get(reclamations.size() - 1);
	    } else {
	        return null; // Ou lancez une exception appropriée si aucune réclamation n'est disponible.
	    }
	}

	public List<Reclamation> getReclamationsArchivees() {
	    return reclamationRepository.findByArchivedTrue();
	  }
	
}
