package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
	
	private String username; 
	private String password ; 
	private String nom;
	private String prenom;
	

}
