package com.pds1.ProjetoReferenciaPDS1.resourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pds1.ProjetoReferenciaPDS1.dto.PaymentDTO;
import com.pds1.ProjetoReferenciaPDS1.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResourse {
	
	@Autowired
	private PaymentService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<PaymentDTO>> findAll(){
		List<PaymentDTO> list = service.findAll();				
		return ResponseEntity.ok().body(list);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PaymentDTO> findById(@PathVariable Long id){
		PaymentDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
