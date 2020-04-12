package com.example.demo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.entity.Avis;

import com.example.demo.entity.Reclamation;
import com.example.demo.service.CrudRestClient;

@RestController
public class ClientController {

	@Autowired
	private CrudRestClient crudRest;
	
	// Gestion Avis 
	
	@PostMapping("/avis")
	public Avis avis( @RequestBody Avis avis) {
		Avis avs = new Avis();
		avs.setAvis(avis.getAvis());
		avs.setDateAvis(java.time.LocalDate.now());
		avs.setClient(avis.getClient());
		crudRest.postAvis(avs);
		return avs ;
	}

	@PutMapping("/avis/{id}")
	public Avis modifyAvis(@RequestBody Avis avis ,@PathVariable("id") String id) {
		Optional<Avis> a = crudRest.findAvisById(id);
		Avis as = new Avis();
		as.setDateAvis(avis.getDateAvis());
		as.setAvis(avis.getAvis());
		as.setDateAvis(avis.getDateAvis());
		as.setClient(avis.getClient());
		crudRest.modifyAvis(as, id);
		
	return as ;	
	}
	
	@DeleteMapping("/avis/{id}")
	public void deleteById(@PathVariable("id") String id){
		crudRest.deleteById(id);
	}
	
	// Gestion Reclamation
	
	
	@PostMapping("/reclamation")
	public Reclamation reclamation(@RequestBody Reclamation reclamation) {
		Reclamation rec = new Reclamation();
		rec.setDateRec(java.time.LocalDate.now());
		rec.setReclamation(reclamation.getReclamation());
		rec.setCommande(reclamation.getCommande());
		
		crudRest.postReclamation(rec);
		return rec ;
	}
	
	@PutMapping("/reclamation/{id}")
	public Reclamation modifyReclamation(@RequestBody Reclamation reclamation ,@PathVariable("id") String id) {
		Reclamation rec = new Reclamation();
		rec.setDateRec(java.time.LocalDate.now());
		rec.setReclamation(reclamation.getReclamation());
		rec.setCommande(reclamation.getCommande());
		crudRest.modifyReclamation(reclamation, id);
		return rec ;
	}
	@DeleteMapping("/reclamation/{id}")
	public void deleteReclamationById(@PathVariable("id") String id){
		crudRest.deleteReclamationById(id);
	}
	
	
	
	
	
	
	
	@GetMapping("/article")
	public Resources<Article> getAllArticle(){
		return crudRest.findAllArticle();
	}
}
