package com.assis.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assis.dsvendas.dto.SaleDTO;
import com.assis.dsvendas.dto.SaleSuccessDTO;
import com.assis.dsvendas.dto.SaleSumDTO;
import com.assis.dsvendas.service.SaleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@ApiOperation(value = "Retorna uma lista com todas as vendas.")
	@GetMapping(produces="application/json")
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@ApiOperation(value = "Retorna uma lista agrupada pelos vendedores com o total de vendas de cada um.")
	@GetMapping(value = "/amount-by-seller", produces="application/json")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@ApiOperation(value = "Retorna uma lista agrupada pelos vendedores com o total de visitas e de negócios fechados.")
	@GetMapping(value = "/success-by-seller", produces="application/json")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}

}
