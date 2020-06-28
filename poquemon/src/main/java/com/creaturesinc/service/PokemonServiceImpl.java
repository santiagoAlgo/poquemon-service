package com.creaturesinc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creatures.xml.pokemon.Pokemon;
import com.creaturesinc.model.PokemonDetails;
import com.creaturesinc.repository.PokemonRepository;
import com.creaturesinc.service.client.PokemonRestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.creatures.xml.pokemon.Ability;
import com.creatures.xml.pokemon.Item;
import com.creatures.xml.pokemon.Move;

@Service
public class PokemonServiceImpl implements PokemonService{

	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	PokemonRestClient pokemonRestClient;
	
	@Autowired
	PokemonRepository repo;
	
	@Override
	public List<Item> getItems(String name) {
		List<Item> condencedItems = new ArrayList<Item>(); 

		String itemsJson = pokemonRestClient.getPokemonInfo(name);
		List<Map<String, Object>> condencedMap = getCondencedMap(itemsJson, "held_items");
		for(Map<String, Object> tempMap: condencedMap) {
			Map<String, String> itemCoreMap =  (Map<String, String>) tempMap.get("item");
			Item item = new Item();
			item.setName(itemCoreMap.get("name"));
			item.setUrl(itemCoreMap.get("url"));

			condencedItems.add(item);
		}
		
		return condencedItems;
	}

	@Override
	public List<Ability> getAbilities(String name) {
		
		List<Ability> condencedItems = new ArrayList<Ability>(); 

		String itemsJson = pokemonRestClient.getPokemonInfo(name);
		List<Map<String, Object>> condencedMap = getCondencedMap(itemsJson, "abilities");
		for(Map<String, Object> tempMap: condencedMap) {
			Map<String, String> itemCoreMap =  (Map<String, String>) tempMap.get("ability");
			Ability item = new Ability();
			item.setName(itemCoreMap.get("name"));
			item.setUrl(itemCoreMap.get("url"));
			condencedItems.add(item);
		}
		
		return condencedItems;
	}
	
	@Override
	public List<Move> getMoves(String name) {
		
		List<Move> condencedItems = new ArrayList<Move>(); 

		String itemsJson = pokemonRestClient.getPokemonInfo(name);
		List<Map<String, Object>> condencedMap = getCondencedMap(itemsJson, "moves");
		for(Map<String, Object> tempMap: condencedMap) {
			Map<String, String> itemCoreMap =  (Map<String, String>) tempMap.get("move");
			Move item = new Move();
			item.setName(itemCoreMap.get("name"));
			item.setUrl(itemCoreMap.get("url"));
			condencedItems.add(item);
		}
		
		return condencedItems;

	}

	@Override
	public Pokemon getDetails(String name) {
		
		Pokemon pokemon = new Pokemon(); 

		String itemsJson = pokemonRestClient.getPokemonInfo(name);
		
		Map<String, Object> map = null; 
		try {
			map = mapper.readValue(itemsJson, Map.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pokemonName = (String) map.get("name");
		Integer pokemonWeight = (Integer) map.get("weight");
		pokemon.setName(pokemonName);

		pokemon.setWeight(pokemonWeight);
		return pokemon;

	}	
	
	
		private List<Map<String, Object>> getCondencedMap(String itemsJson, String parameter){
			Map<String, Object> map = null; 
			List<Map<String, Object>> itemsString = null;
			Map<String, String> itemCoreMap = null;
			try {
				map = mapper.readValue(itemsJson, Map.class);
				itemsString = (List<Map<String, Object>>) map.get(parameter);
				/*for(Map<String, Object> tempMap: itemsString) {
					itemCoreMap =  (Map<String, String>) tempMap.get("item");

				}*/
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
			catch (Exception e) {

				e.printStackTrace();
			}
			return itemsString;
		}


		
		
		private void updatePokemon() {
			
		}
}
