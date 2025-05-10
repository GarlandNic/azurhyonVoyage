package com.azurhyon.azurhyonVoyage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.azurhyon.azurhyonVoyage.dto.MeteoDto;

@Controller
public class MainController {
	
	@GetMapping("/azurhyon/voyage")
	public String pagePrincipale(Model model) {
		return filledPageVoyage(model);
	}

	private String filledPageVoyage(Model model) {
		if(!model.containsAttribute("meteo")) model.addAttribute("meteo", new MeteoDto());
		// TODO Auto-generated method stub
//		model.addAttribute("combohandicap", perso.getComboHandicap());
//		model.addAttribute("combototal", perso.getComboTotal());
		return "voyage";
	}


}
