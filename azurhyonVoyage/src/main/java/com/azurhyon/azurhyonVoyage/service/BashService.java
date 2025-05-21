package com.azurhyon.azurhyonVoyage.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.azurhyon.azurhyonVoyage.dto.BashDto;
import com.azurhyon.azurhyonVoyage.dto.RouteDto.RouteTypes;

@Service
public class BashService {

	public BashDto lancerBash(int orient, int survie, int diff, RouteTypes route) {
		Random random = new Random();
		return calculBash(orient, survie, diff, route, d20(), random.nextInt(20)+1, 
				random.nextInt(20)+1, 0);
	}
	public BashDto calculBash(int orient, int survie, int diff, RouteTypes route, int deBash, int deGravite, int dePeril, int deEvnmt) {
		BashDto bash = new BashDto();
		
		int margeSurvie = calculMargeSurvie(orient, survie, diff);
		int bonusBash = calculBonusBash(margeSurvie);
		
		bash.setJet(deBash);
		bash.setCritique(deBash==1);

		if(deBash >= 20) {
//			Chance !
			bash.setEffet(choixChance(deBash, deEvnmt));
		} else if(deBash==1 || deBash+bonusBash <= limiteBash(route)) {
			bash.setBash(true);
			// désagrément ou péril
			bash.setGravite(deGravite);
			int deGrave = deGravite;
			if(deBash==1) deGrave = deGravite+bonusBash;
			if(deGrave <= limitePeril(route)) {
				bash.setPeril(dePeril);
				bash.setDeEvnmt(deEvnmt);
				bash.setEffet("Péril : " + choixPeril(dePeril) + " Ex : " + choixMonstre(deEvnmt));
			} else if(deGrave <= limiteDanger(route)) {
				bash.setEffet("Danger : " + choixDanger(deEvnmt));
			} else if(deGrave <= limiteContrariete(route)) {
				bash.setEffet("Contrariété : " + choixContrariete(deEvnmt));
			} else if(deGrave <= limiteDesagrement(route)) {
				bash.setEffet("Désagrément : " + choixDesagrement(deEvnmt));
			} else {
				bash.setEffet("Boarf, c'est pas si grave.");
			}
		} else {
			bash.setEffet("");
		}

		return bash;
	}

