package com.home.camel.micro.b.beans;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.home.camel.micro.b.model.CurrencyExchange;

@Component
public class MyCurrencyExchangeProcessor {

	Logger logger = LoggerFactory.getLogger(MyCurrencyExchangeProcessor.class);
	
	public CurrencyExchange processMessage(CurrencyExchange currencyExchange) {
		
		currencyExchange.setConversionMultiple(
				currencyExchange.getConversionMultiple().multiply(BigDecimal.TEN));
		
		//logger.info("Do some processing with currencyExchange.getConversionMultiple() value which is{}", 
			//	currencyExchange.getConversionMultiple());
		
		return currencyExchange;
	}
}
