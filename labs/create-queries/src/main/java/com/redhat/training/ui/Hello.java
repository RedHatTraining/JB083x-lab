package com.redhat.training.ui;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.redhat.training.model.Person;
import com.redhat.training.services.PersonService;

import javax.inject.Inject;
import java.util.List;



@RequestScoped
@Named("hello")
public class Hello {
	private String name;
	private Long id;
	private List<Person> results;

	@Inject
	private PersonService personService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

      //View all persons in the database table
	public List<Person> getPersons() {
		return personService.getAllPersons();
	}

    //view all persons whose name matches the name given in the query
		/*public void search() {
					results = personService.getPersonsWithName(name);
	  }*/

		public List<Person> getResults() {
						return results;
		}

		public void setResults(List<Person> results) {
						this.results = results;
		}



}
