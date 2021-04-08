package com.home.camel.micro.b.routes;

import org.apache.camel.builder.RouteBuilder;

//import org.springframework.stereotype.Component;



//@Component
public class KafkaReciverRouter extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		from("kafka:mi-actividad-kafka-queue")
		.to("log:mensaje-recivido-de-kafka-actividad");
		
	}

}
