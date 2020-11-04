package com.teste.pismo.service;

import java.math.BigDecimal;

import com.teste.pismo.model.Account;
import com.teste.pismo.model.Transaction;

public interface AccountService {
	
	void insertAccount(Account account);
	
	Account findAccountById(Long id);
	
	void isAccountValid(Long id);
	
	void updateAvailableCreditLimite(Account account, Transaction transaction);
	
}
