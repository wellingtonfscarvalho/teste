package com.teste.pismo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teste.pismo.enums.OperationTypeEnum;

@Entity
@Table(name = "Transactions")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2656664247331564786L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Account_Id", referencedColumnName = "id")
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
	private Account account;

	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "OperationType_Id", referencedColumnName = "id" )
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer" }) 
	private OperationType operationType;
	

	@Column(name = "Amount")
	private BigDecimal amount;

	@Column(name = "EventDate")
	private Date eventDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

}
