package com.teste.pismo.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.pismo.enums.OperationTypeEnum;
import com.teste.pismo.exception.NegocioException;
import com.teste.pismo.model.Account;
import com.teste.pismo.model.Transaction;
import com.teste.pismo.repository.TransactionRepository;
import com.teste.pismo.service.AccountService;
import com.teste.pismo.service.TransactionService;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public void insertTransaction(Transaction transaction) {
		accountService.isAccountValid(transaction.getAccount().getAccountId());
		Account account = accountService.findAccountById(transaction.getAccount().getAccountId());
		if (!transaction.getOperationType().getId().equals(OperationTypeEnum.PAGAMENTO.getId())) {
			isLimiteDisponivel(account, transaction);
			transaction.setAmount(transaction.getAmount().negate());
		} 
		transaction.setEventDate(new Date());
		transactionRepository.save(transaction);
		accountService.updateAvailableCreditLimite(account, transaction);
	}
	
	@Override
	public List<Transaction> listAll() {
		return transactionRepository.findAll();
	}
	
	private void isLimiteDisponivel(Account account, Transaction transaction) {
		if (transaction.getAmount().compareTo(account.getAvailableCreditLimit()) == BigDecimal.ONE.intValue()) {
			throw new NegocioException("Limite nao disponivel pra essa transacao");
		}
	}
	
}
