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
		return "";
	}
	
	private String descriptionDuLieu(LieuDto lieu) {
		return "";
	}

}
