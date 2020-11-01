package com.teste.pismo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.pismo.enums.OperationTypeEnum;
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
		if (!transaction.getOperationType().getId().equals(OperationTypeEnum.PAGAMENTO.getId())) {
			transaction.setAmount(transaction.getAmount().negate());
		}
		transaction.setEventDate(new Date());
		transactionRepository.save(transaction);
	}
	
	@Override
	public List<Transaction> listAll() {
		return transactionRepository.findAll();
	}
	
}
