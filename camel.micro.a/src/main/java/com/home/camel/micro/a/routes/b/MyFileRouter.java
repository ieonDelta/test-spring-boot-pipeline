package com.home.camel.micro.a.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.camel.micro.a.beans.DeciderBean;

//@Component
public class MyFileRouter extends RouteBuilder{
	
	@Autowired
	private DeciderBean deciderBean;
	
	@Override
	public void configure() throws Exception {
		
		
		// TODO Auto-generated method stub
		from("file:files/input")
		//.pipeline()
		.routeId("Files-Input-Route")
		.transform().body(String.class)
		.choice()
			.when(simple("${file:ext} ends with 'xml'"))
				.log("XML FILE")
			//.when(simple("${body} contains 'USD'"))
			.when(method(deciderBean))
				.log("Not an XML FILE BUT contains USD")
			.otherwise()
				.log("Not and XML FILE")
		.end()
		//.log("${messageHistory} ${headers.CamelFileAbsolute}")
		.to("direct://log-file-values")
		.to("file:files/output");
		
		from("direct:log-file-values")
		.log("${messageHistory} ${file:absolute.path}")
		.log("${file:name} ${file:name.ext} ${file:name.noext} ${file:onlyname}")
		.log("${file:onlyname.noext} ${file:parent} ${file:path} ${file:absolute}")
		.log("${file:size} ${file:modified}")
		.log("${routeId} ${camelId} ${body}");
	}
}


