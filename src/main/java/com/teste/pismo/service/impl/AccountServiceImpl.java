package com.teste.pismo.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.pismo.enums.OperationTypeEnum;
import com.teste.pismo.exception.NegocioException;
import com.teste.pismo.model.Account;
import com.teste.pismo.model.Transaction;
import com.teste.pismo.repository.AccountRepository;
import com.teste.pismo.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void insertAccount(Account account) {
		accountRepository.save(account);
	}
	
	@Override
	public Account findAccountById(Long id) {
		Optional<Account> optional = accountRepository.findById(id);
		
		if ( !optional.isPresent() ) {
			throw new NegocioException("Conta não encontrada");
		}
		
		return optional.get();
	}
	
	@Override
	public void updateAvailableCreditLimite(Account account, Transaction transaction) {
		account.setAvailableCreditLimit(account.getAvailableCreditLimit().add(transaction.getAmount()));
		accountRepository.save(account);
	}
	
	@Override
	public void isAccountValid(Long id) {
		this.findAccountById(id);
	}

}
