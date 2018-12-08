package com.amtkxa.springbootreladomo.usecase.web.inputport;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;

import java.util.List;

public interface AccountUseCase {

  /**
   * Search all customer.
   *
   * @return list of AccountView
   */
  List<? extends AccountView> findAll();

  /**
   * Search a customer with an ID.
   *
   * @parm customerId
   * @return list of AccountView
   */
  List<? extends AccountView> findByCustomerId(int customerId);

  /**
   * Create a customer.
   *
   * @parm accountView
   * @return list of AccountView
   */
  List<? extends AccountView> create(AccountView accountView);

  /**
   * Update a customer.
   *
   * @parm accountView
   * @return list of AccountView
   */
  List<? extends AccountView> update(AccountView accountView);

  /**
   * Terminate a customer.
   *
   * @parm accountView
   * @return list of AccountView
   */
  void terminate(AccountView accountView);
}
