package com.demo.gaminggears.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.gaminggears.entity.Cart;
import com.demo.gaminggears.entity.CartBody;
import com.demo.gaminggears.service.ICartService;

@CrossOrigin(origins ="*")
@RestController
public class CartController {

	@Autowired
	ICartService iCartService;
	
	@GetMapping("/add-to-cart")
	public ResponseEntity<String> addtoCart(@RequestBody CartBody cartBody){
		iCartService.addtoCart(cartBody);
		return ResponseEntity.ok("added successfully");
	}
	@GetMapping("/getcart/{custID)")
	public List<Cart> getCart(@PathVariable int custID){
		return iCartService.getCart(custID);
	}
	
	
}
