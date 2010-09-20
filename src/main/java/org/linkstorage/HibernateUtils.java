package org.linkstorage;

import org.linkstorage.model.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
* @author Nabeel Ali Memon
*/
public class HibernateUtils {
  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    try {
      // Create the SessionFactory from hibernate.cfg.xml
      return new Configuration().configure().buildSessionFactory();
    }
    catch (Throwable e) {
      // Make sure you log the exception, as it might be swallowed
      System.err.println("Initial SessionFactory creation failed." + e);
      throw new ExceptionInInitializerError(e);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static void main(String[] args) {
    Session session = getSessionFactory().getCurrentSession();
    session.getTransaction().begin();
    Link link = (Link) session.get(Link.class, new Long(1));
    System.out.println("user's email id is: "+ link.getUrl());
    session.getTransaction().commit();
  }
}