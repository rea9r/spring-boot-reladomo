package com.amtkxa.springbootreladomo.adapter.controller;

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

  @NonNull
  private final AccountUseCaseImpl accountServiceImpl;

  @GetMapping(value = "/api/customer/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> getAllCustomer() {
    return accountServiceImpl.findAll();
  }

  @GetMapping(value = "/api/customer/account/{customerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> getCustomerById(@PathVariable("customerId") int customerId) {
    return accountServiceImpl.findByAccountId(customerId);
  }

  @PostMapping(value = "/api/customer/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> createCustomer(@RequestBody AccountView accountView) {
    return accountServiceImpl.create(accountView);
  }

  @PutMapping(value = "/api/customer/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends AccountView> updateCustomer(@RequestBody AccountView accountView) {
    return accountServiceImpl.update(accountView);
  }

  @DeleteMapping(value = "/api/customer/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteCustomer(@RequestBody AccountView accountView) {
    accountServiceImpl.terminate(accountView);
  }
}
