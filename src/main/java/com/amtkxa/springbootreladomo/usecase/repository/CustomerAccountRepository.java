package com.amtkxa.springbootreladomo.usecase.repository;

import com.amtkxa.springbootreladomo.domain.model.CustomerAccountList;
import com.amtkxa.springbootreladomo.usecase.view.CustomerAccountView;

public interface CustomerAccountRepository {

  CustomerAccountList findAll();

  CustomerAccountList findByCustomerId(int customerId);

  CustomerAccountList create(CustomerAccountView customerAccountView);

  CustomerAccountList update(CustomerAccountView customerAccountView);

  void terminate(CustomerAccountView customerAccountView);
}
