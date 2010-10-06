package org.linkstorage.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LinkValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Link.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        //ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Link l = (Link) obj;
        if (l.getId() != null) {
        	e.rejectValue("id", "negativevalue");
        }
    }
}