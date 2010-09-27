package org.linkstorage.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.linkstorage.model.Link;

@XmlRootElement(name="links")
public class LinkBean {

	private Link link;

	public LinkBean() {}

	public LinkBean(Link link) {
		this.link = link;
	}

	@XmlElement(name="link")
	public Link getLink() {
		return link;
	}
}