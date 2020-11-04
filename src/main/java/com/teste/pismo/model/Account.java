package com.teste.pismo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2962321615989530801L;
	
	public Account() {
	}
	
	public Account(Long documentNumber) {
		this.documentNumber = documentNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long accountId;
	
	@Column(name = "Document_Number")
	private Long documentNumber;
	
	@Column(name = "AvailableCreditLimit")
	private BigDecimal availableCreditLimit;
	
	public Long getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public Long getDocumentNumber() {
		return documentNumber;
	}
	
	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}
	
	public BigDecimal getAvailableCreditLimit() {
		return availableCreditLimit;
	}
	
	public void setAvailableCreditLimit(BigDecimal availableCreditLimit) {
		this.availableCreditLimit = availableCreditLimit;
	}
}
