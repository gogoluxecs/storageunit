package org.linkstorage.model;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Test
public class LinkTest {

	@Test
	@Parameters({"url", "metaDescription"})
	public void setAndGetAttributes(String url, String metaDescription) {
		Link link = new Link();
		link.setUrl(url);
		link.setMetaDescription(metaDescription);

		assertEquals(link.getUrl(), url, "Should get url that was set");
		assertEquals(link.getMetaDescription(), metaDescription, "Should get metaDescription that was set");
	}
}
