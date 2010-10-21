package org.linkstorage.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.linkstorage.model.Link;
import org.linkstorage.repository.LinkBase;
import org.linkstorage.web.controller.LinkController;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class LinkControllerTest {
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private LinkController linkController;
	private AnnotationMethodHandlerAdapter methodHandlerAdapter;
	private LinkBase linkRepositoryMock;
	
	@BeforeMethod
	public void init() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		methodHandlerAdapter = new AnnotationMethodHandlerAdapter();
		linkRepositoryMock = EasyMock.createStrictMock(LinkBase.class);
	}
	
	@Test(alwaysRun = true)
	@Parameters({"getLink"})
	public void getLink(String linkPage) throws Exception {
		request.setRequestURI("/integration/link/{id}");
		request.setMethod("GET");
		Link link = new Link();
		Integer linkId = new Integer(1);
		
		Map<String, String>pathVariables = new HashMap<String, String>();
		pathVariables.put("id", String.valueOf(linkId));
		request.setAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, pathVariables);
		
		EasyMock.expect(linkRepositoryMock.getLink(linkId)).andReturn(link).anyTimes();
		EasyMock.replay(linkRepositoryMock);
		
		linkController = new LinkController(linkRepositoryMock);
		ModelAndView modelAndView = methodHandlerAdapter.handle(request, response, linkController);
		
		Assert.assertEquals(modelAndView.getViewName(), linkPage, "returned view name should be " + linkPage);
		
		EasyMock.verify(linkRepositoryMock);
	}
	
}
