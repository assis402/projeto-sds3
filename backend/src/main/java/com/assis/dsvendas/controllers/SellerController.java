package com.assis.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assis.dsvendas.dto.SellerDTO;
import com.assis.dsvendas.service.SellerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@ApiOperation(value = "Retorna uma lista com todos os vendedores.")
	@GetMapping(produces="application/json")
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

}
