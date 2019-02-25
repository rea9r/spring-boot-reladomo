package com.amtkxa.springbootreladomo.usecase.web.interactor;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.domain.entity.TransactionList;
import com.amtkxa.springbootreladomo.domain.entity.TransactionType;
import com.amtkxa.springbootreladomo.domain.repository.AccountRepository;
import com.amtkxa.springbootreladomo.domain.repository.TransactionRepository;
import com.amtkxa.springbootreladomo.usecase.web.inputport.AccountUseCase;
import com.amtkxa.springbootreladomo.usecase.web.outputport.AccountPresenter;
import com.gs.fw.common.mithra.MithraManagerProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountUseCaseImpl implements AccountUseCase {
  @NonNull private final AccountRepository accountRepository;
  @NonNull private final AccountPresenter accountPresenter;
  @NonNull private final TransactionRepository transactionRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends AccountView> findByAccountId(int accountId) {
    AccountList accountList = accountRepository.findByAccountId(accountId);
    return accountPresenter.response(accountList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends AccountView> create(AccountView accountView) {
    AccountList accountList = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      AccountList txAccountList = accountRepository.create(accountView);
      return txAccountList;
    });
    return accountPresenter.response(accountList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends AccountView> deposit(TransactionView transactionView) {
    AccountList accountList = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      transactionView.setTransactionType(TransactionType.DEPOSIT);
      AccountList txAccountList = accountRepository.deposit(transactionView);
      TransactionList txTransactionList = transactionRepository.create(transactionView);
      return txAccountList;
    });
    return accountPresenter.response(accountList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends AccountView> withdrawal(TransactionView transactionView) {
    AccountList accountList = MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      transactionView.setTransactionType(TransactionType.WITHDRAWAL);
      AccountList txAccountList = accountRepository.withdrawal(transactionView);
      TransactionList txTransactionList = transactionRepository.create(transactionView);
      return txAccountList;
    });
    return accountPresenter.response(accountList);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void terminate(int accountId) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      accountRepository.terminateByAccountId(accountId);
      return null;
    });
  }
}
