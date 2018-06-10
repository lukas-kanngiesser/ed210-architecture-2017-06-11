package at.arz.ed210.architecture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.arz.ed210.architecture.rest.MyRestApp;

@RunWith(Arquillian.class)
public class TestResourceIT {

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap
				// Type:
				.create(WebArchive.class, "test.war")
				// Content:
				.addPackages(true, MyRestApp.class.getPackage())

				// Resources:
				.addAsWebInfResource("WEB-INF/web.xml", "web.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	@RunAsClient
	public void testRestEndpoint() throws Exception {

		String url = "http://localhost:8080/test/example/hello?name=Arquillian";

		HttpGet request = new HttpGet(url);

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		// Then
		assertThat(httpResponse.getStatusLine().getStatusCode(), is(200));

		String responseBody = EntityUtils.toString(httpResponse.getEntity());
		assertThat(responseBody, is("Hello Arquillian!"));

	}

}
