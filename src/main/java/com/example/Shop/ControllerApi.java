package com.example.Shop;

import java.awt.PageAttributes.MediaType;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerApi {
	
	@Autowired
	ContactRepo cRepo;
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public java.util.List<Contact> contact()
	{
		
		return (java.util.List<Contact>) cRepo.findAll();
	}
	
	@RequestMapping(value = "/contact/{ID}", method = RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable int ID)
	{
		
		return (Optional<Contact>)cRepo.findById(ID);
	}
	
	@RequestMapping(value = "/contact/addContact", method = RequestMethod.POST)
	public void addContact(@RequestBody Contact c)
	{
	    //System.out.println(c.getName());
	    cRepo.save(c);
		
	}


}
