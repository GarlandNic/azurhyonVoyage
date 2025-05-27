package com.azurhyon.azurhyonVoyage.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.azurhyon.azurhyonVoyage.dto.LieuDto;

@Service
public class LieuService {
	
	public LieuDto nouveauLieux() {
		Random random = new Random();
		LieuDto lieu = new LieuDto(random.nextInt(8)+1, random.nextInt(30)+1);
		lieu.setNom(nomDuLieu(lieu));
		lieu.setDescription(descriptionDuLieu(lieu));
		return lieu;
	}

	private String nomDuLieu(LieuDto lieu) {
		return switch(lieu.getDe8()) {
			case 1 -> nomRocher(lieu.getDe30());
			case 2 -> nomEau(lieu.getDe30());
			case 3 -> nomVegetation(lieu.getDe30());
			case 4 -> nomRelief(lieu.getDe30());
			case 5 -> nomRoutier(lieu.getDe30());
			case 6 -> nomBatiment(lieu.getDe30());
			case 7 -> nomAgglo(lieu.getDe30());
			case 8 -> nomActivite(lieu.getDe30());
			default -> "";
		};
	}

	private String descriptionDuLieu(LieuDto lieu) {
		return switch(lieu.getDe8()) {
			case 1 -> descriptionRocher(lieu.getDe30());
			case 2 -> descriptionEau(lieu.getDe30());
			case 3 -> descriptionVegetation(lieu.getDe30());
			case 4 -> descriptionRelief(lieu.getDe30());
			case 5 -> descriptionRoutier(lieu.getDe30());
			case 6 -> descriptionBatiment(lieu.getDe30());
			case 7 -> descriptionAgglo(lieu.getDe30());
			case 8 -> descriptionActivite(lieu.getDe30());
			default -> "";
		};
	}
	
