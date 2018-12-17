package com.amtkxa.springbootreladomo.usecase.repository.operation;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.TransactionFinder;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Component;

/**
 * The criteria with which {@link TransactionFinder}s execute queries against domain models.
 */
@Component
public class TransactionOperation {
  // TRANSACTION_LOG.ACCOUNT_ID:
  public Operation accountId(int accountId) {
    return TransactionFinder.accountId().eq(accountId);
  }

  public Operation accountId(TransactionView transactionView) {
    return TransactionFinder.accountId().eq(transactionView.getAccountId());
  }
}