	private String choixMonstre(int de) {
		if(de == 0) {
			Random random = new Random();
			de = random.nextInt(100)+1;
		}
        return switch(de) {
			case 1 -> "Araignées géantes";
			case 2 -> "Insectes sociaux géants (fourmis, gehknas, blattes, termites etc.)";
			case 3 -> "Insectes volants géants (mouches, guêpes, moustiques géants, etc.)";
			case 4 -> "Myriapodes venimeux (mille-pattes géant, centipède, chenilles, etc.)";
			case 5 -> "Insectes monstrueux (mante géante, punaise-bombe, scarabées géants, etc.)";
			case 6 -> "Scorpions géants, uropyge, pseudoscorpion, etc.";
			case 7 -> "Escargots, limaces, sangsues, etc.";
			case 8 -> "Papillons magiques";
			case 9 -> "Vers, apodes, vers charognards, wurms, etc.";
			case 10 -> "Loups géants (loup noir, loup des glaces, etc.)";
			case 11 -> "Suidés (sangliers géants, entélodonte, etc.)";
			case 12 -> "Canidés (renards magiques, chiens, etc.)";
			case 13 -> "Cervidés (cerf, chevreuils, dama, magiques ou non)";
			case 14 -> "Belette, blaireau sanguinaire, glouton, ratel, furet de feu …";
			case 15 -> "Ursidés ";
			case 16 -> "Rongeurs (rats, rats géants, etc.)";
			case 17 -> "Singes (gorilles, chimpanzés, chabouins, gnoars, etc.)";
			case 18 -> "Equidés (pégases, licornes, chevaux de feu, chevaux célestes, etc.)";
			case 19 -> "Félins (lion, puma, panthère cuirassée, etc.)";
			case 20 -> "Bovidés (auroch, taureau, bison, yack, taureau d’airain, etc.) ";
			case 21 -> "Chèvre, mouflon, bouquetin, etc.";
			case 22 -> "Mastodontes (éléphant, rhinocéros, hippopotame, béhémoth, oliphant, etc.)";
			case 23 -> "Wargs, hyènes, hyaénodons, etc.";
			case 24 -> "Chauves-souris, wak-waks, gobe-lune, méphites, etc.";
			case 25 -> "Gastornis (oiseaux coureurs)";
			case 26 -> "Rapaces (aigles, faucons, hiboux, etc.)";
			case 27 -> "Oiseaux charognards (corbeaux, crebains, corneilles à 3 yeux, vautours, marabouts, etc.)";
			case 28 -> "Oiseaux aquatiques et marins (canards, échassiers, mouettes, etc.) ";
			case 29 -> "Oiseaux des plaines et forêts (hirondelle, mésange, coucou, faisan, perroquet, etc.)";
			case 30 -> "Cuirassés : hérissons, tatous, tortues, etc.";
			case 31 -> "Tentaculaires (fouetteurs, charognards rampants, etc.)";
			case 32 -> "Serpents (boas, pythons,cobras, serpent-bélier, serpent à plume, guivre, etc.)";
			case 33 -> "Lézards";
			case 34 -> "Reptiles : tortues, crocodiliens, kromodox, etc.";
			case 35 -> "Tritons, salamandres, etc.";
			case 36 -> "Crapauds et batraciens géants";
			case 37 -> "Fruits de mer, palourdes, crabes géants, etc.";
			case 38 -> "Poissons (requins, etc.)";
			case 39 -> "Poulpes (pieuvre, calamar géant, poulpe arboricole, etc.)";
			case 40 -> "Autres créatures aquatiques : cétacés, méduses, etc.";
			case 41 -> "Dinosaures aquatiques, mégalodon, etc.";
			case 42 -> "Monstres marins : sirènes, chevaux marins, lions marins, etc.";
			case 43 -> "Gros monstres marins : kraken, léviathan, hydre, etc.";
			case 44 -> "Algues, coraux, plantes et créatures aquatiques";
			case 45 -> "Limons, blobs et gelées";
			case 46 -> "Mousses et lichens";
			case 47 -> "Champignons ";
			case 48 -> "Arbres magiques (arbres enlaceurs, cogneurs, etc.)";
			case 49 -> "Plantes dangereuses (carnivores, magiques, etc.)";
			case 50 -> "Lianes, plantes grimpantes, ronces, etc. ";
			case 51 -> "Fleurs magiques";
			case 52 -> "Sylviens (treefolk), tréants, tertres";
			case 53 -> "Créatures minérales";
			case 54 -> "Golems et mécas";
			case 55 -> "Parasites";
			case 56 -> "Créatures préhistoriques";
			case 57 -> "Créatures hybrides (hibours, crocodours, varhino, cerlinx, elanion, etc.)";
			case 58 -> "Chimères (chimère, manticore, sphinx, qilin, lammasu, etc.)";
			case 59 -> "Chimères magiques (pétrifiants notamment) : basilic, coquatrix, méduses, etc. ";
			case 60 -> "Monstres volants : griffons, hippogriffes, panthère ailée, pégase cornu, etc.";
			case 61 -> "Créatures élémentaires (phénix, oiseaux-tonnerres)";
			case 62 -> "Créatures immenses (Oiseau rokh, tortue-île, etc.)";
			case 63 -> "Gros streums (urvak, thobal, guivre, etc.)";
			case 64 -> "Dragons, wyverns, drakôns, ryu, etc.";
			case 65 -> "Draconides (créatures animal-dragon)";
			case 66 -> "Mi-humains : centaures, damoiseaux, arachnelfes, etc.";
			case 67 -> "Humanoïdes : satires, faunes, minotaure, etc.";
			case 68 -> "Créatures magiques peu agressive (téléport, etc.)";
			case 69 -> "Fées, pixies, lutins, trognoms, farfadets, etc.";
			case 70 -> "Djinns, effrits, génies, etc.";
			case 71 -> "Dryades, naïades, sylphes, etc.";
			case 72 -> "Elémentaires";
			case 73 -> "Géants, ogres, cyclopes, triclopes, etc.";
			case 74 -> "Trolls (des bois, des marais, des cavernes, géants, etc.)";
			case 75 -> "Métamorphes : garous et théranthropes, mimics, dopple, etc.";
			case 76 -> "Fantômes, spectre, dame blanche, banshee, nashgûl …";
			case 77 -> "Esprits : follets, croque-mitaine, poltergeist, ankou, acheri, etc.";
			case 78 -> "Ombres, voleur d’âme, dépresseur, brumeux, etc.";
			case 79 -> "Sorcières, guenaudes, lamia, etc.";
			case 80 -> "Morts-vivants (squelettes, zombis, faucheuse, momie, etc.)";
			case 81 -> "Vampire, liche, nécromant, momie royale, etc. ";
			case 82 -> "Nécrophages (goules, blêmes, décharnés, etc.) ";
			case 83 -> "Autres créatures liées aux morts-vivants (épouvantails, armures animées, etc.)";
			case 84 -> "Volants maléfiques (harpies, striges, singes volants, gargouilles, etc.)";
			case 85 -> "Démons et diables";
			case 86 -> "Asuras, onis, kamis et démons de diverses cultures, monstres infernaux";
			case 87 -> "Abominations chaotiques (tyrannoeil, hécatonchire, etc.)";
			case 88 -> "Monstruosités horrifiques (chtul, alien, etc.)";
			case 89 -> "Mange-truc (mange-terre, mange-magie, etc.)";
			case 90 -> "Synéïdes";
			case 91 -> "Créatures interplanaires, monstres astraux, etc.";
			case 92 -> "Monstres-esprits (inugami, wendigo, etc.)";
			case 93 -> "Créatures célestes, monstres divins";
			case 94 -> "Bandits ";
			case 95 -> "Pillards Peaux-Vertes, Elfes Noirs, etc.";
			case 96 -> "Anihoms";
			case 97 -> "Sectes maléfiques";
			case 98 -> "Créatures mythologiques ";
			case 99 -> "Créatures d’un autre monde"; 
			case 100 -> "Retirez deux fois";
        	default -> "Monstre.";
        };
	}
	private String choixPeril(int dePeril) {
		return switch(dePeril) {
			case 1 -> "Péril national (IC 154, PM 11)";
			case 2 -> "Péril national (IC 140, PM 10)";
			case 3 -> "Péril national (IC 126, PM 9)";
			case 4 -> "Péril régional (IC 119, PM 8,5)";
			case 5 -> "Péril régional (IC 112, PM 8)";
			case 6 -> "Péril régional (IC 105, PM 7,5)";
			case 7 -> "Péril régional (IC 98, PM 7)";
			case 8 -> "Péril régional (IC 91, PM 6,5)";
			case 9 -> "Péril régional (IC 84, PM 6)";
			case 10 -> "Diablino : Les PJ croisent un petit diablotin qui les agonit d’injures et donne à chacun une tare avant de disparaître (se reporter aux règles de création de personnage, si le personnage tombe sur une tare de limitation de Carac, il prend -1 Carac à la place). Diablino est immortel et invincible. Il fait partie des mystères d’Azurhyòn.";
			case 11 -> "Péril comtal (IC 77, PM 5,5)";
			case 12 -> "Péril comtal (IC 70, PM 5)";
			case 13 -> "Péril comtal (IC 63, PM 4,5)";
			case 14 -> "Péril local (IC 56, PM 4)";
			case 15 -> "Péril local (IC 56, PM 4)";
			case 16 -> "Péril local (IC 49, PM 3,5)";
			case 17 -> "Péril local (IC 49, PM 3,5)";
			case 18 -> "Péril local (IC 42, PM 3)";
			case 19 -> "Péril local (IC 42, PM 3)";
			case 20 -> "Péril local (IC 35, PM 2,5)";
			default -> "";
		};
	}
	private String choixDanger(int de) {
		if(de == 0) {
			Random random = new Random();
			de = random.nextInt(40)+1;
		}
        return switch(de) {
			case 1 -> "Le personnage tombe malade (empoisonnement, fièvre des marais…)";
			case 2 -> "Eau polluée (test d'Endurance), le personnage attrape la diarrhée."; 
			case 3 -> "Bourbier, gué dangereux (test de Mouvement et de Vigueur)";
			case 4 -> "Passage étroit à flanc de montagne (test d'équilibre), chemin escarpé (test d'escalade), faille à sauter (test de saut)";
			case 5 -> "Une prophétie annonce qu’un danger menace le village et que c’est aux PJ de l’écarter, les obligeant à résoudre le problème";
			case 6 -> "Le personnage est victime d’un vol (-1D20 x100 PO)";
			case 7 -> "Un piège ou un effondrement provoque une blessure. ";
			case 8 -> "Le personnage est victime d’une malédiction gênante (mauvais sort)";
			case 9 -> "Une partie de l’équipement est gravement endommagé (-1D20 x100 PO)";
			case 10 -> "Une autorité locale accuse le personnage d’un crime qu’il n’a pas commis : il est arrêté et doit se disculper.";
			case 11 -> "Un démon mineur ou esprit vindicatif poursuit le PJ.";
			case 12 -> "Le PJ est la cible d’une rumeur infamante (sorcellerie, trahison, adultère…), qui nuit à sa réputation et dont il doit se justifier. ";
			case 13 -> "La monture du personnage est blessée ou tuée. ";
			case 14 -> "Le personnage est blessé à la suite d’une attaque ou d’une mauvaise chute. ";
			case 15 -> "Des problèmes locaux font perdre plusieurs jours de voyage au personnage (chargement immobilisé ou gros détour à faire). ";
			case 16 -> "Une créature magique ou une ancienne connaissance demande une dette de sang ou de service.";
			case 17 -> "Le personnage doit lutter contre un incendie. ";
			case 18 -> "Les personnages brisent un tabou local sans le savoir et doivent se racheter. ";
			case 19 -> "Des papiers ou laissez-passer sont demandés, et doivent être obtenus mais l’administration est lente ou corrompue.";
			case 20 -> "Il faut aider des marchands en détresse ou des réfugiés. Les PJ ne peuvent pas laisser ces pauvres gens se débrouiller par eux-mêmes et restent avec eux quelques jours. ";
			case 21 -> "Un escroc les arnaque (-1D20 x 100 PO).  ";
			case 22 -> "Une anomalie dans le Voile piège le groupe dans une illusion.";
			case 23 -> "Une anomalie dans le Voile modifie l’espace-temps, faisant perdre du temps aux PJ";
			case 24 -> "Le groupe tombe sur une région maudite ou un lieu hanté qui altère leur sommeil ou leurs rêves pendant plusieurs nuits (ou une âme en peine les piège dans une boucle temporelle).";
			case 25 -> "Une personne aimée ou un allié est en danger, forçant à reconsidérer les priorités.";
			case 26 -> "Une faction ou guilde ennemie met une prime sur la tête du personnage.";
			case 27 -> "Une infection magique ou une malédiction subtile ronge peu à peu le PJ, nécessitant un remède rare.";
			case 28 -> "Une distorsion magique aspire temporairement le personnage dans une dimension inconnue.";
			case 29 -> "Le PJ est ensorcelé ou charmé à son insu, agissant contre ses intérêts pendant un temps.";
			case 30 -> "Le personnage découvre qu’un ennemi a usurpé son identité quand on vient lui demander des comptes.";
			case 31 -> "Péril Facile : canidés (loups, bande de chiens errants, etc.)";
			case 32 -> "Péril Facile : animaux géants (rats géants, chauve-souris géante, etc.) ";
			case 33 -> "Péril Facile : peaux-vertes (gobelins, hobgobelins, etc.)";
			case 34 -> "Péril Facile : morts vivants (squelettes, zombis, goules, etc.)";
			case 35 -> "Péril Facile : humains (groupe de paysans, de voyous ou de bandits)";
			case 36 -> "Péril Local : 1 adversaire impressionnant pour le groupe (un ogrillon par exemple, un loup ou un sanglier géant) ";
			case 37 -> "Péril Facile : petites créatures magiques, plus facétieuses que dangereuses (pixies, démons, etc.)";
			case 38 -> "Péril Facile : créatures des marais (vers, sangsues, grenouille géante, etc.)";
			case 39 -> "Péril Facile : monstres-plantes";
			case 40 -> "Péril Facile : reptiles (serpent venimeux, gros lézard, etc.)";
        	default -> "Danger.";
        };
	}

