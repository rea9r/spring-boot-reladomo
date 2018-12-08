package com.amtkxa.springbootreladomo.interface_adapter.presenter;

import com.amtkxa.springbootreladomo.domain.model.CustomerAccountList;
import com.amtkxa.springbootreladomo.usecase.view.CustomerAccountView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerAccountPresenter {
  public List<? extends CustomerAccountView> response(CustomerAccountList customerAccountList) {
    return customerAccountList
        .stream()
        .filter(c -> c != null)
        .map(c -> CustomerAccountView.fromCustomerAccount(c))
        .collect(Collectors.toList());
  }
}
