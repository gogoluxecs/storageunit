package org.linkstorage.repository;

import org.linkstorage.model.Author;

import java.util.List;

public interface AuthorBase {
	public Author getAuthor(Long id);
	public List getAuthors();
	public void addAuthor(Author author);
}