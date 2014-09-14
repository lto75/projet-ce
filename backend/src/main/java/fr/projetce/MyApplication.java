package fr.projetce;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("test")
public class MyApplication extends ResourceConfig {

	public MyApplication(){
		packages("fr.projetce.api");
	}
}
