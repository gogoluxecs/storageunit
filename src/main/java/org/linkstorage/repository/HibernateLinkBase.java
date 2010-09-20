package org.linkstorage.repository;

import org.linkstorage.model.Link;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	public Link getLink(Long id) {
	    return (Link) sessionFactory.getCurrentSession().get(Link.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List getLinks() {
	  return sessionFactory.getCurrentSession().createQuery("from Link l").list();
	}

	@Override
	public void addLink(Link link) {
		sessionFactory.getCurrentSession().save(link);
	}
}