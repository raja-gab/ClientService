package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avis {
	private String idAvis ;
	private String avis ; 
	private LocalDate dateAvis ; 
	
	
	
	private Client client;
	
}
