package com.amtkxa.springbootreladomo.domain.repository;

import com.amtkxa.springbootreladomo.domain.entity.CustomerList;
import com.amtkxa.springbootreladomo.adapter.view.CustomerView;

public interface CustomerRepository {

  CustomerList findAll();

  CustomerList findByCustomerId(int customerId);

  CustomerList create(CustomerView customerView);

  CustomerList update(CustomerView customerView);

  void terminate(CustomerView customerView);
}
