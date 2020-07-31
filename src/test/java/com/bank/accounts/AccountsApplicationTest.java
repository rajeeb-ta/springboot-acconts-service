package com.bank.accounts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.accounts.controller.AccountsController;

@SpringBootTest
class AccountsApplicationTest {

	@Autowired
	private AccountsController controller;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}	
}
