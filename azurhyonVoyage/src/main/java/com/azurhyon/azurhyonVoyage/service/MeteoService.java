package com.azurhyon.azurhyonVoyage.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azurhyon.azurhyonVoyage.dto.MeteoDto;
import com.azurhyon.azurhyonVoyage.model.MeteoData;
import com.azurhyon.azurhyonVoyage.repository.MeteoRepository;

@Service
public class MeteoService {
	
	@Autowired
	MeteoRepository meteoRepo;
	
//	MeteoData nouvelleMeteo(MeteoDto meteo) {
//		MeteoData meteoFinale = new MeteoData();
//		return meteoFinale;
//	}
	
	MeteoDto update(MeteoDto meteo) {
		int hier = meteo.getHier() ;
		if(hier < 0 || hier > 7) {
			hier = tpsAlea();
			meteo.setHier(hier);
		}
		int aujd = meteo.getAujd();
		if(aujd < 0 || aujd > 7) {
			aujd = variationDHier(hier);
		}

		return meteo;
	}

	private int variationDHier(int hier) {
		Random random = new Random();
		int d20 = random.nextInt(0, 20) +1;
		int variation = switch(d20) {
			case 1 -> -4;
			case 2 -> -3;
			case 3 -> -3;
			case 4 -> -2;
			case 5 -> -2;
			case 6 -> -1;
			case 7 -> -1;
			case 8 -> -1;
			case 9 -> 0;
			case 10 -> 0;
			case 11 -> 0;
			case 12 -> 0;
			case 13 -> 1;
			case 14 -> 1;
			case 15 -> 1;
			case 16 -> 2;
			case 17 -> 2;
			case 18 -> 3;
			case 19 -> 3;
			case 20 -> 4;
			default -> 0;
		};
		return (hier + variation + 8) % 8;
	}

	private int tpsAlea() {
		Random random = new Random();
        int tps = random.nextInt(8);
		return tps;
	}

}
