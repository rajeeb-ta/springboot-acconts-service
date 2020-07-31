package com.bank.accounts.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.accounts.model.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, String> {

	public List<Accounts> findAllByAccountName(String accountName);
}
