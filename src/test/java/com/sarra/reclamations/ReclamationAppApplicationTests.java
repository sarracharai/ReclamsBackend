package com.sarra.reclamations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sarra.reclamations.entities.Agent;
import com.sarra.reclamations.entities.Reclamation;
import com.sarra.reclamations.repos.ReclamationRepository;

@SpringBootTest
class ReclamationAppApplicationTests {
	
	@Autowired
	private ReclamationRepository reclamationRepository;
	
	@Test
	public void testCreateReclamation() {
		Reclamation reclam = new Reclamation(123L,"tunisietelecom",new Date(), "2016", 3L, "maladie" );
		reclamationRepository.save(reclam);
	}
	
	@Test
	public void testFindReclamation()
	 { 
		Reclamation r = reclamationRepository.findById(123L).get();
		System.out.println(r);
	}
	
	@Test
	public void testUpdateReclamation()
	{
		Reclamation r = reclamationRepository.findById(123L).get();
		r.setNbSemaine(4L);
		reclamationRepository.save(r);
	}
	
	@Test
	public void testDeleteReclamation() {
		reclamationRepository.deleteById(123L);
	}
	
	
	@Test
	public void testListerTousReclamations(){
		List<Reclamation> reclams = reclamationRepository.findAll();
			for (Reclamation r : reclams)
		{
			System.out.println(r);
		}
	}
	
	@Test
	public void testFindByAnnee()
	{
	List<Reclamation> reclams = reclamationRepository.findByAnnee("2016");
	for (Reclamation r : reclams)
		{
	System.out.println(r);
		}
	}
	
	@Test
	public void testfindByAgent()
	{
	Agent ag = new Agent();
	ag.setMatriculeAgent("11FF");
	List<Reclamation> reclams = reclamationRepository.findByAgent(ag);
	for (Reclamation r : reclams)
	{
	System.out.println(r);
	}
	}
	
	@Test
	public void findByAgentMatriculeAgent()
	{
	List<Reclamation> reclams = reclamationRepository.findByAgentMatriculeAgent("11FF");
	for (Reclamation r : reclams)
	{
	System.out.println(r);
	}
	}
	
	@Test
	public void testfindByOrderByAnneeAsc()
	{
	List<Reclamation> reclams = reclamationRepository.findByOrderByAnneeAsc();
	for (Reclamation r : reclams)
	{
	System.out.println(r);
	}
	}
	
	
	
	@Test
	void contextLoads() {
	}
	
	

}
