package com.creaturesinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creaturesinc.entity.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, String>{

	
	
}
