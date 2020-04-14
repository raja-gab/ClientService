package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection ="Utilisateur" )
public abstract class Utilisateur {
	@Id
	private String login; 
	private String password ; 
	private String nom;
	private String prenom;
	private String role; 

}