	private String choixContrariete(int de) {
		if(de == 0) {
			Random random = new Random();
			de = random.nextInt(40)+1;
		}
        return switch(de) {
			case  1	-> "Une roue de chariot casse, il faut la réparer. Une monture se blesse, soins nécessaires. Le personnage perd une chaussure.";
			case  2	-> "Le pont prévu est effondré, une rivière est sortie de son lit, le chemin de montagne s’est éboulé, détour obligatoire.";
			case  3	-> "Une taxe locale impromptue est exigée à l’entrée d’un territoire.";
			case  4	-> "Un garde tatillon exige de fouiller les affaires, ce qui retarde le groupe.";
			case  5	-> "Le personnage a oublié un objet important à l’étape précédente. Demi-tour.";
			case  6	-> "Les bottes ou vêtements sont abîmés et doivent être rapiécés ou remplacés.";
			case  7	-> "Une cérémonie religieuse locale empêche le groupe de continuer. ";
			case  8	-> "Une dispute éclate avec un local, et la garde s’en mêle. Temps perdu ou amende.";
			case  9	-> "Un artisan exige une rallonge ou un délai pour un service commandé.";
			case 10	-> "Une monture est en fuite, il faut la retrouver.";
			case 11	-> "Une taverne locale refuse de servir les étrangers sans un « cadeau » au patron.";
			case 12	-> "Les vivres ont tourné ou sont infestés, il faut les remplacer.";
			case 13	-> "Un voleur tente de subtiliser un objet ; réussite ou pas, il faut vérifier tout.";
			case 14	-> "Un objet important est tombé dans un endroit peu accessible, il faut le récupérer.";
			case 15	-> "Une barrière fermée exige de convaincre ou payer le garde.";
			case 16	-> "Une querelle ou un accident bloque l’avancée.";
			case 17	-> "Des papiers ou laissez-passer sont demandés, et doivent être obtenus.";
			case 18	-> "Une pénurie locale fait grimper les prix temporairement.";
			case 19	-> "Une affaire locale provoque un contrôle renforcé aux portes, les gardes cherchent des criminels et les PJ sont suspects.";
			case 20	-> "Un artisan prend du retard pour un service attendu en raison d’une maladie, d’un problème familial ou autre.";
			case 21	-> "Le groupe doit attendre l’arrivée d’un bac pour traverser une rivière mais le passeur, saoûl, s’est endormi.";
			case 22	-> "Une sentinelle endormie empêche de franchir une porte ou un poste.";
			case 23	-> "Une manifestation ou foire bloque les rues pendant des heures.";
			case 24	-> "Un marchand accuse les PJ de vol. Faux, mais il faut clarifier.";
			case 25	-> "Une demande d’aide d’un local est difficile à refuser (blessé, enfant, etc.).";
			case 26	-> "Une tempête, un animal sauvage ou un mauvais coup ruine la tente. ";
			case 27	-> "Un EC en cuisine rend malade les PJ pendant quelques heures.";
			case 28	-> "Un arbre abattu en travers du chemin gêne le passage. Il faut le dégager. ";
			case 29	-> "Une charrette renversée bloque la route, il faut aider ou contourner.";
			case 30	-> "Une route en mauvais état (nids de poule, boue, ronces, pavés disjoints, etc.) ralentit la progression des personnages. ";
			case 31	-> "Des enfants chapardeurs s’enfuient avec un objet. Il faut les poursuivre.";
			case 32	-> "Un feu de forêt ou incendie empêche de passer par la route prévue. ";
			case 33	-> "Une enquête locale pousse les PJ à rester pour témoigner.";
			case 34	-> "Un voleur vole les PJ ou un escroc les arnaque (-1D20 x 10 PO).";  
			case 35	-> "Le personnage a la diarrhée.";
			case 36	-> "Le sac du personnage se déchire, éparpillant ses affaires (il met peut-être du temps à s’en rendre compte et sème une traînée de vêtements sur son passage). ";
			case 37	-> "Une anomalie dans le Voile piège le groupe dans une illusion";
			case 38	-> "Une anomalie dans le Voile modifie l’espace-temps, faisant perdre du temps aux PJ";
			case 39	-> "Un esprit farceur décide d’embêter les PJ";
			case 40	-> "Un salopac souille le personnage. ";
        	default -> "Contrariété.";
        };
	}
	
