package com.home.camel.micro.a.routes.patterns;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EiPatternsRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		//pipeline
		//Content base routing -choice()
		// multicast
		
		
		//from("timer:multicast?period=10000")
		//.multicast().to("log:something1", "log:something2", "log:something3");
		
		from("file:files/csv")
		.unmarshal().csv()
		.split(body())
		.to("activemq:split-queue");
		
	}
}
