package org.linkstorage.service;

import java.io.StringReader;
import java.util.Date;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.linkstorage.bean.LinkBean;
import org.linkstorage.model.Link;
import org.linkstorage.repository.LinkBase;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class LinkManager {

	private String body;

	private LinkBase linksRepository;
	private Jaxb2Marshaller jaxb2Marshaller;

	public LinkManager(String body) {
		this.body = body;
	}

	public LinkBean addLink() {
		Source source = new StreamSource(new StringReader(body));
		Link link = (Link) jaxb2Marshaller.unmarshal(source);

		link.setUpdatedAt(new Date());
		link.setCreatedAt(new Date());
		linksRepository.addLink(link);

		LinkBean linkbean = new LinkBean(link);

		return linkbean;
	}
}