package com.azurhyon.azurhyonVoyage.service;

import java.util.Random;

import com.azurhyon.azurhyonVoyage.dto.LogementDto;
import com.azurhyon.azurhyonVoyage.dto.RouteDto.RouteTypes;

public class LogementService {

	public String confortDescr(LogementDto logement) {
		int conf = logement.getConfort();
		return switch(conf) {
			case -1 -> "Ignoble (nuit blanche) : " + confortIgnoble(logement.getTirageConfort());
			case 0 -> "Ignoble (nuit blanche) : " + confortIgnoble(logement.getTirageConfort());
			case 1 -> "Nul (1/4 de nuit) : " + confortNul(logement.getTirageConfort());
			case 2 -> "Mauvais (1/2 nuit) : " + confortMauvais(logement.getTirageConfort());
			case 3 -> "Médiocre (3/4 de nuit) : " + confortMédiocre(logement.getTirageConfort());
			case 4 -> "Moyen";
			case 5 -> "Assez bon";
			case 6 -> "Bon";
			case 7 -> "Très bon";
			case 8 -> "Excellent";
			case 9 -> "Sublime";
			case 10 -> "Magnifique";
			case 11 -> "Chef d'oeuvre";
			default -> "Belle étoile";
		};
	}

	private String confortMédiocre(int tirageConfort) {
		return switch(tirageConfort % 17 +1) {
			case 1 -> "Lit étroit ou oreiller inconfortable (courbatures)";
			case 2 -> "Moustiques ou puces gênants";
			case 3 -> "Environnement bruyant mais supportable (auberge populaire)";
			case 4 -> "Chambre au-dessus d’une taverne ou rue passante";
			case 5 -> "Odeurs fortes (fumier, cuisine, renfermé, moisissure, latrines proches)";
			case 6 -> "Lit peu propre, les draps sont sales ou tâchés";
			case 7 -> "Hôte bavard ou curieux interrompant le coucher";
			case 8 -> "Le propriétaire impose une prière ou un chant collectif (gêne, temps perdu)";
			case 9 -> "Chambre au-dessus de l’écurie (bruit et odeur)";
			case 10 -> "Aucune intimité, dortoir bondé";
			case 11 -> "Ballonné, reflux gastrique";
			case 12 -> "Client agressif ou alcoolisé dans l’auberge";
			case 13 -> "Réveillé à l’aube par le coq";
			case 14 -> "Dispute juste devant la chambre";
			case 15 -> "L’aubergiste a loué la chambre deux fois (doit partager ou changer en pleine nuit)";
			case 16 -> "Cauchemars ";
			case 17 -> "Une alarme magique se déclenche par erreur";
			default -> "";
		};
	}

	private String confortMauvais(int tirageConfort) {
		return switch(tirageConfort % 20 +1) {
			case 1 -> "Chambre froide ";
			case 2 -> "Vent sifflant dans une bâtisse en ruine";
			case 3 -> "Gîte spartiate ou sol de grange";
			case 4 -> "Lit trop court, grinçant, cassé ou qui tangue";
			case 5 -> "Ronflements puissants dans la pièce";
			case 6 -> "Conditions de voyage (chariot, bateau, train sans couchette)";
			case 7 -> "Mal positionné : près de l'entrée, des cuisines ou des animaux";
			case 8 -> "Proximité d’un couple très actif ou d’un bébé qui pleure";
			case 9 -> "Maux de ventre pendant la nuit";
			case 10 -> "Moustiques nombreux";
			case 11 -> "Lit plein de paille qui gratte";
			case 12 -> "Pièce enfumée";
			case 13 -> "Le bâtiment craque et grince de partout";
			case 14 -> "Vol ou tentative de vol durant la nuit";
			case 15 -> "Réveillé par une bagarre ou une descente de garde";
			case 16 -> "Une souris, un chat ou un rat se balade sur vous";
			case 17 -> "Des fêtards ou une taverne en dessous empêchent le sommeil";
			case 18 -> "Mendiant ou voyageur clandestin dans la pièce (sentiment d’insécurité)";
			case 19 -> "Un rêve perturbant ou magique vous réveille en sueur";
			case 20 -> "Un visiteur nocturne (inconnu, serviteur, voleur)";
			default -> "";
		};
	}

