package com.redhat.training.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
//import persistence related libraries
import javax.persistence.TypedQuery;

import com.redhat.training.model.Person;

@Stateless

public class PersonService {
    //TODO: obtain an EntityManager instance using @PersistenceContext 
	

	// Simple non-RESTy method for JSF bean invocation
	public String hello(String name) {
		try {
				// let's grab the current date and time on the server
				LocalDateTime today = LocalDateTime.now();

				// format it nicely for on-screen display
				DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm:ss a");
				String fdate = today.format(format);

				// Create a new Person object and persist to database
				Person p = new Person();
				p.setName(name);
				// call persist() method of entity manager to save the data																
				
				// respond back with Hello and convert the name to UPPERCASE. Also, send the
				// current time on the server.
				return "Hello " + name.toUpperCase() + "!. " + "Time on the server is: " + fdate;
		} catch (Exception e) {
			throw new EJBException(e);
		}
	}


	// TODO:add public String getPerson(Long id) method here to fetch result
        // by Person id using find() method 
		
	// Get all Person objects in the Database
	public List<Person> getAllPersons() {
		TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
		List<Person> persons = query.getResultList();

		return persons;
	}

}
