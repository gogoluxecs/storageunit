package org.linkstorage.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.linkstorage.model.Link;

@XmlRootElement(name="response")
public class LinkBean {

	private Link link;
	private List<Link> links;	
	private int count;

	public LinkBean() {}

	public LinkBean(Link link) {
		this.link = link;
	}
	
	public LinkBean(List<Link> links) {
		this.links = links;
		this.count = links.size();
	}

	@XmlElement(name="link")
	public Link getLink() {
		return link;
	}

	public int getCount() {
		return count;
	}
	
	@XmlElement(name="link")
	public List<Link> getLinks() {
		return links;
	}
}