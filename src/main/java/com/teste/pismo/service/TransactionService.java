package com.teste.pismo.service;

import java.util.List;

import com.teste.pismo.model.Transaction;

public interface TransactionService {

	void inserirTransacao(Transaction transaction);
	
	List<Transaction> listAll();
	
}
