package com.bank.accounts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.accounts.dao.AccountsRepository;
import com.bank.accounts.model.Accounts;

@Service
public class AccountService {

	private AccountsRepository accountsRepository;

	public AccountService(AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}

	public List<Accounts> getAccounts(String accountName) {
		return accountsRepository.findAllByAccountName(accountName);
	}

}
