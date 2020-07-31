package com.bank.accounts.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.accounts.model.AccountTransactions;

@Repository
public interface TransactionsRepository extends CrudRepository<AccountTransactions, String>  {

	public List<AccountTransactions> findAllByAccountNumber(String accountNumber);
}
