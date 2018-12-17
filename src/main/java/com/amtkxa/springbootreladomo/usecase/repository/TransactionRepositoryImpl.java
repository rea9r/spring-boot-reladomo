package com.amtkxa.springbootreladomo.usecase.repository;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.*;
import com.amtkxa.springbootreladomo.domain.repository.TransactionRepository;
import com.amtkxa.springbootreladomo.usecase.repository.operation.TransactionOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * {@link TransactionRepository} to retrieve and update transaction data.
 */
@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

  @NonNull private TransactionOperation op;

  @Override
  public TransactionList findByAccountId(int accountId) {
    return TransactionFinder.findMany(op.accountId(accountId));
  }

  @Override
  public TransactionList create(TransactionView transactionView) {
    Transaction tansactionLog = new Transaction(transactionView);
    tansactionLog.cascadeInsert();
    return new TransactionList(tansactionLog);
  }
}
