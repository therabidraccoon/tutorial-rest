package com.example.tutorialrest.dao.impl;

import org.springframework.stereotype.Component;

import com.example.tutorialrest.dao.IPersonaDao;
import com.example.tutorialrest.model.Persona;

@Component
public class PersonaDaoImpl implements IPersonaDao {

	@Override
	public Persona getPersonaByName(String name) {
		Persona persona = new Persona();
		persona.setCognome("Qualcuno");
		persona.setNome(name);
		persona.setEta(123);
		return persona;
	}
}
