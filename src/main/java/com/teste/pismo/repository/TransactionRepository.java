package com.teste.pismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.pismo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, TransactionRepositoryCustom {

}
