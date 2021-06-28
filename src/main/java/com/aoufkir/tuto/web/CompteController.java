package com.aoufkir.tuto.web;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aoufkir.tuto.entity.ClientTypes;
import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.entity.CompteTypes;
import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.entity.Operations;
import com.aoufkir.tuto.service.ClientService;
import com.aoufkir.tuto.service.CompteService;
import com.aoufkir.tuto.service.CompteTypeService;
import com.aoufkir.tuto.service.OperationService;
import com.aoufkir.tuto.service.OperationTypSservice;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

@Controller
public class CompteController {

	@Autowired
	private CompteService compteservice;

	@Autowired
	private ClientService clientservice;

	@Autowired
	private OperationTypSservice operationtypes;

	@Autowired
	private OperationService operationservice;

	@Autowired
	private CompteTypeService comptetypeservice;

	String erreur = "Veuillez entrez un compte existant";

	@RequestMapping(value = "compte/ajouter/{id}")
	public String EnregistrerCompte(Model model, @PathVariable(value = "id") long id) {
		Iterable<CompteTypes> listecomptetype = comptetypeservice.listeCompteType();
		model.addAttribute("comptetype", listecomptetype);
		model.addAttribute("compte", new Comptes());
		Clients client = clientservice.FindClientByID(id);
		model.addAttribute("client", client);
		return "compte";
	}

	@RequestMapping(value = "compte", method = RequestMethod.POST)
	private String EnregistrerClient(Comptes compte) {
		compteservice.EnregistrerCompte(compte);

		return "redirect:/clientdetails/" + compte.getClientcode().getId();

	}

	@RequestMapping(value = "/consultercompte")
	private String ConsulterCompte(Model model, String codeCompte, Comptes compte,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		try {
			compte = compteservice.findCompteByCode(codeCompte);
				if (compte == null) throw new RuntimeException(erreur);
			model.addAttribute("codeCompte", codeCompte);
			model.addAttribute("compte", compte);
			model.addAttribute("operationtype", operationtypes.listOperationType());
			Page<Operations> listoperations = operationservice.findByCompteID(compte, page, size);
			int[] pages = new int[listoperations.getTotalPages()];
			model.addAttribute("operation", listoperations.getContent());
			model.addAttribute("pages", pages);
			
			
		} catch (Exception ex) {
			model.addAttribute("exception", ex);
		}

		return "operations";
	}
	
	@RequestMapping(value = "compte/supprimer/{id}", method = RequestMethod.POST)
	private String Supprimercompte(@PathVariable("id") long idCompte, RedirectAttributes redirectAttrs) {
		Comptes compte = compteservice.findCompteById(idCompte);
		compteservice.DeleteCompte(idCompte);
		String msg = "Compte supprimer avec succés";
		redirectAttrs.addFlashAttribute("supprimer", msg);
		return "redirect:/clientdetails/" + compte.getClientcode().getId();
	}

}
