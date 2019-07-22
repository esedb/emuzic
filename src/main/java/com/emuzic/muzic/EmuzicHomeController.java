package com.emuzic.muzic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emuzic.muzic.entitybeans.Users;

@Controller
public class EmuzicHomeController {
	
	@Autowired
	UserRepository userrepo;
	
	
	
	@PersistenceContext
	EntityManager entitymanager;
	
	
	@RequestMapping(value = {"/"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String home() {		
	
		return "index";
	}
	@RequestMapping("/albums")
	public String getMusician() {	
		return "albums-store";
	}
	@RequestMapping("/albums/{login}")
	public String login(@PathVariable("login") String login) {	
		return "login";
	}
	
	

}
