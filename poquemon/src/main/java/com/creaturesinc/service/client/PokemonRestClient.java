package com.creaturesinc.service.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonRestClient {

	   @Autowired
	   RestTemplate restTemplate;
	   
	 public String getPokemonInfo(String pokemon) {
		 String result = "";
		 ResponseEntity<String>resultEnt = null;
		 
         HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
         HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 
		 
		 try {
			 resultEnt = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/"+pokemon, HttpMethod.GET,entity,String.class);
		 }catch(Exception ex) {
			 ex.printStackTrace();
			 
		 }
		 return resultEnt.getBody().toString();
	 }  
	
}
