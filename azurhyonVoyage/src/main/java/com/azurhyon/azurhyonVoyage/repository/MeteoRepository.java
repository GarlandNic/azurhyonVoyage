package com.azurhyon.azurhyonVoyage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.azurhyon.azurhyonVoyage.model.MeteoData;

@Repository
public interface MeteoRepository extends CrudRepository<MeteoData, Integer> {
	
}