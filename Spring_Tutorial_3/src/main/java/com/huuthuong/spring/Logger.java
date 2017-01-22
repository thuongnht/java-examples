package com.huuthuong.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Logger {
//    @Autowired
    private LogWriter fileWriter;
    
//    @Autowired
    private ConsoleWriter consoleWriter;
    
//  @Autowired
//  public Logger(FileWriter fileWriter, ConsoleWriter consoleWriter) {
//		this.fileWriter = fileWriter;
//		this.consoleWriter = consoleWriter;
//	}
     
    @Autowired(required=false)
    @Qualifier("toconsole")
	public void setConsoleWriter(ConsoleWriter cw) {
		this.consoleWriter = cw;
	}
    
    @Autowired(required=false)
    @Qualifier("tofile")
   	public void setFileWriter(LogWriter fw) {
   		this.fileWriter = fw;
   	}
    
//    private LogWriter fileWriter;
//    private LogWriter consoleWriter;
//    
//    @Autowired
//	public Logger(LogWriter fileWriter, LogWriter consoleWriter) {
//		this.fileWriter = fileWriter;
//		this.consoleWriter = consoleWriter;
//	}
//    
//    @Autowired
//	public void setFileWriter(LogWriter fw) {
//		this.fileWriter = fw;
//	}
//    
//    @Autowired
//	public void setConsoleWriter(LogWriter cw) {
//		this.consoleWriter = cw;
//	}
    
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
    
}
