package com.amtkxa.springbootreladomo.interface_adapter.presenter;

import com.amtkxa.springbootreladomo.domain.model.AccountList;
import com.amtkxa.springbootreladomo.usecase.view.AccountView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountPresenter {
  public List<? extends AccountView> response(AccountList accountList) {
    return accountList
        .stream()
        .filter(c -> c != null)
        .map(c -> AccountView.fromCustomerAccount(c))
        .collect(Collectors.toList());
  }
}
