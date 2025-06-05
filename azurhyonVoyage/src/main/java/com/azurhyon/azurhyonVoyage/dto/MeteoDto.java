package com.azurhyon.azurhyonVoyage.dto;

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
		HIVER;
		
		@Override
		public String toString() {
			switch (this) {
	        	case PRINTEMPS:
	        		return "Printemps";
	        	case ETE:
	        		return "Eté";
	        	case AUTOMNE:
	        		return "Automne";
	        	case HIVER:
	        		return "Hiver";
	        	default:
	        		return null;
			}
		}
	}
	
	private Climats clim = Climats.TEMPERE;
	private Saisons sais = Saisons.PRINTEMPS;
	private int hier = 8;
//	0: tps de saison, 1: assez beau, 2: beau, 3: très beau, 4:tps de saison, 5:très mauvais, 6:mauvais, 7:assez mauvais
	private int aujd = 10;
	
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
	public String tpsToString(int jour) {
//		0: tps de saison, 1: assez beau, 2: beau, 3: très beau, 4:tps de saison, 5:très mauvais, 6:mauvais, 7:assez mauvais
		String res = switch(jour) {
			case 0 -> tempsDeSaison();
			case 1 -> "Assez beau temps";
			case 2 -> "Beau temps";
			case 3 -> "Très beau temps";
			case 4 -> tempsDeSaison();
			case 5 -> "Très mauvais temps";
			case 6 -> "Mauvais temps";
			case 7 -> "Assez mauvais temps";
			case 8 -> "Aléatoire";
			default -> "";
		};
		return res;
	}
	private String tempsDeSaison() {
		return switch(this.sais) {
		case PRINTEMPS -> "Assez beau temps";
		case ETE -> "Beau temps";
		case AUTOMNE -> "Assez mauvais temps";
		case HIVER -> "Mauvais temps";
		};
	}
	
	public int tempsDeSaisonToInt(int jour) {
		if(jour == 0 || jour == 4 || jour > 7) {
			return switch(this.sais) {
				case PRINTEMPS -> 1;
				case ETE -> 2;
				case AUTOMNE -> 7;
				case HIVER -> 6;
				default -> jour;
			};
		} else {
			return jour;
		}
	}

}
