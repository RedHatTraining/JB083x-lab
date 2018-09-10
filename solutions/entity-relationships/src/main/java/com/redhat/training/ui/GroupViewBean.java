package com.redhat.training.ui;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.redhat.training.ejb.UserBean;
import com.redhat.training.model.User;
import com.redhat.training.model.UserGroup;

@Named("groupView")
@Stateless
@RequestScoped
public class GroupViewBean {

	private Set<UserGroup> groups;

	private UserGroup currentGroup;

	private Set<User> users;

	@Inject
	private Logger log;

	@Inject
	UserBean peopleBean;

	@PostConstruct
	public void init() {
		log.info("INIT!!!");
		groups = peopleBean.getAllUserGroups();

	}

	public void update(ValueChangeEvent event) {

		UserGroup group = (UserGroup) event.getNewValue();
		users = new HashSet<User>(group.getUsers());
			
	}

	public Set<UserGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<UserGroup> userGroups) {
		this.groups = userGroups;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public UserGroup getCurrentGroup() {
		return currentGroup;
	}

	public void setCurrentGroup(UserGroup currentGroup) {
		this.currentGroup = currentGroup;
	}

	public List<User> getUserList(){
		if(users != null) {
			return new ArrayList<User>(users);
		}else {
			return new ArrayList<User>();
		}
	}

}
