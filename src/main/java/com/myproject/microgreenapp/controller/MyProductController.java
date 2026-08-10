package com.myproject.microgreenapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.microgreenapp.entities.Product;
import com.myproject.microgreenapp.exceptionhandling.ProductNotFoundException;
import com.myproject.microgreenapp.services.MyProductService;

@RestController
@RequestMapping("/product")
public class MyProductController {
	@Autowired
	private MyProductService myProductService;
	
//	@GetMapping("/test")
//	public String testMethod() {
//		return "Good to go";
//	}
//	
	@GetMapping("/getallproducts")
	public List<Product> getAllProducts() {
		return myProductService.getAllProducts();
		
	}
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return myProductService.addProduct(product);		
	}
	
	@GetMapping("/getproductbyid/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product product =  myProductService.getProductById(id);
		if(product != null) {
			return ResponseEntity.ok(product);
		}else {
			throw new ProductNotFoundException();
		}
		
	}
	
	@PutMapping("/updateproduct/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product){
		return myProductService.updateProduct(id, product);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return myProductService.deleteProduct(id);
	}

}
