package com.amtkxa.springbootreladomo.domain.service.impl;

import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.presentation.presenter.AccountPresenter;
import com.amtkxa.springbootreladomo.domain.repository.impl.AccountRepositoryImpl;
import com.amtkxa.springbootreladomo.domain.service.AccountService;
import com.amtkxa.springbootreladomo.presentation.view.AccountView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
  @NonNull private final AccountRepositoryImpl accountRepositoryImpl;
  @NonNull private final AccountPresenter accountPresenter;

  /** {@inheritDoc} */
  @Override
  public List<? extends AccountView> findAll() {
    AccountList accountList = accountRepositoryImpl.findAll();
    return accountPresenter.response(accountList);
  }

  /** {@inheritDoc} */
  @Override
  public List<? extends AccountView> findByCustomerId(int customerId) {
    AccountList accountList = accountRepositoryImpl.findByCustomerId(customerId);
    return accountPresenter.response(accountList);
  }

  /** {@inheritDoc} */
  @Override
  public List<? extends AccountView> create(AccountView accountView) {
    AccountList accountList = accountRepositoryImpl.create(accountView);
    return accountPresenter.response(accountList);
  }

  /** {@inheritDoc} */
  @Override
  public List<? extends AccountView> update(AccountView accountView) {
    AccountList accountList = accountRepositoryImpl.update(accountView);
    return accountPresenter.response(accountList);
  }

  /** {@inheritDoc} */
  @Override
  public void terminate(AccountView accountView) {
    accountRepositoryImpl.terminate(accountView);
  }
}
