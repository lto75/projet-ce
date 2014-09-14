package fr.projetce;



import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.external.ExternalTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

public class TestMyApplication extends JerseyTest{
	
	protected Application configure(){
		enable(TestProperties.LOG_TRAFFIC);
		return new MyApplication();
	}
	
	@Override
	protected TestContainerFactory getTestContainerFactory()
			throws TestContainerException {
		
		return new ExternalTestContainerFactory();
	}
	
	protected URI getBaseUri(){
		return UriBuilder.fromUri(super.getBaseUri()).path("backend").build();
	}
	
	
	/** utilise avec mvn test -Djersey.test.host=localhost -Djersey.config.test.container.port=8080**/
	@Test
	public void shouldResponsGotIt(){
		String myresponse = target().path("test/myresource").request().get(String.class);
		assertEquals("Got it!",myresponse);
	}

}
