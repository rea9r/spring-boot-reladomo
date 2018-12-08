package com.amtkxa.springbootreladomo.usecase.web.inputport;

import com.amtkxa.springbootreladomo.adapter.view.CustomerView;

import java.util.List;

public interface CustomerUseCase {

  /**
   * Search all customer.
   *
   * @return list of CustomerView
   */
  List<? extends CustomerView> findAll();

  /**
   * Search a customer with an ID.
   *
   * @parm customerId
   * @return list of CustomerView
   */
  List<? extends CustomerView> findByCustomerId(int customerId);

  /**
   * Create a customer.
   *
   * @parm customerView
   * @return list of CustomerView
   */
  List<? extends CustomerView> create(CustomerView customerView);

  /**
   * Update a customer.
   *
   * @parm customerView
   * @return list of CustomerView
   */
  List<? extends CustomerView> update(CustomerView customerView);

  /**
   * Terminate a customer.
   *
   * @parm customerView
   * @return list of CustomerView
   */
  void terminate(CustomerView customerView);
}
