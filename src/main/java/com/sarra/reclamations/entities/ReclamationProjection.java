package com.sarra.reclamations.entities;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "anneeReclam", types = { Reclamation.class })
public interface ReclamationProjection {
	
	public String getAnnee();
	

}
