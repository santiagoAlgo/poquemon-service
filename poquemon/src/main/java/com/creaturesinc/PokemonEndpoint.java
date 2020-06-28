package com.creaturesinc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.creatures.xml.pokemon.Pokemon;
import com.creatures.xml.pokemon.PokemonDetailsRequest;
import com.creatures.xml.pokemon.PokemonDetailsResponse;
import com.creaturesinc.service.PokemonService;
import com.creatures.xml.pokemon.Ability;
import com.creatures.xml.pokemon.Item;
import com.creatures.xml.pokemon.Move;
import com.creatures.xml.pokemon.PokemonAbilities;
import com.creatures.xml.pokemon.PokemonAbilitiesRequest;
import com.creatures.xml.pokemon.PokemonAbilitiesResponse;
import com.creatures.xml.pokemon.PokemonBasedExp;

import com.creatures.xml.pokemon.PokemonItems;
import com.creatures.xml.pokemon.PokemonItemsRequest;
import com.creatures.xml.pokemon.PokemonItemsResponse;
import com.creatures.xml.pokemon.PokemonMoves;
import com.creatures.xml.pokemon.PokemonMovesRequest;
import com.creatures.xml.pokemon.PokemonMovesResponse;
//import com.howtodoinjava.xml.school.PokemonHabilitiesResponse;





@Endpoint
public class PokemonEndpoint {
	private static final String NAMESPACE_URI = "http://www.creatures.com/xml/pokemon";

	
	@Autowired
	private PokemonService pokemonService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PokemonDetailsRequest")
	@ResponsePayload
	public PokemonDetailsResponse getPokemon(@RequestPayload PokemonDetailsRequest request) {
		PokemonDetailsResponse response = new PokemonDetailsResponse();
		Pokemon resolvedElement = pokemonService.getDetails(request.getName());
		response.setPokemon(resolvedElement);
		
		return response;
	}
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PokemonItemsRequest")
	@ResponsePayload
	public  PokemonItemsResponse getItems(@RequestPayload PokemonItemsRequest request) {
		List<Item> resolvedElements = pokemonService.getItems(request.getName());
		PokemonItems pokemonItems = new PokemonItems();
		pokemonItems.getItems().addAll(resolvedElements);
		PokemonItemsResponse response= new PokemonItemsResponse();
		response.setPokemonItems(pokemonItems);

		return response;
	}	
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PokemonAbilitiesRequest")
	@ResponsePayload
	public  PokemonAbilitiesResponse getAbilities(@RequestPayload PokemonAbilitiesRequest request) {
		PokemonAbilities items = new PokemonAbilities();
		List<Ability> resolvedElements = pokemonService.getAbilities(request.getName());
		items.getAbilities().addAll(resolvedElements);
		
		PokemonAbilitiesResponse response= new PokemonAbilitiesResponse();
		response.setPokemonAbilities(items);

		return response;
	}
	

	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PokemonMovesRequest")
	@ResponsePayload
	public  PokemonMovesResponse getMoves(@RequestPayload PokemonMovesRequest request) {
		
		PokemonMoves items = new PokemonMoves();
		pokemonService.getMoves(request.getName());
		List<Move> resolvedElements = pokemonService.getMoves(request.getName());
		items.getMoves().addAll(resolvedElements);
		//items.getAbilities().addAll(resolvedElements);
		
		PokemonMovesResponse response= new PokemonMovesResponse();
		response.setPokemonMoves(items);


		return response;
	}
	
	
}