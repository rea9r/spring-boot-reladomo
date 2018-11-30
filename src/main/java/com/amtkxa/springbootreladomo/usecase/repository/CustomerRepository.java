package com.amtkxa.springbootreladomo.usecase.repository;

import com.amtkxa.springbootreladomo.domain.model.CustomerList;

public interface CustomerRepository {

  CustomerList findAll();

  CustomerList findByCustomerId(int customerId);
}
