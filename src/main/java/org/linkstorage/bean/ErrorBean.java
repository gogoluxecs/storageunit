package org.linkstorage.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class ErrorBean {

	private String error;

	public ErrorBean() {
	}

	public ErrorBean(String error) {
		this.error = error;
	}

	@XmlElement(name="error")
	public String getError() {
		return error;
	}
}