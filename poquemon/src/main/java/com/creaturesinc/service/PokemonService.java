package com.creaturesinc.service;

import java.util.List;

import com.creatures.xml.pokemon.Pokemon;
import com.creatures.xml.pokemon.Ability;
import com.creatures.xml.pokemon.Item;
import com.creatures.xml.pokemon.Move;;

public interface PokemonService {

	public List<Item> getItems(String name);
	
	public List<Ability> getAbilities(String name);
	
	public List<Move> getMoves(String name);
	
	public Pokemon getDetails(String name);
	
}
