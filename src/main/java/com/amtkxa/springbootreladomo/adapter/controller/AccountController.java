package com.amtkxa.springbootreladomo.adapter.controller;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.usecase.web.inputport.AccountUseCase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

  @NonNull private final AccountUseCase accountUseCase;

  @GetMapping(value = "/api/account/{accountId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> getAccountByAccountId(@PathVariable("accountId") int accountId) {
    return accountUseCase.findByAccountId(accountId);
  }

  @PostMapping(value = "/api/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> createAccount(@RequestBody AccountView accountView) {
    return accountUseCase.create(accountView);
  }

  @PutMapping(value = "/api/account/deposit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> deposit(@RequestBody TransactionView transactionView) {
    return accountUseCase.deposit(transactionView);
  }

  @PutMapping(value = "/api/account/withdrawal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> withdrawal(@RequestBody TransactionView transactionView) {
    return accountUseCase.withdrawal(transactionView);
  }

  @DeleteMapping(value = "/api/account/{accountId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteAccount(@PathVariable("accountId") int accountId) {
    accountUseCase.terminate(accountId);
  }
}