	private String descriptionRocher(int de30) {
		return switch(de30) {
			case 1 -> "Une pierre massive évoquant un visage figé qui crie, rit ou pleure. Il y a une légende locale à son sujet";
			case 2 -> "Des monolithes verticaux, une zone de magie très ancienne. ";
			case 3 -> "Un dolmen forme une sorte d’autel cyclopéen. Des symboles y sont gravés, usés par le temps.";
			case 4 -> "De grandes formations rocheuses verticales avec une construction au-dessus (généralement un temple). ";
			case 5 -> "Une formation rocheuse évoque un crâne brisé de quelque créature gigantesque. Le lieu dégage une aura inquiétante …";
			case 6 -> "Un culte ancien y célébrait un dieu …";
			case 7 -> "Une arche naturelle, à travers lequel le vent souffle. On dit que c’est une porte entre les mondes.";
			case 8 -> "Des roches pointues qui évoquent des lames, vestiges d’un sort de terre ?";
			case 9 -> "Une roche fendue net, la légende veut que ce soit dû au coup d’un héros mythologique";
			case 10 -> "Le vent ici produit d’étranges gémissements ou musique";
			case 11 -> "Un bloc sculpté en forme de siège gigantesque, à moitié effondré. Celui qui s’y assied est pris de visions …";
			case 12 -> "Les rochers ont la forme d’une énorme créature pétrifiée …";
			case 13 -> "Lié à une histoire d’amour locale, les amoureux viennent ici pour avoir de la chance en amour";
			case 14 -> "Cette empreinte monstrueuse figée dans la pierre serait celle d’un démon …";
			case 15 -> "Cette pierre dressée est couverte de runes très anciennes, qui nécessitent parfois certaines conditions pour être visibles";
			case 16 -> "Un mégalithe en forme d’animal";
			case 17 -> "Un étrange liquide coule de ce rocher";
			case 18 -> "Une longue roche qui semble pointer quelque chose";
			case 19 -> "Cet endroit semble attirer les fantômes";
			case 20 -> "Ce rocher est une borne qui délimite un certain territoire";
			case 21 -> "Une étrange pierre lisse …";
			case 22 -> "Un trou, entrée du monde souterrain";
			case 23 -> "Un certain type de mousse ou de lichen recouvre ce rocher";
			case 24 -> "Un chaos de pierres, vestige d’une ancienne bataille dantesque ? ";
			case 25 -> "Ces rochers ne sont pas naturels, mais à quelle civilisation appartiennent-ils ? ";
			case 26 -> "Quelle créature se terre ici ? ";
			case 27 -> "Cet endroit a des propriétés magiques inhabituelles";
			case 28 -> "Ce rocher serait tombé du ciel en des temps très reculés";
			case 29 -> "Qui a sculpté ces rochers ? A moins que ce ne soient des créatures pétrifiées ? ";
			case 30 -> "Colonnes de basalte hexagonales, colonnes naturelles et orgues, boules de pierre, désert de sel, grotte de marbre, etc.";
			default -> "description rocher";
		};
	}
	private String descriptionEau(int de30) {
		return switch(de30) {
			case 1 -> "Espace communautaire, on y apprend les rumeurs, surtout les cancans du village";
			case 2 -> "Cette fontaine sculptée représente une ancienne divinité de l’eau";
			case 3 -> "Il faut tirer de l’eau";
			case 4 -> "Un petit cours d’eau";
			case 5 -> "Un grand cours d’eau";
			case 6 -> "Une petite étendue d’eau";
			case 7 -> "Une grande étendue d’eau";
			case 8 -> "Une zone humide giboyeuse mais dangereuse";
			case 9 -> "Le puit où la source murmure …";
			case 10 -> "L’eau a un drôle de goût …";
			case 11 -> "On ne peut pas boire";
			case 12 -> "L’eau est polluée et donc non-potable. Il faut peut-être trouver la source de cette pollution ? ";
			case 13 -> "Une eau minérale pure et cristalline";
			case 14 -> "Des lucioles ou des papillons virevoltent autour du bassin (à moins que ce ne soient des moustiques ?)";
			case 15 -> "L’eau est stagnante et croupie, ceux qui la boivent risquent de tomber malades";
			case 16 -> "L’eau est naturellement chaude";
			case 17 -> "Une eau aux propriétés curatives";
			case 18 -> "L’eau est potable mais a une odeur déplaisante (ou suave ?)";
			case 19 -> "Une créature rôde sous la surface …";
			case 20 -> "L’eau est glacée, il s’agit peut-être d’une eau magique (liquide yin par exemple)";
			case 21 -> "Une eau chargée en magie ou des phénomènes étranges ont lieu autour de la source";
			case 22 -> "Il y a une divinité de l’eau qui habite ici";
			case 23 -> "Il y a un monstre aquatique";
			case 24 -> "Ce qu’on voit dans l’eau n’est pas un reflet mais une vision …";
			case 25 -> "Eau maudite couleur sang …";
			case 26 -> "Une aura de mort règne ici …";
			case 27 -> "Une cascade";
			case 28 -> "Torrent impétueux ou rivière en crue";
			case 29 -> "On voit de nombreux poissons";
			case 30 -> "Un havre de paix, l’eau semble avoir des propriétés bénéfiques";
			default -> "description point d'eau";
		};
	}
	private String descriptionVegetation(int de30) {
		return switch(de30) {
			case 1 -> "Le tronc est fendu comme une bouche. C’est une bonne cachette …";
			case 2 -> "Des buissons couverts de toiles scintillantes";
			case 3 -> "Un tapis de mousse ou de lichen particulier.";
			case 4 -> "Une plante grimpante qui bouge";
			case 5 -> "Des fleurs étranges, aux propriétés magiques";
			case 6 -> "Un arbre au tronc lisse, sans écorce ni branche. Imposant et blanc comme de l’os. ";
			case 7 -> "Une touffe d’herbes sifflantes. Le vent produit un son étrange, parfois mélodique, parfois grinçant.";
			case 8 -> "Des champignons aux couleurs vives disposés de curieuse manière.";
			case 9 -> "Ils lacèrent les vêtements si on s’y frotte.";
			case 10 -> "Un buisson couvert de baies. Elles ont une odeur sucrée, mais attirent de gros insectes. Délice ou poison ?";
			case 11 -> "Une clairière dominée par un arbre solitaire. Sa présence en impose. ";
			case 12 -> "Cette immense végétation semble sortir d’un autre temps. Elle dissimule facilement un groupe.";
			case 13 -> "Une haie de ronces entrelacées forme un mur naturel infranchissable. ";
			case 14 -> "Des plantes bizarrement alignées. Leur disposition semble obéir à une géométrie sacrée ou magique.";
			case 15 -> "Un arbre qui « saigne » une sève épaisse. ";
			case 16 -> "Un sol tapissé de feuilles mortes hors de saison, étrange.";
			case 17 -> "Un arbre couvert de fruits énormes, tous intacts. Aucun ne semble avoir été mangé par des bêtes. Pourtant, ils sont mûrs à point.";
			case 18 -> "Un vieux tronc à l’écorce gravée de motifs. Les nervures du bois forment des symboles ou visages… ou bien est-ce juste une illusion d’optique ?";
			case 19 -> "Un arbre de forme bizarre. Une légende parle de métamorphose. ";
			case 20 -> "Des racines encombrent le sol.";
			case 21 -> "Des herbes particulières, aux reflets métalliques";
			case 22 -> "Des lianes pendent des branches";
			case 23 -> "Les feuilles de ces arbres sont très particulières";
			case 24 -> "Une aura magique particulière imprègne l’endroit";
			case 25 -> "Un point de passage au-delà du Voile, vers Faërie";
			case 26 -> "Des plantes lumineuses ou fluorescentes";
			case 27 -> "Un bosquet de végétaux qui semblent fossilisés. ";
			case 28 -> "Un endroit maudit, hanté par des esprits";
			case 29 -> "Une plante magique particulière";
			case 30 -> "L’endroit est extraordinairement luxuriant ";
			default -> "description végétation";
		};
	}
	private String descriptionRelief(int de30) {
		return switch(de30) {
			case 1 -> "Une avancée de pierre abrupte, idéale pour un point de vue, un nid de prédateur ou une vigie.";
			case 2 -> "Un monticule recouvert de végétation, de ruines ou autre. Visible de loin, parfois sacré.";
			case 3 -> "Étroit, encaissé, ombragé même en plein jour. Le vent y souffle en longs soupirs.";
			case 4 -> "Une formation volcanique rectiligne, sombre et lisse comme du verre noirci.";
			case 5 -> "Difficile d’accès, mais caché et fertile. Peut contenir un microclimat ou une créature retirée.";
			case 6 -> "Immense et ouvert, sans abri. On peut y voir l’orage approcher à des lieues.";
			case 7 -> "Le relief change chaque jour. Pièges de sable, mirages, ou créatures camouflées.";
			case 8 -> "Des paliers de pierre, d’argile ou de tuf. L’eau y ruisselle en cas de pluie.";
			case 9 -> "Entouré de falaises, il peut abriter un glacier, un lac, un village, ou un culte secret.";
			case 10 -> "Volcan ou chute de météorite ? Son fond est fertile… ou maudit.";
			case 11 -> "Habitat de rongeurs, ou de créatures moins inoffensives. Parfois habité par des ermites ou des esprits.";
			case 12 -> "Un passage resserré parfait pour une embuscade… ou un contrôle par un groupe local (et un péage).";
			case 13 -> "Pierres fraîches, troncs brisés, faune dispersée. Peut bloquer une route ou dévoiler une grotte.";
			case 14 -> "Un sol fissuré, blanc ou rouge, qui craque sous les pas. Rien ne pousse.";
			case 15 -> "Un sentier étroit qui suit la ligne sommitale. Vertigineux et magnifique.";
			case 16 -> "Un réseau inextricable de creux et canaux secs, parfait pour perdre quelqu’un… ou s’y perdre.";
			case 17 -> "Une paroi trouée de niches, autrefois des nids ou des tombes.";
			case 18 -> "La pente forme un triangle parfait ou une spirale naturelle. Mystère d’érosion ou œuvre ancienne ?";
			case 19 -> "Un surplomb étroit prêt à céder. On peut s’y tenir… ou s’y piéger.";
			case 20 -> "Un vieux lit de rivière transformé en route naturelle, douce et sinueuse.";
			case 21 -> "Rythmant le paysage de petites ondulations, elles forment une chaîne douce et régulière.";
			case 22 -> "Fertile, abritée entre deux chaînes de collines ou montagnes, souvent habitée ou cultivée.";
			case 23 -> "Plate, ouverte, balayée par le vent. Le ciel y semble immense.";
			case 24 -> "Élévation modeste longeant un chemin, formée par l’érosion ou une ancienne construction.";
			case 25 -> "Un point un peu plus haut dans une forêt, souvent utilisé pour observer ou établir un camp.";
			case 26 -> "Un léger creux du terrain où l’eau stagne. Joncs, insectes, brume matinale fréquente.";
			case 27 -> "Une longue élévation linéaire, couverte de végétation. Peut cacher une ancienne frontière ou servir de refuge.";
			case 28 -> "Une sorte de bol naturel dans le sol, parfois inondé en saison. Utilisé pour les cultures ou les campements.";
			case 29 -> "Passage naturel pour franchir des reliefs. Convoité, gardé ou simplement emprunté depuis des siècles.";
			case 30 -> "Colline ou promontoire d’où l’on voit loin. Lieu de guet, de prière ou d’anciens rituels.";
			default -> "description relief";
		};
	}
	private String descriptionRoutier(int de30) {
		return switch(de30) {
			case 1 -> "Gravée de chiffres illisibles, vestige d’un empire ancien.";
			case 2 -> "En bordure, couvert d’offrandes : galets, fleurs, pièces, rubans.";
			case 3 -> "Trois directions, sans indication. Marqué de traces récentes.";
			case 4 -> "Les voyageurs y laissent des lettres, objets, ou mots codés.";
			case 5 -> "Sur un ruisseau. Un panneau indique une limite de poids douteuse.";
			case 6 -> "Ici est mort un voyageur. Des pierres sont empilées par les passants.";
			case 7 -> "Symbole de protection ou d’avertissement.";
			case 8 -> "Certaines flèches ont été tournées ou brisées.";
			case 9 -> "Vestige de route commerçante";
			case 10 -> "Officiel… ou auto-proclamé. Tarif variable selon l'humeur.";
			case 11 -> "Pierres disjointes, herbe entre les dalles. Témoignage d’un passé glorieux.";
			case 12 -> "Marques de randonneurs, signes de piste, langage des druides ?";
			case 13 -> "Nœuds colorés attachés à ses branches, pour la chance ou la mémoire.";
			case 14 -> "Ou pied de statue antique brisée. Ce qu’elle représentait ou signalait est oublié depuis longtemps.";
			case 15 -> "Ouverte ou fermée. Marque un territoire. ";
			case 16 -> "Un ouvrage d’art important. Peut aussi être un aqueduc. ";
			case 17 -> "Une grange, une bergerie ou une écurie";
			case 18 -> "Gravée sur une paroi rocheuse, montre des cavaliers, des dieux ou une route menant à un lieu mythique.";
			case 19 -> "Creusé dans la falaise, avec icônes ou bougies éteintes.";
			case 20 -> "On ne passe qu’à marée basse. Des os flottent parfois dans l’eau.";
			case 21 -> "Empilement de cailloux. Symbole de passage, de prière, ou d’alerte.";
			case 22 -> "Roue brisée, caisse ouverte… ou piège tendu ? ";
			case 23 -> "Peut contenir des caches, des messages ou un serpent.";
			case 24 -> "Masque sculpté, une tradition locale ou un artiste fou ?";
			case 25 -> "Petit refuge rudimentaire contre le vent ou la pluie.";
			case 26 -> "Lieu de pause fréquent. Gravures de noms et de cœurs.";
			case 27 -> "Peut marquer une limite symbolique ou mystique, à franchir prudemment";
			case 28 -> "Surveille la route et protège les voyageurs";
			case 29 -> "Barrière végétale, mais des traces fraîches mènent à l’intérieur.";
			case 30 -> "Pont, bac, entrée de bourg ou de ville";
			default -> "description repère routier";
		};
	}
	private String descriptionBatiment(int de30) {
		return switch(de30) {
			case 1 -> "Un petit lieu de culte rural, simple mais recueilli";
			case 2 -> "Occupé par une congrégation religieuse";
			case 3 -> "Un lieu de culte assez important";
			case 4 -> "Autel de bord de route";
			case 5 -> "Un espace naturel dédié à des divinités anciennes";
			case 6 -> "Champs autour, porcherie, bruit de bétail. Accueil parfois méfiant.";
			case 7 -> "Mur d’enceinte, bâtiments en pierre, sentinelle.";
			case 8 -> "Cendres froides, restes de repas, traces de lutte, silence pesant.";
			case 9 -> "Verger bien taillé, potager garni, mais personne en vue.";
			case 10 -> "Surveille les environs. Avec système de drapeaux ou feux.";
			case 11 -> "Délabré, noblesse sur le déclin";
			case 12 -> "Un édifice imposant, appartenant à un puissant";
			case 13 -> "Une construction étrange";
			case 14 -> "Parfois encore utilisée pour dormir ou observer. Graffitis, le sous-sol peut être accessible.";
			case 15 -> "Avec écuries et personnel ";
			case 16 -> "Peu fréquentée, très « couleur locale »";
			case 17 -> "Accepte d’accueillir des voyageurs";
			case 18 -> "Tables en bois, tonneaux vides, pancarte « Fermé pour cause d’invasion ».";
			case 19 -> "Pleine de voyageurs, un bon endroit pour faire des rencontres et prendre des nouvelles. ";
			case 20 -> "Repos sous la falaise, graffiti de voyageurs.";
			case 21 -> "Ailes grinçantes, meunier bourru, farine dans l’air.";
			case 22 -> "Pont de bois, ruche bourdonnante, vieux chien qui grogne en dormant.";
			case 23 -> "Au bord d’un ruisseau, odeurs de sève, planches empilées, hache plantée dans une souche.";
			case 24 -> "Ambiance brûlante, bruit métallique. L’artisan parle peu.";
			case 25 -> "Four calciné, mur rougeâtre, cachette potentielle.";
			case 26 -> "Baraquements vide, entrée bouchée, outils rouillés.";
			case 27 -> "Feux de camp encore tièdes.";
			case 28 -> "Ambiance mystérieuse. ";
			case 29 -> "Etroit, sombre et spartiate, mais protège des intempéries";
			case 30 -> "Signe décoloré, éclats de verre au sol. Des rires étouffés s’entendent parfois. Repaire de canailles. ";
			default -> "description bâtiment";
		};
	}
	private String descriptionAgglo(int de30) {
		return switch(de30) {
			case 1 -> "Tentes ou roulottes, chevaux harnachés, un ancien conteur près du feu.";
			case 2 -> "Un capitaine désabusé et des sentinelles peu bavardes.";
			case 3 -> "Bûcherons ou autres, bruyant le jour, silencieux et sombre la nuit.";
			case 4 -> "Ont des marchandises exotiques. Des gardes protègent le convoi. ";
			case 5 -> "Une ambiance priante et mystique. ";
			case 6 -> "Maisons reliées par des passerelles branlantes, moustiques en nuée.";
			case 7 -> "Quelques chaumières. Peuple rustique, toujours méfiant envers les étrangers.";
			case 8 -> "En ruine ou récemment abandonné. Que sont devenus les habitants ?  ";
			case 9 -> "Autour d’un puits ou d’un arbre sacré. Chaque maison arbore un symbole protecteur peint.";
			case 10 -> "Creusé dans un flanc de colline. Discret mais des cris d’enfants ou une forte odeur trahissent sa présence. ";
			case 11 -> "Avec pont de pierre et petit moulin. Rivière tranquille, grenier communal sous clé.";
			case 12 -> "Entouré d’un fossé et d’une palissade de pieux acérés.";
			case 13 -> "L’arbre sert de lieu de culte, de rendez-vous et de refuge.";
			case 14 -> "Charpente fraîche, travaux encore visibles, tension palpable.";
			case 15 -> "Il s’y passe des choses inquiétantes. Il est hanté par des esprits. ";
			case 16 -> "Chaque maison surplombe la suivante, ça grimpe raide. ";
			case 17 -> "Toits moussus, clairière centrale, barde à l’auberge.";
			case 18 -> "Une moitié en ruines, l’autre occupée par une poignée d’irréductibles.";
			case 19 -> "Apothicaires, guérisseuses, rumeurs d’un herboriste exilé.";
			case 20 -> "Maisons en pierre, filets suspendus, chants marins le soir.";
			case 21 -> " Peaux de bêtes rares, potions douteuses, herbes interdites.";
			case 22 -> "Place centrale pavée, halle marchande couverte, maire tatillon.";
			case 23 -> "Ruelles en pente raide, cloche qui sonne à toute intrusion.";
			case 24 -> "Barques chargées, docks bruyants, contrebandiers discrets.";
			case 25 -> "Sentinelles sur les toits, taxes à l’entrée, méfiance palpable.";
			case 26 -> "Auberges pleines, poussière noire dans l’air, bagarres fréquentes.";
			case 27 -> "Encens, cloches, reliques exhibées sur la place du marché.";
			case 28 -> "Peu d’enfants, regards fuyants, autel aux morts.";
			case 29 -> "Ateliers précieux, grande fierté locale, coût de vie élevé.";
			case 30 -> "Conserve les anciennes traditions, des fêtes et des rites ancestraux";
			default -> "description agglomération";
		};
	}
	private String descriptionActivite(int de30) {
		return switch(de30) {
			case 1 -> "Un paysage structuré, presque géométrique, où l’homme a maîtrisé la terre.";
			case 2 -> "Travail de générations, chaque niveau témoigne d’un effort ancien.";
			case 3 -> "Odeurs sucrées, bourdonnement d’abeilles, fruits tombés au sol, bordé de haies basses.";
			case 4 -> "Sur les pentes d’un coteau ensoleillé, en rangs parfaits, cabane de vigneron au sommet.";
			case 5 -> "Fumée montant en colonnes lentes. Paysage noirci, âcre, presque désolé.";
			case 6 -> "Ondoyant sous le vent, un tapis doré jusqu’à l’horizon, sillonné par des chemins de terre.";
			case 7 -> "Chacun montre une culture différente : lin, fèves, navets, etc.";
			case 8 -> "Sur un versant brumeux, petits sentiers étroits entre les buissons odorants.";
			case 9 -> "Clos de bois tordu ou de cordes, taches de verdure joyeuse";
			case 10 -> "Herbe haute, oiseaux en nombre, eau claire canalisée. ";
			case 11 -> "Cabanes de bergers en pierre sèche, clochettes au loin, moutons dispersés, fromages affinés.";
			case 12 -> "Vaches paisibles, seau de traite, sentier de terre.";
			case 13 -> "Touffes de laine, cris de bêtes.";
			case 14 -> "Parsemées de fleurs sauvages, traces de sabots dans la boue.";
			case 15 -> "Sable remué, hennissements, silhouettes en armure d’entraînement.";
			case 16 -> "Pré bordé de pierres levées anciennes. ";
			case 17 -> "Ancienne route des troupeaux, marquée par des ornières profondes, herbe foulée, buissons écorchés.";
			case 18 -> "Mélange de roche et de paille, odeur de bétail persistante.";
			case 19 -> "Séparées par des digues de terre, réflexion du ciel dans l’eau.";
			case 20 -> "Troncs abattus et meules de bois empilées, sifflets de scieurs, odeur de résine et sciure fraîche.";
			case 21 -> "Escaliers creusés dans la roche, éclats blancs ou ocre, poussière en suspension.";
			case 22 -> "Sol instable, puits comblés, quelques cabanes effondrées.";
			case 23 -> "Protégées par une palissade basse, bourdonnement constant";
			case 24 -> "Charbon craquant, bruit métallique, brasier rougeoyant.";
			case 25 -> "Grincements, ruines annexes, herbes hautes envahissantes.";
			case 26 -> "Odeur prenante, peaux étendues, fosses sombres, teintes ocre et brunes.";
			case 27 -> "Sous une canopée dense, sol retourné, chiens fouineurs, silence feutré.";
			case 28 -> "Cimetière rural entretenu, ancienne nécropole ou site funéraire antique oublié …";
			case 29 -> "Lieu de passage des marchands, avec entrepôts, puits central, ânes attachés à l’ombre.";
			case 30 -> "Lieu d’un carnage plus ou moins récent, présence de charognards ou d’esprits. ";
			default -> "description activité et paysage";
		};
	}

