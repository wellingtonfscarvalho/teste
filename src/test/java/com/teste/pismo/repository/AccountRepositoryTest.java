package com.teste.pismo.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste.pismo.model.Account;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void insertAccount() {
		Account account = new Account(12345678999L);
		this.accountRepository.save(account);
		
		Assertions.assertThat(account.getAccountId()).isNotNull();
		Assertions.assertThat(account.getDocumentNumber()).isEqualTo(12345678999L);
	}
	
	@Test
	public void findById() {
		Account account = new Account(12345678900L);
		this.accountRepository.save(account);
		
		Optional<Account> optional = this.accountRepository.findById(account.getAccountId());
		Account acc = optional.get();
		Assertions.assertThat(acc.getDocumentNumber()).isEqualTo(12345678900L);
	}
	
}
