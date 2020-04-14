package com.example.demo.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Article;
import com.example.demo.entity.Avis;
import com.example.demo.entity.Client;
import com.example.demo.entity.Commande;
import com.example.demo.entity.Reclamation;


import org.springframework.hateoas.Resources;




@FeignClient(name = "CrudApplication" )
public interface CrudRestClient {
	
	@GetMapping("/getproduct/{id}")
	public Optional<Article> getArticleById();
	
	
	@PostMapping("/reclamation")
	public Optional<Avis> postReclamation( @RequestBody Reclamation reclamation);
	
	
	@GetMapping("/article")
	public Resources<Article> findAllArticle();
	
	@PostMapping("/article")
	public Optional<Article>  postArticle (@RequestBody Article article);

	@GetMapping("/avis/{id}")
	public Optional<Avis> findAvisById(@PathVariable("id") String id );
	
	
	@PostMapping("/avis")
	public Optional<Avis> postAvis( @RequestBody Avis avis);
	
	@PutMapping("/avis/{id}")
	public Avis modifyAvis(@RequestBody Avis avis ,@PathVariable("id") String id);
	
	@DeleteMapping("/avis/{id}")
	public void deleteById(@PathVariable("id") String id);
	
	@PutMapping("/reclamation/{id}")
	public Avis modifyReclamation(@RequestBody Reclamation reclamation ,@PathVariable("id") String id);
	
	@DeleteMapping("/reclamation/{id}")
	public void deleteReclamationById(@PathVariable("id") String id);
	@PostMapping("/commande")
	public Commande postCommande (@RequestBody Commande commande);
	
	@PutMapping("/client/{id}")
	public Optional<Client> updatClient(@RequestBody Client client,@PathVariable String id);
	
	@PostMapping("/client")
	public Client addClient (@RequestBody Client client);	
	
	
	
	
	
	
	
	
	
	
	/*@PostMapping("/avis")
	public Avis avis( @RequestBody Avis avis);
	
	@PostMapping("/reclamation/{id}")
	public Reclamation reclamation(@RequestBody Reclamation relamaction , @PathVariable("id") String idCmd);
	*/
}