	private String choixDesagrement(int de) {
		if(de == 0) {
			Random random = new Random();
	        de = random.nextInt(50)+1;
		}
        return switch(de) {
			case 1 -> "Une guêpe s’est glissée dans la tunique/le casque.";
			case 2 -> "Le personnage marche dans la merde, l’odeur reste.";
			case 3 -> "Il perd un bouton, une boucle ou une lanière essentielle.";
			case 4 -> "Son sac se renverse au sol, son contenu se répand partout.";
			case 5 -> "Il reçoit une fiente d’oiseau dessus.";
			case 6 -> "Un chien le suit en aboyant sans relâche.";
			case 7 -> "Sa boisson est imbuvable, il y a un truc dedans";
			case 8 -> "Il a le hoquet sans arrêt pendant une heure.";
			case 9 -> "Une envie pressante… sans lieu décent pour s’isoler.";
			case 10 -> "Son repas est immangeable (trop salé, trop épicé, moisi…).";
			case 11 -> "Quelqu’un lui renverse un pot de chambre dessus.";
			case 12 -> "Un homme saoul lui vomi dessus. ";
			case 13 -> "Il oublie sans arrêt le mot qu’il avait sur le bout de la langue.";
			case 14 -> "Il est constamment interrompu quand il veut parler.";
			case 15 -> "Une mèche de cheveux/blessure/griffure le démange atrocement.";
			case 16 -> "Il a un caillou dans la chaussure ou dans son armure, mais ne peut s’arrêter.";
			case 17 -> "Un moustique le harcèle.";
			case 18 -> "Il se rend compte qu’il a une tache sur le nez / un truc vert sur les dents";
			case 19 -> "Quelqu’un insiste lourdement pour lui vendre une babiole inutile.";
			case 20 -> "Il entend une chanson qu’il déteste, et elle lui reste en tête.";
			case 21 -> "Il se fait éclabousser par un char ou une monture.";
			case 22 -> "Il est suivi par un mendiant trop collant.";
			case 23 -> "Il déchire accidentellement un vêtement.";
			case 24 -> "Il renverse de l’encre/un liquide coloré sur ses affaires.";
			case 25 -> "Des gens se moquent de lui.";
			case 26 -> "Il reçoit une écharde ou se pique avec une ronce.";
			case 27 -> "Il trébuche dans un escalier ou dans la rue (et se fait remarquer).";
			case 28 -> "Il égare un objet (valeur 1D20 PO).";
			case 29 -> "Il est réveillé en sursaut par un coq fou ou une cloche prématurée.";
			case 30 -> "Un ronfleur l’empêche de dormir.";
			case 31 -> "Un sifflement ou acouphène persiste dans son oreille.";
			case 32 -> "Une tique / puce / sangsue s’est logée à un endroit fâcheux.";
			case 33 -> "Une mouche ou un grain de sable dans l’œil pendant une discussion.";
			case 34 -> "Il attrape une ampoule au pied";
			case 35 -> "Quelqu’un éternue sur lui. Fort. Et deux fois.";
			case 36 -> "On lui sert du lait tourné / de la viande avariée / du pain moisi, en tout cas un truc infect.";
			case 37 -> "Il se fait involontairement éclabousser de vin / soupe / graisse.";
			case 38 -> "Il fait tomber sa bourse et des enfants s’enfuient avec ses pièces avant qu’il ne puisse toutes les ramasser (-1D20 PO).";
			case 39 -> "Le vent soulève une poussière fine qui pique les yeux et s’infiltre à travers les vêtements. Le personnage tousse et se sent sale.";
			case 40 -> "Il souffre de frottements irritants à cause de ses vêtements ou d’un harnais mal ajusté.";
			case 41 -> "Attrape un bon coup de soleil ou un petit rhume.";
			case 42 -> "Une odeur désagréable le poursuit toute la journée. D’où vient-elle ?";
			case 43 -> "Il se réveille avec des douleurs qui le poursuivent toute la journée.";
			case 44 -> "Sa monture est récalcitrante aujourd’hui. ";
			case 45 -> "Il fait de l’eczéma, a des rougeurs et irritations. ";
			case 46 -> "Il a une rhinite allergique et passe la journée à éternuer. ";
			case 47 -> "Il se cogne le petit orteil contre un meuble/un rocher et jure pendant dix minutes.";
			case 48 -> "Son équipement grince ou cliquette sans arrêt (armure, sac, armes…), ça lui tape sur les nerfs.";
			case 49 -> "On lui vole son déjeuner / renverse son repas";
			case 50 -> "Il se trompe de chemin et perd une heure";
        	default -> "Désagrément.";
        };
	}
	
