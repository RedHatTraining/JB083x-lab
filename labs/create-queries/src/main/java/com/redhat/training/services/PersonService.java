package com.redhat.training.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

import com.redhat.training.model.Person;

@Stateless

public class PersonService {

  @PersistenceContext(unitName="hello")
	private EntityManager entityManager;

	// Get all Person objects in the Database
  public List<Person> getAllPersons(){
	  
  }

  //Get persons whose name matches the name given in the query

}
