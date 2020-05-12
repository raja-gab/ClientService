package com.example.demo.entity;

import java.time.LocalDate;

import feign.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avis {
	
	private String id;        
	private String mat;
	private String avis ; 
	private LocalDate dateAvis ; 
	
	private Client client;
	
	public String getId( ) {
        return this.mat;
    }
	
}
