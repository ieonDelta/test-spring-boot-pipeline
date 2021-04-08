package com.home.camel.micro.a.beans;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class MyFirstBean {
	
	public String getCurrentTimpe() {
		return "Time now is" + LocalDateTime.now();
	}

}
