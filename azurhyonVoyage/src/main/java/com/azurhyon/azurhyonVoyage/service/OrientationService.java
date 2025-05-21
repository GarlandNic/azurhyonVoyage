package com.azurhyon.azurhyonVoyage.service;

import org.springframework.stereotype.Service;

import com.azurhyon.azurhyonVoyage.dto.VoyageDto;

@Service
public class OrientationService {

	public VoyageDto update(VoyageDto voyage) {
		int m = voyage.getOrientation() - voyage.getRoute().getDiff();
		String result = "";
		if(m <= -10) {
			result = "Complètement perdu, s’éloigne de sa destination. -5 pour insister.";
		} else if(m <= -6) {
			result = "Perdu, tourne en rond. -3 pour insister.";
		} else if(m <= -3) {
			result = "Égaré, ne fait que le tiers de la distance prévue. -2 pour insister.";
		} else if(m <= -1) {
			result = "Fourvoyé, fait les 2/3 de la distance prévue -1 pour insister.";
		} else if(m <= 1) {
			result = "Trouve son chemin difficilement";
		} else if(m <= 3) {
			result = "Trouve son chemin";
		} else if(m <= 6) {
			result = "Trouve son chemin facilement";
		} else if(m <= 9) {
			result = "Trouve son chemin très facilement.";
		} else if(m <= 12) {
			result = "Trouve un très bon chemin.";
		} else if(m <= 15) {
			result = "Trouve le meilleur chemin.";
		} else {
			result = "Trouve un raccourci, gagne du temps.";
		}
		voyage.setSuccesOrientation(result);
		return voyage;
	}
	
	

}
