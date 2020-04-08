package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Avis;
import com.example.demo.entity.Reclamation;
import com.example.demo.service.CrudRestService;

@RestController
public class ClientController {

	@Autowired
	private CrudRestService crudRest;
	
	
	@PostMapping("/avis")
	public Avis avis( @RequestBody Avis avis) {
		Avis avs = new Avis();
		avs.setAvis(avis.getAvis());
		avs.setDateAvis(java.time.LocalDate.now());
		avs.setClient(avis.getClient());
		
		crudRest.postAvis(avs);
		return avs ;

	}
	
	@PostMapping("/reclamation")
	public Reclamation reclamation(@RequestBody Reclamation reclamation) {
		Reclamation rec = new Reclamation();
		rec.setDateRec(java.time.LocalDate.now());
		rec.setReclamation(reclamation.getReclamation());
		rec.setCommande(reclamation.getCommande());
		
		crudRest.postReclamation(rec);
		return rec ;
	}
	
}
