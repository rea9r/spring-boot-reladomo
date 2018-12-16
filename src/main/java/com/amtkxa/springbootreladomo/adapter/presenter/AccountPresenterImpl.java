package com.amtkxa.springbootreladomo.adapter.presenter;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.usecase.web.outputport.AccountPresenter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountPresenterImpl implements AccountPresenter {
  /**
   * {@inheritDoc}
   */
  public List<? extends AccountView> response(AccountList accountList) {
    return accountList
        .stream()
        .filter(c -> c != null)
        .map(c -> AccountView.fromAccount(c))
        .collect(Collectors.toList());
  }
}