	private String choixChance(int deBash, int deEvnmt) {
		if(deBash <= 29) {
			return bonneJournee(deEvnmt);
		} else if(deBash <= 39) {
			return superJournee(deEvnmt);
		} else if(deBash <= 49) {
			return chanceux(deEvnmt);
		} else if(deBash <= 59) {
			return tresChanceux(deEvnmt);
		} else {
			return "Les PJ croisent un petit lutin fort sympathique qui leur accorde à chacun un don et disparaît (se reporter aux règles de création de personnage). Traditionnellement, Lutino offre des cookies à ceux qu’il croise. Lutino et Diablino sont immortels et invincibles. Ils font partie des mystères d’Azurhyòn.";
		}
	}

	private String tresChanceux(int de) {
		if(de == 0) {
			Random random = new Random();
			de = random.nextInt(40)+1;
		}
        return switch(de) {
			case 1	 -> "Trouve 1D20 x1000 PO";
			case 2	 -> "Trouve des bijoux d’une valeur d’1D20 x1000 PO";
			case 3	 -> "Gagne le jackpot au jeu (valeur 1D20 x1000 PO)";
			case 4	 -> "Les PJ sauvent la vie d’un riche personnage (1D20 x1000 PO)";
			case 5	 -> "Récompense pour un service ou une information capitale à une puissance (royaume, guilde, culte…) ";
			case 6	 -> "Trouve des objets de collection d’une valeur d’1D20 x100 PO (trouvaille archéologique, objet d’art, livre rare)";
			case 7	 -> "Trouve un coffre rempli d’objets d’une valeur d’1D20 x1000 PO ";
			case 8	 -> "Les PJ tombent sur les restes d’une caravane marchande";
			case 9	 -> "Découverte d’un trésor oublié dans une crypte, un ancien champ de bataille ou une ruine (valeur 1D20 x1000 PO)";
			case 10 -> "Les PJ capturent un monstre ou une créature inhabituelle";
			case 11 -> "Les PJ trouvent un filon de minerais précieux ou de gemmes";
			case 12 -> "Les PJ touchent un héritage inattendu";
			case 13 -> "Un esprit magique aide les PJ (PM 5 à 9,5)";
			case 14 -> "Bénéficie d’un sort PM 5 à 9,5";
			case 15 -> "Bénéficie d’un miracle PM 5 à 9,5";
			case 16 -> "Trouve un ingrédient magique (PM 5 à 9,5)";
			case 17 -> "Trouve un parchemin magique (PM 5 à 9,5)";
			case 18 -> "Trouve une potion magique (PM 5 à 9,5)";
			case 19 -> "Rencontre un allié ou un contact puissant (+5 à +9)";
			case 20 -> "Trouvent un objet magique (PM 1 à 4,5)";
        	default -> "(50+) Très chanceux, le personnage gagne ou économise 1D20x1000 PO.";
        };
	}

