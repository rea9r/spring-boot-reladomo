package com.amtkxa.springbootreladomo.usecase.web.interactor;

import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.adapter.presenter.AccountPresenterImpl;
import com.amtkxa.springbootreladomo.usecase.repository.AccountRepositoryImpl;
import com.amtkxa.springbootreladomo.usecase.web.inputport.AccountUseCase;
import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountUseCaseImpl implements AccountUseCase {
  @NonNull private final AccountRepositoryImpl accountRepositoryImpl;
  @NonNull private final AccountPresenterImpl accountPresenter;

  /** {@inheritDoc} */
  @Override
  public List<? extends AccountView> findAll() {
    AccountList accountList = accountRepositoryImpl.findAll();
    return accountPresenter.response(accountList);
  }

  /** {@inheritDoc} */
  @Override
  public List<? extends AccountView> findByAccountId(int accountId) {
    AccountList accountList = accountRepositoryImpl.findByAccountId(accountId);
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
