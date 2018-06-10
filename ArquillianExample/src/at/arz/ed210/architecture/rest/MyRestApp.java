package at.arz.ed210.architecture.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("example")
public class MyRestApp extends Application {

	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> resources = new HashSet<>();
		resources.add(TestResource.class);
		return resources;
	}

}
