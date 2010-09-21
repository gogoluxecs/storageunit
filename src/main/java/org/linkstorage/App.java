package org.linkstorage;

import org.linkstorage.model.Link;
import org.linkstorage.repository.LinkBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
	    LinkBase links = (LinkBase) ctx.getBean("repository.links");
	    Link link = links.getLink(new Long(1));
	    System.out.println("Url: " + link.getUrl());
	}
}