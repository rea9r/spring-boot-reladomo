package com.amtkxa.springbootreladomo.domain.service.impl;

import com.amtkxa.springbootreladomo.data.entity.CustomerList;
import com.amtkxa.springbootreladomo.presentation.presenter.CustomerPresenter;
import com.amtkxa.springbootreladomo.domain.repository.impl.CustomerRepositoryImpl;
import com.amtkxa.springbootreladomo.domain.service.CustomerService;
import com.amtkxa.springbootreladomo.presentation.view.CustomerView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
  @NonNull
  private final CustomerRepositoryImpl customerRepositoryImpl;
  @NonNull
  private final CustomerPresenter customerPresenter;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends CustomerView> findAll() {
    CustomerList customerList = customerRepositoryImpl.findAll();
    return customerPresenter.response(customerList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends CustomerView> findByCustomerId(int customerId) {
    CustomerList customerList = customerRepositoryImpl.findByCustomerId(customerId);
    return customerPresenter.response(customerList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends CustomerView> create(CustomerView customerView) {
    CustomerList customerList = customerRepositoryImpl.create(customerView);
    return customerPresenter.response(customerList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends CustomerView> update(CustomerView customerView) {
    CustomerList customerList = customerRepositoryImpl.update(customerView);
    return customerPresenter.response(customerList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void terminate(CustomerView customerView) {
    customerRepositoryImpl.terminate(customerView);
  }
}
