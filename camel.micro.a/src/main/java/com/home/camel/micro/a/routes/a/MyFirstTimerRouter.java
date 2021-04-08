package com.home.camel.micro.a.routes.a;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.camel.micro.a.beans.MyFirstBean;
import com.home.camel.micro.a.beans.SimpleLoggingProcessingComponent;


//@Component
public class MyFirstTimerRouter extends RouteBuilder{
	
	

	@Autowired
	private MyFirstBean myfirstbean;
	
	@Autowired
	private SimpleLoggingProcessingComponent loggingComponent;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		//queue //timer
		//transformation
		//database / log
		
		from("timer:primer-tiempo") //queue - el mensaje es null
		//.transform().constant("my mensaje constante") // transforma el cuerpo de primer tiempo de null a my mensaje constante
		//.transform().constant("la hora y fecha es " + LocalDateTime.now()) // ahora el cuerpo se transforma en la fecha actual del equipo
		.bean(myfirstbean)
		.bean(loggingComponent)
		.process(new SimpleLogginProcessor())
		.to("log:primer-tiempo"); //database / consola
		
		
	}

}

class SimpleLogginProcessor implements Processor {

	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("Sinple login de proceso {}", exchange.getMessage().getBody());

	}

}
