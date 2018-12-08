package com.amtkxa.springbootreladomo.interface_adapter.presenter;

import com.amtkxa.springbootreladomo.domain.model.CustomerList;
import com.amtkxa.springbootreladomo.interface_adapter.view.CustomerView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerPresenter {
  public List<? extends CustomerView> response(CustomerList customerList) {
    return customerList
            .stream()
            .filter(c -> c != null)
            .map(c -> CustomerView.fromCustomer(c))
            .collect(Collectors.toList());
  }
}
