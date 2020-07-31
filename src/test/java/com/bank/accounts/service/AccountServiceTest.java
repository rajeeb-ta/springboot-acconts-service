package com.bank.accounts.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bank.accounts.configurations.AccountsTestconfigurations;
import com.bank.accounts.configurations.MockData;
import com.bank.accounts.dao.AccountsRepository;
import com.bank.accounts.model.Accounts;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AccountsTestconfigurations.class, MockData.class})
public class AccountServiceTest {

	
	@Autowired
	AccountsRepository accountRepo;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	MockData mockData;
	
	@Test
	public void testUserHasAccounts() {
		final String accountName = "Ravi";
		Mockito.when(accountRepo.findAllByAccountName(accountName)).thenReturn(mockData.getAccounts());

		List<Accounts> accounts = accountService.getAccounts(accountName);
		
		assertThat(accounts).isNotNull();
		assertThat(accounts).hasSize(1);
		assertThat(accounts.get(0).getAccountName()).isEqualTo(accountName);
		assertThat(accounts.get(0).getAccountNumber()).isEqualTo("2003");
		assertThat(accounts.get(0).getAccountType()).isEqualTo("Savings");
		assertThat(accounts.get(0).getBalanceDate()).isBeforeOrEqualTo(LocalDate.now());
		assertThat(accounts.get(0).getCurrency()).isEqualTo("SGD");
		assertThat(accounts.get(0).getOpeningBalance()).isEqualTo(BigDecimal.valueOf(22003.33));
		
	}

	@Test
	public void testUserHasNoAccounts() {
		final String accountNumber = "999";
		Mockito.when(accountRepo.findAllByAccountName(accountNumber)).thenReturn(mockData.noAccounts());

		List<Accounts> accounts = accountService.getAccounts(accountNumber);
		
		assertThat(accounts).isNotNull();
		assertThat(accounts).hasSize(0);
	}

}
