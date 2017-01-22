package com.huuthuong.spring;

import javax.annotation.*;

import org.springframework.stereotype.Component;

public class LoggerResource {
    private LogWriter fileWriter;
    private ConsoleWriter consoleWriter;

    @Resource
	public void setConsoleWriter(ConsoleWriter cw) {
		this.consoleWriter = cw;
	}
  
    @Resource(name="fileWriter")
 	public void setFileWriter(LogWriter fw) {
 		this.fileWriter = fw;
 	}
  
	public void writeConsole(String text) {
		if (this.consoleWriter!=null) {
		    this.consoleWriter.write(text);
		}
	}
	
	public void writeFile(String text) {
		if (this.fileWriter!=null) {
			this.fileWriter.write(text);
		}
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Init");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy");
	}
}
