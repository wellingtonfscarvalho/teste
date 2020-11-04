package com.teste.pismo.service;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste.pismo.model.Account;
import com.teste.pismo.model.Transaction;
import com.teste.pismo.util.AccountTestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.teste.pismo.TestePismoApplication.class})
public class AccountServiceTest {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void updateAvailableCreditLimite() {
		Account account = AccountTestUtil.populateAccount().get();
		Transaction tra = AccountTestUtil.popularTransaction();
		
		accountService.updateAvailableCreditLimite(account, tra);
		
		Assertions.assertThat(account.getAvailableCreditLimit()).isEqualTo(new BigDecimal(110));
	}
	
	@Test
	public void updateAvailableDebitoLimite() {
		Account account = AccountTestUtil.populateAccount().get();
		Transaction tra = AccountTestUtil.popularTransaction();
		tra.setAmount(tra.getAmount().negate());
		
		accountService.updateAvailableCreditLimite(account, tra);
		
		Assertions.assertThat(account.getAvailableCreditLimit()).isEqualTo(new BigDecimal(90));
	}

}
