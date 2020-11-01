package com.teste.pismo.service;

import java.util.List;

import com.teste.pismo.model.Transaction;

public interface TransactionService {

	void insertTransaction(Transaction transaction);
	
	List<Transaction> listAll();
	
}
