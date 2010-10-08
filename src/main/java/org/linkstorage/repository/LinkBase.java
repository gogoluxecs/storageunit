package org.linkstorage.repository;

import org.linkstorage.model.Link;

import java.util.List;

public interface LinkBase {

	/**
	 *
	 * @param id
	 * @return
	 */
	public Link getLink(Integer id);

	/**
	 *
	 * @return
	 */
	public List<Link> getLinks();

	/**
	 *
	 * @param link
	 */
	public void addLink(Link link);
}