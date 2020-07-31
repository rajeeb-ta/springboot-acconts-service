package com.bank.accounts.configurations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.accounts.model.AccountTransactions;
import com.bank.accounts.model.Accounts;

@Component
public class MockData {

	public List<Accounts> getAccounts() {
		List<Accounts> accountList = new ArrayList<>();
		
		Accounts accounts = new Accounts();
		accounts.setAccountName("Ravi");
		accounts.setAccountNumber("2003");
		accounts.setAccountType("Savings");
		accounts.setBalanceDate(LocalDate.now());
		accounts.setOpeningBalance(BigDecimal.valueOf(22003.33));
		accounts.setCurrency("SGD");
		accountList.add(accounts);
		
		return accountList;
	}

	public List<Accounts> noAccounts() {
		List<Accounts> accountList = new ArrayList<>();
		
		return accountList;
	}

	public List<AccountTransactions> getTransactions() {
		List<AccountTransactions> transactionList = new ArrayList<>();
		
		AccountTransactions transaction = new AccountTransactions();
		transaction.setTransactionId(1234);
		transaction.setAccountName("Ravi");
		transaction.setAccountNumber("2003");
		transaction.setCreditAmount(BigDecimal.valueOf(1000.00d));
		transaction.setCurrency("SGD");
		transaction.setDebitCredit("Credit");
		transaction.setValueDate(LocalDate.now());
		transaction.setTransactionNarrative(null);
		transaction.setDebitAmount(null);
		transactionList.add(transaction);
		
		return transactionList;
	}

	
}
