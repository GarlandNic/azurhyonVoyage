package com.azurhyon.azurhyonVoyage.Initialisation;

import com.azurhyon.azurhyonVoyage.model.EffetMeteo;
import com.azurhyon.azurhyonVoyage.model.TableMeteo;

import java.util.List;

import com.azurhyon.azurhyonVoyage.dto.MeteoDto.*;

public class MeteoInit {
    public static final TableMeteo METEO = new TableMeteo();
    
	public static int tpsToInt(String temps) {
		if(temps == null) return 8;
		return switch(temps) {
			case "AB" -> 1;
			case "B" -> 2;
			case "TB" -> 3;
			case "TM" -> 5;
			case "M" -> 6;
			case "AM" -> 7;
			default -> 8;
		};
	}

    static {
        METEO.ajouter(Climats.POLAIRE,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Frais (rare)", "pas de vent", "sec", "ciel très ensoleillé")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Froid, vent faible, sec, ciel ensoleillé")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Froid, vent faible, normal, ciel légèrement couvert, sec")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Froid, vent moyen, normal, ciel couvert, gel")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Très froid, vent moyen, sec, ciel très couvert, poudreuse")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Glacial, vent fort, sec, ciel sombre, tempête de neige")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Glacial, pas de vent, sec, ciel limpide")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Très froid, pas de vent, sec, ciel légèrement couvert")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Très froid, vent faible, sec, ciel nuageux, sec")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Très froid, vent moyen, sec, ciel gris, givre")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("Glacial, vent fort, sec, ciel couvert, poudrerie continue")
                )
            );
        METEO.ajouter(Climats.POLAIRE,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Froid extrême, vent violent, très sec, ciel sombre, blizzard")
                )
            );
        
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Chaleur douce, pas de vent, sec, ciel très ensoleillé")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Bon ou chaud, vent faible, sec, ciel ensoleillé, sec")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Bon, vent faible, normal, ciel légèrement couvert, sec")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Bon, vent faible, normal, ciel nuageux, averses légères")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Frais, vent moyen, humide, ciel couvert, pluie froide")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Froid, vent fort, humide, ciel sombre, pluie glacée")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Froid sec, pas de vent, sec, ciel limpide")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Froid, pas de vent, sec, ciel ensoleillé, sec")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Très froid, vent faible, sec, ciel légèrement couvert, sec")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Froid, vent moyen, sec, ciel couvert, gel")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("Très froid, vent fort, sec, ciel très couvert, neige")
                )
            );
        METEO.ajouter(Climats.SUBARCTIQUE,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Glacial, vent violent, sec, ciel sombre, blizzard")
                )
            );
        
        METEO.ajouter(Climats.CONTINENTAL,Saisons.PRINTEMPS,tpsToInt("TM"),
                new EffetMeteo(List.of("Pluie froide, vent for, grêle")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.PRINTEMPS,tpsToInt("M"),
                new EffetMeteo(List.of("Pluie froide, ciel plombé")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.PRINTEMPS,tpsToInt("AM"),
                new EffetMeteo(List.of("Temps changeant, ciel gris, crachin, fraîcheur humide")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.PRINTEMPS,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps doux, nuages dispersés, frais mais ensoleillé")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.PRINTEMPS,tpsToInt("B"),
                new EffetMeteo(List.of("Air doux, ciel clair, ensoleillé")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.PRINTEMPS,tpsToInt("TB"),
                new EffetMeteo(List.of("Ciel dégagé, soleil, température agréable")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Canicule, orages, vent chaud")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Chaleur accablante, ciel couvert, pluie chaude")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Temps lourd, chaleur humide")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Chaud mais supportable, ciel ensoleillé mais nuageux")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Chaud, sec, ciel dégagé, brise agréable")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Chaleur douce, ciel limpide, air sec, soleil radieux")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.AUTOMNE,tpsToInt("TM"),
                new EffetMeteo(List.of("Pluie froide, rafales violentes, ciel noir")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.AUTOMNE,tpsToInt("M"),
                new EffetMeteo(List.of("Vent fort, ciel couvert, air frais")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.AUTOMNE,tpsToInt("AM"),
                new EffetMeteo(List.of("Fraîcheur humide, ciel gris")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.AUTOMNE,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps frais, ciel voilé")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.AUTOMNE,tpsToInt("B"),
                new EffetMeteo(List.of("Douceur automnale, ciel dégagé")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.AUTOMNE,tpsToInt("TB"),
                new EffetMeteo(List.of("Lumière dorée, air sec, ciel clair, fraîcheur agréable")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Tempête de neige, froid glacial, vent violent")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("Chutes de neige, ciel sombre, Froid intense, vent glacial")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Neige ou verglas, froid, vent, ciel couvert")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Froid sec, ciel voilé mais éclaircies")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Temps sec, frais mais lumineux, ciel dégagé")
                )
            );
        METEO.ajouter(Climats.CONTINENTAL,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Frais, sec, ciel bleu profond")
                )
            );
        
        METEO.ajouter(Climats.TEMPERE,Saisons.PRINTEMPS,tpsToInt("TM"),
                new EffetMeteo(List.of("Giboulées (orages de grêle, pluie froide), vent fort")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.PRINTEMPS,tpsToInt("M"),
                new EffetMeteo(List.of("Forte pluie, fraîcheur")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.PRINTEMPS,tpsToInt("AM"),
                new EffetMeteo(List.of("Nuages et averses, fraîcheur, ou nuages épais, bruine")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.PRINTEMPS,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps doux, ciel changeant ou frais mais dégagé")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.PRINTEMPS,tpsToInt("B"),
                new EffetMeteo(List.of("Soleil doux, ciel bleu")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.PRINTEMPS,tpsToInt("TB"),
                new EffetMeteo(List.of("Soleil éclatant, brise légère")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Orages violents, chaleur humide")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Temps lourd, pluie orageuse, moiteur")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Chaleur humide et nuages bas")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Chaud, ciel partiellement dégagé")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Chaleur modérée, ciel bleu, vent léger")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Soleil franc, brise douce, air sec")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.AUTOMNE,tpsToInt("TM"),
                new EffetMeteo(List.of("Bourrasques, vent fort, pluie froide.")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.AUTOMNE,tpsToInt("M"),
                new EffetMeteo(List.of("Pluie régulière, vent moyen, froid humide, ciel couvert")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.AUTOMNE,tpsToInt("AM"),
                new EffetMeteo(List.of("Nuages gris, humidité, fraîcheur")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.AUTOMNE,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps doux, ciel voilé, frais mais lumineux")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.AUTOMNE,tpsToInt("B"),
                new EffetMeteo(List.of("Temps clair, air vif soleil bas")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.AUTOMNE,tpsToInt("TB"),
                new EffetMeteo(List.of("Journée ensoleillée et sèche, ciel limpide")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Tempête, neige ou verglas, vent glacial")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("froid humide, neige/pluie froide, ciel gris")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Humidité, froid modéré, gel, ciel gris")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Froid sec, ciel assez lumineux")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Froid doux, soleil hivernal")
                )
            );
        METEO.ajouter(Climats.TEMPERE,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Air vif, ciel bleu, soleil")
                )
            );

        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.PRINTEMPS,tpsToInt("TM"),
                new EffetMeteo(List.of("Orage violent, grêle, rafales violentes")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.PRINTEMPS,tpsToInt("M"),
                new EffetMeteo(List.of("Pluie soudaine, ciel sombre, humidité")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.PRINTEMPS,tpsToInt("AM"),
                new EffetMeteo(List.of("Temps variable, nuageux, humide")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.PRINTEMPS,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps variable, nuageux, humide")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.PRINTEMPS,tpsToInt("B"),
                new EffetMeteo(List.of("Chaleur douce, soleil généreux, ciel clair")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.PRINTEMPS,tpsToInt("TB"),
                new EffetMeteo(List.of("Temps radieux, ciel dégagé, brise légère")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Canicule, air très sec, sirocco (vents brûlants)")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Très chaud, poussière, ciel blanc")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Chaleur sèche, ciel voilé, vent faible")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Chaud avec brise marine")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Chaleur modérée, ciel limpide")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Brise fraîche, soleil doux, ciel limpide")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.AUTOMNE,tpsToInt("TM"),
                new EffetMeteo(List.of("Orage cévenol, pluie diluvienne")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.AUTOMNE,tpsToInt("M"),
                new EffetMeteo(List.of("Averses intenses, vent irrégulier")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.AUTOMNE,tpsToInt("AM"),
                new EffetMeteo(List.of("Temps instable, ciel changeant, humidité")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.AUTOMNE,tpsToInt("AB"),
                new EffetMeteo(List.of("Chaleur résiduelle, temps clair avec fraîcheur, ciel voilé")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.AUTOMNE,tpsToInt("B"),
                new EffetMeteo(List.of("Doux, soleil présent")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.AUTOMNE,tpsToInt("TB"),
                new EffetMeteo(List.of("Ciel azur, lumière dorée, douceur, vent faible")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Vent violent, pluie froide, ciel bas")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("Pluie, ciel gris, vent, temps humide, froid modéré")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Nuageux, air frais, humide, vents côtiers")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Frais mais lumineux, temps doux, quelques nuages")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Ciel bleu, température douce")
                )
            );
        METEO.ajouter(Climats.MEDITERRANEEN,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Soleil, pas de vent, air doux")
                )
            );

        METEO.ajouter(Climats.SAVANE,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Caniculaire, pas de vent, sec, ciel très ensoleillé, sec")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Très chaud, pas de vent, sec, ciel ensoleillé, sec")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Chaud, vent faible, normal, ciel légèrement couvert, sec")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Chaud, vent faible, humide, ciel nuageux, averse")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Très chaud, vent moyen, très humide, ciel couvert, forte pluie")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Très chaud, vent fort, moite, ciel sombre, orage tropical")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Chaleur sèche, pas de vent, air limpide, ciel bleu intense")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Très chaud, pas de vent, sec, ciel très ensoleillé")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Très chaud, vent faible, sec, ciel dégagé")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Chaud, vent moyen, sec, ciel légèrement couvert, sec")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("Très chaud, pas de vent, sec, ciel très ensoleillé")
                )
            );
        METEO.ajouter(Climats.SAVANE,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Chaleur sèche, pas de vent, air limpide, ciel bleu intense")
                )
            );

        METEO.ajouter(Climats.EQUATORIAL,Saisons.PRINTEMPS,tpsToInt("TB"),
                new EffetMeteo(List.of("Soleil éclatant, chaleur stable, légère brise, air étonnamment sec pour la région")
                )
            );
        METEO.ajouter(Climats.EQUATORIAL,Saisons.PRINTEMPS,tpsToInt("B"),
                new EffetMeteo(List.of("Chaleur agréable, ciel ensoleillé avec quelques nuages, humidité normale")
                )
            );
        METEO.ajouter(Climats.EQUATORIAL,Saisons.PRINTEMPS,tpsToInt("AB"),
                new EffetMeteo(List.of("Chaleur stable, ciel légèrement couvert, air humide mais calme")
                )
            );
        METEO.ajouter(Climats.EQUATORIAL,Saisons.PRINTEMPS,tpsToInt("AM"),
                new EffetMeteo(List.of("Ciel très couvert, chaleur moite, petite pluie fréquente")
                )
            );
        METEO.ajouter(Climats.EQUATORIAL,Saisons.PRINTEMPS,tpsToInt("M"),
                new EffetMeteo(List.of("Grosse averse chaude, ciel sombre, atmosphère moite, vent moyen")
                )
            );
        METEO.ajouter(Climats.EQUATORIAL,Saisons.PRINTEMPS,tpsToInt("TM"),
                new EffetMeteo(List.of("Orage tropical violent, forte chaleur moite, vent fort, pluie torrentielle, visibilité réduite")
                )
            );

        METEO.ajouter(Climats.MOUSSON,Saisons.PRINTEMPS,tpsToInt("TM"),
                new EffetMeteo(List.of("Chaleur moite, pluie soudaine, orages, vents chauds")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.PRINTEMPS,tpsToInt("M"),
                new EffetMeteo(List.of("Temps instable, humidité croissante, ciel couvert, pluie légère")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.PRINTEMPS,tpsToInt("AM"),
                new EffetMeteo(List.of("Chaleur humide, ciel menaçant")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.PRINTEMPS,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps chaud, nuages élevés, ciel variable")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.PRINTEMPS,tpsToInt("B"),
                new EffetMeteo(List.of("Soleil abondant, chaleur agréable")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.PRINTEMPS,tpsToInt("TB"),
                new EffetMeteo(List.of("Temps chaud et sec, ciel clair")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Pluie torrentielle, vents puissants, inondations")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Pluie continue, vent fort, ciel sombre")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Très humide, averses régulières, chaleur moite")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Chaud et humide, éclaircies")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Alternance pluie/soleil, chaleur douce")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Soleil et clarté entre les pluies")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.AUTOMNE,tpsToInt("TM"),
                new EffetMeteo(List.of("Rafales post-mousson, orages résiduels")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.AUTOMNE,tpsToInt("M"),
                new EffetMeteo(List.of("Pluie fine persistante, air moite, ciel gris")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.AUTOMNE,tpsToInt("AM"),
                new EffetMeteo(List.of("Humidité élevée, ciel chargé")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.AUTOMNE,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps encore chaud, soleil diffus avec quelques nuages")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.AUTOMNE,tpsToInt("B"),
                new EffetMeteo(List.of("Temps doux, ciel clair dégagé")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.AUTOMNE,tpsToInt("TB"),
                new EffetMeteo(List.of("Temps sec, ciel bleu, brise légère")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Froid humide, brouillard épais")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("Temps morne, vent modéré, ciel bas, pluie fine")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Humidité résiduelle, fraîcheur, ciel couver")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps frais, ciel changeant, peu de vent")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Ciel clair et lumineux, température douce")
                )
            );
        METEO.ajouter(Climats.MOUSSON,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Froid sec, ciel bleu, air calme")
                )
            );

        METEO.ajouter(Climats.ARIDE,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Caniculaire, pas de vent, air limpide, ciel éclatant, sec")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Très chaud, pas de vent, sec, ciel ensoleillé")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Très chaud, vent faible, sec, ciel dégagé")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Très chaud, vent moyen, sec, ciel légèrement couvert")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Très chaud, vent fort, sec, ciel couvert, chaleur suffocante")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Caniculaire, vent violent, très sec, ciel gris, tempête de sable")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Douce chaleur diurne, nuit fraîche, ciel très clair, pas un souffle de vent")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Chaleur agréable, pas de vent, sec, ciel ensoleillé")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Chaud doux le jour, froid la nuit, vent faible, sec, ciel dégagé")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Bon le jour, froid la nuit, vent faible, sec, ciel nuageux")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("Chaud le jour, frais la nuit, vent moyen, sec, ciel nuageux")
                )
            );
        METEO.ajouter(Climats.ARIDE,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Très chaud le jour, froid la nuit, vent fort, sec, ciel menaçant ")
                )
            );

        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.PRINTEMPS,tpsToInt("TM"),
                new EffetMeteo(List.of("Tempête de neige, vents violents, avalanches, fonte soudaine, pluie verglaçante")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.PRINTEMPS,tpsToInt("M"),
                new EffetMeteo(List.of("Orages de montagne, neige fondue, visibilité réduite")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.PRINTEMPS,tpsToInt("AM"),
                new EffetMeteo(List.of("Temps humide et froid, vent, brouillard")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.PRINTEMPS,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps humide et froid, vent, brouillard")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.PRINTEMPS,tpsToInt("B"),
                new EffetMeteo(List.of("Soleil clair, froid sec, fonte lente des neiges")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.PRINTEMPS,tpsToInt("TB"),
                new EffetMeteo(List.of("Ciel lumineux et limpide, air vif et pur")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.ETE,tpsToInt("TM"),
                new EffetMeteo(List.of("Orages violents, brouillard, grêle")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.ETE,tpsToInt("M"),
                new EffetMeteo(List.of("Pluie froide, vent en rafale")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.ETE,tpsToInt("AM"),
                new EffetMeteo(List.of("Nuages épais, vent frais, brume, fraîcheur")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.ETE,tpsToInt("AB"),
                new EffetMeteo(List.of("Temps frais, éclaircies")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.ETE,tpsToInt("B"),
                new EffetMeteo(List.of("Air pur, ciel dégagé, température fraîche, vent calme")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.ETE,tpsToInt("TB"),
                new EffetMeteo(List.of("Temps radieux, fraîcheur agréable, vent léger")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.AUTOMNE,tpsToInt("TM"),
                new EffetMeteo(List.of("Neige précoce, froid, vent violent, brouillard épais")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.AUTOMNE,tpsToInt("M"),
                new EffetMeteo(List.of("Temps instable, pluie, froid humide")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.AUTOMNE,tpsToInt("AM"),
                new EffetMeteo(List.of("Vent, froid, ciel couvert")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.AUTOMNE,tpsToInt("AB"),
                new EffetMeteo(List.of("Air vif, ciel voilé ou variable")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.AUTOMNE,tpsToInt("B"),
                new EffetMeteo(List.of("Fraîcheur sèche, ciel dégagé")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.AUTOMNE,tpsToInt("TB"),
                new EffetMeteo(List.of("Lumière claire, air cristallin, temps calme")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.HIVER,tpsToInt("TM"),
                new EffetMeteo(List.of("Blizzard, températures extrêmes")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.HIVER,tpsToInt("M"),
                new EffetMeteo(List.of("Neige dense, brouillard, froid mordant, vent glacial")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.HIVER,tpsToInt("AM"),
                new EffetMeteo(List.of("Froid vif, ciel chargé")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.HIVER,tpsToInt("AB"),
                new EffetMeteo(List.of("Froid sec, quelques éclaircies")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.HIVER,tpsToInt("B"),
                new EffetMeteo(List.of("Ciel dégagé, froid supportable")
                )
            );
        METEO.ajouter(Climats.HAUTEMONTAGNE,Saisons.HIVER,tpsToInt("TB"),
                new EffetMeteo(List.of("Temps frais, montagne enneigée sous un ciel bleu éclatant")
                )
            );

    }
}
