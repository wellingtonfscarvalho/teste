package com.teste.pismo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.pismo.model.Transaction;
import com.teste.pismo.service.TransactionService;

@RestController
@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping( value = "/transactions" )
	public ResponseEntity inserirTransacao(@RequestBody Transaction transaction) {
		transactionService.inserirTransacao(transaction);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping( value = "/transactions/list" )
	public List<Transaction> listarTodos() {
		return transactionService.listAll();
	}

}
