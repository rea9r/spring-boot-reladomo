package com.amtkxa.springbootreladomo.usecase.service.impl;

import com.amtkxa.springbootreladomo.Interface.presenter.CustomerPresenter;
import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.usecase.repository.impl.CustomerRepositoryImpl;
import com.amtkxa.springbootreladomo.usecase.service.CustomerService;
import com.amtkxa.springbootreladomo.usecase.view.CustomerView;
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

  @Override
  public List<? extends CustomerView> findAll() {
    CustomerList customerList = customerRepositoryImpl.findAll();
    return customerPresenter.response(customerList);
  }

  @Override
  public List<? extends CustomerView> findByCustomerId(int customerId) {
    CustomerList customerList = customerRepositoryImpl.findByCustomerId(customerId);
    return customerPresenter.response(customerList);
  }

  @Override
  public List<? extends CustomerView> create(CustomerView customerView) {
    CustomerList customerList = customerRepositoryImpl.create(customerView);
    return customerPresenter.response(customerList);
  }
}
