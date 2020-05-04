package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
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
import com.example.demo.entity.Client;
import com.example.demo.entity.Article;
import com.example.demo.entity.Avis;
import com.example.demo.entity.Commande;
import com.example.demo.entity.Facture;
import com.example.demo.entity.Fournisseur;
import com.example.demo.entity.LigneCommande;
import com.example.demo.entity.Marque;
import com.example.demo.entity.Order;
import com.example.demo.entity.Reclamation;
import com.example.demo.entity.SousCategorie;
import com.example.demo.service.CrudRestClient;
import com.example.demo.service.PaymentRestClient;
import com.paypal.api.payments.Payment;

@RestController
public class ClientController {

	@Autowired
	private CrudRestClient crudRest;
	@Autowired
	private PaymentRestClient paymentRest;
	// Gestion Avis 
	
	@PostMapping("/avis")
	public Avis avis( @RequestBody Avis avis) {
		Avis avs = new Avis();
		avs.setIdAvis(avis.getIdAvis());
		avs.setAvis(avis.getAvis());
		avs.setDateAvis(java.time.LocalDate.now());
		avs.setClient(avis.getClient());
		crudRest.postAvis(avs);
		return avs ;
	}
	@GetMapping("/avis")
	public Resources<Avis> getAllAvis(){
		return crudRest.findAllAvis();
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
	@GetMapping("/reclamation")
	public Resources<Reclamation> getAllReclamation(){
		return crudRest.findAllReclamation();
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
	
	// Commande 
	@PostMapping("/commande")
	public Commande addCommande (@RequestBody Commande commande) {
		Commande cmd = new Commande();
		
		cmd.setIdCmd(commande.getIdCmd());
		cmd.setDateCmd(commande.getDateCmd());
		cmd.setTotalCmd(commande.getTotalCmd());
		cmd.setModePaiement(commande.getModePaiement());
		cmd.setLigneCmd(commande.getLigneCmd());
		cmd.setClientCmd(commande.getClientCmd());
		cmd.setLigneLivraisonCmd(commande.getLigneLivraisonCmd());
		
        List<LigneCommande> a = new ArrayList<>();
        a = cmd.getLigneCmd();
        for (LigneCommande e : a) {
		Article article = crudRest.findArticleById(e.getArticle().getIdArt());
		int ns =article.getQteStockArt()-e.getQteArtLC();
		Article art = new Article();
		art.setDesigntationArt(article.getDesigntationArt());
		art.setDescriptionArt(article.getDescriptionArt());
		art.setImageModel(article.getImageModel());
		art.setPrixArt(article.getPrixArt());
		art.setQteStockArt(ns);
		art.setTauxRemiseArt(article.getTauxRemiseArt());
	    Marque m = crudRest.findMarqueById(article.getMarqueArt().getIdMarq());
		art.setMarqueArt(m);
		SousCategorie sousCat = crudRest.findSousCategorieById(article.getSousCategorieArt().getIdSousCat());
		art.setSousCategorieArt(sousCat);
		Fournisseur f = crudRest.findFournisseurById(article.getFournisseurArt().getUsername());
		art.setFournisseurArt(f);
		crudRest.updatArticle(art,e.getArticle().getIdArt());
        }

		crudRest.postCommande(cmd);
		return cmd ;
	}
	

	
	/*Manager
	 *client
	 */
	
	//add Client just for test
	@PostMapping("/client")
	public Client addClient (@RequestBody Client client) {
		Client clt = new Client();
		clt.setNom(client.getNom());
		clt.setPrenom(client.getPrenom());
		clt.setCin(client.getCin());
		clt.setPhoneNumber(client.getPhoneNumber());
		clt.setUsername(client.getUsername());
		clt.setPassword(client.getPassword());
		crudRest.addClient(clt);
		return clt ;
	}
	
	
	//update Client
	@PutMapping("/client/{id}")
	public Client modifyFour(@RequestBody Client client , @PathVariable("id") String id) {
		
				Client clt = new Client();
				clt.setPhoneNumber(client.getPhoneNumber());
				clt.setCin(client.getCin());
				clt.setUsername(client.getUsername());

				clt.setPassword(client.getPassword());
				clt.setNom(client.getNom());
				clt.setPrenom(client.getPrenom());
				
					
		crudRest.updatClient(clt,id);
		return clt;	
	}
	
	@GetMapping("/client/{id}")
	public Optional<Client> getClientById(@PathVariable("id") String id ){
		return crudRest.findClientById(id);
	}
	
}
