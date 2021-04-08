package com.home.camel.micro.a.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqSenderRouter extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		// con este manda mensajes
		// TODO Auto-generated method stub
		//from("timer:active-mq-timer?period=10000")
		//.transform().constant("my mensaje para MQ activado")
		//.log("${body}")
		//.to("activemq:mi-actividad-mq-queue");
		
		//queue
		//mandar datos de json
		//from("file:files/json")
		//.log("${body}")
		//.to("activemq:mi-actividad-mq-queue");
		
		from("file:files/xml")
		.log("${body}")
		.to("activemq:mi-actividad-mq-xml-queue");
	}
}
