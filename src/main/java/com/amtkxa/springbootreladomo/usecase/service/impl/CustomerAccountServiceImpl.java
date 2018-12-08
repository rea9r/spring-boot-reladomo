package com.amtkxa.springbootreladomo.usecase.service.impl;

import com.amtkxa.springbootreladomo.domain.model.CustomerAccountList;
import com.amtkxa.springbootreladomo.interface_adapter.presenter.CustomerAccountPresenter;
import com.amtkxa.springbootreladomo.usecase.repository.impl.CustomerAccountRepositoryImpl;
import com.amtkxa.springbootreladomo.usecase.service.CustomerAccountService;
import com.amtkxa.springbootreladomo.usecase.view.CustomerAccountView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerAccountServiceImpl implements CustomerAccountService {
  @NonNull private final CustomerAccountRepositoryImpl customerAccountRepositoryImpl;
  @NonNull private final CustomerAccountPresenter customerAccountPresenter;

  /** {@inheritDoc} */
  @Override
  public List<? extends CustomerAccountView> findAll() {
    CustomerAccountList customerAccountList = customerAccountRepositoryImpl.findAll();
    return customerAccountPresenter.response(customerAccountList);
  }

  /** {@inheritDoc} */
  @Override
  public List<? extends CustomerAccountView> findByCustomerId(int customerId) {
    CustomerAccountList customerAccountList =
        customerAccountRepositoryImpl.findByCustomerId(customerId);
    return customerAccountPresenter.response(customerAccountList);
  }

  /** {@inheritDoc} */
  @Override
  public List<? extends CustomerAccountView> create(CustomerAccountView customerAccountView) {
    CustomerAccountList customerAccountList =
        customerAccountRepositoryImpl.create(customerAccountView);
    return customerAccountPresenter.response(customerAccountList);
  }

  /** {@inheritDoc} */
  @Override
  public List<? extends CustomerAccountView> update(CustomerAccountView customerAccountView) {
    CustomerAccountList customerAccountList =
        customerAccountRepositoryImpl.update(customerAccountView);
    return customerAccountPresenter.response(customerAccountList);
  }

  /** {@inheritDoc} */
  @Override
  public void terminate(CustomerAccountView customerAccountView) {
    customerAccountRepositoryImpl.terminate(customerAccountView);
  }
}
