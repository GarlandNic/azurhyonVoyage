package com.azurhyon.azurhyonVoyage.service;

import java.util.Random;

import com.azurhyon.azurhyonVoyage.dto.EvenementDto;

public class EvenementService {

	public EvenementDto nouveauEvnmt() {
		Random random = new Random();
		EvenementDto evnmt = new EvenementDto(random.nextInt(200)+1, random.nextInt(100)+1);
		evnmt.setNom(nomDelEvnmt(evnmt));
		evnmt.setDescription(descriptionDelEvnmt(evnmt));
		return evnmt;
	}

	private String descriptionDelEvnmt(EvenementDto evnmt) {
		int de200 = evnmt.getDe200();
		if(de200 <= 0) {
			return "";
		} else if(de200 <= 50) {
			return descriptionTradition(de200);
		} else if(de200 <= 100) {
			return descriptionPittoresque(de200);
		} else {
			return (descriptionRencontre(de200-100) + " (" + personnalite(evnmt.getDe100()) + ")");
		}
	}

	private String personnalite(int de100) {
		return switch(de100) {
			case 1 -> "fan de";
			case 2 -> "déteste";
			case 3 -> "religieux";
			case 4 -> "athée";
			case 5 -> "optimiste ";
			case 6 -> "pessimiste";
			case 7 -> "tolérant";
			case 8 -> "intolérant";
			case 9 -> "bon vivant";
			case 10 -> "ascèse";
			case 11 -> "concerné";
			case 12 -> "à côté de la plaque";
			case 13 -> "progressiste";
			case 14 -> "conservateur";
			case 15 -> "charitable";
			case 16 -> "égoïste";
			case 17 -> "désintéressé";
			case 18 -> "ambitieux";
			case 19 -> "débonnaire";
			case 20 -> "sévère";
			case 21 -> "révolutionnaire";
			case 22 -> "immobiliste";
			case 23 -> "naïf";
			case 24 -> "suspicieux";
			case 25 -> "coeur d'artichaut";
			case 26 -> "coeur brisé";
			case 27 -> "sincère";
			case 28 -> "menteur";
			case 29 -> "honnête";
			case 30 -> "truand";
			case 31 -> "perfectionniste";
			case 32 -> "paresseux";
			case 33 -> "prévoyant";
			case 34 -> "impulsif";
			case 35 -> "flegmatique";
			case 36 -> "emporté";
			case 37 -> "sociable";
			case 38 -> "solitaire";
			case 39 -> "téméraire";
			case 40 -> "timoré";
			case 41 -> "émotif ";
			case 42 -> "froid";
			case 43 -> "constant";
			case 44 -> "versatile";
			case 45 -> "blagueur";
			case 46 -> "sérieux";
			case 47 -> "narcissique";
			case 48 -> "timide";
			case 49 -> "idéaliste";
			case 50 -> "cynique";
			case 51 -> "influençable";
			case 52 -> "entêté";
			case 53 -> "intellectuel";
			case 54 -> "homme d'action";
			case 55 -> "curieux";
			case 56 -> "blasé";
			case 57 -> "familier";
			case 58 -> "snob";
			case 59 -> "bavard";
			case 60 -> "taiseux";
			case 61 -> "généreux";
			case 62 -> "pingre";
			case 63 -> "suffisant";
			case 64 -> "mal assuré";
			case 65 -> "pragmatique";
			case 66 -> "distrait";
			case 67 -> "obséquieux";
			case 68 -> "rude";
			case 69 -> "miséricordieux";
			case 70 -> "rancunier";
			case 71 -> "pur";
			case 72 -> "canaille";
			case 73 -> "chaste";
			case 74 -> "libidineux";
			case 75 -> "citadin";
			case 76 -> "sauvage";
			case 77 -> "fiable";
			case 78 -> "peu fiable";
			case 79 -> "obéissant";
			case 80 -> "indépendant";
			case 81 -> "communautaire";
			case 82 -> "individualiste";
			case 83 -> "protecteur";
			case 84 -> "dominateur";
			case 85 -> "coquet";
			case 86 -> "négligé";
			case 87 -> "inflexible";
			case 88 -> "flexible";
			case 89 -> "médiateur";
			case 90 -> "provocateur";
			case 91 -> "romantique";
			case 92 -> "misogyne/misandre";
			case 93 -> "modeste";
			case 94 -> "starlette";
			case 95 -> "puritain";
			case 96 -> "débauché";
			case 97 -> "leader";
			case 98 -> "suiveur";
			case 99 -> "coopératif";
			case 100 -> "envieux";
			default -> "personnalité";
		};
	}

