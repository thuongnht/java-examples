package com.huuthuong.spring;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomText {
    private String[] sentences = {
     "get out!",
     "shut up!",
     "don't let me crazy",
     null
    };

	public String getSentence() {
		Random random = new Random();
		return this.sentences[random.nextInt(sentences.length)];
	}
    
    
}
