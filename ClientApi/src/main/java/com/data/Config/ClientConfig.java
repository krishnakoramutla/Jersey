package com.data.Config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.data.Controller.ClientController;

@Component
public class ClientConfig extends ResourceConfig{

	public ClientConfig(Class<?>... classes) {
register(ClientController.class);
	}

	
}
