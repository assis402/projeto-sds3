package com.assis.dsvendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assis.dsvendas.dto.NewSaleDTO;
import com.assis.dsvendas.dto.SaleDTO;
import com.assis.dsvendas.dto.SaleSuccessDTO;
import com.assis.dsvendas.dto.SaleSumDTO;
import com.assis.dsvendas.entities.Sale;
import com.assis.dsvendas.entities.Seller;
import com.assis.dsvendas.repositories.SaleRepository;
import com.assis.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional
	public SaleDTO save(NewSaleDTO entity){
		Optional<Seller> seller = sellerRepository.findById(entity.getSellerId());
		Sale newEntity = repository.save(new Sale(entity, seller));
		return (new SaleDTO(newEntity));
		
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}
