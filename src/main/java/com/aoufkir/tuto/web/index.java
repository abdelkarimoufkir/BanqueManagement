package com.aoufkir.tuto.web;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aoufkir.tuto.entity.Clients;
import com.aoufkir.tuto.entity.Comptes;
import com.aoufkir.tuto.service.ClientService;
import com.aoufkir.tuto.service.CompteService;
import com.aoufkir.tuto.service.OperationService;

@Controller
public class index {

	@Autowired
	CompteService compteservice;
	
	@Autowired
	ClientService clientservice;
	
	@Autowired
	OperationService operationservice;
	
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy");

	int totalcomptes;
	int totalclients;
	Date dates = new Date();
	
	@RequestMapping("/")
	public String main(Model model) {
		List<Comptes> comptes = (List<Comptes>)compteservice.ListComptes();
		List<Clients> clients = (List<Clients>) clientservice.ListeClients();
		
		Map<String,Double> graphData = comptes.stream()
				.collect(Collectors.groupingBy(
						c -> format1.format(c.getDateOuverture() ),
						Collectors.summingDouble(c -> ((Number)c.getSolde()).doubleValue())
						));
	
		totalcomptes = comptes.size();
		totalclients = clients.size();
		//System.out.println("Graph Data "+graphData);
		model.addAttribute("chartData", graphData);
		model.addAttribute("totalcomptes", totalcomptes);
		model.addAttribute("totalclients", totalclients);

		return "home";
	} 
	
	@RequestMapping("dataclients")
	public String ListeClients(Model model) {
		Iterable<Clients> clients =  clientservice.ListeClients();
		model.addAttribute("clients", clients);
		
		return "data/clients";
	}
	
	@RequestMapping("datacomptes")
	public String ListeComptes(Model model) {
		Iterable<Comptes> comptes =  compteservice.ListComptes();
		System.out.println(comptes);
		model.addAttribute("comptes", comptes);
		return "data/comptes";
	}
	
	@RequestMapping("compte/consulter")
	public String consulterCompte() {
		return "operations";
	}
	
}
