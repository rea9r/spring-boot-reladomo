package com.amtkxa.springbootreladomo.interface_adapter.controller;

import com.amtkxa.springbootreladomo.domain.service.impl.CustomerServiceImpl;
import com.amtkxa.springbootreladomo.interface_adapter.view.CustomerView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

  @NonNull
  private final CustomerServiceImpl customerServiceImpl;

  @GetMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerView> getAllCustomer() {
    return customerServiceImpl.findAll();
  }

  @GetMapping(value = "/api/customer/{customerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerView> getCustomerById(@PathVariable("customerId") int customerId) {
    return customerServiceImpl.findByCustomerId(customerId);
  }

  @PostMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerView> createCustomer(@RequestBody CustomerView customerView) {
    return customerServiceImpl.create(customerView);
  }

  @PutMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<? extends CustomerView> updateCustomer(@RequestBody CustomerView customerView) {
    return customerServiceImpl.update(customerView);
  }

  @DeleteMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteCustomer(@RequestBody CustomerView customerView) {
    customerServiceImpl.terminate(customerView);
  }
}
