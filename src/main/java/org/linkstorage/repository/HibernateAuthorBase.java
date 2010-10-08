package org.linkstorage.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.linkstorage.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateAuthorBase implements AuthorBase {

	@Autowired
	private SessionFactory sessionFactory;

	public HibernateAuthorBase (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Author getAuthor(Integer id) {
		return (Author) sessionFactory.getCurrentSession().get(Author.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Author> getAuthors() {
		return (List<Author>) sessionFactory.getCurrentSession().createQuery("from Author a").list();
	}

	@Override
	@Transactional
	public void addAuthor(Author author) {
		sessionFactory.getCurrentSession().save(author);
	}

}
