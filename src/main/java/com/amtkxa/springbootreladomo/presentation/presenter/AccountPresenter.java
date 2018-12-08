package com.amtkxa.springbootreladomo.presentation.presenter;

import com.amtkxa.springbootreladomo.data.entity.AccountList;
import com.amtkxa.springbootreladomo.presentation.view.AccountView;
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
