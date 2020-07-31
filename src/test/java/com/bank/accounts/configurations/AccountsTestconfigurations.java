package com.bank.accounts.configurations;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.bank.accounts.dao.AccountsRepository;
import com.bank.accounts.service.AccountService;

@TestConfiguration
public class AccountsTestconfigurations {

	@Bean
	@Primary
	public AccountsRepository accountsRepository() {
		return Mockito.mock(AccountsRepository.class);
	}
	
	@Bean
	@Primary
	public AccountService accountService(AccountsRepository accountsRepository) {
		return new AccountService(accountsRepository);
	}
}
