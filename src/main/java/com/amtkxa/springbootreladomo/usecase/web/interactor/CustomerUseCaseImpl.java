package com.amtkxa.springbootreladomo.usecase.web.interactor;

import com.amtkxa.springbootreladomo.domain.entity.CustomerList;
import com.amtkxa.springbootreladomo.adapter.presenter.CustomerPresenterImpl;
import com.amtkxa.springbootreladomo.usecase.aggregate.CustomerRepositoryImpl;
import com.amtkxa.springbootreladomo.usecase.web.inputport.CustomerUseCase;
import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerUseCaseImpl implements CustomerUseCase {
  @NonNull
  private final CustomerRepositoryImpl customerRepositoryImpl;
  @NonNull
  private final CustomerPresenterImpl customerPresenter;

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
