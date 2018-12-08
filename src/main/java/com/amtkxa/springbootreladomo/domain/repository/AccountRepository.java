package com.amtkxa.springbootreladomo.domain.repository;

import com.amtkxa.springbootreladomo.data.entity.AccountList;
import com.amtkxa.springbootreladomo.presentation.view.AccountView;

public interface AccountRepository {

  AccountList findAll();

  AccountList findByCustomerId(int customerId);

  AccountList create(AccountView accountView);

  AccountList update(AccountView accountView);

  void terminate(AccountView accountView);
}
