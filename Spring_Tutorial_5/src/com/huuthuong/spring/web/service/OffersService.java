package com.huuthuong.spring.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huuthuong.spring.web.dao.Offer;
import com.huuthuong.spring.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
   private OffersDAO offersDao;

   @Autowired
   public void setOffersDao(OffersDAO offersDao) {
	   this.offersDao = offersDao;
   }
   
   public List<Offer> getCurrent() {
	   return this.offersDao.getOffers();
   }
   
   public List<Offer> getCurrent(int id) {
	   List<Offer> offers = new ArrayList<Offer>();
	   offers.add(this.offersDao.getOffer(id));
	   return offers;
   }
   
   public List<Offer> deleteCurrent(int id) {
	   int isDelete = this.offersDao.deleteOffer(id);
	   
	   if (isDelete==0) return null;
	   
	   return this.offersDao.getOffers();
   }
   
   public List<Offer> updateCurrent(Offer offer) {
	   int isUpdate = this.offersDao.updateOffer(offer);
	   
	   if (isUpdate==0) return null;
	   
	   return this.offersDao.getOffers();
   }
   
   public boolean createCurrent(Offer offer) {
	   int isCreate = this.offersDao.createOffer(offer);
	   
	   return (isCreate==0) ? false : true;
   }
   
   public List<Offer> makeOffers(Offer offer) {
	   List<Offer> offers = new ArrayList<Offer>();
	   offers.add(offer);
	   
	   return offers;
   }
}
