package com.assis.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assis.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
 	
}
