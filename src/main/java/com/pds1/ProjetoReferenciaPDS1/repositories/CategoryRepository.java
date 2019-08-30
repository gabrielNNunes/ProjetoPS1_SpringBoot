package com.pds1.ProjetoReferenciaPDS1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pds1.ProjetoReferenciaPDS1.entities.Category;
import com.pds1.ProjetoReferenciaPDS1.entities.User;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
