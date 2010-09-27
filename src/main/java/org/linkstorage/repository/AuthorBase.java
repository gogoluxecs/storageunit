package org.linkstorage.repository;

import java.util.List;

import org.linkstorage.model.Author;

public interface AuthorBase {

	/**
	 *
	 * @param id
	 * @return
	 */
	public Author getAuthor(Integer id);

	/**
	 *
	 * @return
	 */
	public List getAuthors();

	/**
	 *
	 * @param author
	 */
	public void addAuthor(Author author);
}
