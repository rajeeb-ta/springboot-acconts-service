package com.bank.accounts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.bank.accounts.configurations.AccountsTestconfigurations;
import com.bank.accounts.configurations.MockData;
import com.bank.accounts.dao.AccountsRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = { AccountsController.class, AccountsTestconfigurations.class })
class AccountsControllerTest {

	@Autowired
	AccountsRepository accountRepo;

	@Autowired
	MockData mockData;

	@Autowired
	MockMvc mockMvc;

	@Test
	void testAccountsController() throws Exception {
		final String accountName = "Ravi";
		when(accountRepo.findAllByAccountName(accountName)).thenReturn(mockData.getAccounts());

		mockMvc.perform(get("/users/Ravi/accounts")).andExpect(status().isOk());
	}

}
