package com.azurhyon.azurhyonVoyage.dto;

import java.util.Random;

public class MeteoDto {

	public static enum Climats {
		POLAIRE,
		SUBARCTIQUE,
		CONTINENTAL,
		TEMPERE,
		MEDITERRANEEN,
		SAVANE,
		EQUATORIAL,
		MOUSSON,
		ARIDE,
		HAUTEMONTAGNE;
		
		@Override
		public String toString() {
			switch (this) {
				case POLAIRE:
					return "polaire";
				case SUBARCTIQUE:
					return "subarctique";
				case CONTINENTAL:
					return "continental";
				case TEMPERE:
					return "tempéré";
				case MEDITERRANEEN:
					return "méditerranéen";
				case SAVANE:
					return "de savane";
				case EQUATORIAL:
					return "équatorial";
				case MOUSSON:
					return "de mousson";
				case ARIDE:
					return "aride";
				case HAUTEMONTAGNE:
					return "de haute montagne";
	        	default:
	        		return null;
			}
		}
	}

	public static enum Saisons {
		PRINTEMPS,
		ETE,
		AUTOMNE,
		HIVERS;
		
		@Override
		public String toString() {
			switch (this) {
	        	case PRINTEMPS:
	        		return "Printemps";
	        	case ETE:
	        		return "Eté";
	        	case AUTOMNE:
	        		return "Automne";
	        	case HIVERS:
	        		return "Hivers";
	        	default:
	        		return null;
			}
		}
	}
	
	private Climats clim = Climats.TEMPERE;
	private Saisons sais = Saisons.PRINTEMPS;
	private int hier = 8;
//	0: tps de saison, 1: assez beau, 2: beau, 3: très beau, 4:tps de saison, 5:très mauvais, 6:mauvais, 7:assez mauvais
	private int aujd = 8;
	
	public Climats getClim() {
		return clim;
	}
	public void setClim(Climats clim) {
		this.clim = clim;
	}
	public Saisons getSais() {
		return sais;
	}
	public void setSais(Saisons sais) {
		this.sais = sais;
	}
	public int getHier() {
		return hier;
	}
	public void setHier(int hier) {
		this.hier = hier;
	}
	public int getAujd() {
		return aujd;
	}
	public void setAujd(int aujd) {
		this.aujd = aujd;
	}

}
