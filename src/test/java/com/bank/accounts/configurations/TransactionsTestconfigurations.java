package com.bank.accounts.configurations;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.bank.accounts.dao.TransactionsRepository;
import com.bank.accounts.service.TransactionService;

@TestConfiguration
public class TransactionsTestconfigurations {

	@Bean
	public TransactionsRepository transactionRepo() {
		return Mockito.mock(TransactionsRepository.class);
	}
	
	@Bean
	public TransactionService transactionService(TransactionsRepository transactionsRepository) {
		return new TransactionService(transactionsRepository);
	}

	
}
