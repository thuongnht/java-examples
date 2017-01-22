package com.huuthuong.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fileWriter")
public class FileWriter implements LogWriter {

	public void write(String text) {
	    System.out.println("File: " + text);		
	}
}
