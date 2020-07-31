package com.bank.accounts.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.bank.accounts.configurations.MockData;
import com.bank.accounts.configurations.TransactionsTestconfigurations;
import com.bank.accounts.dao.TransactionsRepository;
import com.bank.accounts.service.TransactionService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = { AccountsController.class, TransactionsTestconfigurations.class })
class TransactionsControllerTest {

	@Autowired
	TransactionsRepository transactionRepo;
	
	@Autowired
	TransactionService transactionService;

	@Autowired
	MockData mockData;

	@Autowired
	MockMvc mockMvc;

	@Test
	void testTransactionController() throws Exception {

		final String accountNumber = "2003";
		Mockito.when(transactionRepo.findAllByAccountNumber(accountNumber)).thenReturn(mockData.getTransactions());

		mockMvc.perform(get("/users/Ravi/accounts/10002/transactions")).andExpect(status().isOk());

	}
	
}
