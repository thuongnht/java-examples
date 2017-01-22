package com.huuthuong.spring.web.controller;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleException {

//	@ExceptionHandler(DataAccessException.class)
//	public ModelAndView handleDatabaseException(DataAccessException dax) {
//		
//		ModelAndView mv = new ModelAndView("error");
//		Map<String,Object> model = mv.getModel();
//		model.put("errorMessage", dax.getMessage() + "<br/>" + dax.getClass());
//		return mv;
//		
//	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleDatabaseException(Exception e) {
		
		ModelAndView mv = new ModelAndView("error");
		Map<String,Object> model = mv.getModel();
		model.put("errorMessage", e.getMessage() + "<br/>" + e.getClass());
		return mv;
		
	}
	
}
