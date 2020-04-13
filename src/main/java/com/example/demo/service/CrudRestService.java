package com.example.demo.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Article;
import com.example.demo.entity.Avis;
import com.example.demo.entity.Commande;
import com.example.demo.entity.Reclamation;

@FeignClient(name = "CrudApplication")
public interface CrudRestService {
	
	@GetMapping("/getproduct/{id}")
	public Optional<Article> getArticleById();
	
	@PostMapping("/avis")
	public Optional<Avis> postAvis( @RequestBody Avis avis);
	
	@PostMapping("/reclamation")
	public Optional<Avis> postReclamation( @RequestBody Reclamation reclamation);
	@PostMapping("/commande")
	public Commande postCommande (@RequestBody Commande commande);
	
	

}