	private String chanceux(int de) {
		if(de == 0) {
			Random random = new Random();
			de = random.nextInt(40)+1;
		}
        return switch(de) {
			case 1	-> "Trouve 1D20 x100 PO";
			case 2	-> "Trouve un ou des bijoux perdus d’une valeur d’1D20 x100 PO";
			case 3	-> "Trouve le butin d’un gang (valeur 1D20 x100 PO)";
			case 4	-> "Vend une information très convoitée à la bonne personne (valeur 1D20 x100 PO)";
			case 5	-> "Gagne au jeu (valeur 1D20 x100 PO)";
			case 6	-> "Gagne un concours local (1D20 x100 PO)";
			case 7	-> "Un noble ou un riche marchand le gratifie largement pour son aide (1D20 x100 PO)";
			case 8	-> "Le PJ remporte un duel d’honneur contre un noble… et reçoit une rançon ou un prix (1D20 x100 PO)";
			case 9	-> "Gagne le gros lot dans une foire (d’une valeur d’1D20 x100 PO)";
			case 10	-> "Trouve un objet de collection d’une valeur d’1D20 x100 PO (trouvaille archéologique, objet d’art, livre rare)";
			case 11	-> "Trouve un sac ou un coffre ou une caisse perdue, rempli d’objets d’une valeur d’1D20 x100 PO ";
			case 12	-> "Les PJ tombent sur les restes d’une caravane pillée";
			case 13	-> "Les PJ trouvent les restes d’un aventurier";
			case 14	-> "Reçoivent un cadeau de valeur par quelqu’un qui veut les remercier ou s’attirer leurs bonnes grâces (1D20 x100 PO)";
			case 15	-> "Les PJ trouvent des pépites d’or";
			case 16	-> "Commerçant sympa, promotion sur des objets chers";
			case 17	-> "Troc avantageux (échanger un objet contre un autre similaire d’une qualité supérieure) (gagne 1D20 x100 PO)";
			case 18	-> "Vend un objet bien plus que sa valeur auprès d’un collectionneur (gagne 1D20 x100 PO)";
			case 19	-> "Les PJ trouvent des chevaux sans maître";
			case 20	-> "Les PJ capturent un monstre ou une créature inhabituelle";
			case 21	-> "Quelqu’un fait un don aux PJ en règlement d’une vieille dette ou en récompense d’une action passée";
			case 22	-> "Un esprit magique aide les PJ (PM 2 à 5,5)";
			case 23	-> "Bénéficie d’un sort PM 2 à 5,5";
			case 24	-> "Bénéficie d’un miracle PM 2 à 5,5";
			case 25	-> "Trouve un ingrédient magique (PM 2 à 5,5)";
			case 26	-> "Trouve un parchemin magique (PM 2 à 5,5)";
			case 27	-> "Trouve une potion magique (PM 2 à 5,5)";
			case 28	-> "Une divination spontanée (PM 2 à 5,5)";
			case 29	-> "Rencontre un allié ou un contact très utile (+2 à +6)";
			case 30	-> "Trouve un objet magique de bas niveau (PM 1 à 1,5)";
        	default -> "(40+) Chanceux, le personnage gagne ou économise 1D20x100 PO.";
        };
	}
	
