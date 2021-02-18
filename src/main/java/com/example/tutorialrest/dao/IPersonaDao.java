package com.example.tutorialrest.dao;

import com.example.tutorialrest.model.Persona;

public interface IPersonaDao {

	public Persona getPersonaByName(String name);

}
