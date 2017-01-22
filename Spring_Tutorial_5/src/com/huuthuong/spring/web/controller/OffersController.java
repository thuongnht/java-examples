package com.huuthuong.spring.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huuthuong.spring.web.dao.Offer;
import com.huuthuong.spring.web.service.OffersService;

@Controller
public class OffersController {
    
	private OffersService offersService;
	private String errorMessage = "";
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}


	@RequestMapping("/offer/list")
	public String listOffers(ModelMap model) {
		String errorMessage = "Can not list Offers <br/>";
		
		List<Offer> offers = this.offersService.getCurrent();
		
		if (offers==null) {
			model.addAttribute("errorMessage", errorMessage);
			return "error";
		}
		
		model.addAttribute("offers", offers);

		return "listOffers";
	}
	
	@RequestMapping(value="/offer/form", method=RequestMethod.GET)
	public String createCurrent(ModelMap model) {
		
		model.addAttribute("offer", new Offer());
		model.addAttribute("status", null);
		
		return "createOffer";
	}
	
	@RequestMapping(value="/offer/form/create", method=RequestMethod.POST)
	public String doCreateCurrent(ModelMap model, @Valid Offer offer, BindingResult bindResult) {

		if (bindResult.hasErrors()) return "createOffer";

		String errorMessage = "Can not create Node " + offer + "<br/>";
        boolean isCreated = this.offersService.createCurrent(null);
				
		if (!isCreated) {
			model.addAttribute("errorMessage", errorMessage);
			return "error";
		}
				
		model.addAttribute("offer", new Offer());
		model.addAttribute("status", "Offer is created");
		
		return "createOffer";
	}
	
	@RequestMapping(value="/offer/list/", method=RequestMethod.GET)
	public String listCurrent(ModelMap model, @RequestParam("id") int id) {
		String errorMessage = "Can not list ID " + id + "<br/>";

		List<Offer> offers = this.offersService.getCurrent(id);
		
		if (offers==null) {
			model.addAttribute("errorMessage", errorMessage);
			return "error";
		}
		
		model.addAttribute("offers", offers);
		
		return "listOffers";
	}
	
	@RequestMapping(value="/offer/delete/", method=RequestMethod.GET)
	public String deleteCurrent(ModelMap model, @RequestParam("id") int id) {
		String errorMessage = "Can not delete ID " + id + "<br/>";

		List<Offer> offers = this.offersService.deleteCurrent(id);
		
		if (offers==null) {
			model.addAttribute("errorMessage", errorMessage);
			return "error";
		}
		
		model.addAttribute("offers", offers);
		
		return "listOffers";
	}
	
	@RequestMapping(value="/offer/update/", method=RequestMethod.POST)
	public String updateCurrent(ModelMap model, @Valid Offer offer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("offers", this.offersService.makeOffers(offer));
		}
		else {
			//		List<Offer> offers = this.offersService.updateCurrent(offer);
			//		
			//		if (offers==null) {
			//			model.addAttribute("errorMessage", "Can not update ID " + offer.getId());
			//			return "error";
			//		}
			//		
			//		model.addAttribute("offers", offers);
			System.out.println("Offer is updated " + offer);
		}
		
		return "listOffers";
	}
	
	
}
