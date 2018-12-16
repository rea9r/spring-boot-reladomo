package com.amtkxa.springbootreladomo.adapter.presenter;

import com.amtkxa.springbootreladomo.adapter.view.CustomerView;
import com.amtkxa.springbootreladomo.domain.entity.CustomerList;
import com.amtkxa.springbootreladomo.usecase.web.outputport.CustomerPresenter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerPresenterImpl implements CustomerPresenter {
  /**
   * {@inheritDoc}
   */
  public List<? extends CustomerView> response(CustomerList customerList) {
    return customerList
            .stream()
            .filter(c -> c != null)
            .map(c -> CustomerView.fromCustomer(c))
            .collect(Collectors.toList());
  }
}