	private String nomRocher(int de30) {
		return switch(de30) {
			case 1 -> "Le Rocher-Face";
			case 2 -> "Les Menhirs";
			case 3 -> "Le Dolmen";
			case 4 -> "Les Météores";
			case 5 -> "Le Crâne";
			case 6 -> "La Roche Sacrificielle";
			case 7 -> "L’Arche";
			case 8 -> "Les Épées";
			case 9 -> "La Faille";
			case 10 -> "Le Son des Pierres";
			case 11 -> "Le Trône";
			case 12 -> "Le Géant pétrifié";
			case 13 -> "Le Rocher des Amoureux";
			case 14 -> "L’Empreinte du Diable";
			case 15 -> "Le Mégalithe Gravé";
			case 16 -> "Le Totem de Pierre";
			case 17 -> "Le Roc qui Suinte";
			case 18 -> "Le Doigt / l’Aiguille / Le Croc";
			case 19 -> "Le Roc aux Esprits";
			case 20 -> "La Borne";
			case 21 -> "La Pierre Inconnue";
			case 22 -> "Le Gouffre";
			case 23 -> "La Moussue";
			case 24 -> "Le Chaos";
			case 25 -> "Les Ruines";
			case 26 -> "Le Nid / Repaire / Tanière";
			case 27 -> "La Zone Magique";
			case 28 -> "La Pierre Céleste";
			case 29 -> "Les Sculptures";
			case 30 -> "La Curiosité Géologique";
			default -> "Rocher de forme caractéristique";
		};
	}
	private String nomEau(int de30) {
		return switch(de30) {
			case 1 -> "Le Lavoir";
			case 2 -> "La Fontaine";
			case 3 -> "Le Puits";
			case 4 -> "Le Ruisseau";
			case 5 -> "La Rivière";
			case 6 -> "La Mare";
			case 7 -> "Le Lac";
			case 8 -> "Le Marais";
			case 9 -> "Le Chuchoteur";
			case 10 -> "Drôle de Goût";
			case 11 -> "A Sec / Gelé";
			case 12 -> "Polluée";
			case 13 -> "Pure";
			case 14 -> "Le Bassin aux Lucioles";
			case 15 -> "Eau Croupie";
			case 16 -> "Eau Chaude";
			case 17 -> "Eau Thermale";
			case 18 -> "Eau Soufrée";
			case 19 -> "Créature";
			case 20 -> "Glacée";
			case 21 -> "Eau Étrange";
			case 22 -> "Naïade";
			case 23 -> "Monstre";
			case 24 -> "Reflets";
			case 25 -> "Sanglante";
			case 26 -> "Mortelle";
			case 27 -> "Cascade";
			case 28 -> "Tumultueuse";
			case 29 -> "Poissonneuse";
			case 30 -> "Féérique";
			default -> "Point d'eau";
		};
	}
	private String nomVegetation(int de30) {
		return switch(de30) {
			case 1 -> "L’Arbre Creux";
			case 2 -> "Entoilée";
			case 3 -> "Mousse";
			case 4 -> "Plante Grimpante";
			case 5 -> "Fleurs Etranges";
			case 6 -> "Arbre Blanc";
			case 7 -> "Sifflante";
			case 8 -> "Champignons";
			case 9 -> "Epineux";
			case 10 -> "Baies";
			case 11 -> "Arbre Solitaire";
			case 12 -> "Géante";
			case 13 -> "Mur";
			case 14 -> "Forme";
			case 15 -> "Saignant";
			case 16 -> "Feuilles Mortes";
			case 17 -> "Fruits";
			case 18 -> "Ridé";
			case 19 -> "Biscornu";
			case 20 -> "Racines";
			case 21 -> "Herbes";
			case 22 -> "Lianes";
			case 23 -> "Feuilles";
			case 24 -> "Magique";
			case 25 -> "Féérique";
			case 26 -> "Lumineux";
			case 27 -> "Pétrifié";
			case 28 -> "Aura de Mort";
			case 29 -> "Plante Magique";
			case 30 -> "Luxuriant";
			default -> "Végétation";
		};
	}
	private String nomRelief(int de30) {
		return switch(de30) {
			case 1 -> "Éperon rocheux";
			case 2 -> "Butte isolée";
			case 3 -> "Canyon tortueux";
			case 4 -> "Muraille naturelle";
			case 5 -> "Ravin envahi de végétation";
			case 6 -> "Plateau battu par les vents";
			case 7 -> "Champ de dunes mouvantes";
			case 8 -> "Terrasses en escalier";
			case 9 -> "Cirque rocheux en fer à cheval";
			case 10 -> "Cratère ";
			case 11 -> "Flanc de colline parsemé de terriers";
			case 12 -> "Étranglement rocheux dans une vallée";
			case 13 -> "Éboulement récent";
			case 14 -> "Croûte saline ou rocheuse";
			case 15 -> "Chemin de crête";
			case 16 -> "Labyrinthe de ravines";
			case 17 -> "Escarpement avec cavités naturelles";
			case 18 -> "Monticule aux lignes géométriques étranges";
			case 19 -> "Corniche fragile";
			case 20 -> "Chemin sculpté par l’eau";
			case 21 -> "Collines douces et arrondies";
			case 22 -> "Large vallée verdoyante";
			case 23 -> "Plaine herbeuse à perte de vue";
			case 24 -> "Talus bordant un sentier";
			case 25 -> "Hauteur boisée ou promontoire forestier";
			case 26 -> "Dépression humide ou marécageuse";
			case 27 -> "Ligne de crête boisée";
			case 28 -> "Bassin peu profond ou cuvette sèche";
			case 29 -> "Petit col entre deux sommets";
			case 30 -> "Éminence isolée avec vue dégagée";
			default -> "Relief";
		};
	}	
	private String nomRoutier(int de30) {
		return switch(de30) {
			case 1 -> "Borne";
			case 2 -> "Autel aux dieux des chemins";
			case 3 -> "Carrefour en forme de patte d’oie";
			case 4 -> "Arbre creux à message";
			case 5 -> "Pont de bois grinçant";
			case 6 -> "Stèle funéraire solitaire";
			case 7 -> "Symbole religieux ou poteau totémique";
			case 8 -> "Panneau indicateur";
			case 9 -> "Ruines d’un bâtiment";
			case 10 -> "Péage tenu par des hommes en armes";
			case 11 -> "Vestige de chaussée pavée";
			case 12 -> "Rocher gravé de symboles";
			case 13 -> "Arbre aux rubans";
			case 14 -> "Colonne brisée";
			case 15 -> "Vieille barrière";
			case 16 -> "Pont de pierre";
			case 17 -> "Un Toit bienvenu";
			case 18 -> "Fresque";
			case 19 -> "Petit sanctuaire troglodytique";
			case 20 -> "Gué marqués par des piquets";
			case 21 -> "Cairn";
			case 22 -> "Chariot renversé";
			case 23 -> "Mur de pierres sèches longeant la route";
			case 24 -> "Croisement marqué par une effigie grotesque";
			case 25 -> "Abri rocheux";
			case 26 -> "Tronc taillé en banc rustique";
			case 27 -> "Portail de bois";
			case 28 -> "Poste de garde";
			case 29 -> "Entrée de chemin secondaire dissimulée";
			case 30 -> "Péage";
			default -> "Repère routier";
		};
	}
	private String nomBatiment(int de30) {
		return switch(de30) {
			case 1 -> "Chapelle";
			case 2 -> "Monastère";
			case 3 -> "Temple";
			case 4 -> "Petit Sanctuaire";
			case 5 -> "Lieu Sacré";
			case 6 -> "Ferme en activité";
			case 7 -> "Ferme fortifiée";
			case 8 -> "Ruine de ferme";
			case 9 -> "Maison isolée";
			case 10 -> "Tour de guet";
			case 11 -> "Petit château";
			case 12 -> "Grand château";
			case 13 -> "Tour de mage";
			case 14 -> "Tour en ruine";
			case 15 -> "Relais de diligence";
			case 16 -> "Auberge rustique";
			case 17 -> "Habitation ";
			case 18 -> "Chantier désaffecté";
			case 19 -> "Auberge prospère";
			case 20 -> "Grotte";
			case 21 -> "Moulin à vent";
			case 22 -> "Moulin à eau";
			case 23 -> "Scierie ";
			case 24 -> "Forge solitaire";
			case 25 -> "Ancienne briqueterie";
			case 26 -> "Mine abandonnée";
			case 27 -> "Campement ";
			case 28 -> "Maison d’ermite";
			case 29 -> "Refuge minuscule";
			case 30 -> "Maison de passe";
			default -> "Bâtiment isolé";
		};
	}
	private String nomAgglo(int de30) {
		return switch(de30) {
			case 1 -> "Campement de nomades";
			case 2 -> "Camp militaire";
			case 3 -> "Campement de travailleurs";
			case 4 -> "Camp de marchands de passage";
			case 5 -> "Campement de pèlerins";
			case 6 -> "Hameau sur pilotis dans un marais";
			case 7 -> "Hameau de montagne";
			case 8 -> "Hameau désert";
			case 9 -> "Habitations en demi-cercle ";
			case 10 -> "Hameau troglodytique";
			case 11 -> "Village paisible au bord de l’eau";
			case 12 -> "Village fortifié";
			case 13 -> "Village circulaire autour d’un arbre gigantesque";
			case 14 -> "Village en bois reconstruit après un incendie récent";
			case 15 -> "Village sur un ancien cimetière";
			case 16 -> "Village en terrasse à flanc de montagne";
			case 17 -> "Village champignon dans une forêt dense";
			case 18 -> "Village à moitié abandonné";
			case 19 -> "Village entouré de champs de fleurs médicinales";
			case 20 -> "Village de pêcheurs ";
			case 21 -> "Bourg au marché renommé pour ses produits étranges";
			case 22 -> "Petite bastide aux rues géométriques";
			case 23 -> "Castrum médiéval sur promontoire rocheux";
			case 24 -> "Bourg fluvial avec port actif";
			case 25 -> "Bourg frontalier avec garnison d’archers";
			case 26 -> "Bourg minier en pleine expansion";
			case 27 -> "Bourg religieux avec cloître et pèlerins";
			case 28 -> "Bourg sinistré par une maladie";
			case 29 -> "Bourg tourné vers l’artisanat d’élite";
			case 30 -> "Bourg païen ";
			default -> "Agglomération";
		};
	}
	private String nomActivite(int de30) {
		return switch(de30) {
			case 1 -> "Champs cultivés à perte de vue";
			case 2 -> "Terrasses agricoles à flanc de colline";
			case 3 -> "Verger en fleurs";
			case 4 -> "Vignoble";
			case 5 -> "Champs brûlés";
			case 6 -> "Céréales";
			case 7 -> "Petits champs morcelés ";
			case 8 -> "Plantation de thé ou d’herbes médicinales ";
			case 9 -> "Jardins potagers communautaires";
			case 10 -> "Prairie irriguée";
			case 11 -> "Alpages ";
			case 12 -> "Clairière aménagée en pâture";
			case 13 -> "Enclos pour la tonte ";
			case 14 -> "Prairies d’estive ";
			case 15 -> "Carrière de chevaux";
			case 16 -> "Zone de pâturage libre";
			case 17 -> "Aire de transhumance";
			case 18 -> "Bergeries";
			case 19 -> "Rizières ou marais salants";
			case 20 -> "Casse forestière";
			case 21 -> "Carrière de pierre à ciel ouvert";
			case 22 -> "Zone de charbonnage abandonnée";
			case 23 -> "Ruches sur une colline fleurie";
			case 24 -> "Forge rurale";
			case 25 -> "Ancien moulin à eau";
			case 26 -> "Tannerie";
			case 27 -> "Culture de champignons";
			case 28 -> "Cimetière";
			case 29 -> "Caravansérail";
			case 30 -> "Champ de bataille";
			default -> "Activité et paysage";
		};
	}



}
