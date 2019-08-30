package com.pds1.ProjetoReferenciaPDS1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pds1.ProjetoReferenciaPDS1.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
