package com.amtkxa.springbootreladomo.usecase.repository;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.Account;
import com.amtkxa.springbootreladomo.domain.entity.AccountFinder;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.domain.repository.AccountRepository;
import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.usecase.repository.operation.AccountOperation;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.Operation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * {@link AccountRepository} for retrieving account data.
 */
@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

  @NonNull
  AccountOperation op;

  @Override
  public AccountList findByAccountId(int accountId) {
    return AccountFinder.findMany(op.id(accountId));
  }

  @Override
  public AccountList create(AccountView accountView) {
    Account account = new Account(accountView);
    account.cascadeInsert();
    return new AccountList(account);
  }

  @Override
  public AccountList deposit(TransactionView transactionView) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      Account account = AccountFinder.findOne(op.id(transactionView).and(op.bDate(transactionView)));
      account.deposit(transactionView);
      return null;
    });
    return findByAccountId(transactionView.getAccountId());
  }

  @Override
  public void terminate(AccountView accountView) {
    MithraManagerProvider.getMithraManager().executeTransactionalCommand((tx) -> {
      Account account = AccountFinder.findOne(op.id(accountView).and(op.bDate(accountView)).and(op.pDate()));
      account.terminate();
      return null;
    });
  }
}
