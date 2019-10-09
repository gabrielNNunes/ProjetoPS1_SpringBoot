package com.pds1.ProjetoReferenciaPDS1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pds1.ProjetoReferenciaPDS1.dto.OrderDTO;
import com.pds1.ProjetoReferenciaPDS1.entities.Order;
import com.pds1.ProjetoReferenciaPDS1.entities.User;
import com.pds1.ProjetoReferenciaPDS1.repositories.OrderRepository;

import services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findAll();
		return list.stream().map(e -> new OrderDTO(e)).collect(Collectors.toList());
	}
	public OrderDTO findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		Order entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		authService.validadeOwnOrderOrAdmin(entity);
		return new OrderDTO(entity);
	}
	public List<OrderDTO> findByClient(){
		User client = authService.authenticated();
		List<Order> list = repository.findByClient(client);
		return list.stream().map(e -> new OrderDTO(e)).collect(Collectors.toList());
	}
	
	
}
