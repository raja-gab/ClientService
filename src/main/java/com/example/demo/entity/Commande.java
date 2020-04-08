package com.example.demo.entity;


import java.time.LocalDate;

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
	

	
	
}
