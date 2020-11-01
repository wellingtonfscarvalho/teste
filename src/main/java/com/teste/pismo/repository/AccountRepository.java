package com.teste.pismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.pismo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom{

}
