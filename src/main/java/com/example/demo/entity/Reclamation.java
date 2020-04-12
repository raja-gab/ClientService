package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamation {
	private String idRec;
	private String reclamation ; 
	private LocalDate dateRec;
	
	
	private Commande commande ;
}
