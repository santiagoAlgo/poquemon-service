package com.creaturesinc.model;

import java.util.List;

public class PokemonDetails {

	List<AbilityDeails> abilities;
	List<ItemDetails> held_items;
	List<MoveDetails> moves;
	public List<AbilityDeails> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<AbilityDeails> abilities) {
		this.abilities = abilities;
	}
	public List<ItemDetails> getHeld_items() {
		return held_items;
	}
	public void setHeld_items(List<ItemDetails> held_items) {
		this.held_items = held_items;
	}
	public List<MoveDetails> getMoves() {
		return moves;
	}
	public void setMoves(List<MoveDetails> moves) {
		this.moves = moves;
	}
	
	
	
	
}
