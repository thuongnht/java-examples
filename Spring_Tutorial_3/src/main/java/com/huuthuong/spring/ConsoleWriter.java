package com.huuthuong.spring;

import org.springframework.stereotype.Component;

@Component("consoleWriter")
public class ConsoleWriter implements LogWriter {

	public void write(String text) {
	    System.out.println("Console: " + text);
	}

}
