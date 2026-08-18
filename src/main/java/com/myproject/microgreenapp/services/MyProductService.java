package com.myproject.microgreenapp.services;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.microgreenapp.entities.Product;
import com.myproject.microgreenapp.repository.ProductRepository;

@Service
public class MyProductService {
	@Autowired
	ProductRepository myProductRepository;

	public List<Product> getAllProducts() {
		return myProductRepository.findAll();
	}
	
	public Product addProduct(Product product) {
		return myProductRepository.save(product);
	}

	public Product getProductById(int id) {
		return myProductRepository.findById(id).orElse(null);
	}

	public Product updateProduct(int id, Product product) {
		System.out.println("Service update product + " + id + " " + product.getP_id());
		Product updatedProduct = myProductRepository.findById(id).orElse(null);
		if(updatedProduct != null && product.getP_id() == id) {
			return myProductRepository.save(product);
		}else if(updatedProduct != null && product.getP_id() != id) {
			product.setP_id(id);
			return myProductRepository.save(product);
		}
		return updatedProduct;
	}

	public String deleteProduct(int id) {
		 if(myProductRepository.existsById(id)) {
			 myProductRepository.deleteById(id);
		 }else {
			 return "Product does not exists";
		 }
		 return "success";
	}
}
