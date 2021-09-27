package com.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.demo.model.Employee;
import com.demo.resource.EmployeeResource;

@Component
public class RestConfig extends ResourceConfig {

	public RestConfig(Class<?>... classes) {
		register(EmployeeResource.class);
	}

}
