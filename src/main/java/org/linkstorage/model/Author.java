package org.linkstorage.model;

public class Author {
	private Long id;
	private String nickname;
	private String channel;

	public Author() {}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * @return String
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param String nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return String
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param String channel
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
}