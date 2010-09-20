package org.linkstorage.repository;

import org.linkstorage.model.Link;

import java.util.List;

public interface LinkBase {
	public Link getLink(Long id);
	public List getLinks();
	public void addLink(Link link);
}
