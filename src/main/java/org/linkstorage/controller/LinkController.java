package org.linkstorage.controller;

import java.io.StringReader;
import java.util.Date;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linkstorage.bean.LinkBean;
import org.linkstorage.model.Link;
import org.linkstorage.model.LinkValidator;
import org.linkstorage.repository.LinkBase;

@Controller
@RequestMapping("/integration/*")
public class LinkController {

	private LinkBase linksRepository;

	private Jaxb2Marshaller jaxb2Marshaller;

	/**
	 * Name of the jsp view template
	 */
	private static final String XML_VIEW_NAME = "links";

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 *
	 * @param LinkBase linksRepository
	 */
	@Autowired
	public LinkController(LinkBase linksRepository) {
		this.linksRepository = linksRepository;
	}

	public void setJaxb2Marshaller(Jaxb2Marshaller jaxb2Marshaller) {
		this.jaxb2Marshaller = jaxb2Marshaller;
	}

	/**
	 * Gets link by id
	 *
	 * @param String id
	 * @return ModelAndView
	 */
	@RequestMapping(method=RequestMethod.GET, value="link/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public ModelAndView getLink(@PathVariable String id){
		ModelAndView modelAndView = new ModelAndView();

		Link link = linksRepository.getLink(Integer.parseInt(id));
		if(link != null) {
			LinkBean linkbean = new LinkBean(link);

			modelAndView.setViewName(XML_VIEW_NAME);
		    modelAndView.addObject("link", linkbean);
		}

		return modelAndView;
	}

	/**
	 * Get links
	 *
	 * @return ModelAndView
	 */
	//TODO create offset and limit in the query
	@RequestMapping(method=RequestMethod.GET, value="links")
	@ResponseStatus(value=HttpStatus.OK)
	public ModelAndView getLinks() {
		List<Link> links = linksRepository.getLinks();
		LinkBean linksList = new LinkBean(links);

		return new ModelAndView(XML_VIEW_NAME, "links", linksList);
	}

	/**
	 * Adds link
	 *
	 * @param body
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="/link")
	public ModelAndView addLink(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		Link link = (Link) jaxb2Marshaller.unmarshal(source);

		ModelAndView modelAndView = new ModelAndView();

		DataBinder binder = new DataBinder(link);
		binder.setValidator(new LinkValidator());
		binder.validate();
		BindingResult results = binder.getBindingResult();

		if(results.hasErrors() == false) {
			link.setUpdatedAt(new Date());
			link.setCreatedAt(new Date());

			linksRepository.addLink(link);

			LinkBean linkbean = new LinkBean(link);

			modelAndView.setViewName(XML_VIEW_NAME);
			modelAndView.addObject("link", linkbean);
		} else {
			//TODO replace error404 with error response
			/*
				ErrorBean errorBean = new ErrorBean("Error sending parameters");
				modelAndView.setViewName(XML_VIEW_ERROR);
				modelAndView.addObject("error", errorBean);
			*/
		}

		return modelAndView;
	}
}