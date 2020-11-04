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
import com.teste.pismo.util.AccountTestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.teste.pismo.TestePismoApplication.class})
@AutoConfigureMockMvc
public class AccountControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@MockBean
	private AccountRepository accountRepository;
	
	@Test
	public void findById() throws Exception {
		Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(AccountTestUtil.populateAccount());
		
		RequestBuilder request = MockMvcRequestBuilders.get("/accounts/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		String expected = "{\"accountId\":1,\"documentNumber\":123456789987,\"availableCreditLimit\":100}";
		
		Assertions.assertThat(result.getResponse().getContentAsString()).isEqualTo(expected);
	}
	
	@Test
	public void findByIdNotFound() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/accounts/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void insertAccount() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/accounts")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"documentNumber\":123456789987}")
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
	}

}
