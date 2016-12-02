package com.kerneldc.HeroServiceSpringBoot;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.kerneldc.HeroServiceSpringBoot.resource.HeroResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		// Specifying a package does not work due to Jersey classpath scanning limitations
		// See: https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-1.4-Release-Notes#jersey-classpath-scanning-limitations
		// Listing of Jersey resources is required as a workaround
		//
		//packages(true, "hello.resource");
		register(HeroResource.class);
		//register(ReverseEndpoint.class);

	}
}