	private String confortNul(int tirageConfort) {
		return switch(tirageConfort % 12 +1) {
			case 1 -> "Matelas très dur ou cassé";
			case 2 -> "Orage violent et fuites au plafond";
			case 3 -> "Lit partagé avec un inconnu peu hygiénique";
			case 4 -> "Rats ou insectes dérangeants (cafards, punaises)";
			case 5 -> "Intoxication alimentaire ou maux d'estomac";
			case 6 -> "Hôtes bruyants ou réveils fréquents";
			case 7 -> "Environnement inquiétant : grotte occupée, auberge mal famée";
			case 8 -> "Lits mouillés (accident, fuite, humidité)";
			case 9 -> "Malade durant la nuit";
			case 10 -> "Un ivrogne cogne plusieurs fois à la porte durant la nuit";
			case 11 -> "Hanté par des cauchemars horrifiques";
			case 12 -> "Un feu s’est déclaré à proximité";
			default -> "";
		};
	}

	private String confortIgnoble(int tirageConfort) {
		return switch(tirageConfort % 8 +1) {
			case 1 -> "Matelas infesté de punaises ou de puces";
			case 2 -> "Fête toute la nuit dans l’auberge";
			case 3 -> "Couché à même la terre humide";
			case 4 -> "Chambre voisine en travaux ou cris constants";
			case 5 -> "Maladies ou douleurs empêchant le sommeil";
			case 6 -> "Première nuit de prison, cellule froide et humide";
			case 7 -> "Chiens qui hurlent sans interruption toute la nuit";
			case 8 -> "Chambre hantée (ou que vous croyez hantée)";
			default -> "";
		};
	}

	public LogementDto lancerLogement(int renseignement, RouteTypes type) {
		int modif = switch(type) {
			case GRANDEVOIE -> 3;
			case ROUTE -> 0;
			case CHEMIN -> -3;
			case SENTIER -> -6;
			default -> -100;
		};
		int score = renseignement + modif;
		int qualiteGlobale = score/3 +1;
		if(score < 0) qualiteGlobale = -10;
		if(qualiteGlobale > 11) qualiteGlobale = 11;
		
		Random random = new Random();
		LogementDto loge = new LogementDto();
		loge.setVariationQualite(random.nextInt(7)+1);
		loge.setConfort(qualiteGlobale);
		loge.setPrix(qualiteGlobale);
		loge.setSecurite(qualiteGlobale);
		loge.setTirageConfort(random.nextInt(10000));
		
		switch(loge.getVariationQualite()) {
		case 1 : 
			loge.setConfort(qualiteGlobale -2);
			loge.setPrix(0);
			loge.setSecurite(qualiteGlobale -2);
			break;
		case 2 : 
			loge.setConfort(qualiteGlobale -1);
			loge.setPrix(qualiteGlobale -2);
			loge.setSecurite(qualiteGlobale -1);
			break;
		case 3 : 
			break;
		case 4 : 
			loge.setConfort(qualiteGlobale -1);
			loge.setPrix(qualiteGlobale +1);
			loge.setSecurite(qualiteGlobale -1);
			break;
		case 5 : 
			loge.setConfort(qualiteGlobale +1);
			loge.setPrix(qualiteGlobale -1);
			loge.setSecurite(qualiteGlobale +1);
			break;
		case 6 : 
			loge.setConfort(qualiteGlobale +1);
			loge.setPrix(qualiteGlobale +2);
			loge.setSecurite(qualiteGlobale +1);
			break;
		case 7 : 
			loge.setConfort(qualiteGlobale +2);
			loge.setPrix(qualiteGlobale +4);
			loge.setSecurite(qualiteGlobale +2);
			break;
		default : break;
		}
		
		return loge;
	}

}
