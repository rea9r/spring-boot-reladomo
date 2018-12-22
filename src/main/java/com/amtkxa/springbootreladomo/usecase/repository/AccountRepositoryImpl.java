package com.amtkxa.springbootreladomo.usecase.repository;

import com.amtkxa.springbootreladomo.adapter.view.AccountView;
import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.Account;
import com.amtkxa.springbootreladomo.domain.entity.AccountFinder;
import com.amtkxa.springbootreladomo.domain.entity.AccountList;
import com.amtkxa.springbootreladomo.domain.repository.AccountRepository;
import com.amtkxa.springbootreladomo.usecase.repository.operation.AccountOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * {@link AccountRepository} to retrieve and update account data.
 */
@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

  @NonNull AccountOperation op;

  @Override
  public AccountList findByAccountId(int accountId) {
    return AccountFinder.findMany(op.accountId(accountId).and(op.businessDate()));
  }

  @Override
  public AccountList create(AccountView accountView) {
    Account account = new Account(accountView);
    account.cascadeInsert();
    return new AccountList(account);
  }

  @Override
  public AccountList deposit(TransactionView transactionView) {
    Account account = AccountFinder.findOne(op.accountId(transactionView).and(op.businessDate(transactionView)));
    account.deposit(transactionView);
    return new AccountList(account);
  }

  @Override
  public AccountList withdrawal(TransactionView transactionView) {
    Account account = AccountFinder.findOne(op.accountId(transactionView).and(op.businessDate(transactionView)));
    account.withdrawal(transactionView);
    return new AccountList(account);
  }

  @Override
  public void terminateByAccountId(int accountId) {
    Account account = AccountFinder.findOne(op.accountId(accountId).and(op.businessDate()).and(op.processingDate()));
    account.terminate();
  }

  @Override
  public void terminateByCustomerId(int customerId) {
    AccountList accountList = AccountFinder.findMany(op.customerId(customerId).and(op.businessDate()).and(op.processingDate()));
    accountList.terminateAll();
  }
}
