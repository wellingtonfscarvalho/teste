package com.teste.pismo.controller;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.teste.pismo.model.Account;
import com.teste.pismo.repository.AccountRepository;
import com.teste.pismo.repository.TransactionRepository;
import com.teste.pismo.util.AccountTestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.teste.pismo.TestePismoApplication.class})
@AutoConfigureMockMvc
public class TransactionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@MockBean
	private TransactionRepository transactionRepository;
	
	@MockBean
	private AccountRepository accountRepository;
	
	@Test
	public void insertTransaction() throws Exception {
		Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(AccountTestUtil.populateAccount());
		
		RequestBuilder request = MockMvcRequestBuilders.post("/transactions")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"account\":{\"accountId\":1},\"operationType\":{\"id\":4},\"amount\": 500}")
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void insertTransactionAccountNotFound() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/transactions")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"account\":{\"accountId\":1},\"operationType\":{\"id\":4},\"amount\": 500}")
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}

	
}