	private String descriptionRencontre(int i) {
		return switch(i) {
			case 1 -> "Courrier / Coursier";
			case 2 -> "Messager / Héraut";
			case 3 -> "Diligence / Cocher";
			case 4 -> "Grand seigneur";
			case 5 -> "Diplomate ";
			case 6 -> "Châtelain / seigneur / chevalier";
			case 7 -> "Hobereau (Gentilhomme campagnard), nobliau";
			case 8 -> "Garde";
			case 9 -> "Marchand de matière première agricoles";
			case 10 -> "Marchand de bétail";
			case 11 -> "Marchand d’esclaves";
			case 12 -> "Marchand de bois";
			case 13 -> "Marchand de pierre";
			case 14 -> "Marchand de minerais";
			case 15 -> "Marchand de métal / ferronnerie";
			case 16 -> "Marchand de laine";
			case 17 -> "Marchand de fourrure";
			case 18 -> "Marchand de cuir";
			case 19 -> "Marchand d’armes";
			case 20 -> "Marchand de vin";
			case 21 -> "Marchand de vêtements";
			case 22 -> "Marchand de tissus";
			case 23 -> "Marchand de céramique";
			case 24 -> "Marchand d’épices";
			case 25 -> "Marchand de produits de luxe";
			case 26 -> "Marchand d’ingrédients magiques ";
			case 27 -> "Forgeron ";
			case 28 -> "Tailleur de pierre";
			case 29 -> "Maçon";
			case 30 -> "Maître verrier";
			case 31 -> "Ebéniste";
			case 32 -> "Paysan";
			case 33 -> "Eleveur";
			case 34 -> "Jardinier";
			case 35 -> "Boucher";
			case 36 -> "Fromager";
			case 37 -> "Meunier";
			case 38 -> "Brasseur";
			case 39 -> "Vigneron";
			case 40 -> "Armurier";
			case 41 -> "Bûcheron ";
			case 42 -> "Charpentier";
			case 43 -> "Menuisier";
			case 44 -> "Briquetier, tuilier";
			case 45 -> "Potier";
			case 46 -> "Ouvrier";
			case 47 -> "Tanneur";
			case 48 -> "Barbier";
			case 49 -> "Chirurgien";
			case 50 -> "Médecin";
			case 51 -> "Artilleur";
			case 52 -> "Marin";
			case 53 -> "Orfèvre";
			case 54 -> "Mineur";
			case 55 -> "Cuisinier ";
			case 56 -> "Femme de ménage, bonne";
			case 57 -> "Serviteur, domestique";
			case 58 -> "Vannier, rempailleur";
			case 59 -> "Ramoneur ";
			case 60 -> "Colporteur ";
			case 61 -> "Ouvrier textile, cardeur, foulon";
			case 62 -> "Tisserant, teinturier";
			case 63 -> "blanchisseuse, couturière,";
			case 64 -> "Rôdeur, ranger";
			case 65 -> "Chasseur";
			case 66 -> "Pêcheur";
			case 67 -> "Soldat";
			case 68 -> "Mercenaire";
			case 69 -> "Paladin";
			case 70 -> "Moine";
			case 71 -> "Prélat ";
			case 72 -> "Prêtre ";
			case 73 -> "Pèlerin ";
			case 74 -> "Ermite";
			case 75 -> "Ménestrel, barde";
			case 76 -> "Saltimbanque";
			case 77 -> "Musicien, chanteur";
			case 78 -> "Acteur de théâtre";
			case 79 -> "Artiste de cirque";
			case 80 -> "Artiste ";
			case 81 -> "Peintre ";
			case 82 -> "Aventurier ";
			case 83 -> "Architecte";
			case 84 -> "Ingénieur ";
			case 85 -> "Savant ";
			case 86 -> "Lettré ";
			case 87 -> "Scientifique ";
			case 88 -> "Notaire, juriste";
			case 89 -> "Sciences humaines : cartographe, historien, anthropologue, sociologue, etc.";
			case 90 -> "Etudiant";
			case 91 -> "Lépreux ";
			case 92 -> "Mendiant, vagabond";
			case 93 -> "Devin";
			case 94 -> "Mage";
			case 95 -> "Réfugié";
			case 96 -> "Notable";
			case 97 -> "Officier royal";
			case 98 -> "Anihom";
			case 99 -> "Membre de l’Humanitas (Elfes, Nains, Hafling, Semi-Ogre, etc.)";
			case 100 -> "Posseux";
			default -> "description rencontre";
		};
	}

