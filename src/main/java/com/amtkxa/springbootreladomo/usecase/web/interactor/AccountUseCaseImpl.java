package com.amtkxa.springbootreladomo.usecase.web.interactor;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.adapter.presenter.AccountPresenterImpl;
import com.amtkxa.springbootreladomo.domain.entity.TransactionLogList;
import com.amtkxa.springbootreladomo.domain.entity.TransactionType;
import com.amtkxa.springbootreladomo.usecase.repository.AccountRepositoryImpl;
import com.amtkxa.springbootreladomo.usecase.repository.TransactionLogRepositoryImpl;
import com.amtkxa.springbootreladomo.usecase.web.inputport.AccountUseCase;
import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.gs.fw.common.mithra.MithraManagerProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountUseCaseImpl implements AccountUseCase {
  @NonNull private final AccountRepositoryImpl accountRepositoryImpl;
  @NonNull private final AccountPresenterImpl accountPresenter;
  @NonNull private final TransactionLogRepositoryImpl transactionLogRepositoryImpl;

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
  public List<? extends AccountView> deposit(TransactionView transactionView) {
    AccountList accountList = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      transactionView.setTransactionType(TransactionType.DEPOSIT);
      AccountList txAccountList = accountRepositoryImpl.deposit(transactionView);
      TransactionLogList txTransactionLogList = transactionLogRepositoryImpl.create(transactionView);
      return txAccountList;
    });
    return accountPresenter.response(accountList);
  }

  /** {@inheritDoc} */
  @Override
  public List<? extends AccountView> withdrawal(TransactionView transactionView) {
    AccountList accountList = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      transactionView.setTransactionType(TransactionType.WITHDRAWAL);
      AccountList txAccountList = accountRepositoryImpl.withdrawal(transactionView);
      TransactionLogList txTransactionLogList = transactionLogRepositoryImpl.create(transactionView);
      return txAccountList;
    });
    return accountPresenter.response(accountList);
  }

  /** {@inheritDoc} */
  @Override
  public void terminate(AccountView accountView) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      accountRepositoryImpl.terminate(accountView);
      return null;
    });
  }
}
