package com.teste.pismo.util;

import java.util.Optional;

import com.teste.pismo.model.Account;

public class AccountTestUtil {
	
	public static Optional<Account> populateAccount() {
		Account acc = new Account(123456789987L);
		acc.setAccountId(1L);
		
		return Optional.of(acc);
	}

}
