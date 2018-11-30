package com.amtkxa.springbootreladomo.usecase.repository.impl;

import com.amtkxa.springbootreladomo.domain.model.CustomerFinder;
import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.usecase.repository.CustomerRepository;
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
}
