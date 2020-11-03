package com.teste.pismo.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste.pismo.enums.OperationTypeEnum;
import com.teste.pismo.model.Account;
import com.teste.pismo.model.OperationType;
import com.teste.pismo.model.Transaction;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"/scripts/insert_test_transactions.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TransactionRepositoryTest {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void insertTransaction() {
		Transaction transaction = populateTransaction();
		this.transactionRepository.save(transaction);
		
		Assertions.assertThat(transaction.getId()).isNotNull();
	}
	
	private Transaction populateTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAccount(new Account(1L));
		transaction.setAmount(BigDecimal.TEN);
		transaction.setEventDate(new Date());
		transaction.setOperationType(new OperationType(OperationTypeEnum.SAQUE.getId()));
		return transaction;
	}
	
}
