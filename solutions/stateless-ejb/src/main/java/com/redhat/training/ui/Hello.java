package com.redhat.training.ui;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.redhat.training.ejb.HelloBean;

@RequestScoped
@Named("hello")
public class Hello {
	private String name;
	
	@EJB
	HelloBean helloEJB;

	public String greet() {
		return helloEJB.sayHello(name);
	}
	public void sayHello() {
		String response = greet();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(response));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
