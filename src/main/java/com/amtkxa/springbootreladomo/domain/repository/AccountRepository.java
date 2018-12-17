package com.amtkxa.springbootreladomo.domain.repository;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.Account;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.adapter.view.AccountView;

/**
 * Interface that represents a Repository for getting {@link Account} related data.
 */
public interface AccountRepository {

  AccountList findByAccountId(int accountId);

  AccountList create(AccountView accountView);

  AccountList deposit(TransactionView transactionView);

  AccountList withdrawal(TransactionView transactionView);

  void terminateByAccountId(int accountId);

  void terminateByCustomerId(int customerId);
}
