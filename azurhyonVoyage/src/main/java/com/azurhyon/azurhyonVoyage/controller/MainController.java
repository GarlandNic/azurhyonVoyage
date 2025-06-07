package com.azurhyon.azurhyonVoyage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.azurhyon.azurhyonVoyage.dto.MeteoDto;
import com.azurhyon.azurhyonVoyage.dto.RouteDto;
import com.azurhyon.azurhyonVoyage.dto.VoyageDto;
import com.azurhyon.azurhyonVoyage.dto.RouteDto.RouteTypes;
import com.azurhyon.azurhyonVoyage.dto.MeteoDto.Climats;
import com.azurhyon.azurhyonVoyage.dto.MeteoDto.Saisons;
import com.azurhyon.azurhyonVoyage.service.BashService;
import com.azurhyon.azurhyonVoyage.service.DistanceService;
import com.azurhyon.azurhyonVoyage.service.EvenementService;
import com.azurhyon.azurhyonVoyage.service.LieuService;
import com.azurhyon.azurhyonVoyage.service.LogementService;
import com.azurhyon.azurhyonVoyage.service.MeteoService;
import com.azurhyon.azurhyonVoyage.service.OrientationService;

@Controller
public class MainController {
	
	@Autowired
	MeteoService meteoServ;
	
	@Autowired
	BashService bashServ;
	
	@Autowired
	OrientationService orientServ;
	
	@Autowired
	LieuService lieuServ;
	
	@Autowired
	DistanceService distServ;

	@Autowired
	EvenementService evnmtServ;

	@Autowired
	LogementService logmtServ;
	
	@GetMapping("/azurhyon/voyage")
	public String pagePrincipale(Model model) {
		return filledPageVoyage(model);
	}
	
	@PostMapping(value="/azurhyon/voyage", params={"meteoButton"})
	public String calculDuTemps(Model model, @ModelAttribute("voyage") VoyageDto voyage, BindingResult result) {
	    if (result.hasErrors()) {
	        result.getAllErrors().forEach(System.out::println);
			return filledPageVoyage(model);
	    }
		voyage.setMeteo(meteoServ.update(voyage.getMeteo()));
		model.addAttribute("voyage", voyage);
		return filledPageVoyage(model);
	}

	@PostMapping(value="/azurhyon/voyage", params={"jourSuivant"})
	public String jourSuivant(Model model, @ModelAttribute("voyage") VoyageDto voyage) {
		voyage.setMeteo(meteoServ.jourSuivant(voyage.getMeteo()));
		model.addAttribute("voyage", voyage);
		return filledPageVoyage(model);
	}

	@PostMapping(value="/azurhyon/voyage", params={"update"})
	public String simpleUpdate(Model model, @ModelAttribute("voyage") VoyageDto voyage) {
		return filledPageVoyage(model);
	}

	@PostMapping(value="/azurhyon/voyage", params={"orientationResult"})
	public String orientationResult(Model model, @ModelAttribute("voyage") VoyageDto voyage) {
		orientServ.update(voyage);
		return filledPageVoyage(model);
	}

	@PostMapping(value="/azurhyon/voyage", params={"lancerBash"})
	public String lancerBash(Model model, @ModelAttribute("voyage") VoyageDto voyage) {
		voyage.setBash(bashServ.lancerBash(voyage.getOrientation(), voyage.getSurvie(), 
				voyage.getRoute().getDiff(), voyage.getRoute().getType()));
		model.addAttribute("voyage", voyage);
		return filledPageVoyage(model);
	}

	@PostMapping(value="/azurhyon/voyage", params={"bashEffet"})
	public String bashEffet(Model model, @ModelAttribute("voyage") VoyageDto voyage) {
		voyage.setBash(bashServ.calculBash(voyage.getOrientation(), voyage.getSurvie(), 
				voyage.getRoute().getDiff(), voyage.getRoute().getType(), voyage.getBash().getJet(),
				voyage.getBash().getGravite(), voyage.getBash().getPeril(), 0));
		model.addAttribute("voyage", voyage);
		return filledPageVoyage(model);
	}
	
	@PostMapping(value="/azurhyon/voyage", params={"lieuNotable"})
	public String lieuNotable(Model model, @ModelAttribute("voyage") VoyageDto voyage) {
		voyage.setLieu1(lieuServ.nouveauLieux());
		voyage.setLieu2(lieuServ.nouveauLieux());
		model.addAttribute("voyage", voyage);
		return filledPageVoyage(model);
	}
	
	@PostMapping(value="/azurhyon/voyage", params={"evnmtNotable"})
	public String evnmtNotable(Model model, @ModelAttribute("voyage") VoyageDto voyage) {
		voyage.setEvnmt1(evnmtServ.nouveauEvnmt());
		voyage.setEvnmt2(evnmtServ.nouveauEvnmt());
		model.addAttribute("voyage", voyage);
		return filledPageVoyage(model);
	}
	
	@PostMapping(value="/azurhyon/voyage", params={"lancerLogement"})
	public String lancerLogement(Model model, @ModelAttribute("voyage") VoyageDto voyage) {
		voyage.setLogement(logmtServ.lancerLogement(voyage.getRenseignement(), voyage.getRoute().getType()));
		model.addAttribute("voyage", voyage);
		return filledPageVoyage(model);
	}
	

	private String filledPageVoyage(Model model) {
		VoyageDto voy = new VoyageDto();
		if(!model.containsAttribute("voyage")) {
			voy.setMeteo(new MeteoDto());
			voy.setRoute(new RouteDto());
			model.addAttribute("voyage", voy);
		} else {
			voy = (VoyageDto) model.getAttribute("voyage");
		}
		model.addAttribute("climats", Climats.values());
		model.addAttribute("saisons", Saisons.values());
		model.addAttribute("effetsDuTemps", meteoServ.effets(voy.getMeteo()));
		model.addAttribute("routeTypes", RouteTypes.values());
		model.addAttribute("distance", distServ.computeDist(voy));
		model.addAttribute("confort", logmtServ.confortDescr(voy.getLogement()));
		
		return "voyage";
	}


}
