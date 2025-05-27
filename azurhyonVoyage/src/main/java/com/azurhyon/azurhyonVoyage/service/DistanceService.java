package com.azurhyon.azurhyonVoyage.service;

import org.springframework.stereotype.Service;

import com.azurhyon.azurhyonVoyage.dto.VoyageDto;

@Service
public class DistanceService {

	public int computeDist(VoyageDto voy) {
		double res = 0;
		res = (voy.getVitesse() + modifMeteo(voy));
		res = res * voy.getTempsMarche();
		res = res /3;
//		(score Déplacement + modif Météo)/2 * (2/3 * tempsMarche)
		return (int) Math.round(res);
	}

	private int modifMeteo(VoyageDto voy) {
		int auj = voy.getMeteo().getAujd();
		auj = voy.getMeteo().tempsDeSaisonToInt(auj);
		return switch(auj) {
			case 1 -> 0;
			case 2 -> 0;
			case 3 -> 1;
			case 5 -> -4;
			case 6 -> -2;
			case 7 -> -1;
			default -> 0;
		};
	}
	
	

}
