package com.aoufkir.tuto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aoufkir.tuto.entity.ClientTypes;
import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.repository.CompteRepository;
import com.aoufkir.tuto.service.ClientService;
import com.aoufkir.tuto.service.ClientTypeService;
import com.aoufkir.tuto.service.CompteService;

import lombok.Setter;

@Controller
public class ClientController {

	@Autowired 
	private ClientService clientservice;
	
	@Autowired
	private ClientTypeService clienttypeservice;
	
	@Autowired 
	private CompteService compteservice;
	
	
	@RequestMapping(value = "/client/nouveau")
	public String Ajouterclient(Model model) {
		model.addAttribute("client", new Clients());
		Iterable<ClientTypes> listecltype = clienttypeservice.listeClientType();
		model.addAttribute("cltype",listecltype);
		return "client";
	}
	
	
	@RequestMapping(value="client", method = RequestMethod.POST)
	private String EnregistrerClient(Clients client) {
		clientservice.SaveClient(client);
		return "redirect:/clientdetails/"+client.getId();
	}
	
	@RequestMapping(value = "/clientdetails/{id}")
	public String AfficherClient(Model model, @PathVariable Integer id, Clients client) {
			client = clientservice.FindClientByID(id);
			List<Comptes> compte = compteservice.findCompteByclientcode(client);
			model.addAttribute("compte",compte);
			model.addAttribute("client",client );
		
		return "clientdetails";
	}
	
	@RequestMapping(value = "/client/modifier/{id}")
	public String ModifierClient(Model model, @PathVariable Integer id) {
		model.addAttribute("client",clientservice.FindClientByID(id) );
		Iterable<ClientTypes> listecltype = clienttypeservice.listeClientType();
		model.addAttribute("cltype",listecltype);
		return "client";
	}
	
	@RequestMapping(value = "/client/supprimer/{id}")
	public String SupprimerClient(Model model, @PathVariable Integer id) {
		clientservice.DeleteClient(id);
		return "redirect:/home";
	}
	
	
	
}
