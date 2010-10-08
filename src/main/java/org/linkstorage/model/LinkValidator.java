package org.linkstorage.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LinkValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Link.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        Link l = (Link) obj;
        
        if(l.getId().toString().length() > 0) {
        	e.rejectValue("id", "notnullvalue");
        }
    }
}