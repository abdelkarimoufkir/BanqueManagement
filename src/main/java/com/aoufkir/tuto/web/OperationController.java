package com.aoufkir.tuto.web;

import java.text.Format;
import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.entity.Operations;
import com.aoufkir.tuto.service.CompteService;
import com.aoufkir.tuto.service.OperationService;

@Controller
public class OperationController {

	@Autowired
	private OperationService operationservice;

	@Autowired
	private CompteService compteservice;

	@RequestMapping(value = "operation", method = RequestMethod.POST)
	private String Versement(@RequestParam("montant") double montant, @RequestParam("codeCompte") String codeCompte,
			@RequestParam("operationTypeCode") String type, String codeCompte2, Operations operation, Model model) {

		model.addAttribute("codeCompte2", codeCompte2);
		Comptes compte = compteservice.findCompteByCode(codeCompte);
		
		try {
			if (type.equals("Versement")) {
				operationservice.Versement(codeCompte, montant, type);
			} else if (type.equals("Retrait") && compte.getSolde() >= montant) {
				operationservice.Retrait(codeCompte, montant, type);
			}  if (type.equals("Virement") && compte.getSolde() >= montant) 
				operationservice.Virement(codeCompte, codeCompte2, montant, type);
				
		} catch (Exception e) {
			model.addAttribute("erreur", e);
			return "redirect:/consultercompte?codeCompte=" + codeCompte + "&erreur=" + e.getMessage();
		}

		return "redirect:/consultercompte?codeCompte=" + codeCompte;

	}
}
