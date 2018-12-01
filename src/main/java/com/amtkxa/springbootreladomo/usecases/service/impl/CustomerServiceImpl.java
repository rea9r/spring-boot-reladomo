package com.amtkxa.springbootreladomo.usecases.service.impl;

import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.interfaces.presenter.CustomerPresenter;
import com.amtkxa.springbootreladomo.usecases.repository.impl.CustomerRepositoryImpl;
import com.amtkxa.springbootreladomo.usecases.service.CustomerService;
import com.amtkxa.springbootreladomo.usecases.view.CustomerView;
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
    CustomerList customerList = customerRepositoryImpl.save(customerView);
    return customerPresenter.response(customerList);
  }

  @Override
  public List<? extends CustomerView> update(CustomerView customerView) {
    CustomerList customerList = customerRepositoryImpl.save(customerView);
    return customerPresenter.response(customerList);
  }
}
