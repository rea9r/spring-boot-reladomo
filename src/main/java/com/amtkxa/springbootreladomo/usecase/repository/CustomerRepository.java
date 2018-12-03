package com.amtkxa.springbootreladomo.usecase.repository;

import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.usecase.view.CustomerView;

public interface CustomerRepository {

  CustomerList findAll();

  CustomerList findByCustomerId(int customerId);

  CustomerList create(CustomerView customerView);

  CustomerList update(CustomerView customerView);

  void terminate(CustomerView customerView);
}
