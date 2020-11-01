package com.teste.pismo.service;

import com.teste.pismo.model.Account;

public interface AccountService {
	
	void insertAccount(Account account);
	
	Account findAccountById(Long id);
	
	void isAccountValid(Long id);
	
}
