package at.arz.ed210.architecture;

import org.junit.runner.RunWith;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Arquillian.class)
public class MyServiceIT {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				// Type:
				.create(JavaArchive.class)
				// Content:
				.addClass(MyService.class).addClass(OtherService.class)

				// Resources:
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	private MyService cut;

	@Test
	public void should_create_greeting() {
		assertThat(cut.sayHello(), is("Hello arquillian!"));
	}

	@RunAsClient
	@Test(expected = Exception.class)
	public void will_fail() {
		assertThat(cut.sayHello(), is("Hello arquillian!"));
	}

}
