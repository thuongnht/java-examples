package com.huuthuong.spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.huuthuong.spring.web.dao.Offer;
import com.huuthuong.spring.web.service.OffersService;

@Controller
public class HomeController {	
	
//	@RequestMapping("/")
//	public ModelAndView home(HttpSession session) {
//		ModelAndView mv = new ModelAndView("home");
//		Map<String,Object> model = mv.getModel();
//		model.put("name", "Phuong");
//
//		return mv;
//	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
}
