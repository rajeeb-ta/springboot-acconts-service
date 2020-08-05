package com.bank.accounts.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bank.accounts.configurations.MockData;
import com.bank.accounts.configurations.TransactionsTestconfigurations;
import com.bank.accounts.dao.TransactionsRepository;
import com.bank.accounts.model.AccountTransactions;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TransactionsTestconfigurations.class, MockData.class})
class TransactionServiceTest {

	@Autowired
	TransactionsRepository transactionRepo;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	MockData mockData;

	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetTransactions() {
		final String accountNumber = "2003";
		
		when(transactionRepo.findAllByAccountNumber(accountNumber)).thenReturn(mockData.getTransactions());
		
		List<AccountTransactions> transactions = transactionService.getTransactions("2003");
		
		assertThat(transactions).isNotNull();
		assertThat(transactions).hasSize(1);
		assertThat(transactions.get(0).getCreditAmount()).isEqualTo(BigDecimal.valueOf(1000.00d));
		assertThat(transactions.get(0).getAccountName()).isEqualTo("Ravi");
		assertThat(transactions.get(0).getAccountNumber()).isEqualTo("2003");
		assertThat(transactions.get(0).getCurrency()).isEqualTo("SGD");
		assertThat(transactions.get(0).getDebitCredit()).isEqualTo("Credit");
		assertThat(transactions.get(0).getTransactionId()).isEqualTo(1234);
		assertThat(transactions.get(0).getDebitAmount()).isNull();
		assertThat(transactions.get(0).getTransactionNarrative()).isNull();
		assertThat(transactions.get(0).getValueDate()).isBeforeOrEqualTo(LocalDate.now());
		
		
	}

	
}