	private String descriptionPittoresque(int i) {
		return switch(i) {
			case 51 -> "Les villageois invitent les PJ à danser";
			case 52 -> "Célébration chantante, des enfants lancent des pétales de fleurs.";
			case 53 -> "Un épouvantail décoré est porté en triomphe";
			case 54 -> "Les invités ont trop bu, ça dégénère en bagarre ";
			case 55 -> "Atmosphère mystique et rituel chamanique";
			case 56 -> "Traverse en silence, un instrument joue une mélodie poignante.";
			case 57 -> "Perd la boule ou parle seul à la tombe de sa femme disparue.";
			case 58 -> "Son enfant est malade, elle appelle un prêtre ou un guérisseur.";
			case 59 -> "Chante une chanson triste ou se lamente sur l’existence.";
			case 60 -> "Maudit la guerre et renonce à la violence.";
			case 61 -> "Bouscule tout et sème le chaos sur son passage";
			case 62 -> "Deux vieillards s’insultent à grands cris… pour finir par éclater de rire. Ou deux commères se prennent le bec … avant d’unir leurs langues de vipère contre celui ou celle qui tente de les apaiser. ";
			case 63 -> "Un saltimbanque raté tente une acrobatie et s’effondre dans une fontaine.";
			case 64 -> "Un chien court après un enfant… qui tient un gigot.";
			case 65 -> "Un mage amateur provoque une mini-explosion de fumée violette aux effets inattendus. ";
			case 66 -> "Une bagarre éclate entre ivrognes devant une taverne.";
			case 67 -> "Une dispute de couple devient publique et attire une foule de curieux.";
			case 68 -> "Une arrestation brutale par des gardes injustes.";
			case 69 -> "Des enfants jettent des pierres sur un vagabond ou martyrisent un pauvre chaton.";
			case 70 -> "Une manifestation populaire contre une taxe inique.";
			case 71 -> "Un ancien soldat apprend à lire à des enfants sur une pierre plate.";
			case 72 -> "Une jeune aveugle joue d’un instrument avec grâce.";
			case 73 -> "Deux amoureux de castes différentes se retrouvent en cachette.";
			case 74 -> "Une vieille dame donne des biscuits aux orphelins.";
			case 75 -> "Un enfant offre une fleur à un PJ “parce que tu as l’air triste”.";
			case 76 -> "Des paysans travaillent en chantant.";
			case 77 -> "Un berger joue de la flûte pour ses chèvres.";
			case 78 -> "Une famille pique-nique sous un arbre, heureuse et insouciante.";
			case 79 -> "Une vieille femme vend des tisanes et raconte des légendes.";
			case 80 -> "Des enfants jouent au cerceau ou construisent un petit moulin à eau sur un ruisseau.";
			case 81 -> "Un chariot renversé bloque la route, et les chevaux sont paniqués.";
			case 82 -> "Un incendie débute ou se termine";
			case 83 -> "Un enfant tombe dans un puits et les villageois s’activent pour le sauver.";
			case 84 -> "Un cheval s’est emballé ou une bête féroce vient de s’échapper.";
			case 85 -> "Un arbre vient de tomber sur une hutte, écrasant le toit.";
			case 86 -> "Un marché animé, avec cris de marchands, parfums d’épices, et voleurs à la tire.";
			case 87 -> "Un crieur public annonce des nouvelles du royaume";
			case 88 -> "Une caravane passe, avec musiciens, marchands et animaux exotiques.";
			case 89 -> "Une controverse entre deux érudits ou une dispute entre deux marchands d’ethnies rivales sur l’origine d’un bijou.";
			case 90 -> "Des pèlerins partagent leur pain avec les PJ ";
			case 91 -> "Une femme parle au vent comme s’il répondait.";
			case 92 -> "Un enfant prétend avoir vu un esprit dans le puits.";
			case 93 -> "Une statue pleure, et des fidèles viennent y poser des offrandes.";
			case 94 -> "Un vieillard semble parler aux corbeaux… et ils lui répondent.";
			case 95 -> "Une lumière étrange plane au-dessus d’un champ sans raison apparente.";
			case 96 -> "L’enterrement en grande pompe d’un personnage important";
			case 97 -> "L’enterrement pitoyable d’un pauvre, laissant une famille démunie";
			case 98 -> "Un mariage aristocratique ";
			case 99 -> "Un cortège tapageur de jeunes éméchés";
			case 100 -> "Tout le village est décoré pour l’occasion";
			default -> "description scène pittoresque";
		};
	}

