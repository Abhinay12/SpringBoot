package com.bootbasic.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootbasic.demo.exception.NoDataFoundException;

@RestController
public class basicController {
	
	 @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	   public List<String> getProducts(@PathVariable Long id) {
	     List<String> productsList = new ArrayList<>();
		 if(id==1) {

		      productsList.add("Honey");
		      productsList.add("Almond");
		      return productsList;  
		 } 
		 else {
			 throw new NoDataFoundException(); 
		 }
	 
	   }

}
