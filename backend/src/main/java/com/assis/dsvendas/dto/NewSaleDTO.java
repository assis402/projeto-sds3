package com.assis.dsvendas.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class NewSaleDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long sellerId;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	public NewSaleDTO(Long sellerId, Integer visited, Integer deals, Double amount, LocalDate date) {
		this.sellerId = sellerId;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSeller_id(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
