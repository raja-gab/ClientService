
package com.example.demo.entity;


import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
	private String idCmd; 
	private LocalDate dateCmd; 
	private double totalCmd; 
	private String modePaiement;
	private List<LigneCommande> ligneCmd ; 
	
	private Client clientCmd;
	
	private LigneLivraison ligneLivraisonCmd;

	

	
	
}