	private String superJournee(int de) {
		if(de == 0) {
			Random random = new Random();
			de = random.nextInt(40)+1;
		}
        return switch(de) {
			case 1  -> "On offre aux PJ le gîte et de couvert pour la nuit";
			case 2  -> "On offre aux PJ un banquet";
			case 3  -> "Plusieurs jours de rations";
			case 4  -> "Les PJ trouvent du gibier en abondance ou une grosse prise";
			case 5  -> "Plusieurs bouteilles de vin ou d’alcool fort ";
			case 6  -> "Les PJ ont un soin esthétique gratuit (bain, massage, etc.)";
			case 7  -> "Les PJ ont une aventure d’un soir";
			case 8  -> "Des informations utiles sur la région ou leur quête (+1 à +3)";
			case 9  -> "Trouve une bourse d’1D20 x10 PO";
			case 10 ->  "Trouve un bijou perdu d’une valeur d’1D20 x10 PO";
			case 11 ->  "Quelqu’un paye généreusement le PJ pour un service (1D20 x10 PO)";
			case 12 ->  "Gagne un pari ou un jeu (1D20 x10 PO)";
			case 13 ->  "Gagne un concours local (1D20 x10 PO)";
			case 14 ->  "Commerçant sympa, promotion";
			case 15 ->  "Troc avantageux (échanger un objet contre un autre similaire d’une qualité supérieure) (gagne 1D20 x10 PO)";
			case 16 ->  "Vend un objet plus que sa valeur (gagne 1D20 x10 PO)";
			case 17 ->  "On leur répare gratuitement leur équipement ou autre service spécialisé";
			case 18 ->  "Obtient une carte ou une place en diligence";
			case 19 ->  "Gagne un lot dans une foire (d’une valeur d’1D20 x10 PO)";
			case 20 ->  "Trouve un trésor d’une valeur d’1D20 x10 PO";
			case 21 ->  "Obtient un objet utile d’une valeur d’1D20 x10 PO (sac à dos de qualité, dague, épée, lanterne, etc.)";
			case 22 ->  "Reçoivent un cadeau de valeur (1D20 x10 PO)";
			case 23 ->  "Bonus au jet de Survie pour la nuit, passe une nuit tranquille / confortable";
			case 24 ->  "Une divination spontanée (PM 1 à 3)";
			case 25 ->  "Rencontre un personnage sympa ou un contact utile (+1 à +3)";
			case 26 ->  "Chien, oiseau ou autre animal de compagnie s’attache au PJ";
			case 27 ->  "Un esprit de la nature aide les PJ (PM 1 à 3)";
			case 28 ->  "Un allié assiste les PJ dans leur quête (+1 à +3)";
			case 29 ->  "Soigne gratuitement les PJ";
			case 30 ->  "Assistent à un spectacle de qualité (concert, bal, opéra)";
			case 31 ->  "Reçoivent un objet d’art (d’une valeur d’1D20 x10 PO)";
			case 32 ->  "Reçoivent des conseils d’un érudit (+1 à +3) ou trouvent des livres (d’une valeur d’1D20 x10 PO)";
			case 33 ->  "Reçoit le soutien financier d’un personnage puissant (1D20 x10 PO)";
			case 34 ->  "Bénéficie d’un sort PM 1 à 3";
			case 35 ->  "Bénéficie d’un miracle PM 1 à 3";
			case 36 ->  "Trouve un parchemin magique (PM 1 à 3)";
			case 37 ->  "Trouve une potion magique (PM 1 à 3)";
			case 38 ->  "Trouve un ingrédient végétal magique (PM 1 à 3)";
			case 39 ->  "Trouve un ingrédient minéral magique (PM 1 à 3)";
			case 40 ->  "Trouve un ingrédient animal magique (PM 1 à 3)";
        	default -> "(30+) Super journée, le personnage gagne ou économise 1D20x10 PO.";
        };
	}