	private String descriptionTradition(int de200) {
		return switch(de200) {
			case 1 -> "Tenue de fête";
			case 2 -> "Tenue du quotidien";
			case 3 -> "Tenue rituelle, de cérémonie religieuse";
			case 4 -> "Tenue d’apparat, marque la distinction sociale";
			case 5 -> "Tenue liée à une activité locale";
			case 6 -> "Flûtes ou autre, jouées par un musicien solitaire";
			case 7 -> "Tambours et percussions, rythme festif";
			case 8 -> "Chants pour une cérémonie sociale ou religieuse";
			case 9 -> "Cornes ou cloches pour annoncer un événement sacré ";
			case 10 -> "Instruments à corde pour divertir un public";
			case 11 -> "Danse rituelle à l’occasion d’une cérémonie sacrée";
			case 12 -> "Danse de séduction ou de mariage";
			case 13 -> "Danse acrobatique ou danse des armes exécutée par les jeunes ou les guerriers";
			case 14 -> "Spectacle de danse";
			case 15 -> "Danse festive, conviviale";
			case 16 -> "Jeux d’adresse";
			case 17 -> "Jeux athlétiques";
			case 18 -> "Jeux intellectuels";
			case 19 -> "Jeux d’équipes";
			case 20 -> "Jeux d’affrontement, un contre un ou deux contre deux";
			case 21 -> "Rituels spirituels ou symboliques";
			case 22 -> "Coutumes liées à la nature ou à l’agriculture";
			case 23 -> "Vie quotidienne et traditions sociales";
			case 24 -> "Festivités et événements communautaires";
			case 25 -> "Rites de passage";
			case 26 -> "Superstitions, croyances populaires et objets rituels";
			case 27 -> "Tabous locaux";
			case 28 -> "Rites funéraires";
			case 29 -> "Célébrations liées à la naissance";
			case 30 -> "Coutume liée à l’amour ou au mariage";
			case 31 -> "Coutume liée à l’honneur";
			case 32 -> "Formule de salutation et de politesse, mots courants";
			case 33 -> "Jurons et exclamations";
			case 34 -> "Proverbes, maximes et dictons";
			case 35 -> "Métaphores et comparaisons, expressions imagées";
			case 36 -> "Régionalismes (mot local)";
			case 37 -> "Expressions religieuses ou superstitieuses";
			case 38 -> "Entrée chaude";
			case 39 -> "Entrée froide";
			case 40 -> "Plat de légume";
			case 41 -> "Plat de viande";
			case 42 -> "Plat de poisson";
			case 43 -> "Boulangerie, pâtisserie ";
			case 44 -> "Fromage ";
			case 45 -> "Dessert ";
			case 46 -> "Bière, boisson alcoolisée légère";
			case 47 -> "Boisson « soft »";
			case 48 -> "Vin, boisson fermentée";
			case 49 -> "Alcool fort";
			case 50 -> "Infusions, tisanes et décoctions";
			default -> "description tradition locale";
		};
	}

	private String nomDelEvnmt(EvenementDto evnmt) {
		int de200 = evnmt.getDe200();
		if(de200 <= 0) {
			return "";
		} else if(de200 <= 50) {
			return "Tradition locale";
		} else if(de200 <= 100) {
			return "Scène pittoresque";
		} else {
			return "Rencontre";
		}
	}

}
