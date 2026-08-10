package com.myproject.microgreenapp.servicesImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.microgreenapp.dtos.OrderResponse;
import com.myproject.microgreenapp.entities.Customer;
import com.myproject.microgreenapp.entities.Order;
import com.myproject.microgreenapp.entities.OrderItem;
import com.myproject.microgreenapp.entities.Product;
import com.myproject.microgreenapp.exceptionhandling.InsufficientStockException;
import com.myproject.microgreenapp.exceptionhandling.ProductNotFoundException;
import com.myproject.microgreenapp.exceptionhandling.ResourceNotFoundException;
import com.myproject.microgreenapp.mappers.OrderResponseMapper;
import com.myproject.microgreenapp.repository.MyCustomerRepository;
import com.myproject.microgreenapp.repository.MyProductRepository;
import com.myproject.microgreenapp.repository.OrderRepository;
import com.myproject.microgreenapp.requests.OrderItemRequest;
import com.myproject.microgreenapp.requests.OrderRequest;
import com.myproject.microgreenapp.services.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	MyCustomerRepository customerRepository;
	
	@Autowired
	MyProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderResponseMapper orderResponseMapper;
	
	@Override
	@Transactional
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		Customer customer = customerRepository.findById(orderRequest.getContactNo())
				.orElseThrow(()-> new ResourceNotFoundException("Customer not Found"));
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setOrder_Date(LocalDateTime.now());
		order.setStatus("PLACED");
		
		double totalBill = 0;
		
		for(OrderItemRequest itemRequest:orderRequest.getItems()) {
			System.out.println(itemRequest.getP_id());
			Product product = productRepository.findById(itemRequest.getP_id())
					.orElseThrow(()->new ProductNotFoundException());
			
			if(product.getP_stock()< itemRequest.getQuantity()) {
				throw new InsufficientStockException("Product Out Of Stock");
			}
			
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setPrice(product.getP_price());
			orderItem.setQuantity(itemRequest.getQuantity());
			orderItem.setProduct(product);
			
			order.getOrderItems().add(orderItem);
			
			totalBill += product.getP_price() * itemRequest.getQuantity();

            product.setP_stock(product.getP_stock() - itemRequest.getQuantity());
			
		}
		order.setTotal_Amount(totalBill);
		orderRepository.save(order);
		return orderResponseMapper.toOrderResponse(order);
	}

	@Override
	@Transactional
	public OrderResponse getOrderById(long order_id) {
		
		Order order = orderRepository.findById(order_id).orElseThrow(()->new ResourceNotFoundException("Order not found with id "+order_id));
		return orderResponseMapper.toOrderResponse(order);
	}

}
