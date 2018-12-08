package com.amtkxa.springbootreladomo.domain.repository;

import com.amtkxa.springbootreladomo.domain.model.AccountList;
import com.amtkxa.springbootreladomo.interface_adapter.view.AccountView;

public interface AccountRepository {

  AccountList findAll();

  AccountList findByCustomerId(int customerId);

  AccountList create(AccountView accountView);

  AccountList update(AccountView accountView);

  void terminate(AccountView accountView);
}
