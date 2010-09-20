package org.linkstorage.model;

public class Link {
	private Long id;
	private String metaDescription;
	private String url;

	public Link() {}

	/**
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param Long id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Long
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMetaDescription() {
		return this.metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
}
