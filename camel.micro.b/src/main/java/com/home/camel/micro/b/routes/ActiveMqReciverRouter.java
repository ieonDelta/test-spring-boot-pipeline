package com.home.camel.micro.b.routes;

import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.model.dataformat.JsonLibrary;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.home.camel.micro.b.beans.MyCurrencyExchangeProcessor;
//import com.home.camel.micro.b.beans.MyCurrencyExchangeTransformer;
//import com.home.camel.micro.b.model.CurrencyExchange;

@Component
public class ActiveMqReciverRouter extends RouteBuilder{
	
	//@Autowired
	//private MyCurrencyExchangeProcessor myCurrencyExchangeProcessor;
	
	//@Autowired
	//private MyCurrencyExchangeTransformer myCurrencyExchangeTransforme;
	
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		//JSON
		//CurrencyExchange
		//{ "id": 1001, "from": "EUR", "to": "INR", "conversionMultiple": 80 }
		
		//from("activemq:mi-actividad-mq-xml-queue")
		//.unmarshal()
		//.jacksonxml(CurrencyExchange.class)
		//.json(JsonLibrary.Jackson, CurrencyExchange.class)
		//.bean(myCurrencyExchangeProcessor)
		//.bean(myCurrencyExchangeTransforme)
		//.to("log:mensaje-recivido-de-mq-actividad");
		
		from("activemq:split-queue")
		.to("log:received-message-from-active-mq");
		
	}

}
