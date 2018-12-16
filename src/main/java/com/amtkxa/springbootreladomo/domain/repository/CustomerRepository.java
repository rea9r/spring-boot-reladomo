package com.amtkxa.springbootreladomo.domain.repository;

import com.amtkxa.springbootreladomo.domain.entity.Customer;
import com.amtkxa.springbootreladomo.domain.entity.CustomerList;
import com.amtkxa.springbootreladomo.adapter.view.CustomerView;

/**
 * Interface that represents a Repository for getting {@link Customer} related data.
 */
public interface CustomerRepository {

  /**
   * Get a List of {@link Customer}.
   */
  CustomerList findAll();

  /**
   * Get a List of {@link Customer}.
   *
   * @param customerId The customer id used to retrieve customer data.
   */
  CustomerList findByCustomerId(int customerId);

  CustomerList create(CustomerView customerView);

  CustomerList update(CustomerView customerView);

  void terminate(int customerId);
}
