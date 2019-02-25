package com.amtkxa.springbootreladomo.adapter.controller;

import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import com.amtkxa.springbootreladomo.usecase.web.inputport.CustomerUseCase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

  @NonNull private final CustomerUseCase customerUseCase;

  @GetMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerView> getAllCustomer() {
    return customerUseCase.findAll();
  }

  @GetMapping(value = "/api/customer/{customerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerView> getCustomerById(@PathVariable("customerId") int customerId) {
    return customerUseCase.findByCustomerId(customerId);
  }

  @PostMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerView> createCustomer(@RequestBody CustomerView customerView) {
    return customerUseCase.create(customerView);
  }

  @PutMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerView> updateCustomer(@RequestBody CustomerView customerView) {
    return customerUseCase.update(customerView);
  }

  @DeleteMapping(value = "/api/customer/{customerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteCustomer(@PathVariable("customerId") int customerId) {
    customerUseCase.terminate(customerId);
  }
}
