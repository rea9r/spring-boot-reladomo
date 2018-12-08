package com.amtkxa.springbootreladomo.usecase.service;

import com.amtkxa.springbootreladomo.usecase.view.CustomerAccountView;

import java.util.List;

public interface CustomerAccountService {

  /**
   * Search all customer.
   *
   * @return list of CustomerView
   */
  List<? extends CustomerAccountView> findAll();

  /**
   * Search a customer with an ID.
   *
   * @parm customerId
   * @return list of CustomerAccountView
   */
  List<? extends CustomerAccountView> findByCustomerId(int customerId);

  /**
   * Create a customer.
   *
   * @parm customerAccountView
   * @return list of CustomerAccountView
   */
  List<? extends CustomerAccountView> create(CustomerAccountView customerAccountView);

  /**
   * Update a customer.
   *
   * @parm customerAccountView
   * @return list of CustomerAccountView
   */
  List<? extends CustomerAccountView> update(CustomerAccountView customerAccountView);

  /**
   * Terminate a customer.
   *
   * @parm customerAccountView
   * @return list of CustomerAccountView
   */
  void terminate(CustomerAccountView customerAccountView);
}
