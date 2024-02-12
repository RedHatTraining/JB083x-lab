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
	  TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p",
			  Person.class);
	  
	  return query.getResultList();
  }
  
  public List<Person> getPersonsWithName(String name) {
	  TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p "
	  		+ "where p.name = ?1", Person.class);
	  query.setParameter(1, name);
	  
	  return query.getResultList();
  }

  //Get persons whose name matches the name given in the query

}
