package org.linkstorage.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.linkstorage.model.Author;

@XmlRootElement(name="response")
public class AuthorBean {

	private Author author;
	private List<Author> authors;
	private int count;

	public AuthorBean() {}
	
	public AuthorBean(Author author) {
		this.author = author;
	}
	
	public AuthorBean(List<Author> authors) {
		this.authors = authors;
		this.count = authors.size();
	}
	
	@XmlElement(name="author")
	public Author getAuthor() {
		return author;
	}
	
	public int getCount() {
		return count;
	}
	
	@XmlElement(name="author")
	public List<Author> getAuthors() {
		return authors;
	}
}
