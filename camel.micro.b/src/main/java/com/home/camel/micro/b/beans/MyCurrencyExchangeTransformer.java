package com.home.camel.micro.b.beans;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.camel.micro.b.model.CurrencyExchange;



public class MyCurrencyExchangeTransformer {

	Logger logger = LoggerFactory.getLogger(MyCurrencyExchangeProcessor.class);
	
	public CurrencyExchange processMessage(CurrencyExchange currencyExchange) {
		
		currencyExchange.setConversionMultiple(
				currencyExchange.getConversionMultiple().multiply(BigDecimal.TEN));
		
		return currencyExchange;
	}
}
