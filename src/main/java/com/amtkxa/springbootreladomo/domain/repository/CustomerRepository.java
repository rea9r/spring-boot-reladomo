package com.amtkxa.springbootreladomo.domain.repository;

import com.amtkxa.springbootreladomo.data.entity.CustomerList;
import com.amtkxa.springbootreladomo.presentation.view.CustomerView;

public interface CustomerRepository {

  CustomerList findAll();

  CustomerList findByCustomerId(int customerId);

  CustomerList create(CustomerView customerView);

  CustomerList update(CustomerView customerView);

  void terminate(CustomerView customerView);
}
