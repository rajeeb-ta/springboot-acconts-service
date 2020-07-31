package com.bank.accounts.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accounts.model.Accounts;
import com.bank.accounts.service.AccountService;

@RestController
public class AccountsController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/users/{user}/accounts")
	public ResponseEntity<List<Accounts>> accounts(@PathVariable("user") String accountName) {
		List<Accounts> accounts = accountService.getAccounts(accountName);

		accounts.stream().forEach(account -> {
			Link link = linkTo(methodOn(TransactionsController.class, accountName, account.getAccountNumber())
					.transactions(accountName, account.getAccountNumber())).withSelfRel();
			account.add(link);
		});

		Link link = linkTo(methodOn(AccountsController.class).accounts(accountName)).withSelfRel();
		CollectionModel<Accounts> result = CollectionModel.of(accounts, link);
		return new ResponseEntity(result, HttpStatus.OK);

	}

}
