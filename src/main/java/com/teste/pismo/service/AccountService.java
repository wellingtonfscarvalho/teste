package com.teste.pismo.service;

import com.teste.pismo.model.Account;

public interface AccountService {
	
	void criarConta(Account account);
	
	Account consultarContaPorId(Long id);

}
