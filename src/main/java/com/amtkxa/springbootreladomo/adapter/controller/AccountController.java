package com.amtkxa.springbootreladomo.adapter.controller;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.usecase.web.interactor.AccountUseCaseImpl;
import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

  @NonNull private final AccountUseCaseImpl accountUseCaseImpl;

  @GetMapping(value = "/api/account/{accountId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> getAccountByAccountId(@PathVariable("accountId") int accountId) {
    return accountUseCaseImpl.findByAccountId(accountId);
  }

  @PostMapping(value = "/api/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> createAccount(@RequestBody AccountView accountView) {
    return accountUseCaseImpl.create(accountView);
  }

  @PutMapping(value = "/api/account/deposit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> deposit(@RequestBody TransactionView transactionView) {
    return accountUseCaseImpl.deposit(transactionView);
  }

  @PutMapping(value = "/api/account/withdrawal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> withdrawal(@RequestBody TransactionView transactionView) {
    return accountUseCaseImpl.withdrawal(transactionView);
  }

  @DeleteMapping(value = "/api/account/{accountId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteAccount(@PathVariable("accountId") int accountId) {
    accountUseCaseImpl.terminate(accountId);
  }
}
