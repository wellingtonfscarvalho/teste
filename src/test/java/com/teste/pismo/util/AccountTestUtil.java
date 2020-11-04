package com.teste.pismo.util;

import java.math.BigDecimal;
import java.util.Optional;

import com.teste.pismo.model.Account;
import com.teste.pismo.model.Transaction;

public class AccountTestUtil {
	
	public static Optional<Account> populateAccount() {
		Account acc = new Account(123456789987L);
		acc.setAccountId(1L);
		acc.setAvailableCreditLimit(new BigDecimal(100));
		
		return Optional.of(acc);
	}

	public static Transaction popularTransaction() {
		Transaction tra = new Transaction();
		tra.setAmount(BigDecimal.TEN);
		
		return tra;
	}
}
