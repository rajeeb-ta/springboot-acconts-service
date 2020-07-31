package com.bank.accounts.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accounts.model.AccountTransactions;
import com.bank.accounts.service.TransactionService;

@RestController
public class TransactionsController {

	private TransactionService transactionService;

	public TransactionsController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("/users/{user}/accounts/{account}/transactions")
	public ResponseEntity<List<AccountTransactions>> transactions(@PathVariable("user") String user,
			@PathVariable("account") String accountNumber) {
		List<AccountTransactions> transactions = transactionService.getTransactions(accountNumber);

		Link link = linkTo(methodOn(AccountsController.class).accounts(user)).withSelfRel();
		CollectionModel<AccountTransactions> result = CollectionModel.of(transactions, link);

		return new ResponseEntity(result, HttpStatus.OK);
	}

}
