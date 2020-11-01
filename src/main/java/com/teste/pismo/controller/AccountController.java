package com.teste.pismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.pismo.model.Account;
import com.teste.pismo.service.AccountService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/accounts")
	public ResponseEntity<?> insertAccount(@RequestBody Account account) {
		System.out.println("######### Document Number: " + account.getDocumentNumber());
		accountService.insertAccount(account);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/accounts/{accountId}")
	public Account findAccountById(@PathVariable("accountId") Long id) {
		return accountService.findAccountById(id);
	}
	
}
