package com.creaturesinc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="pokemon")
public class Pokemon {

	
	@Id
	@Column(name="pokemon_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long banxicoCodeId;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "pokemon")
	private List<Ability> abilities= new ArrayList<Ability>(); 
	

	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
