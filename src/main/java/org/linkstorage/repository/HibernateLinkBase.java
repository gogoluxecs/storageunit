package org.linkstorage.repository;

import java.util.List;

import org.linkstorage.model.Link;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateLinkBase implements LinkBase {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateLinkBase(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Link getLink(Integer id) {
	    return (Link) sessionFactory.getCurrentSession().get(Link.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Link> getLinks() {
	  return (List<Link>) sessionFactory.getCurrentSession().createQuery("from Link l").list();
	}

	@Override
	public void addLink(Link link) {
		sessionFactory.getCurrentSession().save(link);
	}
}