package com.creaturesinc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="pokemon_ability")
public class Ability {
	
	public Ability(com.creatures.xml.pokemon.Ability responseAbility) {
		this.name = responseAbility.getName();
		this.url = responseAbility.getUrl();
	}
	
	public Ability() {}

	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="url")
	private String url;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pokemon_id")
	private Pokemon pokemon;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	
}
