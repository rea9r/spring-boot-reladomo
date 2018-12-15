package com.amtkxa.springbootreladomo.usecase.repository.operation;

import com.amtkxa.springbootreladomo.adapter.view.TransactionView;
import com.amtkxa.springbootreladomo.domain.entity.TransactionLogFinder;
import com.gs.fw.common.mithra.finder.Operation;
import org.springframework.stereotype.Component;

@Component
public class TransactionLogOperation {
  public Operation accountId(int accountId) {
    return TransactionLogFinder.accountId().eq(accountId);
  }

  public Operation accountId(TransactionView transactionView) {
    return TransactionLogFinder.accountId().eq(transactionView.getAccountId());
  }
}
