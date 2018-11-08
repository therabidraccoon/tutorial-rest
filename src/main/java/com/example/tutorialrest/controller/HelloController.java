package com.example.tutorialrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorialrest.model.Persona;

@RestController
public class HelloController {

//	@RequestMapping(value="/persona", method=RequestMethod.POST)
	@PostMapping("/persona")
	public Persona test(@RequestParam("eta") Integer eta) {
		Persona p = new Persona();
		p.setNome("Paolo");
		p.setCognome("Occhionero");
		p.setEta(eta);
		
		return p;
	}
	
	@GetMapping("/persona/{eta}/find-by-age")
	public Persona setEtaPersona(@PathVariable("eta") Integer age) {
		Persona p = new Persona();
		p.setNome("Paolo");
		p.setCognome("Occhionero");
		p.setEta(age);
		
		return p;
	}
	
//	@GetMapping("/persona/{nome}/find-by-name")
//	@GetMapping("/persona/insert")
	
	@PostMapping("/persona-mod") //su postman ricordardi di impostare Header -> Content-Type = application/json e selezionare dal tab Body la casella "raw"
	public Persona returnPersonaMod(@RequestBody Persona p) {
		p.setNome(p.getNome() + " Modificato!");
		
		return p;
	}
	
	@PostMapping("/persona-mod-status") //su postman ricordardi di impostare Header -> Content-Type = application/json e selezionare dal tab Body la casella "raw"
	public ResponseEntity<Persona> returnPersonaModStatus(@RequestBody Persona p) {
		p.setNome(p.getNome() + " Modificato!");
		if(p.getCognome().length() < 3) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista-persone")
	public List<Persona> getPersone(){
		List<Persona> list = new ArrayList<>();
		Persona p = new Persona();
		p.setNome("Paolo");
		p.setCognome("Occhionero");
		p.setEta(122);
		list.add(p);
		
		Persona pe = new Persona();
		pe.setNome("ivan");
		pe.setCognome("maltese");
		pe.setEta(134);
		list.add(pe);
		
		return list;
 	}
	
}
