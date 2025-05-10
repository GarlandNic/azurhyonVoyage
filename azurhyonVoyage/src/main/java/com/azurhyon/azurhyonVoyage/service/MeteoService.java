package com.azurhyon.azurhyonVoyage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azurhyon.azurhyonVoyage.model.MeteoData;
import com.azurhyon.azurhyonVoyage.repository.MeteoRepository;

@Service
public class MeteoService {
	
	@Autowired
	MeteoRepository meteoRepo;
	
	MeteoData nouvelleMeteo(MeteoDto meteo) {
		
		return new MeteoData();
	}

}
