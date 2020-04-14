package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Utilisateur {
	
	
	private String cinCli; 
	private String adresseCli;
	private String numTelCli;
	
}
