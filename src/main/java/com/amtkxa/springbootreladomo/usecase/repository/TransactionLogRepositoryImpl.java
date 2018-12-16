package com.amtkxa.springbootreladomo.usecase.repository;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.*;
import com.amtkxa.springbootreladomo.domain.repository.TransactionLogRepository;
import com.amtkxa.springbootreladomo.usecase.repository.operation.TransactionLogOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * {@link TransactionLogRepository} to retrieve and update transaction data.
 */
@Repository
@RequiredArgsConstructor
public class TransactionLogRepositoryImpl implements TransactionLogRepository {

  @NonNull private TransactionLogOperation op;

  @Override
  public TransactionLogList findByAccountId(int accountId) {
    return TransactionLogFinder.findMany(op.accountId(accountId));
  }

  @Override
  public TransactionLogList create(TransactionView transactionView) {
    TransactionLog tansactionLog = new TransactionLog(transactionView);
    tansactionLog.cascadeInsert();
    return new TransactionLogList(tansactionLog);
  }
}
