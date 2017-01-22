package com.huuthuong.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Robot {
    private String id = "";
    private String say = "hello";
    
    public void speak() {
    	System.out.println(id + " said " + say);
    }

//    @Autowired
	public void setId(@Value("${jdbc.username}") String id) {
		this.id = id;
	}

//    @Autowired
	public void setSay(@Value("${jdbc.password}") String say) {
		this.say = say;
	}
    
    
}
