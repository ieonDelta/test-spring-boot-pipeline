package com.home.camel.micro.a.beans;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoggingProcessingComponent {
	
	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	
	public void process(String message) {
		
		logger.info("Simple Login de procesos de componentes {}", message);
	}
}
