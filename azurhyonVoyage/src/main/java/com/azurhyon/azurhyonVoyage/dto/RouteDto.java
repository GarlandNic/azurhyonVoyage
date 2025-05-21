package com.azurhyon.azurhyonVoyage.dto;

public class RouteDto {
	
	public static enum RouteTypes {
		GRANDEVOIE,
		ROUTE,
		CHEMIN,
		SENTIER,
		HORSPISTE,
		HARD,
		HEAVYHARD;
		
		@Override
		public String toString() {
			return switch (this) {
				case GRANDEVOIE -> "Grande voie";
				case ROUTE -> "Route";
				case CHEMIN -> "Chemin";
				case SENTIER -> "Sentier";
				case HORSPISTE -> "Hors-piste";
				case HARD -> "Hard";
				case HEAVYHARD -> "Heavy Hard";
	        	default -> null;
			};
		}
	}
	
	private RouteTypes type = RouteTypes.GRANDEVOIE;

	public RouteTypes getType() {
		return type;
	}
	public void setType(RouteTypes type) {
		this.type = type;
	}
	
	public int getDiff() {
		return switch (this.type) {
			case GRANDEVOIE -> 3;
			case ROUTE -> 6;
			case CHEMIN -> 9;
			case SENTIER -> 12;
			case HORSPISTE -> 15;
			case HARD -> 18;
			case HEAVYHARD -> 21;
			default -> 3;
		};
	}


}
