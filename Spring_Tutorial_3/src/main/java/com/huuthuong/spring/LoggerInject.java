package com.huuthuong.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
public class LoggerInject {
	private LogWriter fileWriter;
    private ConsoleWriter consoleWriter;

    @Inject
    @Named(value="consoleWriter")
    public void setConsoleWriter(ConsoleWriter cw) {
    	this.consoleWriter = cw;
    }

    @Inject
    @Named(value="fileWriter")
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
