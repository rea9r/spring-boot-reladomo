package com.amtkxa.springbootreladomo.usecases.repository.impl;

import com.amtkxa.springbootreladomo.domain.model.Customer;
import com.amtkxa.springbootreladomo.domain.model.CustomerFinder;
import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.usecases.repository.CustomerRepository;
import com.amtkxa.springbootreladomo.usecases.view.CustomerView;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  @Override
  public CustomerList findAll() {
    return new CustomerList(CustomerFinder.all());
  }

  @Override
  public CustomerList findByCustomerId(int customerId) {
    return CustomerFinder.findMany(CustomerFinder.customerId().eq(customerId));
  }

  @Override
  public CustomerList save(CustomerView customerView) {
    Customer customer = new Customer(customerView);
    customer.cascadeInsert();
    return new CustomerList(customer);
  }
}