	private String bonneJournee(int de) {
		if(de == 0) {
			Random random = new Random();
			de = random.nextInt(30)+1;
		}
        return switch(de) {
        	case 1 -> "Repas partagé offert ";
        	case 2 -> "Un verger ou un potager abandonné regorge de fruits ou de légumes mûrs";
        	case 3 -> "Trouvent un animal mort / pris au piège";
        	case 4 -> "On offre à boire aux PJ";
        	case 5 -> "On offre aux PJ une ration de voyage pour la route (sandwich)";
        	case 6 -> "On offre aux PJ des surplus du marché ou d’un restaurant « pour ne pas gaspiller »";
        	case 7 -> "Les PJ ont l’occasion de se baigner ou de se laver gratuitement";
        	case 8 -> "Un barbier offre une coupe gratuite au PJ";
        	case 9 -> "Trouve 1D20 PO par terre";
        	case 10 -> "Trouve un bijou perdu d’une valeur d’1D20 PO";
        	case 11 -> "Quelqu’un paye le PJ 1D20 PO pour un petit service ";
        	case 12 -> "Gagne un pari ou un jeu (1D20 PO)";
        	case 13 -> "Commerçant sympa, promotion";
        	case 14 -> "Troc avantageux (échanger un petit objet contre un autre similaire d’une qualité supérieure)";
        	case 15 -> "On leur cire les chaussures et brosse gratuitement les manteaux";
        	case 16 -> "On leur nettoie gratuitement leurs habits";
        	case 17 -> "On leur reprise gratuitement leurs habits (ou autre menue réparation)";
        	case 18 -> "On leur entretien gratuitement leurs armes (aiguisées, frottées et huilées)";
        	case 19 -> "Trouvent un petit objet utile perdu ou abandonné (torche, couverture, corde, outre, bâton de marche, etc.)";
        	case 20 -> "On leur donne un petit objet utile (bougie, briquet, plume, parchemin, etc.)";
        	case 21 -> "Trouvent un petit objet de consommation courant (blague à tabac, savon parfumé, flûte, gants de laine, etc.)";
        	case 22 -> "Reçoivent un petit cadeau (collier de perles d’argile ou de bois, mouchoir brodé, une jolie pierre, un jouet en bois)";
        	case 23 -> "Reçoivent un poème, un dessin, une chanson personnalisée, etc. ";
        	case 24 -> "Les PJ gagnent du temps, avancent plus vite";
        	case 25 -> "Les PJ ont de la chance avec la météo (éclaircie soudaine, temps favorable, etc.)";
        	case 26 -> "Une expérience mystique qui conforte la foi des PJ";
        	case 27 -> "Quelque chose qui remonte le moral, encourage les PJ";
        	case 28 -> "Rencontrent un personnage sympa ou un contact potentiel";
        	case 29 -> "Quelqu’un flirte avec le personnage";
        	case 30 -> "Assistent à un spectacle de rue";
        	default -> "(20+) Bonne journée, le personnage gagne ou économise 1D20 PO.";
        };
	}

	private int limiteBash(RouteTypes route) {
		return (switch(route) {
		case GRANDEVOIE -> 1;
		case ROUTE -> 2;
		case CHEMIN -> 3;
		case SENTIER -> 4;
		case HORSPISTE -> 5;
		case HARD -> 6;
		case HEAVYHARD -> 7;
		});
	}
	private int limitePeril(RouteTypes route) {
		return (switch(route) {
		case GRANDEVOIE -> 1;
		case ROUTE -> 2;
		case CHEMIN -> 3;
		case SENTIER -> 4;
		case HORSPISTE -> 5;
		case HARD -> 6;
		case HEAVYHARD -> 7;
		});
	}
	private int limiteDanger(RouteTypes route) {
		return (switch(route) {
		case GRANDEVOIE -> 4;
		case ROUTE -> 5;
		case CHEMIN -> 7;
		case SENTIER -> 8;
		case HORSPISTE -> 10;
		case HARD -> 11;
		case HEAVYHARD -> 12;
		});
	}
	private int limiteContrariete(RouteTypes route) {
		return (switch(route) {
		case GRANDEVOIE -> 10;
		case ROUTE -> 11;
		case CHEMIN -> 12;
		case SENTIER -> 13;
		case HORSPISTE -> 14;
		case HARD -> 15;
		case HEAVYHARD -> 16;
		});
	}
	private int limiteDesagrement(RouteTypes route) {
		return 20;
	}

	private int calculBonusBash(int m) {
		if(m <= -10) return -4;
		if(m <= -6) return -3;
		if(m <= -3) return -2;
		if(m <= -1) return -1;
		if(m <= 1) return 0;
		if(m <= 3) return 1;
		if(m <= 6) return 2;
		if(m <= 9) return 3;
		if(m <= 12) return 4;
		if(m <= 15) return 5;
		if(m >= 16) return 6;
		return 0;
	}

	private int calculMargeSurvie(int orient, int survie, int diff) {
		return survie - diff + bonusDOrientation(orient, diff);
	}

	private int bonusDOrientation(int orient, int diff) {
		int m = orient - diff;
		if(m <= -10) return -3;
		if(m <= -6) return -2;
		if(m <= -3) return -1;
		if(m <= 6) return 0;
		if(m <= 9) return 1;
		if(m <= 12) return 2;
		if(m <= 15) return 3;
		if(m >= 16) return 4;
		return 0;
	}

	private int d20() {
		return d20(0);
	}
	private int d20(int bonus) {
		Random random = new Random();
        int de = random.nextInt(20)+1;
        if(de==10) return d20(bonus+10);
        if(de==20) return d20(bonus+20);
        return de+bonus;
	}

}
