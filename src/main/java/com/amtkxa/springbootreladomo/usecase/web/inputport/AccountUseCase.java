package com.amtkxa.springbootreladomo.usecase.web.inputport;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.adapter.view.TransactionView;

import java.util.List;

public interface AccountUseCase {

  /**
   * Search a account with an ID.
   *
   * @parm customerId
   * @return list of AccountView
   */
  List<? extends AccountView> findByAccountId(int customerId);

  /**
   * Create a account.
   *
   * @parm accountView
   * @return list of AccountView
   */
  List<? extends AccountView> create(AccountView accountView);

  /**
   * Depositing cash into a registered account.
   *
   * @parm transactionView
   * @return list of AccountView
   */
  List<? extends AccountView> deposit(TransactionView transactionView);

  /**
   * Taking cash out of a registered account.
   *
   * @parm transactionView
   * @return list of AccountView
   */
  List<? extends AccountView> withdrawal(TransactionView transactionView);

  /**
   * Terminate a account.
   *
   * @parm accountView
   * @return list of AccountView
   */
  void terminate(AccountView accountView);
}
