package com.assis.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assis.dsvendas.dto.SaleSuccessDTO;
import com.assis.dsvendas.dto.SaleSumDTO;
import com.assis.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
 	
	@Query("SELECT new com.assis.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.assis.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
