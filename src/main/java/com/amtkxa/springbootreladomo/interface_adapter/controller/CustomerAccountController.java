package com.amtkxa.springbootreladomo.interface_adapter.controller;

import com.amtkxa.springbootreladomo.usecase.service.impl.CustomerAccountServiceImpl;
import com.amtkxa.springbootreladomo.usecase.view.CustomerAccountView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerAccountController {

  @NonNull private final CustomerAccountServiceImpl customerAccountServiceImpl;

  @GetMapping(value = "/api/customer/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerAccountView> getAllCustomer() {
    return customerAccountServiceImpl.findAll();
  }

  @GetMapping(
      value = "/api/customer/account/{customerId}",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerAccountView> getCustomerById(
      @PathVariable("customerId") int customerId) {
    return customerAccountServiceImpl.findByCustomerId(customerId);
  }

  @PostMapping(value = "/api/customer/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerAccountView> createCustomer(
      @RequestBody CustomerAccountView customerAccountView) {
    return customerAccountServiceImpl.create(customerAccountView);
  }

  @PutMapping(value = "/api/customer/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerAccountView> updateCustomer(
      @RequestBody CustomerAccountView customerAccountView) {
    return customerAccountServiceImpl.update(customerAccountView);
  }

  @DeleteMapping(value = "/api/customer/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteCustomer(@RequestBody CustomerAccountView customerAccountView) {
    customerAccountServiceImpl.terminate(customerAccountView);
  }
}
