package com.amtkxa.springbootreladomo.usecases.repository;

import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.usecases.view.CustomerView;

public interface CustomerRepository {

  CustomerList findAll();

  CustomerList findByCustomerId(int customerId);

  CustomerList save(CustomerView customerView);
}
