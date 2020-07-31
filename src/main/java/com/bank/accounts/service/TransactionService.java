package com.bank.accounts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.accounts.dao.TransactionsRepository;
import com.bank.accounts.model.AccountTransactions;

@Service
public class TransactionService {

	private TransactionsRepository transactionsRepository;

	public TransactionService(TransactionsRepository transactionsRepository) {
		this.transactionsRepository = transactionsRepository;
	}

	public List<AccountTransactions> getTransactions(String accountNumber) {
		return transactionsRepository.findAllByAccountNumber(accountNumber);
	}

}
