package com.amtkxa.springbootreladomo.usecase.service;

import com.amtkxa.springbootreladomo.usecase.view.CustomerView;

import java.util.List;

public interface CustomerService {

  /**
   * Search all customer.
   *
   * @return list of CustomerView
   */
  List<? extends CustomerView> findAll();

  /**
   * Search a customer with an ID.
   *
   * @return list of CustomerView
   * @parm customerId
   */
  List<? extends CustomerView> findByCustomerId(int customerId);

  /**
   * Create a customer.
   *
   * @return list of CustomerView
   * @parm customerView
   */
  List<? extends CustomerView> create(CustomerView customerView);

  /**
   * Update a customer.
   *
   * @return list of CustomerView
   * @parm customerView
   */
  List<? extends CustomerView> update(CustomerView customerView);

  /**
   * Terminate a customer.
   *
   * @return list of CustomerView
   * @parm customerView
   */
  void terminate(CustomerView customerView);
}
