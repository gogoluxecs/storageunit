package org.linkstorage.web.controller;

import org.linkstorage.repository.AuthorBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class AuthorController {
	
	private AuthorBase authorsRepository;
	private Jaxb2Marshaller jaxb2Marshaller;
	
	private static final String XML_VIEW_NAME = "authors";
	
	@Autowired
	public AuthorController(AuthorBase authorsRepository) {
		this.authorsRepository = authorsRepository; 
	}
}
