package com.amtkxa.springbootreladomo.usecase.repository.impl;

import com.amtkxa.springbootreladomo.domain.model.CustomerAccountList;
import com.amtkxa.springbootreladomo.usecase.repository.CustomerAccountRepository;
import com.amtkxa.springbootreladomo.usecase.view.CustomerAccountView;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAccountRepositoryImpl implements CustomerAccountRepository {

  @Override
  public CustomerAccountList findAll() {
    return null;
  }

  @Override
  public CustomerAccountList findByCustomerId(int customerId) {
    return null;
  }

  @Override
  public CustomerAccountList create(CustomerAccountView customerAccountView) {
    return null;
  }

  @Override
  public CustomerAccountList update(CustomerAccountView customerAccountView) {
    return null;
  }

  @Override
  public void terminate(CustomerAccountView customerAccountView) {}
}
