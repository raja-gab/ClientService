package com.example.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Article {
  
	private String idArt;
	private String designtationArt;
	
	private Avis avisArt ; 

	
	
}
